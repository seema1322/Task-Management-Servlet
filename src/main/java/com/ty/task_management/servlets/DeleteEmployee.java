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
import com.ty.task_management.exceptions.UserNotFoundException;

@WebServlet(value="/deleteuser")
public class DeleteEmployee extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao userDao= new UserDao();
		
		int id= Integer.parseInt(req.getParameter("id"));
		PrintWriter printWriter= resp.getWriter();
		try {
			if (userDao.findById(id)) {
				printWriter.print("<html><body>");
				printWriter.print("<h3>User Deleted</h3>");
				printWriter.print("</body></html>");
				
				RequestDispatcher requestDispatcher= req.getRequestDispatcher("viewemployee");
				requestDispatcher.include(req, resp);
			}
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}
