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
import vidulaPharma.model.Drug;

/**
 *
 * @author isuru
 */
public class DrugController {
//    private String drugId;
//    private String drugNameId;
//    private String drugType;
//    private int dose;
//    private double unitPrice;
//    private String expireDate;
    private static boolean isError = false;
    
   
    public static boolean addDrug(Drug drug) throws SQLException{
        String sql = "INSERT INTO drug VALUES ('"+drug.getDrugId()+"','"+drug.getDrugNameId()+"','"+drug.getDrugType()+"',"+drug.getDose()+","+drug.getUnitPrice()+",'"+drug.getExpireDate()+"','"+drug.getQtyOnHand()+"',"+drug.getAvailability()+")";
        boolean isAdded = DBHandler.setData(DBConnection.getConnection(), sql);
        return isAdded;
    }
    
    public static boolean removeDrug(Drug drug) throws SQLException{
        String sql = "DELETE FROM drug WHERE drug_id = '"+drug.getDrugId()+"'";
        boolean isDeleted = DBHandler.setData(DBConnection.getConnection(), sql);
        return  isDeleted;
    }
    
    public static boolean updateDrug(Drug drug) throws SQLException{
        String sql = "UPDATE drug SET drug_expire_date = '"+drug.getExpireDate()+"', drug_qty = '"+drug.getQtyOnHand()+"', availability = "+true+" WHERE drug_name_id = '"+drug.getDrugNameId()+"'";
        boolean isUpdated = DBHandler.setData(DBConnection.getConnection(), sql);
        return isUpdated;
    }
    
    public static boolean updateQty(ArrayList<Drug> drugList) throws SQLException{
        Connection connection = DBConnection.getConnection();
        connection.setAutoCommit(false);
        for(Drug drug : drugList){
            String sql = "UPDATE drug SET drug_qty = '"+drug.getQtyOnHand()+"' WHERE drug_id = '"+drug.getDrugId()+"'";
            boolean isUpdated = DBHandler.setData(connection, sql);
            if(!isUpdated){
                isError = true;
            }
        }
        if(isError){
            connection.rollback();
        }else{
            connection.commit();
        }
        return !isError;        
    }
    
    public static List<Drug> getAll() throws SQLException{
        String sql = "SELECT * FROM drug";
        ArrayList<Drug> drugList = new ArrayList<>();                   
        ResultSet rSet = DBHandler.getData(DBConnection.getConnection(), sql);
        while(rSet.next()){
            drugList.add(new Drug(rSet.getString("drug_id"), rSet.getString("drug_name_id"), rSet.getString("drug_type"), rSet.getInt("drug_dose"), rSet.getDouble("drug_unit_price"), rSet.getString("drug_expire_date"),rSet.getString("drug_qty"),rSet.getBoolean("availability")));
        }
        return drugList;
    }
    
    public static List<Drug> getLowOnStock() throws SQLException{
        String sql = "SELECT * FROM drug WHERE drug_qty<50";
        ArrayList<Drug> lowStockList = new ArrayList<>();
        ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
        while(results.next()){
            lowStockList.add(new Drug(results.getString("drug_id"), results.getString("drug_name_id"), results.getString("drug_type"), results.getInt("drug_dose"), results.getDouble("drug_unit_price"), results.getString("drug_expire_date"), results.getString("drug_qty"),results.getBoolean("availability")));
        }
        return lowStockList;
    }
    
    public static String getNewId() throws SQLException {
        String sql = "SELECT drug_id FROM drug ORDER BY drug_id ASC";
        ResultSet idSet = DBHandler.getData(DBConnection.getConnection(), sql);
        if (idSet.last()) {
            return IdGen.getId(idSet.getString("drug_id"));
        } else {
            return IdGen.getId("D000");
        }
    }
    
    public static Drug getDrug(String id ) throws SQLException{
        String sql = "SELECT * FROM drug WHERE drug_id = '"+id+"'";
        ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
        Drug drug = null;
        while(results.next()){
           drug = new Drug(results.getString("drug_id"), results.getString("drug_name_id"), results.getString("drug_type"), results.getInt("drug_dose"), results.getDouble("drug_unit_price"), results.getString("drug_expire_date"), results.getString("drug_qty"), results.getBoolean("availability"));
        }
        return drug;
    }
    
    public static Drug searchDrugByTradeName(String tradeId) throws SQLException{
        String sql = "SELECT * FROM drug WHERE (drug_name_id = '"+tradeId+"' AND availability = true)";
        ResultSet result = DBHandler.getData(DBConnection.getConnection(), sql);
        Drug drug= null;
        if(result.next()){
            drug = new Drug(result.getString("drug_id"), result.getString("drug_name_id"), result.getString("drug_type"), result.getInt("drug_dose"), result.getDouble("drug_unit_price"), result.getString("drug_expire_date"), result.getString("drug_qty"), result.getBoolean("availability"));
            return drug;
        }else{
            return null;
        }
    }
    
    public static ResultSet pharmacistSearch(String key , String type) throws SQLException{
         String sql = null;
        switch (type) {
            case "trade_name":
                sql = "SELECT * FROM trade_name RIGHT JOIN drug ON drug.drug_name_id = trade_name.trade_id WHERE trade_name LIKE '%"+key+"%'";
                break;
            case "pharma_name":
                sql = "SELECT * FROM pharma_name";
                break;
        }
        ResultSet rSet = DBHandler.getData(DBConnection.getConnection(), sql);
        return rSet;
    }
    
    public static ResultSet pharmacistSearchForPharmaName(String key) throws SQLException{
        String sql = "SELECT trade_name,drug_id FROM trade_name t,drug d,pharma_name p WHERE d.drug_name_id = t.trade_id AND p.pharma_id = t.pharma_id AND p.pharma_id = '"+key+"'";
        ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
        return results;
    }
}
