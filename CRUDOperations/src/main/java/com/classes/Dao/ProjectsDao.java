package com.classes.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classes.entities.Projects;

@Repository
public class ProjectsDao {

	@Autowired
	SessionFactory sf;

	public Projects insertData(Projects p) {
		Session ss = sf.openSession();
		Transaction tr = null;
		try {
			tr = ss.beginTransaction();
			ss.persist(p);
			tr.commit();

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return p;
		

	}

	public Projects updateData(Projects p, int pro_id) {
		Session ss = sf.openSession();
		Transaction tr = null;
		String msg = null;

		try {

			tr = ss.beginTransaction();

			Projects p1 = ss.get(Projects.class, pro_id);

			if (p1 != null) {

				p1.setName(p.getName());
				p1.setManager_name(p.getManager_name());
				p1.setLeader_name(p.getLeader_name());

				ss.merge(p1);
				tr.commit();
			}

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();

			}
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return p;

	}

	public int deleteData(int pro_id) {
		Session ss = sf.openSession();
		Transaction tr = null;
		String msg;

		try {
			tr = ss.beginTransaction();

			Projects p = ss.get(Projects.class, pro_id);

			ss.remove(p);
			tr.commit();
			msg = "data is deleted...";

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		}

		finally {
			if (ss != null) {
				ss.close();
			}

		}
		return pro_id;
	

	}

	public Projects getSingleRecord(int pro_id) {
		Session ss = sf.openSession();
		Transaction tr = null;

		try {

			tr = ss.beginTransaction();

			String HqlQuery = "from Projects where pro_id = :id";
			Query<Projects> query = ss.createQuery(HqlQuery, Projects.class);
			query.setParameter("id", pro_id);
			Projects p = query.uniqueResult();
			return p;

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();

		} finally {
			if (ss != null) {
				ss.close();
			}

		}
		return null;

	}

	public List<Projects> getAllRecord() {

		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String HqlQuery = "from Projects";
		Query<Projects> query = ss.createQuery(HqlQuery);
		List<Projects> p = query.list();

		return p;

	}

}
