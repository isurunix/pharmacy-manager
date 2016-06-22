/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vidulaPharma.db.DBConnection;
import vidulaPharma.db.DBHandler;
import vidulaPharma.etc.IdGen;
import vidulaPharma.model.Employee;

/**
 *
 * @author isuru
 */
public class EmployeeController {

    //add a employee record
    public static boolean addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee VALUES('" + employee.getEmployeeId() + "','" + employee.getEmployeeName() + "','" + employee.getEmployeeAddress() + "','" + employee.getEmployeeTelephone() + "')";
        Connection connection = DBConnection.getConnection();
        return DBHandler.setData(connection, sql);
    }

    //edit employee record
    public static boolean editEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employee SET employee_name='" + employee.getEmployeeName() + "',employee_address='" + employee.getEmployeeAddress() + "',employee_telephone='" + employee.getEmployeeTelephone() + "';";
        Connection connection = DBConnection.getConnection();
        return DBHandler.setData(connection, sql);
    }

    public static List searchEmployee(String searchTerm, String key) throws SQLException {
        ArrayList<Employee> list;
        list = new ArrayList();
        switch (key) {
            case "name": {
                String sql = "SELECT * FROM employee WHERE employee_name LIKE '%" + searchTerm + "%'";
                ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
                while (results.next()) {
                    Employee employee = new Employee(results.getString("employee_id"), results.getString("employee_name"), results.getString("employee_address"), results.getString("employee_telephone"));
                    list.add(employee);
                }
            }

            case "id": {
                String sql = "SELECT * FROM employee WHERE employee_id ='" + searchTerm + "'";
                ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
                while (results.next()) {
                    Employee employee = new Employee(results.getString("employee_id"), results.getString("employee_name"), results.getString("employee_address"), results.getString("employee_telephone"));
                    list.add(employee);
                }
            }
        }
        return list;
    }

    public static String getNewId() throws SQLException {
        String sql = "SELECT employee_id FROM employee ORDER BY employee_id ASC";
        ResultSet idSet = DBHandler.getData(DBConnection.getConnection(), sql);
        if (idSet.last()) {
            return IdGen.getId(idSet.getString("employee"));
        } else {
            return IdGen.getId("E000");
        }
    }
}
