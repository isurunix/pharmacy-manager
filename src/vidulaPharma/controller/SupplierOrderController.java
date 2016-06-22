/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.controller;

import com.sun.jmx.remote.util.OrderClassLoaders;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vidulaPharma.db.DBConnection;
import vidulaPharma.db.DBHandler;
import vidulaPharma.etc.IdGen;
import vidulaPharma.model.SupplierOrder;
import vidulaPharma.model.SupplierOrderDetail;

/**
 *
 * @author isuru
 */
public class SupplierOrderController {
    
    public static String getNewId() throws SQLException{
        String sql = "SELECT suppplier_order_id FROM supplier_order";
        ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
        if(results.last()){
            return IdGen.getId(results.getString("suppplier_order_id"));
        }else{
            return IdGen.getId("D000");
        }
    }
    public static boolean addSupplierOrder(SupplierOrder supplierOrder) throws SQLException{
        //Connection connection = DBConnection.getConnection();
        //connection.setAutoCommit(false);
        String sql = "INSERT INTO supplier_order VALUES('"+supplierOrder.getSupplierOrderId()+"','"+supplierOrder.getSupplierId()+"','"+supplierOrder.getSupplierOrderDate()+"','"+supplierOrder.getSupplierPaymentId()+"')";
        //boolean isAdded = DBHandler.setData(connection, sql);
        
        return DBHandler.setData(DBConnection.getConnection(), sql);
    }
    
    public static boolean editSupplierOrder(SupplierOrder supplierOrder) throws SQLException{
        String sql = "UPDATE supplier_order SET supplier_id='"+supplierOrder.getSupplierId()+"' WHERE supplier_order_id ='"+supplierOrder.getSupplierOrderId()+"'";
        return DBHandler.setData(DBConnection.getConnection(), sql);
    }
    
    public static boolean deleteSupplierOrder(SupplierOrder supplierOrder) throws SQLException{
        String sql = "DELETE FROM supplier_order WHERE supplier_order_id = '"+supplierOrder.getSupplierOrderId()+"'";
        return DBHandler.setData(DBConnection.getConnection(), sql);
    }
    
    public static List searchSupplierOrder(String searchTerm, String key) throws SQLException{
        ArrayList<SupplierOrder> orders = new ArrayList<>();
        ResultSet results = null;
        switch(key){
            
            case "orderId" :
            {
                String sql = "SELECT * FROM supplier_order WHERE suppplier_order_id = '"+searchTerm+"'";
                results = DBHandler.getData(DBConnection.getConnection(), sql);
            }
                
            case "supplierId" :
            {
                String sql = "SELECT * FROM supplier_order WHERE supplier_id = '"+searchTerm+"'";
                results = DBHandler.getData(DBConnection.getConnection(), sql);
            }
        }
        while(results.next()){
            SupplierOrder supplierOrder = new SupplierOrder(results.getString("suppplier_order_id"), results.getString("supplier_id"), results.getString("supplier_order_date"), results.getString("supplier_payment_id"));
            orders.add(supplierOrder);
        }
        return orders;
    }
    
    public static List<SupplierOrder> searchByDate(String date) throws SQLException{
        String sql = "SELECT * FROM supplier_order WHERE supplier_order_date = '"+date+"'";
        ResultSet dataSet = DBHandler.getData(DBConnection.getConnection(), sql);
        ArrayList<SupplierOrder> orderList = new ArrayList<>();
        while(dataSet.next()){
            orderList.add(new SupplierOrder(dataSet.getString("suppplier_order_id"), dataSet.getString("supplier_id"), dataSet.getString("supplier_order_date"), dataSet.getString("supplier_payment_id")));
        }
        return orderList;
    }
}
