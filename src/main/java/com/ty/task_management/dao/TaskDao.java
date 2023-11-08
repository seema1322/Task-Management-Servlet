package com.ty.task_management.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.task_management.entity.Task;
import com.ty.task_management.entity.User;
import com.ty.task_management.exceptions.TaskNotFoundException;

public class TaskDao {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("seema");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	private static EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveTask(Task task) {
		entityTransaction.begin();
		entityManager.persist(task);

		entityTransaction.commit();
	}

	public void updateStatus(int id, String status) {

		Task task = entityManager.find(Task.class, id);

		if (task != null) {

			task.setStatus(status);
			entityTransaction.begin();
			entityManager.merge(task);
			entityTransaction.commit();
		} else {
			throw new TaskNotFoundException();
		}

	}

	public List<Task> findAll(String email) {
		Query query1 = entityManager.createQuery("select u from User u where email=?1");
		query1.setParameter(1, email);

		User user = (User) query1.getSingleResult();
		List<Task> tasks = user.getTask();

		if (tasks != null) {
			return tasks;
		} else {
			return null;
		}
	}

}
