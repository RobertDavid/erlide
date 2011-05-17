/*******************************************************************************
 * Copyright (c) 2004 Vlad Dumitrescu and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Vlad Dumitrescu
 *******************************************************************************/
package org.erlide.core.model.erlang;

import org.erlide.core.model.root.IErlElement;
import org.erlide.core.model.root.ISourceManipulation;
import org.erlide.core.model.root.ISourceRange;
import org.erlide.core.model.root.ISourceReference;

public interface IErlMember extends IErlElement, ISourceReference,
        ISourceManipulation {

    /**
     * Returns the compilation unit in which this member is declared, or
     * <code>null</code> if this member is not declared in a compilation unit
     * (for example, a binary type). This is a handle-only method.
     * 
     * @return the compilation unit in which this member is declared, or
     *         <code>null</code> if this member is not declared in a compilation
     *         unit (for example, a binary type)
     */
    void setNameRange(int offset, int length);

    ISourceRange getNameRange();

    /**
     * Get module if this element is contained in one (or is one)
     * 
     * @return module or null
     */
    IErlModule getModule();

    String getModuleName();

}
