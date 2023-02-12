#include<iostream>
using namespace std;

class Address {
// MUST have houseNo, roadNo, street, thana, district, zipCode, etc. as private fields
private:
    int houseNo, road,zipCode;
    string street, thana, district;
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    friend istream& operator>>(istream& in, Address& a);
    friend ostream& operator<<(ostream& out, Address& a);
    int getZip(){return zipCode;};

};
class Employee{
    // MUST have employeeID, name, department and the following as private fields
    int employeeID;
    string name, department;
    Address empAddress;
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    friend istream& operator>>(istream& in, Employee& e);
    friend ostream& operator<<(ostream& out, Employee& e);
    int getZip(){return empAddress.getZip();}
};
istream& operator>>(istream& in, Address& a)
{
    cout<<"Enter houseNo: ";
    in>>a.houseNo;
    cout<<"Enter roadNo: ";
    in>>a.road;
    cout<<"Enter zipcode: ";
    in>>a.zipCode;
    cout<<"Enter street: ";
    in>>a.street;
    cout<<"Enter thana: ";
    in>>a.thana;
    cout<<"Enter district: ";
    in>>a.district;
    return in;
}
istream& operator>>(istream& in, Employee& e)
{
    cout<<"\nEnter Id: ";
    in>>e.employeeID;
    cout<<"Enter name: ";
    in>>e.name;
    cout<<"Enter department: ";
    in>>e.department;
    cin>>e.empAddress;
    return in;
}
ostream& operator<<(ostream& out, Address& a)
{
    cout<<"HouseNo: "<<a.houseNo;
    cout<<"\nRoadNo: "<<a.road;
    cout<<"\nZipcode: "<<a.zipCode;
    cout<<"\nStreet: "<<a.street;
    cout<<"\nThana: "<<a.thana;
    cout<<"\nDistrict: "<<a.district;
    return out;
}
ostream& operator<<(ostream& out, Employee& e)
{
    cout<<"\nName: ";
    out<< e.name<<"\n";
    cout<<"ID: ";
    out<< e.employeeID<<"\n";
    cout<<"Department: ";
    out<< e.department<<"\n";
    cout<<e.empAddress<<endl;
    return out;
}
int main(){
    Employee e1, e2;//(4161, “S K Dey”, “CSE”)
    //parameterized constructor also ask for address details
    cout << "Give input for employee 1 & 2: \n" ;
    cin >> e1>>e2;

    //Should ask employeeID, name, department.
    //Then ask address related information.
    cout << "Complete information of the employees are: " << endl;
    cout<<e1<<e2<<endl;
    cout<<"The employee e1 ";
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
