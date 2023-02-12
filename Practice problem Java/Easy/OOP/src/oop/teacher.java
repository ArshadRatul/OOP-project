
package oop;

import java.util.Scanner;

public class teacher {
    String name, subject;
    String[] stdlist;
    double salary;
    int n;
    teacher()
    {
        name=subject="N/A";
        salary=0;
    }
   
    void setInfoT()
    {
        Scanner inp= new Scanner(System.in);
        System.out.print("Enter the teacher's name: ");
        name= inp.next();
        System.out.print("Enter the teacher's subject: ");
        subject= inp.next();
        System.out.print("Enter the teacher's salary: ");
        salary=inp.nextDouble();
        System.out.print("Enter the number of students name: ");
        n=inp.nextInt();//number of students for the teacher
        stdlist= new String[n];
        for (int i = 0; i <n; i++) {
            System.out.print("Enter student "+(i+1)+" name:");
            stdlist[i]=inp.next();
        }
    }
    void printTeacher()
    {
        System.out.print("Teacher's name: "+name);
        System.out.print(" Teacher's subject: "+subject);
        System.out.print(" Teacher's salary: "+salary);
        System.out.println(" Students names: ");
        for (int i = 0; i <n; i++) {
            System.out.println(" student "+(i+1)+": "+stdlist[i]);
        }
    }
}
