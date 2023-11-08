package com.ty.task_management.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.task_management.dao.TaskDao;
import com.ty.task_management.entity.Task;

@WebServlet(value = "/tasktable")
public class ViewEmployeeTask extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		TaskDao taskDao = new TaskDao();
		PrintWriter printWriter = resp.getWriter();

		String email = req.getParameter("User_Email");

		try {
			List<Task> tasks = taskDao.findAll(email);
			
			if (tasks != null) {

				printWriter.print("<html><body>");
				printWriter.print("<h3>Task Details</h3>");
				printWriter.print("<table border='1' cellpadding='10' cellspacing='20'>");
				printWriter.print("<tr>");
				printWriter.print("<th>ID</th>");
				printWriter.print("<th>Description</th>");
				printWriter.print("<th>Assigned Date&Time</th>");
				printWriter.print("<th>Completed Date&Time</th>");
				printWriter.print("<th>Status</th>");
				printWriter.print("<th>Update Status</th>");
				printWriter.print("</tr>");

				for (Task task : tasks) {

					printWriter.print("<tr>");
					printWriter.print("<td>" + task.getId() + "</td>");
					printWriter.print("<td>" + task.getDescription() + "</td>");
					printWriter.print("<td>" + task.getCreatedDateTime() + "</td>");
					printWriter.print("<td>" + task.getCompletedDateTime() + "</td>");
					printWriter.print("<td>" + task.getStatus() + "</td>");
					printWriter.print("<td><a href=updatetask?id=" + task.getId() + "> Completed</a></td>");
					printWriter.print("</tr>");
				}
				printWriter.print("</table>");
				printWriter.print("</body></html>");

			} else {
				printWriter.print("<html><body>");
				printWriter.print("<h3>No Tasks to View</h3>");
				printWriter.print("</body></html>");
			}
		} catch (NoResultException e) {
			System.out.println("Task Details are not present");
		}
	}

}
