package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out =response.getWriter();
        
        HttpSession session = request.getSession(false);	
        //If session is not null
        if(session!=null) 
		{
	        if(session.getAttribute("User")!=null)
	        {
	        	response.sendRedirect("userDashboardServlet");
	        }
	        else if(session.getAttribute("Admin")!=null)
	        {
	        	response.sendRedirect("adminDashboardServlet");
	        }
		}
        else
        {
        	System.out.println("User Not Found");
			out.print("<br>Please Login to Continue");
			RequestDispatcher rd=request.getRequestDispatcher("/signinSignupServlet");  
			rd.include(request, response); 
        }

	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
