package d3.data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    //private String url= "jdbc:hive2://10.0.41.99:10000/";
	private String url= "jdbc:hive2://10.0.41.99:10000/";//"jdbc:hive2://182.71.250.92:10000/";
	//private String url= "jdbc:hive2://10.0.41.123:10000/";
    private String database="default";
    private String user="root";
    private String pass="root321";
    private String driver = "org.apache.hive.jdbc.HiveDriver";
    
    private String connectionString = url + database;
    
    public Connection getConnection()
    {
        
        Connection con=null;
        
        try {
            Class.forName(driver);
             con = DriverManager.getConnection(connectionString, user, pass);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return con;
    }
    
    

}
