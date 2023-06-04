package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Booking;
import model.BookingDao;
import model.Discount;
import model.DiscountDao;

@WebServlet("/bookingActionServlet")
public class BookingActionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//2 lines of repeated code to print the html code onto the web page using servlet
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		//fetching the data from Booking.java page
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String services = request.getParameter("serviceName");
		String barbers = request.getParameter("barbers");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneno = request.getParameter("phoneno");
		float price = Float.parseFloat(request.getParameter("price"));
		
		
		//converting string fetched date into localdate
		String str1 = date;
		LocalDate dt1 = LocalDate.parse(str1);
		System.out.println(dt1);
				
		
		//calculating day from the local date
		DayOfWeek dayOfWeek = dt1.getDayOfWeek();
		System.out.println(dayOfWeek); //Uppercase
		System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())); //Lowercase
		String compareDay = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
		
		
		//getting list of discounts and associated days from the database
		List<Discount> list = null;
		
			try {
				list = DiscountDao.getDiscountAndDay();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		
		//comparing the fetched day from localdate
		//with the discountDay present in database
		//and returning the associated discount percentage
		float discountPercentage = 0;
		for (Discount d : list) {
			if(compareDay.equals(d.getDiscountDay()))
			{
				discountPercentage = d.getDiscount();
			}
		}
		
		
		System.out.println(discountPercentage);
		
		//function to calculate total discountedAmount
		float discountAmount = DiscountDao.discountAmount(price, discountPercentage);
		System.out.println(discountAmount);
		
		
		//Inserting the values into the database
		Booking b = new Booking(date, time, services, barbers, name, email, phoneno, price, discountPercentage, discountAmount);
		
			int a=0;
			try {
				a = BookingDao.booking_insert(b);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (a > 0) {
				System.out.print("data inserted! ");
				response.sendRedirect("dashboard");
			} else
				out.print("data not inserted!");

		

		
		out.print(date+" "+time+" "+services+" "+barbers+" "+name+" "+email+" "+phoneno+" "+price);
	

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
