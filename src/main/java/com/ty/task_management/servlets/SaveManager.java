package com.ty.task_management.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.task_management.dao.UserDao;
import com.ty.task_management.entity.User;
import com.ty.task_management.exceptions.UserNotFoundException;

@WebServlet(value="/signup")
public class SaveManager extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao userDao= new UserDao();
		
		String name= req.getParameter("User_Name");
		String email=req.getParameter("User_Email");
		String password= req.getParameter("User_Password");
		String role= "Manager";
		
		User user= new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		PrintWriter printWriter= resp.getWriter();
		try {
			
			User user1= userDao.saveUser(user);
			printWriter.print("<html><body>");
			printWriter.print("<h1>Account Created</h1>");
			printWriter.print("</body></html>");
			
			RequestDispatcher requestDispatcher= req.getRequestDispatcher("Login.jsp");
			requestDispatcher.include(req, resp);
			
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	

}
