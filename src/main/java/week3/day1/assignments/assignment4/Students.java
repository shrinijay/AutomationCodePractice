package week3.day1.assignments.assignment4;

import week3.day1.assignments.assignment2.org.student.Student;

public class Students {

    public void getStudentInfo(){
        System.out.println("getStudentInfo without arguments method");
    }
    public void getStudentInfo(int id){
        System.out.println("getStudentInfo with id arguments "+id);
    }

    public void getStudentInfo(int id, String name){
        System.out.println("getStudentInfo with id & name "+id+" "+name);
    }

    public void getStudentInfo(String email,long phoneNumber){
        System.out.println("getStudentInfo with email & phoneNumber "+email+" "+phoneNumber);
    }

    public static void main(String[] args) {
        Students students = new Students();
        students.getStudentInfo();
        students.getStudentInfo(28);
        students.getStudentInfo(28,"Shreyas");
        students.getStudentInfo("abcd@xyz.com",9012345690L);
    }

}
