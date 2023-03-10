package com.java.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.springbootrestapi.bean.Student;

@RestController
@RequestMapping("students")
public class StudentController {
	
	//http://localhost:8080/student
	@GetMapping("student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(
				1,
				"Anand",
				"Kumar"
			);
		//return new ResponseEntity<>(student, HttpStatus.OK);
		return ResponseEntity.ok(student);
	}
	
	//http://localhost:8080/students
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Suresh","Kumar"));
		students.add(new Student(2,"Ramesh","Kumar"));
		students.add(new Student(3,"Hitesh","Kumar"));
		
		return ResponseEntity.ok(students);
		
	}
	
	//http://localhost:8080/students/1
	//{id} - URI Template Variable
	@GetMapping("{id}")
	public ResponseEntity<Student> studentPathVariable(@PathVariable int id) {
		Student student = new Student(id,"Ramesh","Kumar");
		return ResponseEntity.ok(student);
	}
	
	//Spring boot REST API with Request Parameter
	//http://localhost:8080/students/query?id=1&firstName=Ramesh&lastName=Kumar
	@GetMapping("query")
	public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
										  @RequestParam String firstName,
										  @RequestParam String lastName) {
		Student student =  new Student(id,firstName,lastName);
		return ResponseEntity.ok(student);
	}
	
	//Spring boot REST API that handles HTTP POST Request to create new resource
	//@PostMapping and @RequestBody
    //@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.print(student.getId());
		System.out.print(student.getFirstName());
		System.out.print(student.getLastName());
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	//Spring boot REST API that handles HTTP PUT Request - updating existing resource
	@PutMapping("{id}/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return ResponseEntity.ok(student);
	}
	
	//Spring boot REST API that handles HTTP DELETE Request - deleting the existing resource
	@DeleteMapping("{id}/delete")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
		System.out.println(studentId);
		return ResponseEntity.ok("Student Deleted Successfully.");
	}
	
}
