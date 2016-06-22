/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.model;

/**
 *
 * @author isuru
 */
public class PharamaName {
    private String pharmaId;
    private String pharmaName;

    public PharamaName(String pharmaId, String pharmaName) {
        this.pharmaId = pharmaId;
        this.pharmaName = pharmaName;
    }

    public PharamaName() {
    }

    
    /**
     * @return the pharmaId
     */
    public String getPharmaId() {
        return pharmaId;
    }

    /**
     * @param pharmaId the pharmaId to set
     */
    public void setPharmaId(String pharmaId) {
        this.pharmaId = pharmaId;
    }

    /**
     * @return the pharmaName
     */
    public String getPharmaName() {
        return pharmaName;
    }

    /**
     * @param pharmaName the pharmaName to set
     */
    public void setPharmaName(String pharmaName) {
        this.pharmaName = pharmaName;
    }

    @Override
    public String toString() {
        return this.pharmaName; //To change body of generated methods, choose Tools | Templates.
    }
    
}
