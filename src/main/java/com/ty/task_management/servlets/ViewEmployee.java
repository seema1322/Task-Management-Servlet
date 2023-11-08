package com.ty.task_management.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.task_management.dao.UserDao;
import com.ty.task_management.entity.User;

@WebServlet(value = "/viewemployee")
public class ViewEmployee extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserDao userDao = new UserDao();

		List<User> users = userDao.findAll();

		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body>");
		printWriter.print("<h3>Employee Details</h3>");
		printWriter.print("<table border='1' cellpadding='10' cellspacing='20'>");
		printWriter.print("<tr>");
		printWriter.print("<th>ID</th>");
		printWriter.print("<th>Name</th>");
		printWriter.print("<th>Email</th>");
		printWriter.print("<th>Role</th>");
		printWriter.print("<th>Action</th>");
		printWriter.print("<tr>");

		for (User user : users) {

			if (user.getRole().equalsIgnoreCase("employee")) {
				printWriter.print("<tr>");
				printWriter.print("<td>"+user.getId()+"</td>");
				printWriter.print("<td>"+user.getName()+"</td>");
				printWriter.print("<td>"+user.getEmail()+"</td>");
				printWriter.print("<td>"+user.getRole()+"</td>");
				//printWriter.print("<td><a href=updateuser?id= "+user.getId()+">Update</a></td>");
				printWriter.print("<td><a href=deleteuser?id=" + user.getId() + ">Delete</a></td>");
				printWriter.print("<tr>");
			}
		}
		printWriter.print("</table>");
		printWriter.print("</body></html>");
	}

}
