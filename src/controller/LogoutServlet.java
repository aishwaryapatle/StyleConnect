package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false); //Fetch session object
		 
        if(session!=null) //If session is not null
        {
            session.invalidate(); //removes all session attributes bound to the session
            System.out.println("You have logged out successfully");
            request.getRequestDispatcher("/signinSignupServlet").include(request, response);
            System.out.println("Logged out");
        }
		
//		if(request.getSession().getAttribute("auth")!=null)
//		{
//			request.getSession().removeAttribute("auth");
//			response.sendRedirect("signinSignupServlet");
//		}
		else
		{
			response.sendRedirect("index.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
