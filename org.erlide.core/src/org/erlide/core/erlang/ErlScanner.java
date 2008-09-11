/*******************************************************************************
 * Copyright (c) 2004 Eric Merritt and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eric Merritt
 *     Vlad Dumitrescu
 *******************************************************************************/
package org.erlide.core.erlang;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;

import erlang.ErlideScanner2;

/**
 * Erlang syntax scanner
 * 
 * @author Vlad
 */
public class ErlScanner implements IErlScanner {

	private final IErlModule module;

	private final String moduleName;

	private String moduleFileName;
	private final String erlidePath;

	public ErlScanner(final IErlModule module, final String initialText,
			final String erlidePath) {
		this.module = module;
		moduleName = createScannerModuleName(module);
		moduleFileName = "";
		final IResource r = module.getResource();
		if (r instanceof IFile) {
			final IFile f = (IFile) r;
			moduleFileName = f.getLocation().toString();
		}
		this.erlidePath = erlidePath;
		ErlideScanner2.initialScan(moduleName, moduleFileName, initialText,
				erlidePath);
		// create();
		// insertText(0, initialText);
	}

	/**
	 * @return
	 */

	static public String createScannerModuleName(final IErlModule module) {
		final IResource res = module.getResource();
		String resName;
		if (res != null) {
			resName = "mod" + res.getFullPath().toPortableString().hashCode()
					+ "_" + res.getName();
		} else {
			// This is not used more than temporarily, so it's ok to have
			// a name that's temporary, as long as it's unique
			resName = "mod" + module.hashCode() + "_";
		}
		return resName;
	}

	// private void create() {
	// ErlideScanner.create(fMod);
	// }

	public void dispose() {
		ErlideScanner2.destroy(moduleName);
	}

	// public void insertText(int offset, String text) {
	// // ErlLogger.debug("scanner insert offset=" + offset + " text.length="
	// // + text.length());
	// ErlideScanner.insertText(fMod, offset, text);
	// }

	// public void removeText(int offset, int length) {
	// // ErlLogger.debug("scanner remove offset=" + offset + " length=" +
	// // length);
	// ErlideScanner.removeText(fMod, offset, length);
	// }

	public void replaceText(final int offset, final int removeLength,
			final String newText) {
		ErlideScanner2.replaceText(moduleName, offset, removeLength, newText);
	}

	public ErlToken getTokenAt(final int offset) {
		return ErlideScanner2.getTokenAt(moduleName, offset);
	}

	// public ErlToken[] getTokensAround(int offset) {
	// return ErlideScanner.getTokensAround(fMod, offset);
	// }

	// public ErlToken[] getTokens() {
	// return ErlideScanner.getTokens(fMod);
	// }

	// public TokenWindow getTokenWindow(int offset, int window) {
	// if (!UseScanner2) {
	// return ErlideScanner.getTokenWindow(moduleName, offset, window);
	// }
	// return ErlideScanner2.getTokenWindow(moduleName, offset, window);
	// }

	public String getScannerModuleName() {
		return moduleName;
	}

	public void rescan(final String fullText) {
		ErlideScanner2.initialScan(moduleName, moduleFileName, fullText,
				erlidePath);
	}

	public List<IErlComment> getComments() {
		return module.getComments();
	}
}
