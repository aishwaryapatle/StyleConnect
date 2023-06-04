package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;


@WebServlet("/signupActionServlet")
public class SignupActionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneno = request.getParameter("phoneno");
		String password = request.getParameter("password");
		String role = "user";
		
		UserDao udao = new UserDao();
		User u = new User(name, email, phoneno, password, role);
		
		int user=0;
		
			try {
				user = udao.userRegistration(u );
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(user>0)
			{
				System.out.println("User Registered");
//				response.sendRedirect("signinSignupServlet");
				out.print("Registration done successfully!");  
				out.print("<br>Please Login to Continue");
				RequestDispatcher rd=request.getRequestDispatcher("/signinSignupServlet");  
				rd.include(request, response); 
			}
			else
			{
				System.out.println("User Not Registered");
			}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
