package com.ty.task_management.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.task_management.dao.UserDao;
import com.ty.task_management.entity.Task;
import com.ty.task_management.entity.User;

@WebServlet(value="/employee")
public class AddEmployee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao userDao= new UserDao();
		String name= req.getParameter("User_Name");
		String email= req.getParameter("User_Email");
		String password= req.getParameter("User_Password");
		
		//String description = req.getParameter("Task_Desc");
		
//		Task task = new Task();
//		task.setDescription(description);
//		List<Task> tasks= new ArrayList<Task>();
		
		User user= new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setRole("Employee");
		//user.setTask(tasks);
		
		userDao.saveUser(user);
		PrintWriter printWriter= resp.getWriter();
		printWriter.print("<html><body>");
		printWriter.print("<h1>Employee On-boarded</h1>");
		printWriter.print("</body></html>");
		
		RequestDispatcher requestDispatcher= req.getRequestDispatcher("ManagerHome.jsp");
		requestDispatcher.include(req, resp);
		
		
	}
	
}
