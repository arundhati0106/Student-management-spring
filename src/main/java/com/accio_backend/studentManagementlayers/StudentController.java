package com.accio_backend.studentManagementlayers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//is the controller layer, deals with client
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //get info
    @GetMapping("/get_student")
    //Response Entity -> a class; two parameters -> ans we want, status code (internet response).. imp for front end
    public ResponseEntity getStudent(@RequestParam("q") int admnNo) {
        Student student = studentService.getStudent(admnNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    //add info
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student) {
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //remove info
    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int admnNo) {
        String response = studentService.deleteStudent(admnNo);

        //if id doesnt exist -> bad request
        if(response.equals(null)) {
            return new ResponseEntity<>("Invalid Admission no.", HttpStatus.BAD_REQUEST);
        }

        //else, return response, request accepted
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    //update info
    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int admnNo, @RequestParam("age") int age) {
        String response = studentService.updateStudent(admnNo, age);

        //if id doesnt exist -> bad request
        if(response.equals(null)) {
            return new ResponseEntity<>("Invalid Admission no.", HttpStatus.BAD_REQUEST);
        }

        //else, return response, request accepted
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
