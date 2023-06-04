package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDao;


@WebServlet("/loginActionServlet")
public class LoginActionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		User user = new User(email, password);
		UserDao userDao = new UserDao();
		
		String userValidate = userDao.authenticateUser(user);
		if(userValidate.equals("User_Role"))
		{
			System.out.println("User's Home");
			HttpSession session = request.getSession();
			session.setAttribute("User", email);
			response.sendRedirect("index.html");
		}
		
		else if(userValidate.equals("Admin_Role"))
        {
            System.out.println("Admin's Home");
 
            HttpSession session = request.getSession(); //Creating a session
            session.setAttribute("Admin", email); //setting session attribute
            response.sendRedirect("index.html");
        }
		
		else if(userValidate.equals("Not_Valid"))
		{
			out.print("Sorry UserName or Password Error!");  
			RequestDispatcher rd=request.getRequestDispatcher("/signinSignupServlet");  
			rd.include(request, response);  

		}
		
		
//		UserDao udao = new UserDao();
//		try {
//			User user=udao.userLogin(email, password);
//			if(user!=null)
//			{
//				HttpSession session = request.getSession();
//				session.setAttribute("auth", user);
//				System.out.println("User Logged in");
//				response.sendRedirect("index.html");
//			}
//			else
//			{
//				out.print("Wrong email or password");
//			}		
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
