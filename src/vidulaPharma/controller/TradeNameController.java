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
import vidulaPharma.model.TradeName;

/**
 *
 * @author isuru
 */
public class TradeNameController {

    public static boolean addPharmaName(TradeName tradeName) throws SQLException {
        String sql = "INSERT INTO trade_name VALUES('" + tradeName.getTradeId() + "','" + tradeName.getTradeName()+ "','" + tradeName.getPharmaId() + "')";
        return DBHandler.setData(DBConnection.getConnection(), sql);
    }

    public static boolean editPharmaName(TradeName tradeName) throws SQLException {
        String sql = "UPDATE trade_name SET trade_name='" + tradeName.getTradeName() + "' WHERE trade_id ='" + tradeName.getTradeId() + "'";
        return DBHandler.setData(DBConnection.getConnection(), sql);
    }

    public static boolean deletePharmaName(TradeName tradeName) throws SQLException {
        String sql = "DELETE FROM trade_name WHERE trade_id = '" + tradeName.getTradeId() + "'";
        return DBHandler.setData(DBConnection.getConnection(), sql);
    }

    public static List searchTradeName(String searchTerm, String key) throws SQLException {
        ArrayList<TradeName> list;
        list = new ArrayList();
        switch (key) {
            case "name": {
                String sql = "SELECT * FROM trade_name WHERE trade_name LIKE '%" + searchTerm + "%'";
                ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
                while (results.next()) {
                    TradeName tradeName = new TradeName(results.getString("trade_id"), results.getString("pharma_id"), results.getString("trade_name"));
                    list.add(tradeName);
                }
            }

            case "id": {
                String sql = "SELECT * FROM trade_name WHERE trade_id ='" + searchTerm + "'";
                ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
                while (results.next()) {
                    TradeName tradeName = new TradeName(results.getString("trade_id"), results.getString("pharma_id"), results.getString("trade_name"));
                    list.add(tradeName);
                }
            }
        }
        return list;
    }

    public static List<TradeName> getAll() throws SQLException {
        String sql = "SELECT * FROM trade_name";
        ResultSet rSet = DBHandler.getData(DBConnection.getConnection(), sql);
        ArrayList<TradeName> nameList = new ArrayList<>();
        while (rSet.next()) {
            nameList.add(new TradeName(rSet.getString("trade_id"), rSet.getString("pharma_id"), rSet.getString("trade_name")));
        }
        return nameList;
    }

    public static TradeName searchTradeId(String id) throws SQLException {
        String sql = "SELECT * FROM trade_name WHERE trade_id ='" + id + "'";
        ResultSet rSet = DBHandler.getData(DBConnection.getConnection(), sql);
        TradeName tradeName = null;
        if (rSet.next()) {
            tradeName = new TradeName(rSet.getString("trade_id"), rSet.getString("pharma_id"), rSet.getString("trade_name"));
        }
        return tradeName;
    }
    
    public static String getNewId() throws SQLException{
        String sql = "SELECT trade_id FROM trade_name";
        ResultSet rSet = DBHandler.getData(DBConnection.getConnection(), sql);
        if(rSet.last()){
            return IdGen.getId(rSet.getString("trade_id"));
        }else{
            return IdGen.getId("T000");
        }
    }
}
