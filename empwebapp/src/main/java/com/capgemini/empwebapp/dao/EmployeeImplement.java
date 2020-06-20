package com.capgemini.empwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.empwebapp.dto.EmployeeBean;

public class EmployeeImplement implements EmployeeDAO{
	private final static EntityManagerFactory factory=Persistence.createEntityManagerFactory("TestPersistence");

	public boolean register(EmployeeBean bean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(bean);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public List<EmployeeBean> search(String name) {
		EntityManager manager=factory.createEntityManager();
		String jpql="select e from EmployeeBean e where e.name=:name";
		TypedQuery<EmployeeBean> query=manager.createQuery(jpql,EmployeeBean.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

		public boolean changePassword(int id, String password) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		EmployeeBean record=manager.find(EmployeeBean.class,id);
		record.setPassword(password);
		transaction.commit();
		return true;
	}
		public EmployeeBean auth(String email, String password) {
			EntityManager manager=factory.createEntityManager();
			String jpql="select e from EmployeeBean e where e.email=:email and e.password=:password";
			TypedQuery<EmployeeBean> query=manager.createQuery(jpql,EmployeeBean.class);
			query.setParameter("email",email );
			query.setParameter("password", password);
			try {
				return query.getSingleResult();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}


}
