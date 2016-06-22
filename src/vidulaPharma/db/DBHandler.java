/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author isuru
 */
public class DBHandler {
    
    //write data to database
    public static boolean setData(Connection connection,String sql,Object[] dataSet) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;
        for(Object data : dataSet){
            preparedStatement.setObject(i++, data);
        }
        return preparedStatement.executeUpdate()>0;
    }
    
    //read data from database
    public static ResultSet getData(Connection connection,String sql,Object[] dataSet) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;
        for(Object data : dataSet){
            preparedStatement.setObject(i++, data);
        }
        return preparedStatement.executeQuery();
    }
    
    //write data to database
    public static ResultSet getData(Connection connection,String sql) throws SQLException{
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }
    
    //read data from database
    public static boolean setData(Connection connection,String sql) throws SQLException{
        Statement statement = connection.createStatement();
        return statement.executeUpdate(sql)>0;
    }
}
