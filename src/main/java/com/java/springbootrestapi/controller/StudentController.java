package com.java.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.springbootrestapi.bean.Student;

@RestController
public class StudentController {
	
	//http://localhost:8080/student
	@GetMapping("student")
	public Student getStudent() {
		Student student = new Student(
				1,
				"Anand",
				"Kumar"
			);
		return student;
	}
	
	//http://localhost:8080/students
	@GetMapping("students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Suresh","Kumar"));
		students.add(new Student(2,"Ramesh","Kumar"));
		students.add(new Student(3,"Hitesh","Kumar"));
		
		return students;
		
	}
	
	//http://localhost:8080/students/1
	//{id} - URI Template Variable
	@GetMapping("students/{id}")
	public Student studentPathVariable(@PathVariable int id) {
		return new Student(id,"Ramesh","Kumar");
	}
	
	//Spring boot REST API with Request Parameter
	//http://localhost:8080/students/query?id=1&firstName=Ramesh&lastName=Kumar
	@GetMapping("students/query")
	public Student studentRequestVariable(@RequestParam int id,
										  @RequestParam String firstName,
										  @RequestParam String lastName) {
		return new Student(id,firstName,lastName);

	}
}
