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
import vidulaPharma.model.SupplierOrderDetail;

/**
 *
 * @author isuru
 */
public class SupplierOrderDetailController {
    public static boolean adOrderdetail(List<SupplierOrderDetail> detailList) throws SQLException{
        Connection connection = DBConnection.getConnection();
        connection.setAutoCommit(false);
        boolean noError = true;
        int i=0;
        while(noError && i<detailList.size()){
            SupplierOrderDetail detail = detailList.get(i++);
            String sql = "INSERT INTO supplier_order_details VALUES('"+detail.getSupplierOrderId()+"','"+detail.getDrugId()+"',"+detail.getUnitPrice()+",'"+detail.getUnitType()+"',"+detail.getDose()+",'"+detail.getQty()+"') ";
            noError = DBHandler.setData(connection, sql);
        }
        if(noError){
            connection.commit();
        }
        return noError;
    }
    
    public static List<SupplierOrderDetail> getOrderDetails(String orderId) throws SQLException{
        String sql = "SELECT * FROM supplier_order_details WHERE order_id = '"+orderId+"'";
        ResultSet resultSet = DBHandler.getData(DBConnection.getConnection(), sql);
        List<SupplierOrderDetail> detList = new ArrayList<>();
        while(resultSet.next()){
            detList.add(new SupplierOrderDetail(resultSet.getString("order_id"), resultSet.getString("trade_id"), resultSet.getDouble("unit_price"), resultSet.getString("unit_type"), resultSet.getString("qty"), resultSet.getInt("dose")));
        }
        return detList;
    }
}
