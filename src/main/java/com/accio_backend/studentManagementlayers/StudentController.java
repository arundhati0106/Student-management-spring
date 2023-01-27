package com.accio_backend.studentManagementlayers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Student getStudent(@RequestParam("q") int admnNo) {
        return studentService.getStudent(admnNo);
    }

    //add info
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    //remove info
    @DeleteMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable("id") int admnNo) {
        return studentService.deleteStudent(admnNo);
    }

    //update info
    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("id") int admnNo, @RequestParam("age") int age) {
        return studentService.updateStudent(admnNo, age);
    }
}
