package com.classes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.classes.Serivice.CustomersService;
import com.classes.entities.Customers;

@RestController
@RequestMapping("/Customers")
public class CustomersController {
	
	@Autowired
	CustomersService cus_service;
	
	@PostMapping("/insertData")
	public String insertData(@RequestBody Customers c) {
		String msg = cus_service.insertData(c);
		return msg;

	}

	@PutMapping("/updateData/{cus_id}")
	public String updateData(@RequestBody Customers c,@PathVariable int cus_id) {
		String msg = cus_service.updateData(c, cus_id);
		return msg;

	}

	@DeleteMapping("/deleteData/{cus_id}")
	public String deleteData(@PathVariable int cus_id) {
		String msg = cus_service.deleteData(cus_id);
		return msg;

	}

	@GetMapping("/getSingleRecord")
	public Customers getSingleRecord(@RequestParam int cus_id) {
		Customers c = cus_service.getSingleRecord(cus_id);
		return c;

	}

	@GetMapping("/getAllRecord")
	public List<Customers> getAllRecord() {
		List<Customers> list = cus_service.getAllRecord();
		return list;

	}

	

}
