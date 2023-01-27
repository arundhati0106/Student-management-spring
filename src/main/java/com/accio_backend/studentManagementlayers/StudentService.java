package com.accio_backend.studentManagementlayers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//service layer
//controller deals with service-> deals with repository
//has to call the function in repo layer that need sto be done
//how to call a func -> 1. by creating an object
//                      2. making it static

//talk between layers w/o creating objects using annotation (spring) -> uses dependency
//@Autowired

@Service
public class StudentService {
    //service layer has nothing to do here, as there aren't any processes
    //to be performed with data retrieved from database
    //eg sort the students acc to marks

    //main part of project, with external db

    //autowired makes objects of the layer, current layer is talking to
    @Autowired
    StudentRepository studentRepository;

    //call the function of repo layer, using the object
    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student getStudent(int admnNo) {
        return studentRepository.getStudent(admnNo);
    }

    public String deleteStudent(int admnNo) {
        return studentRepository.deleteStudent(admnNo);
    }

    public String updateStudent(int admnNo, int age) {
        return studentRepository.updateStudent(admnNo, age);
    }
}

//processing info is done in service layer
//operation related to db is done in repo layer
