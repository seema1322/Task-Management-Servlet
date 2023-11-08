package com.ty.task_management.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.task_management.dao.UserDao;
import com.ty.task_management.entity.Task;
import com.ty.task_management.entity.User;
import com.ty.task_management.exceptions.UserNotFoundException;

@WebServlet(value="/task")
public class AssignTask extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter printWriter= resp.getWriter();
		UserDao userDao= new UserDao();
		String email= req.getParameter("User_Email");
		String description= req.getParameter("Task_Desc");
		String status= "Assigned";
		
		Task task= new Task();
		task.setDescription(description);
		task.setStatus(status);
		
		List<Task> tasks= new ArrayList<Task>();
		tasks.add(task);
		User user = new User();
		user.setEmail(email);
		user.setTask(tasks);
		
		try {
			userDao.updateUser(user);
			printWriter.print("<html><body>");
			printWriter.print("<h3>Task is assigned</h3>");
			printWriter.print("</body></html>");
			
			RequestDispatcher requestDispatcher= req.getRequestDispatcher("ManagerHome.jsp");
			requestDispatcher.include(req, resp);
		} catch (UserNotFoundException e) {
			printWriter.print("<html><body>");
			printWriter.print("<h1>Failed To Assign task</h1>");
			printWriter.print("</body></html>");
			RequestDispatcher requestDispatcher= req.getRequestDispatcher("ManagerHome.jsp");
			requestDispatcher.include(req, resp);
		} catch (NoResultException e) {
			printWriter.print("<html><body>");
			printWriter.print("<h1>Failed To Assign task</h1>");
			printWriter.print("</body></html>");
			RequestDispatcher requestDispatcher= req.getRequestDispatcher("ManagerHome.jsp");
			requestDispatcher.include(req, resp);
		}
	}
	
	

}
