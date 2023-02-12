#include<iostream>
using namespace std;
class ComplexNo
{
private:
    int real, img;
public:
    void insert_value()
    {
        cout <<"Enter real: ";cin>>real;
        cout<<"Enter  imaginary: ";cin>>img;
    }
    void print()
    {
        cout<<real<<(img>=0?"+":"")<<img<<"i"<<endl;
	}
	ComplexNo add_complex(ComplexNo c2)
	{
	    ComplexNo temp;
	    temp.real=real+c2.real;
	    temp.img=img+c2.img;
	    return temp;
	}

};
int main()
{
    ComplexNo c1,c2,c3;
    c1.insert_value();
    c2.insert_value();
    cout<<"C1= ";c1.print();
    cout<<"C2= ";c2.print();
    c3=c1.add_complex(c2);//c1+c2
    cout<<"C3= ";c3.print();
    return 0;
}
