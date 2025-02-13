package com.classes.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classes.entities.Customers;

@Repository
public class CustomersDao {

	@Autowired
	SessionFactory sf;

	public String insertData(Customers c) {
		Session ss = sf.openSession();
		Transaction tr = null;
		String msg = null;

		try {

			tr = ss.beginTransaction();
			ss.persist(c);
			tr.commit();
			msg = "data is inserted...";

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
				e.printStackTrace();
				return "data is not inserted...";

			}
		} finally {
			if (ss != null) {
				ss.close();
			}
		}

		return msg;

	}

	public String updateData(Customers c, int cus_id) {
		Session ss = sf.openSession();
		Transaction tr = null;
		String msg;

		try {
			tr = ss.beginTransaction();

			Customers c1 = ss.get(Customers.class, cus_id);

			if (c1 != null) {
				c1.setCus_name(c.getCus_name());
				c1.setProduct_name(c.getProduct_name());
				c1.setProduct_price(c.getProduct_price());

				tr.commit();
				msg = "Data is updated...";
			} else {
				msg = "Customer not found...";
			}

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
			msg = "Data is not updated...";
		} finally {
			ss.close();
		}

		return msg;
	}

	public String deleteData(int cus_id) {
		Session ss = sf.openSession();
		Transaction tr = null;
		String msg = null;
		try {
			tr = ss.beginTransaction();

			Customers c = ss.get(Customers.class, cus_id);

			ss.remove(c);
			tr.commit();
			msg = "data is deleted...";

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
				e.printStackTrace();
				return "data is not_deleted...";
			}
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return msg;

	}

	public Customers getSingleRecord(int cus_id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String HqlQuery = "from Customers where cus_id =:id";
		Query<Customers> query = ss.createQuery(HqlQuery, Customers.class);
		query.setParameter("id",cus_id);
		Customers c = query.uniqueResult();
		return c;

	}

	public List<Customers> getAllRecord() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String HqlQuery = "from Customers";
		Query<Customers> query = ss.createQuery(HqlQuery);
		List<Customers> list = query.list();
		return list;

	}

}
