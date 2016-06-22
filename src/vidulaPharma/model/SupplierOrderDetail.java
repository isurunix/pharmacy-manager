/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.model;

/**
 *
 * @author isuru
 */
public class SupplierOrderDetail {
    private String supplierOrderId;
    private String drugId;
    private Double unitPrice;
    private String unitType;
    private String qty;
    private int dose;

    public SupplierOrderDetail(String supplierOrderId, String drugId, Double unitPrice, String unitType, String qty, int dose) {
        this.supplierOrderId = supplierOrderId;
        this.drugId = drugId;
        this.unitPrice = unitPrice;
        this.unitType = unitType;
        this.qty = qty;
        this.dose = dose;
    }
    

    

    public SupplierOrderDetail() {
    }

    
    /**
     * @return the supplierOrderId
     */
    public String getSupplierOrderId() {
        return supplierOrderId;
    }

    /**
     * @param supplierOrderId the supplierOrderId to set
     */
    public void setSupplierOrderId(String supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
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
     * @return the unitPrice
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the unitType
     */
    public String getUnitType() {
        return unitType;
    }

    /**
     * @param unitType the unitType to set
     */
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    /**
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(String qty) {
        this.qty = qty;
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
    
    
}
