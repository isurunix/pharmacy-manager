/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vidulaPharma.db.DBConnection;
import vidulaPharma.db.DBHandler;
import vidulaPharma.etc.IdGen;
import vidulaPharma.model.CustomerOrder;

/**
 *
 * @author isuru
 */
public class CustomerOrderController {
    
    public static boolean addCustomerOrder(CustomerOrder customerOrder) throws SQLException{
        String sql= "INSERT INTO customer_order VALUES('"+customerOrder.getCustomerOrderId()+"','"+customerOrder.getCustomerOrderDate()+"',"+customerOrder.getAmount()+",'"+customerOrder.getEmployeeId()+"')";
        return DBHandler.setData(DBConnection.getConnection(), sql);
    }
    
    public static CustomerOrder searchCustomerOrder(String id) throws SQLException{
        String sql = "SELECT * FROM customer_order WHERE customer_order_id = '"+id+"'";
        ResultSet rSet = DBHandler.getData(DBConnection.getConnection(), sql);
        CustomerOrder customerOrder=null;
        if(rSet.next()){
            customerOrder = new CustomerOrder(rSet.getString("customer_order_id"), rSet.getString("customer_order_date"), rSet.getDouble("customer_order_amount"), rSet.getString("employee_id"));
        }
        return customerOrder;
    }
    
    public static String getNewId() throws SQLException{
        String sql = "SELECT customer_order_id FROM customer_order";
        ResultSet resultSet = DBHandler.getData(DBConnection.getConnection(), sql);
        if(resultSet.last()){
            return IdGen.getId(resultSet.getString("customer_order_id"));
        }else{
            return IdGen.getId("C001");
        }
    }
    
    public static List<CustomerOrder> searchByDate(String date) throws SQLException{
        String sql = "SELECT * FROM customer_order WHERE customer_order_date = '"+date+"'";
        ResultSet resultSet = DBHandler.getData(DBConnection.getConnection(), sql);
        ArrayList<CustomerOrder> orderList = new ArrayList<>();
        while(resultSet.next()){
            orderList.add(new CustomerOrder(resultSet.getString("customer_order_id"), resultSet.getString("customer_order_date"), resultSet.getDouble("customer_order_amount"), resultSet.getString("employee_id")));
        }
        return orderList;
    }
}
