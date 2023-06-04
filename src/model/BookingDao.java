package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DatabaseConn;


public class BookingDao {
	
	public static int booking_insert(Booking b) throws SQLException, ClassNotFoundException
    {
//    	String query = "Insert into booking values (?,?,?,?,?,?,?,?)";
		Connection con = DatabaseConn.getConnection();
		String query = "INSERT INTO BarberDB.booking (bdate, btime, bservices, bbarbers, bname, bemail, bphoneno, bprice, bdiscountPercentage, bdiscountAmount) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, b.getDate());
		ps.setString(2, b.getTime());
		ps.setString(3, b.getServices());
		ps.setString(4, b.getBarbers());
		ps.setString(5, b.getName());
		ps.setString(6, b.getEmail());
		ps.setString(7, b.getPhoneno());
		ps.setFloat(8, b.getPrice());
		ps.setFloat(9, b.getDiscountPercentage());
		ps.setFloat(10, b.getDiscountAmount());
		
		int a = ps.executeUpdate();
		con.close();
		return a;
		
    	
    	
//    	Statement st = con.createStatement();
//  		System.out.println("Statement created");
//    	
//    	int a = st.executeUpdate("INSERT INTO booking "
//    			+ "(bdate, btime, bservices, bbarbers, bname, bemail, bphoneno, bprice) "
//    			+ "values('"+b.getDate()+"','"+b.getTime()+"','"+b.getServices()+"','"+b.getBarbers()+"', '"+b.getName()+"','"+b.getEmail()+"','"+b.getPhoneno()+"','"+b.getPrice()+"')");
//		con.close();
//    	return a;
    }

	
	public static List<Booking> getOneUserData(String email) throws ClassNotFoundException, SQLException {

		String sql="SELECT * FROM BarberDB.booking where bemail=?";
		Connection con = DatabaseConn.getConnection();
    	PreparedStatement ps=con.prepareStatement(sql);
    	ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		
		List<Booking> le = new ArrayList<Booking>();
		while(rs.next())
		{
			Booking b = new Booking();
			b.setBid(rs.getInt(1));
			b.setDate(rs.getString(2));
			b.setTime(rs.getString(3));
			b.setServices(rs.getString(4));
			b.setBarbers(rs.getString(5));
			b.setName(rs.getString(6));
			b.setEmail(rs.getString(7));
			b.setPhoneno(rs.getString(8));
			b.setPrice(rs.getFloat(9));
			b.setDiscountPercentage(rs.getFloat(10));
			b.setDiscountAmount(rs.getFloat(11));
			le.add(b);
		}
		con.close();
		
		return le;
	}
	
	
	public static List<Booking> getAllBooking() {
		List<Booking> list = new ArrayList<Booking>();

    	try {
    		Connection con = DatabaseConn.getConnection();
    		PreparedStatement ps = con.prepareStatement("select * from BarberDB.booking");
    		ResultSet rs = ps.executeQuery();
    		while (rs.next()) {
    			Booking b = new Booking();
    			b.setBid(rs.getInt(1));
    			b.setDate(rs.getString(2));
    			b.setTime(rs.getString(3));
    			b.setServices(rs.getString(4));
    			b.setBarbers(rs.getString(5));
    			b.setName(rs.getString(6));
    			b.setEmail(rs.getString(7));
    			b.setPhoneno(rs.getString(8));
    			b.setPrice(rs.getFloat(9));
    			b.setDiscountPercentage(rs.getFloat(10));
    			b.setDiscountAmount(rs.getFloat(11));
    			
    			list.add(b);
    		}
    		con.close();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}

    	return list;
	}	
	
	
	public static int booking_delete(int bid)
    {
    	int a=0;
    	try {
    		Connection con = DatabaseConn.getConnection();
    		// delete query is given to delete the record for
    		// the given UserId
    		PreparedStatement ps = con.prepareStatement(
    			"delete from booking where bid=?");
    		ps.setInt(1, bid);
    		a = ps.executeUpdate();
    		con.close();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}

		return a;
    }
}
