package com.ty.task_management.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.task_management.dao.UserDao;
import com.ty.task_management.entity.User;
import com.ty.task_management.exceptions.UserNotFoundException;

@WebServlet(value="/login")

public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao userDao= new UserDao();
		String email= req.getParameter("User_Email");
		String password= req.getParameter("User_Password");
		PrintWriter printWriter= resp.getWriter();
		try {
			User user= userDao.findByEmail(email, password);
			if (user != null) {
				HttpSession session =req.getSession();
				
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				
				if (user.getRole().equalsIgnoreCase("Manager")) {
					
					printWriter.print("<html><body>");
					printWriter.print("<h1>WEL-COME</h1>");
					printWriter.print("</body></html>");
					RequestDispatcher requestDispatcher= req.getRequestDispatcher("ManagerHome.jsp");
					requestDispatcher.include(req, resp);
				} else {
					printWriter.print("<html><body>");
					printWriter.print("<h1>WEL-COME</h1>");
					printWriter.print("</body></html>");
					req.setAttribute("user", user);
					RequestDispatcher requestDispatcher= req.getRequestDispatcher("ViewTask.jsp");
					requestDispatcher.include(req, resp);
				}
			} else {
				printWriter.print("<html><body>");
				printWriter.print("<h1>Invalid Credentials</h1>");
				printWriter.print("</body></html>");
				RequestDispatcher requestDispatcher= req.getRequestDispatcher("Login.jsp");
				requestDispatcher.include(req, resp);
			}
			
			
		} catch (NoResultException e) {
			printWriter.print("<html><body>");
			printWriter.print("<h1>Invalid Credentials</h1>");
			printWriter.print("</body></html>");
			RequestDispatcher requestDispatcher= req.getRequestDispatcher("Login.jsp");
			requestDispatcher.include(req, resp);
		}
	}
	
	

}
