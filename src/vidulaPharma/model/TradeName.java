/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.model;

/**
 *
 * @author isuru
 */
public class TradeName {
    private String tradeId;
    private String pharmaId;
    private String tradeName;

    public TradeName(String tradeId, String pharmaId, String tradeName) {
        this.tradeId = tradeId;
        this.pharmaId = pharmaId;
        this.tradeName = tradeName;
    }

    public TradeName() {
    }
    
    

    /**
     * @return the tradeId
     */
    public String getTradeId() {
        return tradeId;
    }

    /**
     * @param tradeId the tradeId to set
     */
    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
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
     * @return the tradeName
     */
    public String getTradeName() {
        return tradeName;
    }

    /**
     * @param tradeName the tradeName to set
     */
    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    @Override
    public String toString() {
        return this.tradeName; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
