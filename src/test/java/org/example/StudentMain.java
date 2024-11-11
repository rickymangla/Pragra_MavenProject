package org.example;

public class StudentMain {
    public static void main(String[] args) {
        Student student = new Student();
        Student stu=new Student(23, "amit");

        student.setName("amit");
        student.setId(34);
        // System.out.println(student.getName());
        System.out.println(student);
    }
}
