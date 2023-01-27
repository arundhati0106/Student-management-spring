package com.accio_backend.studentManagementlayers;

public class Student {
    //attributes
    private String name;
    private int admnNo;
    private int age;
    private String state;

    //getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAdmnNo() { return admnNo; }
    public void setAdmnNo(int admnNo) { this.admnNo = admnNo; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    //constructor
    public Student(String name, int admnNo, int age, String state) {
        this.name = name;
        this.admnNo = admnNo;
        this.age = age;
        this.state = state;
    }
}
