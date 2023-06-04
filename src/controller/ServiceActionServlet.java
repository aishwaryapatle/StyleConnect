package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;
import model.ServiceDao;


@WebServlet("/serviceActionServlet")
public class ServiceActionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sname = request.getParameter("sname");
		String price = request.getParameter("sprice");
		float sprice = Float.parseFloat(price);
		
		Service s = new Service(sname, sprice);
		
			int a=0;
			try {
				a = ServiceDao.addService(s);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(a > 0)
			{
				response.sendRedirect("serviceServlet");
				System.out.println("Service added successfully!");
			}
			else
			{
				request.getRequestDispatcher("/serviceServlet").include(request, response);
				out.print("Sorry! service is not added");
			}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
