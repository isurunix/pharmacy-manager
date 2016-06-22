/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author isuru
 */
public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;
    private static final BasicDataSource DATA_SOURCE = new BasicDataSource();
    
//    static {
//        DATA_SOURCE.setDriverClassName("com.mysql.jdbc.Driver");
//        DATA_SOURCE.setUrl("jdbc:mysql://localhost:3306/Pharmacy");
//        DATA_SOURCE.setUsername("root");
//        DATA_SOURCE.setPassword("cheng3");
//    }
    
    private DBConnection() throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacy","root","cheng3");
    }
    
    public static Connection getConnection() throws SQLException{
        if(dbConnection==null){
            dbConnection = new DBConnection();
        }
        return dbConnection.connection;
//        return DATA_SOURCE.getConnection();
    }
    
    
}
