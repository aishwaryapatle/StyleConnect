package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {
	
	private static String driver1 = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/BarberDB";
    private static String username = "root";
    private static String password = "abc123";
 
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        
    	//Step1 Driver Registration
        Class.forName(driver1);
        
        //Step2 Establishing Connection
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connected");
        
        //Returning the Connection's con to use further
        return con;
    }

}
