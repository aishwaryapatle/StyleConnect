package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Discount;
import model.DiscountDao;


@WebServlet("/discountActionServlet")
public class DiscountActionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String discountDay = request.getParameter("day");
		float discount = Float.parseFloat(request.getParameter("discount"));
		String discountDescription = request.getParameter("description");
		

		Discount d = new Discount(discountDay, discount, discountDescription);
		
			int a=0;
			try {
				a = DiscountDao.addDiscount(d);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(a > 0)
			{
				response.sendRedirect("discountServlet");
				System.out.println("Discount added successfully!");
			}
			else
			{
				request.getRequestDispatcher("/discountServlet").include(request, response);
				out.print("Sorry! Discount is not added");
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
