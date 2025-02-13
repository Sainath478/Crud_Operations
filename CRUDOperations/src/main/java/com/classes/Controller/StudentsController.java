package com.classes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.classes.Serivice.StudentsService;
import com.classes.entities.Students;

@RestController
public class StudentsController {

	@Autowired
	StudentsService stuService;

	@PostMapping("/insertDataStudents")
	public String insertData(@RequestBody Students s) {
		String msg = stuService.insertData(s);
		return msg;
	}

	@PutMapping("/updateDataStudents/{stu_id}")
	public String updateData(@RequestBody Students s, @PathVariable int stu_id) {
		String msg = stuService.updateData(s, stu_id);
		return msg;
	}

	@DeleteMapping("/deleteDataStudents/{stu_id}")
	public String deleteData(@PathVariable int stu_id) {
		String msg = stuService.deleteData(stu_id);
		return msg;
	}

	@GetMapping("/getSingleRecordStudents")
	public Students getSingleRecord(@RequestParam int stu_id) {
		Students msg = stuService.getSingleRecord(stu_id);
		return msg;
	}

	@GetMapping("/getAllRecordStudents")
	public List<Students> getAllRecord() {
		List<Students> list = stuService.getAllRecord();
		return list;
	}

}
