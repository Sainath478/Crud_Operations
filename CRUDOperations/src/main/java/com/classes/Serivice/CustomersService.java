package com.classes.Serivice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classes.Dao.CustomersDao;
import com.classes.entities.Customers;

@Service
public class CustomersService {

	@Autowired
	CustomersDao cusdao;

	public String insertData(Customers c) {
		String msg = cusdao.insertData(c);
		return msg;

	}

	public String updateData(Customers c, int cus_id) {
		String msg = cusdao.updateData(c, cus_id);
		return msg;

	}

	public String deleteData(int cus_id) {
		String msg = cusdao.deleteData(cus_id);
		return msg;

	}

	public Customers getSingleRecord(int cus_id) {
		Customers c = cusdao.getSingleRecord(cus_id);
		return c;

	}

	public List<Customers> getAllRecord() {
		List<Customers> list = cusdao.getAllRecord();
		return list;

	}

}
