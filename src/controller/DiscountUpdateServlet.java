package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Discount;
import model.DiscountDao;


@WebServlet("/discountUpdateServlet")
public class DiscountUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         
        String operation = request.getParameter("btn");
		if(operation.equals("Update"))
		{
			int discountId = Integer.parseInt(request.getParameter("discountId"));
			String discountDay = request.getParameter("day");
			float discount = Float.parseFloat(request.getParameter("discount"));
			String discountDescription = request.getParameter("description");

	         
	        Discount d = new Discount(discountId, discountDay, discount, discountDescription);
	       
	        int a = DiscountDao.updateDiscount(d);
	        if(a>0){
	            response.sendRedirect("discountServlet");
	        }else{
	            out.println("Sorry! unable to update record");
	        }
	        out.close();
		}
			
		else if(operation.equals("Cancel"))
		{	
			response.sendRedirect("discountServlet");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
