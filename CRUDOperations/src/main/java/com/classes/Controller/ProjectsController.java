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
import org.springframework.web.bind.annotation.RestController;

import com.classes.Serivice.ProjectsService;
import com.classes.entities.Projects;

@RestController
@RequestMapping("/Projects")
public class ProjectsController {

	@Autowired
	ProjectsService pservice;

	@PostMapping("/insertData")
	public Projects insertData(@RequestBody Projects p) {
		Projects p1 = pservice.insertData(p);
		return p1;
		

	}

	@PutMapping("/updateData/{pro_id}")
	public Projects updateData(@RequestBody Projects p, @PathVariable int pro_id) {
		Projects p1 = pservice.updateData(p, pro_id);
		return p1;

	}

	@DeleteMapping("/deleteData/{pro_id}")
	public int deleteData(@PathVariable int pro_id) {
		int msg = pservice.deleteData(pro_id);
		return msg;

	}

	@GetMapping("/getSingleRecord/{pro_id}")
	public Projects getSingleRecord(@PathVariable int pro_id) {
		Projects p = pservice.getSingleRecord(pro_id);
		return p;

	}

	@GetMapping("/getAllRecord")
	public List<Projects> getAllRecord() {
		List<Projects> p = pservice.getAllRecord();
		return p;

	}

}
