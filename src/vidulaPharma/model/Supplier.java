/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.model;

/**
 *
 * @author isuru
 */
public class Supplier {
//    supplier_id VARCHAR(5) NOT NULL,
//    supplier_name VARCHAR(100) NOT NULL,
//    supplier_address VARCHAR(200) NOT NULL,
//    suplier_telephone VARCHAR(10) NOT NULL,
    
    private String supplierId;
    private String supplierName;
    private String supplierAddress;
    private String supplierTelephone;

    public Supplier(String supplierId, String supplierName, String supplierAddress, String supplierTelephone) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierTelephone = supplierTelephone;
    }

    public Supplier() {
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
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return the supplierAddress
     */
    public String getSupplierAddress() {
        return supplierAddress;
    }

    /**
     * @param supplierAddress the supplierAddress to set
     */
    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    /**
     * @return the supplierTelephone
     */
    public String getSupplierTelephone() {
        return supplierTelephone;
    }

    /**
     * @param supplierTelephone the supplierTelephone to set
     */
    public void setSupplierTelephone(String supplierTelephone) {
        this.supplierTelephone = supplierTelephone;
    }

    @Override
    public String toString() {
        return this.supplierName; //To change body of generated methods, choose Tools | Templates.
    }
    
        
    
}
