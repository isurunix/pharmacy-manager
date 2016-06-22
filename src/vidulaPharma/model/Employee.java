/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.model;

/**
 *
 * @author isuru
 */
public class Employee {
//    employee_id VARCHAR(5) NOT NULL ,
//    employee_name VARCHAR(50) NOT NULL ,
//    employee_address VARCHAR(200) NOT NULL ,
//    employee_telephone VARCHAR(10) NOT NULL ,
    
    private String employeeId;
    private String employeeName;
    private String employeeAddress;
    private String employeeTelephone;

    public Employee(String employeeId, String employeeName, String employeeAddress, String employeeTelephone) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeTelephone = employeeTelephone;
    }

    public Employee() {
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
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName the employeeName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return the employeeAddress
     */
    public String getEmployeeAddress() {
        return employeeAddress;
    }

    /**
     * @param employeeAddress the employeeAddress to set
     */
    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    /**
     * @return the employeeTelephone
     */
    public String getEmployeeTelephone() {
        return employeeTelephone;
    }

    /**
     * @param employeeTelephone the employeeTelephone to set
     */
    public void setEmployeeTelephone(String employeeTelephone) {
        this.employeeTelephone = employeeTelephone;
    }

    @Override
    public String toString() {
        return this.employeeName; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
