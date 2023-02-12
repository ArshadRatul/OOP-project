
package inheritance_practice;

public class person {
    private String name, address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    protected int NID,age;
    protected long mobileNO;
    person()
    {
        name=address="N/A";
        mobileNO=NID=age=0;
    }
    void display1()
    {
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("NID: "+NID);
        System.out.println("Mobile No: "+mobileNO);
    }
    
    
}
