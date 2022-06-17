package com.trainning.testingMongoDB.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/api/v1")
@RestController

public class studentController {
	@Autowired
	private studentRepository stuRepo;
	@GetMapping("/student")
	public List <student> getAllstudent()
	{
		return stuRepo.findAll();
	}
	public student saveStudent(@Validated @RequestBody student student) 
	{
		return stuRepo.save(student);
	}
	@PostMapping("/student")
	public student createStudent(@Validated @RequestBody student student)
	{
		return stuRepo.save(student);
	}
	@PutMapping("/student/{id}")
	public student updateStudent(@RequestBody student Student, @PathVariable String id)
	{
		student currentstudent;
		currentstudent = stuRepo.findById(id).get();
		currentstudent.setFirstName(Student.getFirstName());
		currentstudent.setLastName(Student.getLastName());
		currentstudent.setStudentNumber(Student.getStudentNumber());
		return stuRepo.save(currentstudent);
	}
	@DeleteMapping("/student/{id}")
	public void deletestudentbyid(@PathVariable String id)
	{
		stuRepo.deleteById(id);
	}

	

}
