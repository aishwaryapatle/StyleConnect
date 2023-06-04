package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;
import model.ServiceDao;


@WebServlet("/serviceEditServlet")
public class ServiceEditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Service service = ServiceDao.getServiceById(id);
		
		
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
		out.print("<div style='padding-left: 570px;' class='grp2'>");    		
		out.print("	<h3 style='font-family:Serif;'><b>Update Service Details</b></h3>");
		out.print("	<form action='serviceUpdateServlet' method='post'>");
		out.print("		<table class='css-styled-table'>");
		
		out.print("			<tr>");
		out.print("				<td>Discount Id:</td>");
		out.print("				<td><input type='number' name='sid' value='"+service.getSid()+"' readonly='readonly'></td>");
		out.print("			</tr>");
		
		out.print("			<tr>");
		out.print("				<td>Service Name:</td>");
		out.print("				<td><input type='text' name='sname' value='"+service.getSname()+"'></td>");
		out.print("			</tr>");
		
		out.print("			<tr>");
		out.print("				<td>Service Price:</td>");
		out.print("				<td><input type='number' name='sprice' value='"+service.getSprice()+"'></td>");
		out.print("			</tr>");
		
		out.print("			<tr>");
		out.print("				<td colspan='2' style='text-align: center;''><input style='width: 80px' type='submit' name='btn' value='Update'/> "
								+ "<input style='width: 80px' type='submit' name='btn' value='Cancel' /></td>"); 		
		out.print("			</tr>");
		
		out.print("		</table>");
		out.print("	</form>");
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
