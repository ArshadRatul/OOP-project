//person, taceher and student (single and Hierarchial)
package inheritance_practice;

public class main {
    public static void main(String[] args) {
        person p1= new person();
        student s1= new student();
        teacher t1= new teacher();
        
        s1.setName("Ratul");
        s1.display1();
    }
}
