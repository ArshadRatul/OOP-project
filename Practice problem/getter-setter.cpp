#include<iostream>
using namespace std;
class student
{
private:
    int roll,cg;
    string name;
public:
    student()
    {
        roll=0;
        cg=0;
        name="N/A";
    }
    int getRoll(){return roll;}
    void setRoll(int x){roll=x;}
};
int main()
{
    int x;
    student refat;
    cout<<refat.getRoll();
    cout<<"\nEnter x: ";
    cin>>x;
    refat.setRoll(x);
    cout<<refat.getRoll();
    return 0;
}

