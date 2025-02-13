package com.classes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.classes.Serivice.EmployeesService;
import com.classes.entities.Employees;

@RestController
public class EmployeeController {

	@Autowired
	EmployeesService eservice;

	@PostMapping("/insertDataEmployees")
	public String insertData(@RequestBody Employees e) {
		String msg = eservice.insertData(e);
		return msg;

	}

	@PutMapping("/updateDataEmployees/{id}")
	public String updateData(@RequestBody Employees e, @PathVariable int id) {
		String msg = eservice.updateData(e, id);
		return msg;

	}

	@DeleteMapping("/deleteDataEmployees/{id}")
	public String deleteData(@PathVariable int id) {
		String msg = eservice.deleteData(id);
		return msg;

	}

	@GetMapping("/getSingleRecordEmployees/{id}")
	public Employees getSingleRecord(@PathVariable int id) {
		Employees e = eservice.getSingleRecord(id);
		return e;

	}

	@GetMapping("/getAllRecordEmployees")
	public List<Employees> getAllRecord() {
		List<Employees> list = eservice.getAllRecord();
		 return list;

	}

}
