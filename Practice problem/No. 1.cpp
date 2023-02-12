#include<iostream>
using namespace std;
class Address {
    // MUST have houseNo, roadNo, street, thana, district, zipCode, etc. as private fields
private:
    int houseNo,roadNo,zipCode;
    string street,thana,district;

public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    void setAddress()
    {
        cout<<"Enter house no.: ";
        cin>>houseNo;
        cout<<"Enter road no.: ";
        cin>>roadNo;
        cout<<"Enter street name: ";
        cin>>street;
        cout<<"Enter zipcode: ";
        cin>>zipCode;
        cout<<"Enter thana: ";
        cin>>thana;
        cout<<"Enter district: ";
        cin>>district;
    }
    void showAddress()
    {
        cout<<"Address: "<<houseNo<<", "<<roadNo<<" "<<street<<", "<<zipCode<<" "<<thana<<" "<<district<<endl;
    }
    int getZipcode(){return zipCode;}
};
class Employee{
// MUST have employeeID, name, department and the following as private fields
private:
    int employeeID;
    string name, department;
    Address empAddress;
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    void setEmployInfo()
    {
        cout<< "Enter employee id: ";
        cin>>employeeID;
        cout<<"Enter employee name: ";
        cin>>name;
        cout<<"Enter employee department: ";
        cin>>department;
        empAddress.setAddress();
    }
    void showInfo()
    {
        cout<< "Id: "<< employeeID<<endl;
        cout<<"Name: "<<name<<endl;
        cout<<"Department: "<<department<<endl;
        empAddress.showAddress();
    }
    int getZip()
    {
        return empAddress.getZipcode();
    }
};
int main(){
    Employee e1, e2;//(4161, “S K Dey”, “CSE”)
    //parameterized constructor also ask for address details
    cout << "Give input for employee 1: " << endl;
    e1.setEmployInfo();
    //cout << "Give input for employee 2: " << endl;
    //e2.setEmployInfo();
    //Should ask employeeID, name, department.
    //Then ask address related information.
    cout << "Complete information of the employees are: \n\n" ;
    //cout<< e1 << e2 << endl;
    cout<<"The employee e1:\n";
    e1.showInfo();
    //cout<<"The employee e2:\n";
    //e2.showInfo();
    if(e1.getZip() == 1229)
    {
        cout << "lives in Bashundhara R/A." << endl;
    }
    else
    {
        cout << "does NOT lives in Bashundhara R/A." << endl;
    }
    //comparing zipCode field
    return 0;
}
