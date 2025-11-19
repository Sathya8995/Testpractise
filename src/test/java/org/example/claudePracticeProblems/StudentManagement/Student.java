package org.example.claudePracticeProblems.StudentManagement;

public class Student {
    private int id;
    private float gpa;
    private String dept;

    public Student(int id, float gpa, String dept) {
        this.id = id;
        this.gpa = gpa;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}

