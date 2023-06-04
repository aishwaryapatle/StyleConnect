package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Staff;
import model.StaffDao;


@WebServlet("/staffUpdateServlet")
public class StaffUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         
        String operation = request.getParameter("btn");
		if(operation.equals("Update"))
		{
			String sid = request.getParameter("staffId");
	        int staffId = Integer.parseInt(sid);
	        String staffName = request.getParameter("staffName");
			String staffEmail = request.getParameter("staffEmail");
			String staffMobile = request.getParameter("staffMobile");
			String staffGender = request.getParameter("gender");
			String staffAddress = request.getParameter("staffAddress");
			float staffSalary = Float.parseFloat(request.getParameter("staffSalary"));

	         
	        Staff s = new Staff(staffId, staffName, staffEmail, staffMobile, staffGender, staffAddress, staffSalary);
	         
	        // StaffDao.update method is called
	        // along with the modified values for geekUser
	        int a = StaffDao.updateStaff(s);
	        if(a>0){
	            response.sendRedirect("staffServlet");
	        }else{
	            out.println("Sorry! unable to update record");
	        }
	        out.close();
		}
			
		else if(operation.equals("Cancel"))
		{	
			response.sendRedirect("staffServlet");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
