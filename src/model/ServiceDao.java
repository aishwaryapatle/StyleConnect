package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DatabaseConn;

public class ServiceDao {

	public static int addService(Service s) throws SQLException, ClassNotFoundException
    {
    	Connection con = DatabaseConn.getConnection();
    	Statement st = con.createStatement();
  		System.out.println("Statement created");
    	
    	int a = st.executeUpdate("INSERT INTO BarberDB.service (sname, sprice) values('"+s.getSname()+"','"+s.getSprice()+"')");
		con.close();
    	return a;
    }
	
	public static int deleteService(int sid) throws ClassNotFoundException, SQLException 
	{
		Connection con=DatabaseConn.getConnection();
    	PreparedStatement ps=con.prepareStatement("delete from BarberDB.service where sid=?");
		ps.setInt(1, sid);
	
		int a=ps.executeUpdate();
		con.close();
		return  a;
	}
	
	public static int updateService(Service s)
    {
    	int a = 0;
    	try {
    		Connection con = DatabaseConn.getConnection();
    		// AS we are not sure about what fields need to be
    		// updated, we are setting for all the fields by
    		// means of update query This will update the record
    		// for the corresponding geekUserId
    		PreparedStatement ps = con.prepareStatement(
    			"update BarberDB.service set sname=?, sprice=? where sid=?");
    		
    		ps.setString(1, s.getSname());
    		ps.setFloat(2, s.getSprice());
    		ps.setInt(3, s.getSid());

    		a = ps.executeUpdate();
    		con.close();
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}

    	return a;
    }
	
	
	public static Service getServiceById(int id)
    {
		Service e = new Service();
	   	try {
	   		Connection con = DatabaseConn.getConnection();
	   		// We are getting the details for a specific user
	   		// and hence the query has to be sent in the below way
	   		PreparedStatement ps = con.prepareStatement("SELECT * from BarberDB.service where sid=?");
	   		ps.setInt(1, id);
	   		ResultSet rs = ps.executeQuery();
	   		if (rs.next()) {
	   			e.setSid(rs.getInt(1));
	   			e.setSname(rs.getString(2));
	   			e.setSprice(rs.getFloat(3));
	   		}
	   		con.close();
	   	}
	   	catch (Exception ex) {
	   		ex.printStackTrace();
	   	}

	   	return e;
    }
	
	
	public static List<Service> getAllService() throws ClassNotFoundException, SQLException 
	{
		String sql="SELECT * FROM BarberDB.service";
		Connection con = DatabaseConn.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		List<Service> le=new ArrayList<Service>();
		while(rs.next())
		{
			Service e=new Service(rs.getInt(1),rs.getString(2), rs.getFloat(3));
			le.add(e);
		}
		return le;
	}
	
	
	public static List<Service> getServiceNamePrice() throws ClassNotFoundException, SQLException 
	{
		String sql="SELECT * FROM BarberDB.service";
		Connection con = DatabaseConn.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		List<Service> le=new ArrayList<Service>();
		while(rs.next())
		{
			Service e=new Service(rs.getString("sname"), rs.getFloat("sprice"));
			le.add(e);
		}
		return le;
	}
	
	
	
}
