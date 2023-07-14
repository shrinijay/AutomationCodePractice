package week3.day1.assignments.assignment2.org.student;

import week3.day1.assignments.assignment2.org.department.Department;

public class Student extends Department {

    public void studentName(){
        System.out.println("Student name in studentName class from org.student package");
    }

    public void studentDept(){
        System.out.println("studentDept in studentName class from org.student package");
    }

    public void studentId(){
        System.out.println("studentID in studentName class from org.student package");
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.collegeName();
        student.collegeCode();
        student.collegeRank();
        student.deptName();
        student.studentId();
        student.studentName();
        student.studentDept();
    }
}
