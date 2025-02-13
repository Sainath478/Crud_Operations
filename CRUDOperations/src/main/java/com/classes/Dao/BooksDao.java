package com.classes.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classes.entities.Books;

@Repository
public class BooksDao {

	@Autowired
	SessionFactory sf;

	public String insetData(Books b) {
		Session ss = null;
		Transaction tr = null;
		String msg = null;

		try {
			ss = sf.openSession();
			tr = ss.beginTransaction();
			ss.persist(b);
			tr.commit();
			msg = "data is inserted...";
		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return msg;

	}

	public String updateData(Books b, int book_id) {
		Session ss = sf.openSession();
		Transaction tr = null;
		String msg = null;

		try {
			tr = ss.beginTransaction();

			Books b1 = ss.get(Books.class, book_id);
			if (b1 != null) {
				b1.setBook_name(b.getBook_name());
				b1.setBook_author(b.getBook_author());
				b1.setPrice(b.getPrice());

				ss.merge(b1);
				tr.commit();
				msg = "Data is updated successfully.";
			} else {
				msg = "Book not found.";
			}

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			msg = "Update failed: " + e.getMessage();
			e.printStackTrace();
		} finally {
			ss.close();
		}

		return msg;
	}

	public String deleteData(int book_id) {
		Session ss = null;
		Transaction tr = null;
		String msg = null;

		try {
			ss = sf.openSession();
			tr = ss.beginTransaction();

			Books b = ss.get(Books.class, book_id);

			ss.remove(b);
			tr.commit();
			msg = "data is deleted...";

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
		} finally {
			if (ss != null) {
				ss.close();
			}
		}

		return msg;

	}

	public Books getSingleRecord(int book_id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String HqlQuery = "from Books where book_id = :id";
		Query<Books> query = ss.createQuery(HqlQuery, Books.class);
		query.setParameter("id", book_id);
		Books b = query.uniqueResult();

		return b;

	}

	public List<Books> getAllRecord() {

		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String HqlQuery = "from Books";
		Query<Books> query = ss.createQuery(HqlQuery, Books.class);
		List<Books> list = query.list();
		return list;

	}

}
