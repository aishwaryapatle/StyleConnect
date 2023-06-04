package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Discount;
import model.DiscountDao;


@WebServlet("/discountServlet")
public class DiscountServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='ISO-8859-1'>");
		out.print("<title>Add Staff</title>");
		out.print("<link rel='stylesheet' href='css/serviceServlet.css'>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("    <!--------- <title>Responsive Navigation Menu</title>------>");
        out.print("    <link rel='stylesheet' href='css/adminDashboard.css'>");
        out.print("	   <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
        out.print("    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
        out.print("    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js'></script>");
        out.print("    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <nav>");
        out.print("        <div class='logo'>");
        out.print("            <a href ='index.html'>");
        out.print("                <img src='img/logo.png' alt=''>");
        out.print("            </a>");
        out.print("        </div>");
        out.print("        <input type='checkbox' id='click'>");
        out.print("        <label for='click' class='menu-btn'>");
        out.print("            <i class='fas fa-bars'></i>");
        out.print("        </label>");
        out.print("        <ul>");
        out.print("            <li><a href='index.html'>Home</a></li>");
        out.print("            <li><a href='adminDashboardServlet'>Dashboard</a></li>");
        out.print("            <li><a href='serviceServlet'>Services</a></li>");
        out.print("            <li><a href='staffServlet'>Staff</a></li>");
        out.print("            <li><a class='active' href='discountServlet'>Discount</a></li>");
        out.print("        </ul>");
        out.print("    </nav>");
		
		out.print("<div class='grp1'>");
		
	
        	out.print("<div class='grp2'>");
    		out.print("	<h3 style='font-family:Serif;'><b>Add New Discount</b></h3>");
    		out.print("	<form action='discountActionServlet' method='post'>");
    		out.print("		<table class='css-styled-table'>");
    		out.print("			<tr>");
    		out.print("				<td>Discount Day:</td>");
    		out.print("				<td>");
    		out.print("					<select id='day' name='day'>");
    		out.print("						<option>Day</option>");
    		out.print("						<option value='Sunday'>Sunday</option>");
    		out.print("						<option value='Monday'>Monday</option>");
    		out.print("						<option value='Tuesday'>Tuesday</option>");
    		out.print("						<option value='Wednesday'>Wednesday</option>");
    		out.print("						<option value='Thursday'>Thursday</option>");
    		out.print("						<option value='Friday'>Friday</option>");
    		out.print("						<option value='Saturday'>Saturday</option>");
    		out.print("					</select>");
    		out.print("				</td>");
    		out.print("			</tr>");
    		out.print("				<td>Discount:</td>");
    		out.print("				<td><input type='number' name='discount' ></td>");
    		out.print("			</tr>");
    		out.print("			</tr>");
    		out.print("				<td>Description:</td>");
    		out.print("				<td><textarea name='description' rows='3' cols='22'></textarea></td>");
    		out.print("			</tr>");
    		out.print("			<tr>");
    		out.print("				<td colspan='2' style='text-align: center;''><input style='width: 80px' type='submit' value='Save' /></td>");
    		out.print("			</tr>");
    		out.print("		</table>");
    		out.print("	</form>");
    		out.print("</div>");
       
        
		out.print("<div class='grp2'>");
		out.println("<h3 style='font-family:Serif;'><b>All Discounts</b></h3>");

		List<Discount> list = null;
		
			try {
				list = DiscountDao.getAllDiscount();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		out.print("<table class='css-styled-table'");
		out.print("<tr><th>Discount Id</th>" + "<th>Discount Day</th>" + "<th>Discount</th>" + "<th>Description</th>"
				+ "<th>Action</th></tr>");

		for (Discount d : list) {
			out.print("<tr><td >" + d.getDiscountId() 
					+ "</td><td>" + d.getDiscountDay() 
					+ "</td><td>" + d.getDiscount() 
					+ "</td><td>" + d.getDescription()
					+ "</td><td><a class='btn btn-warning' href='discountEditServlet?id=" + d.getDiscountId() + "'>Edit</a>"
					+ "   <a class='btn btn-danger' href='discountDeleteServlet?id=" + d.getDiscountId() + "'>Delete</a></td></tr>");
		}

		out.print("</table>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("</body>");
		out.print("</html>");

	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
