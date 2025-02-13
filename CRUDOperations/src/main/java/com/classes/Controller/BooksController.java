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

import com.classes.Serivice.BooksService;
import com.classes.entities.Books;

@RestController
@RequestMapping("/Books")
public class BooksController {

	@Autowired
	BooksService bservice;

	@PostMapping("/insertData")
	public String insertData(@RequestBody Books b) {
		String msg = bservice.insertData(b);
		return msg;

	}

	@PutMapping("/updateData/{book_id}")
	public String updateData(@RequestBody Books b, @PathVariable int book_id) {
		String msg = bservice.updateData(b, book_id);
		return msg;

	}

	@DeleteMapping("/deleteData/{book_id}")
	public String deleteData(@PathVariable int book_id) {
		String msg = bservice.deleteData(book_id);
		return msg;

	}

	@GetMapping("/getSingleRecord/{book_id}")
	public Books getSingleRecord(@PathVariable int book_id) {
		Books b = bservice.getSingleRecord(book_id);
		return b;

	}

	@GetMapping("/getAllRecord")
	public List<Books> getAllRecord() {
		List<Books> list = bservice.getAllRecord();
		return list;
	}
}
