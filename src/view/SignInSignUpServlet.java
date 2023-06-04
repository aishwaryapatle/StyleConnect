package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signinSignupServlet")
public class SignInSignUpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<script src='https://cdn.tailwindcss.com'></script>");
			out.print("");
			out.print("    <div class='w-full overflow-hidden'>");
//			out.print("        <nav style='margin-top:0px; top:0px' class='fixed bg-white bg-slate-900 px-2 sm:px-4 py-2.5 px-5 z-10 border-b border-slate-700 w-full'>");
//			out.print("            <div class='flex flex-wrap justify-between items-center text-white'>");
////			out.print("                <h2 class='font-bold'>Sidebar</h2>");
//			 out.print("            <a href ='index.html'>");
//		        out.print("                <img src='img/logo.png' alt=''>");
//		        out.print("            </a>");
//			out.print("                <button id='button'>");
//			out.print("                    <svg class='w-6 h-6' aria-hidden='true' fill='white' viewBox='0 0 20 20'");
//			out.print("                        xmlns='http://www.w3.org/2000/svg'>");
//			out.print("                        <path fill-rule='evenodd'");
//			out.print("                            d='M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z'");
//			out.print("                            clip-rule='evenodd'></path>");
//			out.print("                    </svg>");
//			out.print("                </button>");
//			out.print("            </div>");
//			out.print("        </nav>");
			out.print("        <div class='fixed transition mt-11 duration-500 ease-in-out w-full sm:max-w-xs translate-x-full overflow-x-hidden top-0 right-0'");
			out.print("            id='navbar'>");
			out.print("            <div class='w-full h-screen bg-slate-900' id='list'>");
			out.print("                <ul class='font-semibold pt-3 flex justify-center flex-col gap-3 text-slate-400'>");
			out.print("                    <li class='flex items-center justify-center w-full'>");
			out.print("                        <a href='index.html'");
			out.print("                            class='border-b-2 border-slate-700 pb-3 text-center w-52 hover:text-white transition-all duration-200 ease-in-out hover:w-full cursor-pointer'>Home</a>");
			out.print("                    </li>");
			out.print("                    <li class='flex items-center justify-center w-full'>");
			out.print("                        <a href='index.html'");
			out.print("                            class='border-b-2 border-slate-700 pb-3 text-center w-52 hover:text-white transition-all duration-200 ease-in-out hover:w-full cursor-pointer'>Home</a>");
			out.print("                    </li>");
			out.print("                    <li class='flex items-center justify-center w-full'>");
			out.print("                        <a href='service.html'");
			out.print("                            class='border-b-2 border-slate-700 pb-3 text-center w-52 hover:text-white transition-all duration-200 ease-in-out hover:w-full cursor-pointer'>Service</a>");
			out.print("                    </li>");
			out.print("                    <li class='flex items-center justify-center w-full'>");
			out.print("                        <a href='about.html'");
			out.print("                            class='border-b-2 border-slate-700 pb-3 text-center w-52 hover:text-white transition-all duration-200 ease-in-out hover:w-full cursor-pointer'>About</a>");
			out.print("                    </li>");
			out.print("                    <li class='flex items-center justify-center w-full'>");
			out.print("                        <a href='contact.html'");
			out.print("                            class='border-b-2 border-slate-700 pb-3 text-center w-52 hover:text-white transition-all duration-200 ease-in-out hover:w-full cursor-pointer'>Contact</a>");
			out.print("                    </li>");
			out.print("                    <li class='flex items-center justify-center w-full'>");
			out.print("                        <a href='dashboard'");
			out.print("                            class='border-b-2 border-slate-700 pb-3 text-center w-52 hover:text-white transition-all duration-200 ease-in-out hover:w-full cursor-pointer'>All Bookings</a>");
			out.print("                    </li>");
			out.print("                    <li class='flex items-center justify-center w-full'>");
			out.print("                        <a href='signinSignupServlet'");
			out.print("                            class='border-b-2 border-slate-700 pb-3 text-center w-52 hover:text-white transition-all duration-200 ease-in-out hover:w-full cursor-pointer'>Login</a>");
			out.print("                    </li>");
			out.print("                    <li class='flex items-center justify-center w-full'>");
			out.print("                        <a href='logoutServlet'");
			out.print("                            class='border-b-2 border-slate-700 pb-3 text-center w-52 hover:text-white transition-all duration-200 ease-in-out hover:w-full cursor-pointer'>Logout</a>");
			out.print("                    </li>");
			out.print("                    <li class='flex items-center justify-center w-full'>");
			out.print("                        <a href='bookingServlet'");
			out.print("                            class='border-b-2 border-slate-700 pb-3 text-center w-52 hover:text-white transition-all duration-200 ease-in-out hover:w-full cursor-pointer'>Appointment</a>");
			out.print("                    </li>");
			out.print("                </ul>");
			out.print("            </div>");
			out.print("        </div>");
			out.print("    </div>");
			out.print("");
			out.print("    <script>");
			out.print("        const button = document.getElementById('button');");
			out.print("        const navbar = document.getElementById('navbar');");
			out.print("        const list = document.getElementById('list');");
			out.print("");
			out.print("        button.addEventListener('click', () => {");
			out.print("            navbar.classList.toggle('translate-x-full');");
			out.print("        });");
			out.print("");
			out.print("        list.addEventListener('click', () => {");
			out.print("            navbar.classList.toggle('translate-x-full');");
			out.print("        });");
			out.print("");
			out.print("    </script>");

		
		
		out.print("<link rel='stylesheet' href='css/style1.css'>");

		//signup form	
		out.print("<div class='container' id='container'>");
		out.print("	<div class='form-container sign-up-container'>");
		out.print("		<form action='signupActionServlet'>");
		out.print("			<h1>Create Account</h1><br>");
		out.print("			<input type='text' name='name' placeholder='Name' />");
		out.print("			<input type='email' name='email' placeholder='Email' />");
		out.print("			<input type='text' name='phoneno' placeholder='Mobile Number' />");
		out.print("			<input type='password' name='password' placeholder='Password' />");
		out.print("			<button>Sign Up</button>");
		out.print("		</form>");
		out.print("	</div>");
				
		//login form
		out.print("	<div class='form-container sign-in-container'>");
		out.print("		<form action='loginActionServlet'>");
		out.print("			<h1>Sign in</h1><br>");
		out.print("			<input type='email' name='email' placeholder='Email' />");
		out.print("			<input type='password' name='password' placeholder='Password' />");
		out.print("			<a href='#'>Forgot your password?</a>");
		out.print("			<button>Sign In</button>");
		out.print("		</form>");
		out.print("	</div>");
		
		out.print("	<div class='overlay-container'>");
		out.print("		<div class='overlay'>");
		out.print("			<div class='overlay-panel overlay-left'>");
		out.print("				<h1>Welcome Back!</h1>");
		out.print("				<p>To keep connected with us please login with your personal info</p>");
		out.print("				<button class='ghost' id='signIn'>Sign In</button>");
		out.print("			</div>");
		
		out.print("			<div class='overlay-panel overlay-right'>");
		out.print("				<h1>Hello, Friend!</h1>");
		out.print("				<p>Enter your personal details and start journey with us</p>");
		out.print("				<button class='ghost' id='signUp'>Sign Up</button>");
		out.print("			</div>");
		out.print("		</div>");
		out.print("	</div>");
		out.print("</div>");
		
//		out.print("<footer>");
//		out.print("	<p>");
//		out.print("		Created with <i class='fa fa-heart'></i> by");
//		out.print("		<a target='_blank' href='https://florin-pop.com'>Florin Pop</a>");
//		out.print("		- Read how I created this and how you can join the challenge");
//		out.print("		<a target='_blank' href='https://www.florin-pop.com/blog/2019/03/double-slider-sign-in-up-form/'>here</a>.");
//		out.print("	</p>");
//		out.print("</footer>");
		
		
		out.print("<script>");
		out.print("const signUpButton = document.getElementById('signUp');");
		out.print("const signInButton = document.getElementById('signIn');");
		out.print("const container = document.getElementById('container');");
		out.print("signUpButton.addEventListener('click', () => {");
		out.print("	container.classList.add('right-panel-active');});");
		out.print("signInButton.addEventListener('click', () => {");
		out.print("	container.classList.remove('right-panel-active');});");
		out.print("</script>");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
