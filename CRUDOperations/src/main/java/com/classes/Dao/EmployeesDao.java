package com.classes.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classes.entities.Employees;

@Repository
public class EmployeesDao {

	@Autowired
	SessionFactory sf;

	public String insertData(Employees e) {

		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(e);
		tr.commit();
		ss.close();
		return "data is inserted...";

	}

	public String updateData(Employees e, int id) {
		Session ss = sf.openSession();
		Transaction tr = null;

		try {

			tr = ss.beginTransaction();

			Employees e1 = ss.get(Employees.class, id);
			e1.setName(e1.getName());
			e1.setDomain(e1.getDomain());
			e1.setSalary(e1.getSalary());
			e1.setAddress(e1.getAddress());

			ss.merge(e1);
			tr.commit();
			return "data is updated...";

		} catch (Exception e2) {
			if (tr != null) {
				tr.rollback();
			return "Error updating data.";
			}
		}
		finally {
			ss.close();
		}
		return null;
		
	}

	public String deleteData(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Employees e = ss.get(Employees.class, id);

		ss.remove(e);
		tr.commit();
		ss.close();
		return "data is deleted...";

	}

	public Employees getSingleRecord(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String HqlQuery = "from Employees where id = :emp_id";
		Query<Employees> query = ss.createQuery(HqlQuery, Employees.class);
		query.setParameter("emp_id", id);
		Employees e = query.uniqueResult();
		return e;

	}

	public List<Employees> getAllRecord() {

		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String HqlQuery = "from Employees";
		Query<Employees> query = ss.createQuery(HqlQuery, Employees.class);
		List<Employees> list = query.list();
		return list;

	}
}
