package com.classes.Serivice;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classes.Dao.BooksDao;
import com.classes.entities.Books;

@Service
public class BooksService {

	@Autowired
	BooksDao bDao;

	public String insertData(Books b) {
		String msg = bDao.insetData(b);
		if (Objects.isNull(b)) {
			msg = "data is not inserted...";
		}
		return msg;

	}

	public String updateData(Books b, int book_id) {
		String msg = bDao.updateData(b, book_id);
		if (Objects.isNull(b)) {
			msg = "data is not inserted...";
		}
		return msg;

	}

	public String deleteData(int book_id) {
		String msg = bDao.deleteData(book_id);
		if(msg!=null) {
			msg = "data is not deleted";
		}
		return msg;

	}

	public Books getSingleRecord(int book_id) {
		Books b = bDao.getSingleRecord(book_id);
		return b;

	}

	public List<Books> getAllRecord() {
		List<Books> list = bDao.getAllRecord();
		return list;

	}

}
