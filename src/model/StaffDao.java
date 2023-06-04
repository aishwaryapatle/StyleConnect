package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DatabaseConn;


public class StaffDao {
	
	public static int addStaff(Staff s) throws SQLException, ClassNotFoundException
	{
		String query = "INSERT INTO BarberDB.staff (staffName, staffEmail, staffMobile, staffGender, staffAddress, staffSalary) values (?,?,?,?,?,?)";
		Connection con = DatabaseConn.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, s.getStaffName());
		ps.setString(2, s.getStaffEmail());
		ps.setString(3, s.getStaffMobile());
		ps.setString(4, s.getStaffGender());
		ps.setString(5, s.getStaffAddress());
		ps.setFloat(6, s.getStaffSalary());
		
		int a = ps.executeUpdate();
		con.close();
		return a;
		
	}
	
	public static int updateStaff(Staff s)
    {
    	int a = 0;
    	try {
    		Connection con = DatabaseConn.getConnection();
    		// AS we are not sure about what fields need to be
    		// updated, we are setting for all the fields by
    		// means of update query This will update the record
    		// for the corresponding StaffId
    		PreparedStatement ps = con.prepareStatement(
    			"update BarberDB.staff set staffName=?, staffEmail=?, staffMobile=?, staffGender=?, staffAddress=?, staffSalary=? where staffId=?");
    		
    		ps.setString(1, s.getStaffName());
    		ps.setString(2, s.getStaffEmail());
    		ps.setString(3, s.getStaffMobile());
    		ps.setString(4, s.getStaffGender());
    		ps.setString(5, s.getStaffAddress());
    		ps.setFloat(6, s.getStaffSalary());
    		ps.setInt(7, s.getStaffId());

    		a = ps.executeUpdate();
    		con.close();
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}

    	return a;
    }
	
	public static int deleteStaff(int staffId) throws ClassNotFoundException, SQLException 
	{
		String query = "delete from BarberDB.staff where staffId=?";
		Connection con=DatabaseConn.getConnection();
    	PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, staffId);
	
		int a=ps.executeUpdate();
		con.close();
		return  a;
	}
	
	
	public static List<Staff> getAllStaff() throws ClassNotFoundException, SQLException 
	{
		String sql="SELECT * FROM BarberDB.staff";
		Connection con = DatabaseConn.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		List<Staff> le=new ArrayList<Staff>();
		while(rs.next())
		{
			Staff e=new Staff(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getFloat(7));
			le.add(e);
		}
		return le;
	}
	
	 public static Staff getStaffById(int id)
     {
    	Staff e = new Staff();
    	try {
    		Connection con = DatabaseConn.getConnection();
    		// We are getting the details for a specific user
    		// and hence the query has to be sent in the below way
    		PreparedStatement ps = con.prepareStatement("SELECT * FROM BarberDB.staff where staffId=?");
    		ps.setInt(1, id);
    		ResultSet rs = ps.executeQuery();
    		if (rs.next()) {
    			e.setStaffId(rs.getInt(1));
    			e.setStaffName(rs.getString(2));
    			e.setStaffEmail(rs.getString(3));
    			e.setStaffMobile(rs.getString(4));
    			e.setStaffGender(rs.getString(5));
    			e.setStaffAddress(rs.getString(6));
    			e.setStaffSalary(rs.getFloat(7));
    		}
    		con.close();
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}

    	return e;
     }
	 
	public static List<Staff> getOneStaff(int id) throws ClassNotFoundException, SQLException 
	{
		String sql="SELECT * FROM BarberDB.staff where staffId=?";
		Connection con = DatabaseConn.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery(sql);
		
		List<Staff> le=new ArrayList<Staff>();
		while(rs.next())
		{
			Staff e=new Staff(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getFloat(7));
			le.add(e);
		}
		return le;
	}
	
	
	public static List<Staff> getOnlyStaffName() throws ClassNotFoundException, SQLException 
	{
		String sql="SELECT staffName FROM BarberDB.staff";
		Connection con = DatabaseConn.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		List<Staff> le=new ArrayList<Staff>();
		while(rs.next())
		{
			Staff e=new Staff(rs.getString("staffName"));
			le.add(e);
		}
		return le;
	}
}
