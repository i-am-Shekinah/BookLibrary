package org.library.entity;

public class Student extends User {

    private int studentClass;

    public Student(String name, int studentClass) {
        super(name);
        this.studentClass = studentClass;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }
}
