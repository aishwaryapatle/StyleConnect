package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Discount;
import model.DiscountDao;


@WebServlet("/discountEditServlet")
public class DiscountEditServlet extends HttpServlet {
	
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
		
        int id = Integer.parseInt(request.getParameter("id"));
		Discount discount = DiscountDao.getDiscountById(id);
        
		out.print("<div class='grp1'>");
		
			out.print("<div style='padding-left: 570px;' class='grp2'>");    		
			out.print("	<h3 style='font-family:Serif;'><b>Update Discount Details</b></h3>");
			out.print("	<form action='discountUpdateServlet' method='post'>");
    		out.print("		<table class='css-styled-table'>");
    		
    		out.print("			<tr>");
    		out.print("				<td>Discount Id:</td>");
    		out.print("				<td><input type='number' name='discountId' value='"+discount.getDiscountId()+"' readonly='readonly'></td>");
    		out.print("			</tr>");
    		
    		out.print("			<tr>");
    		out.print("				<td>Discount Day:</td>");
    		out.print("				<td>");
    		out.print("					<select id='day' name='day'>");
    		
    		String day = discount.getDiscountDay();
    		if(day.equals("Sunday"))
    		{
    			out.print("						<option value='Sunday' selected>Sunday</option>");
        		out.print("						<option value='Monday'>Monday</option>");
        		out.print("						<option value='Tuesday'>Tuesday</option>");
        		out.print("						<option value='Wednesday'>Wednesday</option>");
        		out.print("						<option value='Thursday'>Thursday</option>");
        		out.print("						<option value='Friday'>Friday</option>");
        		out.print("						<option value='Saturday'>Saturday</option>");
    		}
    		else if(day.equals("Monday"))
    		{
    			out.print("						<option value='Sunday'>Sunday</option>");
        		out.print("						<option value='Monday' selected>Monday</option>");
        		out.print("						<option value='Tuesday'>Tuesday</option>");
        		out.print("						<option value='Wednesday'>Wednesday</option>");
        		out.print("						<option value='Thursday'>Thursday</option>");
        		out.print("						<option value='Friday'>Friday</option>");
        		out.print("						<option value='Saturday'>Saturday</option>");
    		}
    		else if(day.equals("Tuesday"))
    		{
    			out.print("						<option value='Sunday'>Sunday</option>");
        		out.print("						<option value='Monday'>Monday</option>");
        		out.print("						<option value='Tuesday' selected>Tuesday</option>");
        		out.print("						<option value='Wednesday'>Wednesday</option>");
        		out.print("						<option value='Thursday'>Thursday</option>");
        		out.print("						<option value='Friday'>Friday</option>");
        		out.print("						<option value='Saturday'>Saturday</option>");
    		}
    		else if(day.equals("Wednesday"))
    		{
    			out.print("						<option value='Sunday'>Sunday</option>");
        		out.print("						<option value='Monday'>Monday</option>");
        		out.print("						<option value='Tuesday'>Tuesday</option>");
        		out.print("						<option value='Wednesday' selected>Wednesday</option>");
        		out.print("						<option value='Thursday'>Thursday</option>");
        		out.print("						<option value='Friday'>Friday</option>");
        		out.print("						<option value='Saturday'>Saturday</option>");
    		}
    		else if(day.equals("Thursday"))
    		{
    			out.print("						<option value='Sunday'>Sunday</option>");
        		out.print("						<option value='Monday'>Monday</option>");
        		out.print("						<option value='Tuesday'>Tuesday</option>");
        		out.print("						<option value='Wednesday'>Wednesday</option>");
        		out.print("						<option value='Thursday' selected>Thursday</option>");
        		out.print("						<option value='Friday'>Friday</option>");
        		out.print("						<option value='Saturday'>Saturday</option>");
    		}
    		else if(day.equals("Friday"))
    		{
    			out.print("						<option value='Sunday'>Sunday</option>");
        		out.print("						<option value='Monday'>Monday</option>");
        		out.print("						<option value='Tuesday'>Tuesday</option>");
        		out.print("						<option value='Wednesday'>Wednesday</option>");
        		out.print("						<option value='Thursday'>Thursday</option>");
        		out.print("						<option value='Friday' selected>Friday</option>");
        		out.print("						<option value='Saturday'>Saturday</option>");
    		}
    		else if(day.equals("Saturday"))
    		{
    			out.print("						<option value='Sunday'>Sunday</option>");
        		out.print("						<option value='Monday'>Monday</option>");
        		out.print("						<option value='Tuesday'>Tuesday</option>");
        		out.print("						<option value='Wednesday'>Wednesday</option>");
        		out.print("						<option value='Thursday'>Thursday</option>");
        		out.print("						<option value='Friday'>Friday</option>");
        		out.print("						<option value='Saturday' selected>Saturday</option>");
    		}
        		
    		out.print("					</select>");
    		out.print("				</td>");
    		out.print("			</tr>");
    		
    		out.print("			<tr>");
    		out.print("				<td>Discount:</td>");
    		out.print("				<td><input type='number' name='discount' value='"+discount.getDiscount()+"'></td>");
    		out.print("			</tr>");
    		
    		out.print("			<tr>");
    		out.print("				<td>Description:</td>");
    		out.print("				<td><textarea name='description' rows='3' cols='22' "+discount.getDescription()+"></textarea></td>");
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
