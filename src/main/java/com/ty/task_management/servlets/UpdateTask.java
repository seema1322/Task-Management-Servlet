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

import com.ty.task_management.dao.TaskDao;
import com.ty.task_management.dao.UserDao;
import com.ty.task_management.entity.User;
import com.ty.task_management.exceptions.TaskNotFoundException;

@WebServlet(value = "/updatetask")
public class UpdateTask extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int tid = Integer.parseInt(req.getParameter("id"));
		int userid= Integer.parseInt(req.getParameter("userId"));
		PrintWriter printWriter = resp.getWriter();
		TaskDao taskDao = new TaskDao();

		String status = "Completed";
		try {
			taskDao.updateStatus(tid, status);
			
			UserDao userDao= new UserDao();
			User user=userDao.finUser(userid);
			
			
			printWriter.print("<html><body>");
			printWriter.print("<h1>Status changed to Complete</h1>");
			printWriter.print("</body></html>");
			req.setAttribute("user", user);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewTask.jsp");
			requestDispatcher.include(req, resp);

		} catch (NoResultException e) {
			printWriter.print("<html><body>");
			printWriter.print("<h1>Failed To Update status</h1>");
			printWriter.print("</body></html>");
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewTask.jsp");
			requestDispatcher.include(req, resp);
		} catch (TaskNotFoundException e) {
			printWriter.print("<html><body>");
			printWriter.print("<h1>Failed To Update status</h1>");
			printWriter.print("</body></html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("tasktable");
			requestDispatcher.forward(req, resp);
		}
	}

}
