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
import vidulaPharma.model.SupplierPayment;

/**
 *
 * @author isuru
 */
public class SupplierPaymentController {
    public static boolean addSupplierPayment(SupplierPayment supplierPayment) throws SQLException{
        String sql= "INSERT INTO supplier_payment (payment_id,employee_id,payment_date,paid) VALUES('"+supplierPayment.getPaymentId()+"','"+supplierPayment.getEmployeeId()+"','"+supplierPayment.getPaymentDate()+"',"+supplierPayment.isPaid()+")";
        return DBHandler.setData(DBConnection.getConnection(), sql);
    }
    
    public static SupplierPayment searchSupplierPayment(String id) throws SQLException{
        String sql = "SELECT * FROM supplier_payment WHERE payment_id = '"+id+"'";
        ResultSet rSet = DBHandler.getData(DBConnection.getConnection(), sql);
        SupplierPayment supplierPayment=null;
        if(rSet.next()){
            supplierPayment = new SupplierPayment(rSet.getString("payment_id"), rSet.getString("employee_id"),rSet.getString("payment_date"),rSet.getDouble("amount"),rSet.getBoolean("paid"));
        }
        return supplierPayment;
    }
    
    public static String getNewId() throws SQLException{
        String sql = "SELECT payment_id FROM supplier_payment";
        ResultSet rSet = DBHandler.getData(DBConnection.getConnection(), sql);
        if(rSet.last()){
            return IdGen.getId(rSet.getString("payment_id"));
        }else{
            return IdGen.getId("P000");
        }
    }
    
    public static List<SupplierPayment> searchByDate(String date) throws SQLException{
        String sql = "SELECT * FROM supplier_payment WHERE payment_date = '"+date+"'";
        ResultSet resultSet = DBHandler.getData(DBConnection.getConnection(), sql);
        ArrayList<SupplierPayment> orderList = new ArrayList<>();
        while(resultSet.next()){
            orderList.add(new SupplierPayment(resultSet.getString("payment_id"), resultSet.getString("employee_id"), resultSet.getString("payment_date"), resultSet.getDouble("amount"),resultSet.getBoolean("paid")));
        }
        return orderList;
    }
    
    public static boolean updatePayment(SupplierPayment payment) throws SQLException{
        String sql = "UPDATE supplier_payment SET amount = "+payment.getAmount()+", paid = "+payment.isPaid()+" WHERE payment_id = '"+payment.getPaymentId()+"'";
        boolean setData = DBHandler.setData(DBConnection.getConnection(), sql);
        return setData;
    }
}
