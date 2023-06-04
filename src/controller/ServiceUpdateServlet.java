package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;
import model.ServiceDao;


@WebServlet("/serviceUpdateServlet")
public class ServiceUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
		String operation = request.getParameter("btn");
		if(operation.equals("Update"))
		{
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String price = request.getParameter("sprice");
			float sprice = Float.parseFloat(price);

	         
			Service s = new Service(sid, sname, sprice);
	        int a = ServiceDao.updateService(s);
	        if(a>0){
	            response.sendRedirect("serviceServlet");
	        }else{
	            out.println("Sorry! unable to update record");
	        }
	        out.close();
		}
			
		else if(operation.equals("Cancel"))
		{	
			response.sendRedirect("serviceServlet");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
