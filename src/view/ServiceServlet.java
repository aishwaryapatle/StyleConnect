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

import model.Service;
import model.ServiceDao;


@WebServlet("/serviceServlet")
public class ServiceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='ISO-8859-1'>");
		out.print("<title>Add Services</title>");
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
        out.print("            <li><a class='active' href='serviceServlet'>Services</a></li>");
        out.print("            <li><a href='staffServlet'>Staff</a></li>");
        out.print("            <li><a href='discountServlet'>Discount</a></li>");
        out.print("        </ul>");
        out.print("    </nav>");
		
		out.print("<div class='grp1'>");
		out.print("<div class='grp2'>");
		out.print("	<h3 style='font-family:Serif;'><b>Add New Service</b></h3>");
		out.print("	<form action='serviceActionServlet' method='post'>");
		out.print("		<table class='css-styled-table'>");
		out.print("			<tr>");
		out.print("				<td>Service Name:</td>");
		out.print("				<td><input type='text' name='sname' ></td>");
		out.print("			</tr>");
		out.print("			<tr>");
		out.print("				<td>Service Price:</td>");
		out.print("				<td><input type='number' name='sprice' ></td>");
		out.print("			</tr>");
		out.print("			<tr>");
		out.print("				<td colspan='2' style='text-align: center;''><input style='width: 80px' type='submit' value='Save' /></td>");
		out.print("			</tr>");
		out.print("		</table>");
		out.print("	</form>");
		out.print("</div>");
		out.print("<div class='grp2'>");
		out.println("<h3 style='font-family:Serif;'><b>All Services</b></h3>");

		List<Service> list = null;
		
			try {
				list = ServiceDao.getAllService();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		out.print("<table class='css-styled-table'");
		out.print("<tr><th>Service Id</th>" + "<th>Service Name</th>" + "<th>Service Price</th>"
				+ "<th>Action</th></tr>");

		for (Service s : list) {
			out.print("<tr><td >" + s.getSid() + "</td><td>" + s.getSname() + "</td><td>" + s.getSprice()
					+ "</td><td><a class='btn btn-warning' href='serviceEditServlet?id=" + s.getSid() + "'>Edit</a>"
					+ "   <a class='btn btn-danger' href='serviceDeleteServlet?id=" + s.getSid() + "'>Delete</a></td></tr>");
		}

		out.print("</table>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("</body>");
		out.print("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
