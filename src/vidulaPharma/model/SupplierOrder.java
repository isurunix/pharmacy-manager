/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.model;

/**
 *
 * @author isuru
 */
public class SupplierOrder {
    private String supplierOrderId;
    private String supplierId;
    private String supplierOrderDate;
    private String supplierPaymentId;

    public SupplierOrder(String supplierOrderId, String supplierId, String supplierOrderDate, String supplierPaymentId) {
        this.supplierOrderId = supplierOrderId;
        this.supplierId = supplierId;
        this.supplierOrderDate = supplierOrderDate;
        this.supplierPaymentId = supplierPaymentId;
    }

    public SupplierOrder() {
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
     * @return the supplierId
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId the supplierId to set
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return the supplierOrderDate
     */
    public String getSupplierOrderDate() {
        return supplierOrderDate;
    }

    /**
     * @param supplierOrderDate the supplierOrderDate to set
     */
    public void setSupplierOrderDate(String supplierOrderDate) {
        this.supplierOrderDate = supplierOrderDate;
    }

    /**
     * @return the supplierPaymentId
     */
    public String getSupplierPaymentId() {
        return supplierPaymentId;
    }

    /**
     * @param supplierPaymentId the supplierPaymentId to set
     */
    public void setSupplierPaymentId(String supplierPaymentId) {
        this.supplierPaymentId = supplierPaymentId;
    }
    
    
}
