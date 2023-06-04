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
import javax.servlet.http.HttpSession;

import model.Service;
import model.ServiceDao;
import model.Staff;
import model.StaffDao;



@WebServlet("/bookingServlet")
public class BookingServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Requesting for the previous session
		HttpSession session = request.getSession(false); //Fetch session object
		 
        if(session!=null) //If session is not null
		{
        	//Getting the setted attribute as User in session
        	String email = (String) session.getAttribute("User");
        	
        	
        	//HTML Code
        	out.print("<!DOCTYPE html>");
    		out.print("<html>");
    		out.print("<head>");
    		out.print("<meta charset='ISO-8859-1'>");
    		out.print("<title>Add Staff</title>");
    		out.print("<link rel='stylesheet' href='css/booking.css'>");
    		
    		
    		//JavaScript code to show the selected services from dropdown into price textfield
    		out.print("<script>");
    		out.print("function ddlselect() {var d = document.getElementById('services'); "
    				+ "var displayValue = d.options[d.selectedIndex].value;"
    				+ "document.getElementById('txtvalue').value=displayValue; "
    				+ "var displayText = d.options[d.selectedIndex].text;"
    				+ "document.getElementById('txttext').value=displayText;}");
    		
    		out.print("</script>");
    		
    		out.print("<script type = 'text/javascript'>");
    		out.print("function date1(){"
    				+ "var today = new Date().toISOString().split('T')[0];"
    				+ "document.getElementsByName('date')[0].setAttribute('min', today);");
    		out.print("</script>");

    		
    		out.print("</head>");
    		out.print("<body>");
			
    		//Appointment/Booking page code
			out.print("		<div class='container'>");
			out.print("        <div class='title'>Make an Appointment</div>");
			out.print("        <div class='content'>");
			out.print("            <form action='bookingActionServlet'>");
			out.print("                <div class='user-details'>");
			
			out.print("                    <div class='input-box'>");
			out.print("                        <span class='details'>Date</span>");
			out.print("                        <input type='date' name='date' required>");
			out.print("                    </div>");
			
			out.print("                    <div class='input-box'>");
			out.print("                        <span class='details'>Time</span>");
			out.print("                        <input type='time' name='time' required>");
			out.print("                    </div>");
			
			out.print("                    <div class='input-box'>");
			out.print("                        <span class='details'>Services</span>");
			out.print("                        <select name='services' id='services' onchange='ddlselect();' required>");
			out.print("                            <option>-- Select Services --</option>");
			
			//Storing the services from database into list
			List<Service> list = null;
			
				try {
					list = ServiceDao.getServiceNamePrice();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			//retrieving service name and price from list
			for(Service s : list) {
				out.print("<option value='"+s.getSprice()+"'>"+s.getSname()+"</option>");
			}
			out.print("                        </select>");
			out.print("                    </div>");
			
			out.print("                    <div class='input-box'>");
			out.print("                        <span class='details'>Barbers</span>");
			out.print("                        <select name='barbers' id='barbers' required>");
			out.print("                            <option value='any'>Random</option>");
			
			
			//Storing the staff from database into list
			List<Staff> list1 = null;
				try {
					list1 = StaffDao.getOnlyStaffName();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			//retrieving staff name from list1
			for(Staff s : list1)
			{
				out.print("<option value='"+s.getStaffName()+"'>"+s.getStaffName()+"</option>");
			}
			out.print("                        </select>");
			out.print("                    </div>");
			
			out.print("                    <div class='input-box'>");
			out.print("                        <span class='details'>Name</span>");
			out.print("                        <input type='text' name='name' placeholder='Enter your name' required>");
			out.print("                    </div>");
			
			out.print("                    <div class='input-box'>");
			out.print("                        <span class='details'>Phone Number</span>");
			out.print("                        <input type='tel' name='phoneno' pattern='[0-9]{10}' placeholder='Enter your number' required>");
			out.print("                    </div>");
			
			out.print("                    <div class='input-box'>");
			out.print("                        <span class='details'>Email</span>");
			out.print("                        <input type='email' name='email' readonly='readonly' value = "+email+" >");
			out.print("                    </div>");
			
			out.print("                    <div class='input-box'>");
			out.print("                        <span class='details'>Price</span>");
			out.print("                        <input type='text' id='txtvalue' name='price' readonly='readonly'>");
			out.print("                    </div>");
			
			out.print("                        <input type='hidden' id='txttext' name='serviceName' readonly='readonly'>");

			
//			out.print("                    <div class='gender-details'>");
//			out.print("                        <input type='radio' name='gender' value='male' id='dot-1' required>");
//			out.print("                        <input type='radio' name='gender' value='female' id='dot-2' required>");
//			out.print("                        <span class='gender-title'>Gender</span>");
//			out.print("                        <div class='category'>");
//			out.print("                            <label for='dot-1'>");
//			out.print("                                <span class='dot one'></span>");
//			out.print("                                <span class='gender' style='font-size: 15px;'>Male</span>");
//			out.print("                            </label>");
//			out.print("                            <label for='dot-2'>");
//			out.print("                                <span class='dot two'></span>");
//			out.print("                                <span class='gender' style='font-size: 15px;'>Female</span>");
//			out.print("                            </label>");
//			out.print("                        </div>");
//			out.print("                    </div>");
			
			out.print("                </div>");
			out.print("                <div class='button'>");
			out.print("                    <input type='submit' value='Book'>");
			out.print("                </div>");
			out.print("            </form>");
			out.print("        </div>");
			out.print("    </div>");
			out.print("</body>");
			out.print("</html>");

		}
        //if user has not logged in then send user to login page
		else
		{
			response.sendRedirect("signinSignupServlet");
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
