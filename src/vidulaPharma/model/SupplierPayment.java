/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.model;

/**
 *
 * @author isuru
 */
public class SupplierPayment {
    private String paymentId;
    private String employeeId;
    private String paymentDate;
    private double amount;
    private boolean isPaid;

    public SupplierPayment(String paymentId, String employeeId, String paymentDate, double amount, boolean isPaid) {
        this.paymentId = paymentId;
        this.employeeId = employeeId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public SupplierPayment() {
    }

    
    /**
     * @return the paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the paymentDate
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the isPaid
     */
    public boolean isPaid() {
        return isPaid;
    }

    /**
     * @param isPaid the isPaid to set
     */
    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
    
    
    
}
