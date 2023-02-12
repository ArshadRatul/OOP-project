#include<iostream>
using namespace std;
class complexnumber
{
private:
    int real, img;
public:
    complexnumber()
    {
        real=0;
        img=0;
    }
    void input_val()
    {
        cout<<"enter real: ";
        cin>>real;
        cout<<"enter img: ";
        cin>>img;
    }
    complexnumber add_complex(complexnumber c)
    {
        complexnumber temp;
        temp.real=real+c.real;
        temp.img=img+c.img;
        return temp;
    }
    complexnumber operator+(complexnumber c)
    {
        complexnumber temp;
        temp.real=real+c.real;
        temp.img=img+c.img;
        return temp;
    }
    complexnumber operator-(complexnumber c)
    {
        complexnumber temp;
        temp.real=real-c.real;
        temp.img=img-c.img;
        return temp;
    }
    complexnumber operator*(complexnumber c)
    {
        complexnumber temp;
        temp.real=real*c.real;
        temp.img=img*c.img;
        return temp;
    }
    void show_complex()
    {
        cout<<real<<(img>=0?"+":"")<<img<<"i"<<endl;
    }
    friend ostream& operator<<(ostream& out,complexnumber& c);
    friend istream& operator>>(istream& in, complexnumber& c);
};
ostream& operator<<(ostream& out,complexnumber& c)
{
    cout<<c.real<<(c.img>=0?"+":"")<<c.img<<"i";
    return out;
}
istream& operator>>(istream& in, complexnumber& c)
{
    cout<<"\nEnter real: ";
    in>>c.real;
    cout<<"Enter img: ";
    in>>c.img;
    return in;
}

int main()
{
    complexnumber c1,c2,c3,c4,c5;
    c1.input_val();
    c2.input_val();
    cout<<"C1: ";
    c1.show_complex();
    cout<<"C2: ";
    c2.show_complex();
    c3=c2.add_complex(c1);  //c1+c2
    cout<<"C3: ";
    c3.show_complex();
    c4=c3-c1;
    cout<<"C4: ";
    c4.show_complex();
    cout<<c4;
    cin>>c5;
    cout<<c5;
    return 0;
}
