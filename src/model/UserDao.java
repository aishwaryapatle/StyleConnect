package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconnection.DatabaseConn;


public class UserDao {
		
	private String query;
	private ResultSet rs;
	
	
	public static int userRegistration(User u) throws SQLException, ClassNotFoundException
    {
    	Connection con = DatabaseConn.getConnection();
    	
    	Statement st = con.createStatement();
  		System.out.println("Statement created");
    	
    	int a = st.executeUpdate("INSERT INTO BarberDB.users (uname, uemail, uphoneno, upassword, urole) values('"+u.getName()+"','"+u.getEmail()+"','"+u.getPhoneno()+"','"+u.getPassword()+"','"+u.getRole()+"')");
		con.close();
    	return a;
    }

	public String authenticateUser(User user) {
		
		query = "select uemail, upassword, urole from BarberDB.users";
		String emailDB = "";
		String passwordDB = "";
		String roleDB = "";
		
		String email = user.getEmail();
		String password = user.getPassword();
		
		try {
			Connection con = DatabaseConn.getConnection();
			Statement statement = con.createStatement();
			rs = statement.executeQuery(query);
			
			while(rs.next())
			{
				emailDB = rs.getString("uemail");
				passwordDB = rs.getString("upassword");
				roleDB = rs.getString("urole");
				
				if(email.equals(emailDB) && password.equals(passwordDB) && roleDB.equals("user"))
				{
					return "User_Role";
				}
				else if(email.equals(emailDB) && password.equals(passwordDB) && roleDB.equals("admin"))
				{
					return "Admin_Role";
				}

			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Not_Valid";
	}	
}
