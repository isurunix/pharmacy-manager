/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.model;

/**
 *
 * @author isuru
 */
public class CustomerOrder {
    private String customerOrderId;
    private String customerOrderDate;
    private Double amount;
    private String employeeId;

    public CustomerOrder(String customerOrderId, String customerOrderDate, Double amount, String employeeId) {
        this.customerOrderId = customerOrderId;
        this.customerOrderDate = customerOrderDate;
        this.amount = amount;
        this.employeeId = employeeId;
    }

    public CustomerOrder() {
    }

    
    /**
     * @return the customerOrderId
     */
    public String getCustomerOrderId() {
        return customerOrderId;
    }

    /**
     * @param customerOrderId the customerOrderId to set
     */
    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    /**
     * @return the customerOrderDate
     */
    public String getCustomerOrderDate() {
        return customerOrderDate;
    }

    /**
     * @param customerOrderDate the customerOrderDate to set
     */
    public void setCustomerOrderDate(String customerOrderDate) {
        this.customerOrderDate = customerOrderDate;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
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
    
    
}
