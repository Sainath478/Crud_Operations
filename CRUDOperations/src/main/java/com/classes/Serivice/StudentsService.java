package com.classes.Serivice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classes.Dao.StudentsDao;
import com.classes.entities.Students;

@Service
public class StudentsService {

	@Autowired
	StudentsDao stuDao;

	public String insertData(Students s) {
		String msg = stuDao.insertData(s);
		return msg;

	}

	public String updateData(Students s, int stu_id) {

		String msg = stuDao.updateData(s, stu_id);
		return msg;
	}

	public String deleteData(int stu_id) {
		String msg = stuDao.deleteData(stu_id);
		return msg;
	}

	public Students getSingleRecord(int stu_id) {
		Students msg = stuDao.getSingleRecord(stu_id);
		return msg;
	}

	public List<Students> getAllRecord() {
		List<Students> list = stuDao.getAllRecord();
		return list;
	}

}
