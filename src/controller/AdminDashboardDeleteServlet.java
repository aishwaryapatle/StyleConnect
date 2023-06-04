package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookingDao;


@WebServlet("/adminDashboardDeleteServlet")
public class AdminDashboardDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//fetching the data send through id variable
		//from adminDashboardServlet's delete button
		//and typecasting it into integer type sid
		
		String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
       
        //Calling BookingDao's booking_delete function 
        //which takes an integer argument basically id
        
        BookingDao.booking_delete(id);
        
        response.sendRedirect("adminDashboardServlet");	
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
