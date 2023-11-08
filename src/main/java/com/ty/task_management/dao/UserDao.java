package com.ty.task_management.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.task_management.entity.Task;
import com.ty.task_management.entity.User;
import com.ty.task_management.exceptions.UserNotFoundException;

public class UserDao {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("seema");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	private static EntityTransaction entityTransaction = entityManager.getTransaction();

	public User saveUser(User user) {

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

		return user;
	}

	public User findByEmail(String email, String password) {
		Query query = entityManager.createQuery("select u from User u where email=?1");
		query.setParameter(1, email);
		User user = (User) query.getSingleResult();

		if (user != null) {
			if (user.getPassword().equals(password)) {
				return user;
			} else {
				return null;
			}
		} else {
			throw new UserNotFoundException();
		}

	}

	public boolean removeUser(String email) {

		Query query = entityManager.createQuery("select u from User u where email=?1");
		query.setParameter(1, email);
		User user = (User) query.getSingleResult();

		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		} else {
			throw new UserNotFoundException();
		}
	}

	public User updateUser(User user1) {

		Query query = entityManager.createQuery("select u from User u where u.email=?1");
		query.setParameter(1, user1.getEmail());
		User user = (User) query.getSingleResult();
		
		if (user != null) {
			List<Task> tasks = user.getTask();
			if (tasks != null) {
				tasks.addAll(user1.getTask());
				user.setTask(tasks);
			} else {
				user.setTask(tasks);
			}
			
			entityTransaction.begin();
			List<Task> taskList= user1.getTask();
			for (Task task : taskList) {
				entityManager.persist(task);
			}
			entityManager.merge(user);
			entityTransaction.commit();
			return user;
		} else {
			throw new UserNotFoundException();
		}
	}
	
	public User finUser(int id) {
		User user= entityManager.find(User.class, id);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	public List<User> findAll() {
		Query query = entityManager.createQuery("Select u from User u");
		List<User> users = query.getResultList();

		if (users != null) {
			return users;
		}
		throw new UserNotFoundException();
	}

	public boolean findById(int id) {

		User user = entityManager.find(User.class, id);
		List<Task> tasks = user.getTask();

		if (user != null) {
			entityTransaction.begin();
			for (Task task : tasks) {
				entityManager.remove(task);
			}
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
}
