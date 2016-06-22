/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.model;

/**
 *
 * @author isuru
 */
public class Drug {
    
//        drug_id VARCHAR(5) NOT NULL,
//        drug_name_id VARCHAR(5) NOT NULL,
//        drug_type VARCHAR(50) NOT NULL,
//        drug_dose INT NULL,
//        drug_unit_price DECIMAL NOT NULL,
//        drug_expire_date VARCHAR(50) NOT NULL,
    
    private String drugId;
    private String drugNameId;
    private String drugType;
    private int dose;
    private double unitPrice;
    private String expireDate;
    private String qtyOnHand;
    private boolean availability;

    public Drug(String drugId, String drugNameId, String drugType, int dose, double unitPrice, String expireDate,String qtyOnHand,boolean availability) {
        this.drugId = drugId;
        this.drugNameId = drugNameId;
        this.drugType = drugType;
        this.dose = dose;
        this.unitPrice = unitPrice;
        this.expireDate = expireDate;
        this.qtyOnHand = qtyOnHand;
        this.availability = availability;
    }

    public Drug() {
    }

    
    /**
     * @return the drugId
     */
    public String getDrugId() {
        return drugId;
    }

    /**
     * @param drugId the drugId to set
     */
    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    /**
     * @return the drugNameId
     */
    public String getDrugNameId() {
        return drugNameId;
    }

    /**
     * @param drugNameId the drugNameId to set
     */
    public void setDrugNameId(String drugNameId) {
        this.drugNameId = drugNameId;
    }

    /**
     * @return the drugType
     */
    public String getDrugType() {
        return drugType;
    }

    /**
     * @param drugType the drugType to set
     */
    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    /**
     * @return the dose
     */
    public int getDose() {
        return dose;
    }

    /**
     * @param dose the dose to set
     */
    public void setDose(int dose) {
        this.dose = dose;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the expireDate
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * @param expireDate the expireDate to set
     */
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * @return the qtyOnHand
     */
    public String getQtyOnHand() {
        return qtyOnHand;
    }
    
    public void setQtyOnHand(String qty){
        this.qtyOnHand = qty;
    }
    
    public boolean getAvailability(){
        return this.availability;
    }
    
    public void setAvailability(boolean availablity){
        this.availability = availablity;
    }
    
}
