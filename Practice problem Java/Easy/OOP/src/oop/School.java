// code for a school info 
//student, teacher information
package oop;

import java.util.Scanner;

public class School {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        String name;
        int ID, Class;
        double marks;
        System.out.print("Enter the number of students: ");
        int n= inp.nextInt();
        
        student[] TheStudents =new student[n];
        
        System.out.print("Enter the number of Teachers: ");
        n= inp.nextInt();
        
        teacher[] TheTeachers =new teacher[n];
        
        System.out.println("Set the student info: ");
       for (int i = 0; i < TheStudents.length ; i++) {
           System.out.println("Enter student "+(i+1) +": ");
           System.out.print("name: ");
           name=inp.next();
           System.out.print("ID: ");
           ID=inp.nextInt();
           System.out.print("Class: ");
           Class=inp.nextInt();
           System.out.print("marks: ");
           marks=inp.nextDouble();
           TheStudents[i]=new student();
           TheStudents[i].setInfoS(name, ID, marks, Class);
       }
        for (int i = 0; i < TheStudents.length; i++) {
            System.out.println("Student "+(i+1) +": ");
            TheStudents[i].printStudent();
        }
       
        for (int i = 0; i <TheTeachers.length; i++) {
            TheTeachers[i]=new teacher();
            TheTeachers[i].setInfoT();
        }
        for (int i = 0; i <TheTeachers.length; i++) {
            TheTeachers[i].printTeacher();
        }
    }
}
