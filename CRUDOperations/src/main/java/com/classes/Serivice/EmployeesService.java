package com.classes.Serivice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classes.Dao.EmployeesDao;
import com.classes.entities.Employees;

@Service
public class EmployeesService {

	@Autowired
	EmployeesDao empDao;

	public String insertData(Employees e) {
		String msg = empDao.insertData(e);
		return msg;

	}

	public String deleteData(int id) {
		String msg = empDao.deleteData(id);
		return msg;

	}

	public String updateData(Employees e, int id) {
		String msg = empDao.updateData(e, id);
		return msg;

	}

	public Employees getSingleRecord(int id) {
		Employees e = empDao.getSingleRecord(id);
		return e;

	}

	public List<Employees> getAllRecord() {
		List<Employees> list = empDao.getAllRecord();
		return list;

	}

}
