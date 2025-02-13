package com.classes.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classes.entities.Students;

@Repository
public class StudentsDao {

	@Autowired
	SessionFactory sf;

	public String insertData(Students s) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(s);
		tr.commit();
		ss.close();
		return "data is inserted...";
	}

	public String updateData(Students s, int stu_id) {

		Session ss = sf.openSession(); 
		Transaction tr = null;

		try {
			tr = ss.beginTransaction();

			Students s1 = ss.get(Students.class, stu_id);

			if (s1 == null) {
				return "Student with ID " + stu_id + " not found.";
			}

			s1.setStu_name(s.getStu_name());
			s1.setStu_city(s.getStu_city());
			s1.setStandered(s.getStandered());

			ss.merge(s1);

			tr.commit();
			return "Data is updated successfully.";
		} catch (Exception e) {
			if (tr != null) {
				tr.rollback(); 
			}
			e.printStackTrace();
			return "Error updating data.";
		} finally {
			ss.close(); 
		}
	}

	public String deleteData(int stu_id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Students s = ss.get(Students.class, stu_id);

		ss.remove(s);
		tr.commit();
		ss.close();
		return "data is deleted...";
	}

	public Students getSingleRecord(int stu_id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String HqlQueary = "from Students where stu_id = :id";

		Query<Students> query = ss.createQuery(HqlQueary, Students.class);
		query.setParameter("id", stu_id);
		Students s = query.uniqueResult();

		return s;

	}

	public List<Students> getAllRecord() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String HqlQuery = "from Students";
		Query<Students> query = ss.createQuery(HqlQuery, Students.class);
		List<Students> list = query.list();
		return list;
	}

}
