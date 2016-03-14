package com.codecool.simpleLoginApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SimpleLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		if (userName.equals("hunor") & password.equals("password")){
			session.setAttribute("savedUserName", userName);
			out.println("Welcome " + session.getAttribute("savedUserName"));
		} else {
			out.print("Wrong username or password! Try again.");
            request.getRequestDispatcher("login.html").include(request, response);
            }
	}
}
