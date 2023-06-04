package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DatabaseConn;

public class DiscountDao {

	public static int addDiscount(Discount d) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO BarberDB.discount (discountDay, discount, discountDescription) values (?,?,?)";
		Connection con = DatabaseConn.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, d.getDiscountDay());
		ps.setFloat(2, d.getDiscount());
		ps.setString(3, d.getDescription());

		int a = ps.executeUpdate();
		con.close();
		return a;

	}

	public static int deleteDiscount(int discountId) throws ClassNotFoundException, SQLException {
		String query = "delete from BarberDB.discount where discountId=?";
		Connection con = DatabaseConn.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, discountId);

		int a = ps.executeUpdate();
		con.close();
		return a;
	}

	public static int updateDiscount(Discount d) {
		int a = 0;
		try {
			Connection con = DatabaseConn.getConnection();
			// AS we are not sure about what fields need to be
			// updated, we are setting for all the fields by
			// means of update query This will update the record
			// for the corresponding geekUserId
			PreparedStatement ps = con.prepareStatement(
					"update BarberDB.discount set discountDay=?, discount=?, discountDescription=? where discountId=?");

			ps.setString(1, d.getDiscountDay());
			ps.setFloat(2, d.getDiscount());
			ps.setString(3, d.getDescription());
			ps.setInt(4, d.getDiscountId());

			a = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return a;
	}

	public static List<Discount> getAllDiscount() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM BarberDB.discount";
		Connection con = DatabaseConn.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		List<Discount> le = new ArrayList<Discount>();
		while (rs.next()) {
			Discount d = new Discount(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
			le.add(d);
		}
		return le;
	}

	public static Discount getDiscountById(int id) {
		Discount e = new Discount();
		try {
			Connection con = DatabaseConn.getConnection();
			// We are getting the details for a specific user
			// and hence the query has to be sent in the below way
			PreparedStatement ps = con.prepareStatement("SELECT * from BarberDB.discount where discountId=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setDiscountId(rs.getInt(1));
				e.setDiscountDay(rs.getString(2));
				e.setDiscount(rs.getFloat(3));
				e.setDescription(rs.getString(4));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<Discount> getDiscountAndDay() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM BarberDB.discount";
		Connection con = DatabaseConn.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		List<Discount> le = new ArrayList<Discount>();
		while (rs.next()) {
			Discount d = new Discount(rs.getString(2), rs.getFloat(3));
			le.add(d);
		}
		return le;
	}

	public static float discountAmount(float markedPrice, float discountPercentage) {
		float discount = (discountPercentage / 100) * markedPrice;
		float discountAmount = markedPrice - discount;
		return discountAmount;
	}
}
