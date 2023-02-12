#include<iostream>
using namespace std;
class student
{
private:
    string name;
    int id;
    float cg;
public:
    friend istream& operator>> (istream &in,  student &s);
    friend ostream& operator<< (ostream& out, student &s);
};

istream& operator>>(istream &in, student &s)
{
    cout<<"name: ";
    in>>s.name;
    cout<<"id: ";
    in>>s.id;
    cout<<"cg: ";
    in>>s.cg;
    return in;
}
ostream& operator<<(ostream& out, student &s)
{
    cout<<"\nname: ";
    out<<s.name;
    cout<<"\nid: ";
    out<<s.id;
    cout<<"\ncg: ";
    out<<s.cg;
    return out;
}
int main()
{
    student s1;
    cout<<"Enter Student info: \n";
    cin>>s1;
    cout<<s1;
    return 0;
}

