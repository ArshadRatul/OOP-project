/*
#include<iostream>
using namespace std;

int main(){
    int id; string name, address; float cgpa;
    cin>>id;
    cin.ignore();
    getline(cin,name);
    getline(cin.address);
    cin>>cgpa;
    cout<<"Id="<<id<<", name="<<name<<", cgpa="<<cgpa<<endl;
	return 0;
}
*/
//------------------------------------------------------------------
#include<iostream>
using namespace std;

class ComplexNo{
	int real,img;
	public:
	void setComplexNo(){
		cout<<"Enter real value: "; cin>>real;
		cout<<"Enter imaginary value: "; cin>>img;
	}
	void showComplexNo(){
		cout<<real<<(img>=0?"+":"")<<img<<"i"<<endl;
	}
    int getReal(){return real;}
    int getImg(){return img;}
    void setReal(int val){real = val;}
    void setImg(int img){this->img = img;}
	 ComplexNo add(ComplexNo c){
		ComplexNo temp;
		temp.real = real + c.real;
		temp.img = img + c.img;
		return temp;
	}
	ComplexNo operator+(ComplexNo c){
		ComplexNo temp;
		temp.real = real + c.real;
		temp.img = img + c.img;
		return temp;
	}
	ComplexNo operator+(int val){
		ComplexNo temp;
		temp.real = real + val;
		temp.img = img;
		return temp;
	}
	friend ComplexNo operator-(int, ComplexNo);
};

ComplexNo operator+(int val, ComplexNo c){
	ComplexNo temp;
	temp.setReal( c.getReal() + val );
	temp.setImg( c.getImg() + val );
	return temp;
}
ComplexNo operator-(int val, ComplexNo c){
		ComplexNo temp;
		temp.real = c.real - val;
		temp.img = c.img - val;
		return temp;
}
int main(){
	ComplexNo c1, c2, c3, c4, c5, c6, c7;
	c1.setComplexNo(); 	c2.setComplexNo(); 	c3.setComplexNo();
	//c4 = c1.add(c2);		//c1+c2;
	c4 = c1 + c2 + c3;
	cout<<"c1="; c1.showComplexNo();
	cout<<"c2="; c2.showComplexNo();
	cout<<"c3"; c3.showComplexNo();
	cout<<"after c4=c1+c2, c4:"; c4.showComplexNo();
	c5=c4+10;   //increase real by 10
	cout<<"after c5=c4+10, c5:"; c5.showComplexNo();

	c6=2+c5;   //increase both real & img by 2
	cout<<"after c6=2+c5, c6:"; c6.showComplexNo();

	c7=1-c5;   //decrese both real & img by 1
	cout<<"after c7=1-c5, c7:"; c7.showComplexNo();

    return 0;
}

