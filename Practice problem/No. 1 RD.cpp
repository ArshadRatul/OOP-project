#include<iostream>
using namespace std;

class Address {
// MUST have houseNo, roadNo, street, thana, district, zipCode, etc. as private fields
private:
    int houseNo,roadNo,zipCode;
    string street, thana, district;
public:
    Address()
    {
        houseNo=0,roadNo=0,zipCode=0;
        street="N/A",thana="N/A",district="N/A";
    }
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    friend istream& operator>>(istream& in,Address& a);
    friend ostream& operator<<(ostream& out,Address& a);
    int get_zip(){return zipCode;}
};
class Employee{
// MUST have employeeID, name, department and the following as private fields
Address empAddress;
private:
    int employeeID;
    string name, department;
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    Employee()
    {
        employeeID=0;
        string name="N/A",department="N/A";
    }
    Employee(int a,string b,string c)
    {
        employeeID=a;
        name=b;
        department=c;
    }
    friend istream& operator>>(istream& in,Employee& e);
    friend ostream& operator<<(ostream& out,Employee& e);
    int get_zip(){return empAddress.get_zip();}
};
istream& operator>>(istream& in,Address& a)
{
    cout<<"\nEnter houseNo: ";
    in>>a.houseNo;
    cout<<"Enter roadNo: ";
    in>>a.roadNo;
    cout<<"Enter zipCode: ";
    in>>a.zipCode;
    cout<<"Enter street: ";
    in>>a.street;
    cout<<"Enter thana: ";
    in>>a.thana;
    cout<<"Enter district: ";
    in>>a.district;
    return in;
}
istream& operator>>(istream& in,Employee& e)
{
    cout<<"\nEnter employeeID: ";
    in>>e.employeeID;
    cout<<"Enter name: ";
    in>>e.name;
    cout<<"Enter department: ";
    in>>e.department;
    cin>>e.empAddress;
    return in;
}
ostream& operator<<(ostream& out,Address& a)
{
    cout<<"\nEnter houseNo: "<<a.houseNo;
    cout<<"\nRoadNo: "<<a.roadNo;
    cout<<"\nZipCode: "<<a.zipCode;
    cout<<"\nStreet: "<<a.street;
    cout<<"\nThana: "<<a.thana;
    cout<<"\nDistrict: "<<a.district;
    return out;
}
ostream& operator<<(ostream& out,Employee& e)
{
    cout<<"\nEmployee ID: "<<e.employeeID;
    cout<<"\nname: "<<e.name;
    cout<<"\ndepartment: "<<e.department;
    cout<<e.empAddress;
    return out;
}
int main(){
    Employee e1, e2(4161, "S K Dey", "CSE");
    //parameterized constructor also ask for address details
    cout << "Give input for employee 1: " << endl;
    cin >> e1;
    //Should ask employeeID, name, department.
    //Then ask address related information.
    cout << "Complete information of the employees are: " << endl;
    cout<< e1 << e2 << endl;
    cout<<"The employee e1 ";
    if(e1.get_zip() == 1229){ cout << "lives in Bashundhara R/A." << endl;}
    else {cout << "does NOT lives in Bashundhara R/A." << endl;}
    //comparing zipCode field
    return 0;
}
