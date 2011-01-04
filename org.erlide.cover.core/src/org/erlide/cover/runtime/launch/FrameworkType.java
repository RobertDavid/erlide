package org.erlide.cover.runtime.launch;

/**
 * Supported frameworks
 * 
 * @author Aleksandra Lipiec <aleksandra.lipiec@erlang-solutions.com>
 *
 */
public enum FrameworkType {
    
    EUNIT ("EUnit"),
    CT ("Common Test"),
    QC ("QuickCheck");
    
    private final String fullRepr;
    
    private FrameworkType(String str) {
        fullRepr = str;
    }
    
    public String getRepr() {
        return fullRepr;
    }
    
    public static FrameworkType find(String repr) {
        for(FrameworkType t : FrameworkType.values()) {
            if(t.getRepr().equals(repr)) 
                return t;
        }
        return null;
    }

}
