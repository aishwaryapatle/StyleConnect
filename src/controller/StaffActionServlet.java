package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Staff;
import model.StaffDao;


@WebServlet("/staffActionServlet")
public class StaffActionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String staffName = request.getParameter("staffName");
		String staffEmail = request.getParameter("staffEmail");
		String staffMobile = request.getParameter("staffMobile");
		String staffGender = request.getParameter("gender");
		String staffAddress = request.getParameter("staffAddress");
		float staffSalary = Float.parseFloat(request.getParameter("staffSalary"));
		

		Staff s = new Staff(staffName, staffEmail, staffMobile, staffGender, staffAddress, staffSalary);
			int a=0;
			try {
				a = StaffDao.addStaff(s);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(a > 0)
			{
				response.sendRedirect("staffServlet");
				System.out.println("Service added successfully!");
			}
			else
			{
				request.getRequestDispatcher("/staffServlet").include(request, response);
				out.print("Sorry! service is not added");
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
