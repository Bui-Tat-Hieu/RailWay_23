package com.vti.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.enity.Account;
import com.vti.enity.Address;
import com.vti.enity.Department;
import com.vti.enity.DetailDepartment;
import com.vti.enity.Employee;
import com.vti.enity.Manager;
import com.vti.enity.Position;
import com.vti.enity.Salary;



public class HibernateUtils {

	private static HibernateUtils instance;

	private Configuration configuration;
	private SessionFactory sessionFactory;

	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}

	private HibernateUtils() {
		configure();
	}

	private void configure() {
		// load configuration
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Address.class);
		configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(DetailDepartment.class);
		configuration.addAnnotatedClass(Position.class);
		configuration.addAnnotatedClass(Salary.class);
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Manager.class);
		

	}

	private SessionFactory buildSessionFactory() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}

	public void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}

	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}

}
