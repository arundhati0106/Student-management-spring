package com.accio_backend.studentManagementlayers;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

//repository layer
//service deals with repo, repo deals with database
@Repository
public class StudentRepository {
    //since we aren't using external db, we move db here, in repo
    //while using sql etc, we write code to connect to external db here, in this layer
    Map<Integer, Student> db = new HashMap<>();

    //functions to do with data in the database
    //add info
    public String addStudent(Student student) {
        int admnNo = student.getAdmnNo();
        db.put(admnNo, student);
        return "Student added successfully";
    }

    //get info
    public Student getStudent(int admnNo) {
        return db.get(admnNo);
    }

    //delete info
    public String deleteStudent(int admnNo) {
        if(!db.containsKey(admnNo)) {
            return null;
        }

        db.remove(admnNo);
        return "Data of student with Admission no. " +admnNo+ " has been removed.";
    }

    //update info
    public String updateStudent(int admnNo, int age) {
        if(!db.containsKey(admnNo)) {
            return null;
        }

        db.get(admnNo).setAge(age);
        return "Age of student with Admission no. " +admnNo+ " has been updated.";

        //Student student = db.get(admnNo);
        //student.setAge(age);
        //db.put(admnNo, student);     //no need to put it back, as object value has changed, not copy's value, have to do for string value
    }
}


//processing info is done in service layer
//operations related to db is done in repo layer
