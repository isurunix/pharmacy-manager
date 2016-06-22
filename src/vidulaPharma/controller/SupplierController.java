/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.controller;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vidulaPharma.db.DBConnection;
import vidulaPharma.db.DBHandler;
import vidulaPharma.etc.IdGen;
import vidulaPharma.model.Supplier;

/**
 *
 * @author isuru
 */
public class SupplierController {

    //add a supplier record
    public static boolean addSupplier(Supplier supplier) throws SQLException {
        String sql = "INSERT INTO supplier VALUES('" + supplier.getSupplierId() + "','" + supplier.getSupplierName() + "','" + supplier.getSupplierAddress() + "','" + supplier.getSupplierTelephone() + "')";
        Connection connection = DBConnection.getConnection();
        return DBHandler.setData(connection, sql);
    }

    //edit supplier record
    public static boolean editSupplier(Supplier supplier) throws SQLException {
        String sql = "UPDATE supplier SET supplier_name='" + supplier.getSupplierName() + "',supplier_address='" + supplier.getSupplierAddress() + "',suplier_telephone='" + supplier.getSupplierTelephone() + "';";
        Connection connection = DBConnection.getConnection();
        return DBHandler.setData(connection, sql);
    }

    public static List searchSupplier(String searchTerm, String key) throws SQLException {
        ArrayList<Supplier> list;
        list = new ArrayList();
        switch (key) {
            case "name": {
                String sql = "SELECT * FROM supplier WHERE supplier_name LIKE '%" + searchTerm + "%'";
                ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
                while (results.next()) {
                    Supplier supplier = new Supplier(results.getString("supplier_id"), results.getString("supplier_name"), results.getString("supplier_address"), results.getString("suplier_telephone"));
                    list.add(supplier);
                }
            }

            case "id": {
                String sql = "SELECT * FROM supplier WHERE supplier_id ='" + searchTerm + "'";
                ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
                while (results.next()) {
                    Supplier supplier = new Supplier(results.getString("supplier_id"), results.getString("supplier_name"), results.getString("supplier_address"), results.getString("suplier_telephone"));
                    list.add(supplier);
                }
            }
        }
        return list;
    }

    public static String getNewId() throws SQLException {
        String sql = "SELECT supplier_id FROM supplier ORDER BY supplier_id ASC";
        ResultSet idSet = DBHandler.getData(DBConnection.getConnection(), sql);
        if (idSet.last()) {
            return IdGen.getId(idSet.getString("supplier_id"));
        } else {
            return IdGen.getId("S000");
        }
    }

    public static List<Supplier> getAll() throws SQLException {
        String sql = "SELECT * FROM supplier";
        ResultSet rSet = DBHandler.getData(DBConnection.getConnection(), sql);
        ArrayList<Supplier> suppliers = new ArrayList<>();
        while (rSet.next()) {
            Supplier supplier = new Supplier(rSet.getString("supplier_id"), rSet.getString("supplier_name"), rSet.getString("supplier_address"), rSet.getString("suplier_telephone"));
            suppliers.add(supplier);
        }
        return suppliers;
    }

    public static Supplier getSupplier(String id) throws SQLException {
        String sql = "SELECT * FROM supplier WHERE supplier_id ='" + id + "'";
        ResultSet rSet = DBHandler.getData(DBConnection.getConnection(), sql);
        if (rSet.next()) {
            Supplier supplier = new Supplier(rSet.getString("supplier_id"), rSet.getString("supplier_name"), rSet.getString("supplier_address"), rSet.getString("suplier_telephone"));
            return supplier;
        } else {

            return null;
        }
    }
}
