package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Booking;
import model.BookingDao;


@WebServlet("/adminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out =response.getWriter();
        
        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
        out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("    <title>Admin Dashboard</title>");
        out.print("    <!--------- <title>Responsive Navigation Menu</title>------>");
        out.print("    <link rel='stylesheet' href='css/adminDashboard.css'>");
        out.print("    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css'/>");
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
        out.print("            <li><a class='active' href='adminDashboardServlet'>Dashboard</a></li>");
        out.print("            <li><a href='serviceServlet'>Services</a></li>");
        out.print("            <li><a href='staffServlet'>Staff</a></li>");
        out.print("            <li><a href='discountServlet'>Discount</a></li>");
        out.print("        </ul>");
        out.print("    </nav>");

        out.print("</br>");

        out.println("<h2 style='font-family:Serif;'><b>All Bookings</b></h2><br>");
		
        List<Booking> list = BookingDao.getAllBooking();
		
        out.print("<table class='table table-bordered'");
        out.print("<tr><th>Booking Id</th>"
        		+ "<th>Date</th>"
        		+ "<th>Time</th>"
        		+ "<th>Services</th>"
        		+ "<th>Barbers</th>"
        		+ "<th>Name</th>"
        		+ "<th>Email</th>"
        		+ "<th>Mobile no</th>"
        		+ "<th>Price</th>"
        		+ "<th>Discount%</th>"
        		+ "<th>Total Amount</th>"
        		+ "<th>Action</th></tr>");
        
        for(Booking e:list){
            // each row is identified by means of its id
            // hence on click of 'edit', it is sent as
            // <a href='EditServlet?id="+e.getId()+"'>edit</a>
            // on click of 'delete', it is sent as
            // <a href='DeleteServlet?id="+e.getId()+"'>delete</a>
        	out.print("<tr><td >"+e.getBid()+
        			"</td><td>"+e.getDate()+
        			"</td><td>"+e.getTime()+
        			"</td><td>"+e.getServices()+
        			"</td><td>"+e.getBarbers()+
        			"</td><td>"+e.getName()+
        			"</td><td>"+e.getEmail()+
        			"</td><td>"+e.getPhoneno()+
        			"</td><td>"+e.getPrice()+
        			"</td><td>"+e.getDiscountPercentage()+
        			"</td><td>"+e.getDiscountAmount()+
        			"</td><td><a class='btn btn-warning' href='EditServlet?id="+e.getBid()+"'>Accept</a>"
        					+ "   <a class='btn btn-danger' href='adminDashboardDeleteServlet?id="+e.getBid()+"'>Reject</a></td></tr>");
        }
        
        out.print("</table>");
        out.print("</body>");
        out.print("</html>"); 
        out.close();	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
