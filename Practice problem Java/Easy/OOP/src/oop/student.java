
package oop;

public class student {
    String name;
    int ID,Class;
    double marks;
    student()
    {
        name="N/A";
        ID=Class=0;
        marks=0.0f;
    }
    void setInfoS(String name, int ID, double marks, int Class)
    {
        this.name=name;
        this.ID=ID;
        this.marks=marks;
        this.Class=Class;
    }
    void printStudent()
    {
        System.out.print("name: "+name);
        System.out.print(" ID: "+ID);
        System.out.print(" Class: "+Class);
        System.out.println(" marks: "+marks);
    }
}
