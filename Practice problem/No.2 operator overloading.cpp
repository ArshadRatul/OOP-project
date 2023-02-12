#include<iostream>
using namespace std;
class Date {
// MUST have day (int), month (string), year (int) as private fields.
private:
    int day,year;
    string month;
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    friend istream& operator>>(istream& in, Date& d);
    friend ostream& operator<<(ostream& in, Date& d);
    int getYear(){return year;}
    string getMonth(){return month;}
};
class Employee{
// MUST have employeeID, name, department and the following as private fields.
private:
    int employeeID;
    string department,name;
    Date dateOfJoining;
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    friend istream& operator>>(istream& in, Employee& e);
    friend ostream& operator<<(ostream& in, Employee& e);
    string getName(){return name;}
    int getYear(){return dateOfJoining.getYear();}
    string getMonth(){return dateOfJoining.getMonth();}
};
istream& operator>>(istream& in, Date& d)
{
    cout<<"Enter day: ";
    in>>d.day;
    cout<<"Enter month: ";
    in>>d.month;
    cout<<"Enter year: ";
    in>>d.year;
    return in;
}
istream& operator>>(istream& in, Employee& e)
{
    cout<<"Enter employee ID: ";
    in>>e.employeeID;
    cout<<"Enter name: ";
    in>>e.name;
    cout<<"Enter department: ";
    in>>e.department;
    cin>>e.dateOfJoining;
    return in;
}
ostream& operator<<(ostream& out, Date& d)
{
    cout<<"\nDate of joining: "<<d.day<<" "<<d.month<<" "<<d.year;
    return out;
}
ostream& operator<<(ostream& out, Employee& e)
{
    cout<<"\nEmployee ID: "<<e.employeeID;
    cout<<"\nname: "<<e.name;
    cout<<"\nDepartment: "<<e.department;
    cout<<e.dateOfJoining;
    return out;
}
int main()
{
    Employee e1, e2;//(4161, “S K Dey”, “CSE”);
    cout << "Give input for employee 1: " << endl;
    cin >> e1>>e2;
    //Should ask employeeID, name, department.
    //Then ask for date of joining related information.
    cout << "Complete information of the employees are: " << endl;
    cout<< e1 << e2 << endl;
    cout<<"Mr./Ms. "<< e1.getName();
    if(e1.getYear() == 2017 && e1.getMonth() == "October")
    cout<<" joined the company in October 2017." << endl;
    else
    cout<<" did NOT join the company in October 2017." << endl;
    return 0;
}
