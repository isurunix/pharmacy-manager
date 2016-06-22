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
import vidulaPharma.model.PharamaName;

/**
 *
 * @author isuru
 */
public class PharmaNameController {

    //add new pharmaname record
    public static boolean addPharmaName(PharamaName pharamaName) throws SQLException {
        String sql = "INSERT INTO pharma_name VALUES('" + pharamaName.getPharmaId() + "','" + pharamaName.getPharmaName() + "')";
        return DBHandler.setData(DBConnection.getConnection(), sql);
    }

    public static boolean editPharmaName(PharamaName pharamaName) throws SQLException {
        String sql = "UPDATE pharma_name SET pharma_name='" + pharamaName.getPharmaName() + "' WHERE pharma_id ='" + pharamaName.getPharmaId() + "'";
        return DBHandler.setData(DBConnection.getConnection(), sql);
    }

    public static boolean deletePharmaName(PharamaName pharamaName) throws SQLException {
        String sql = "DELETE FROM pharma_name WHERE pharma_id = '" + pharamaName.getPharmaId() + "'";
        return DBHandler.setData(DBConnection.getConnection(), sql);
    }
    
    public static List<PharamaName> getAll() throws SQLException{
        String sql = "SELECT * FROM pharma_name";
        ResultSet rSet = DBHandler.getData(DBConnection.getConnection(), sql);
        ArrayList<PharamaName> nameList = new ArrayList<>();
        while(rSet.next()){
            nameList.add(new PharamaName(rSet.getString("pharma_id"), rSet.getString("pharma_name")));
        }
        return nameList;
    }

    public static List searchPharamaName(String searchTerm, String key) throws SQLException {
        ArrayList<PharamaName> list;
        list = new ArrayList();
        switch (key) {
            case "name": {
                String sql = "SELECT * FROM pharma_name WHERE pharma_name LIKE '%" + searchTerm + "%'";
                ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
                while (results.next()) {
                    PharamaName pharamaName = new PharamaName(results.getString("pharma_id"), results.getString("pharma_name"));
                    list.add(pharamaName);
                }
            }

            case "id": {
                String sql = "SELECT * FROM pharma_name WHERE pharma_id ='" + searchTerm + "'";
                ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
                while (results.next()) {
                    PharamaName pharamaName = new PharamaName(results.getString("pharma_id"), results.getString("phama_name"));
                    list.add(pharamaName);
                }
            }
        }
        return list;
    }

    public static String searchPharmaId(String id) throws SQLException {
        String sql = "SELECT * FROM pharma_name WHERE pharma_id ='" + id + "'";
        ResultSet results = DBHandler.getData(DBConnection.getConnection(), sql);
        String pName = null;
        if(results.next()){
            pName =  results.getString("pharma_name");
        }
        return pName;
    }
    
    public static String getNewId() throws SQLException{
        String sql = "SELECT pharma_id FROM pharma_name";
        ResultSet rSet = DBHandler.getData(DBConnection.getConnection(), sql);
        if(rSet.last()){
            return IdGen.getId(rSet.getString("pharma_id"));
        }else{
            return IdGen.getId("P001");
        }
    }
}
