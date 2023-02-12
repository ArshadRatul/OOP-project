/*
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
	//friend void operator>>(istream&, ComplexNo&);
	friend istream& operator>>(istream&, ComplexNo&);
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
//void operator>>(istream& in, ComplexNo& c){
istream& operator>>(istream& in, ComplexNo& c){
    cout<<"Enter real value: "; in>>c.real;
	cout<<"Enter imaginary value: "; in>>c.img;
	return in;
}

//void operator<<(ostream& out, ComplexNo c){
ostream& operator<<(ostream& out, ComplexNo c){
    out<<c.getReal()<<(c.getImg()>=0?"+":"")
        <<c.getImg()<<"i";//<<endl;
    return out;
}

int main(){
	ComplexNo c1, c2, c3, c4, c5, c6, c7;
	//cin>>c1;
	//cin>>c2;
	//cin>>c3;
	cin>>c1>>c2>>c3;
	c4 = c1 + c2 + c3;
	cout<<"c1="<<c1<<endl;
	cout<<"c2="<<c2<<endl;
	cout<<"c3="<<c3<<endl;
	cout<<"after c4=c1+c2, c4:"<<c4<<endl;
	c5=c4+10;   //increase real by 10
	cout<<"after c5=c4+10, c5:"<<c5<<endl;

	c6=2+c5;   //increase both real & img by 2
	cout<<"after c6=2+c5, c6:"<<c6<<endl;

	c7=1-c5;   //decrese both real & img by 1
	cout<<"after c7=1-c5, c7:"<<c7<<endl;

    return 0;
}
*/
//-------------------------
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

	//void operator++(){
	ComplexNo operator++(){
	    real++; img++;
	    return *this;
    }

	ComplexNo operator++(int x){
	    ComplexNo temp;
	    temp.real = real;
	    temp.img = img;
	    real++; img++;
	    return temp;
    }

	friend ComplexNo operator-(int, ComplexNo);
	//friend void operator>>(istream&, ComplexNo&);
	friend istream& operator>>(istream&, ComplexNo&);
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
//void operator>>(istream& in, ComplexNo& c){
istream& operator>>(istream& in, ComplexNo& c){
    cout<<"Enter real value: "; in>>c.real;
	cout<<"Enter imaginary value: "; in>>c.img;
	return in;
}

//void operator<<(ostream& out, ComplexNo c){
ostream& operator<<(ostream& out, ComplexNo c){
    out<<c.getReal()<<(c.getImg()>=0?"+":"")
        <<c.getImg()<<"i";//<<endl;
    return out;
}

int main(){
    //int i=10, j=10, k;
    //cout<<++i<<endl;                      //11
    //cout<<j++<<endl;                      //10
    //cout<<"i="<<i<<", j="<<j<<endl; //i=11, j=11

	ComplexNo c1,c2, c3, c4;
	cout<<"Enter real & img for c1: "<<endl;
	cin>>c1;
	cout<<"c1 = "<<c1<<endl;
	cout<<"Enter real & img for c2: "<<endl;
	cin>>c2;
	cout<<"c1 = "<<c1<<endl;
	cout<<"c2 = "<<c2<<endl;

	//++c1;
	c3 = ++c1;
	c4 = c2++;
	//cout<<"after ++C1, C1 = "<<c1<<endl;
	cout<<"after c3 = ++c1, c1 = "<<c1<<endl;
	cout<<"after c3 = ++c1, c3 = "<<c3<<endl;
	cout<<"after c4 = c2++, c2 = "<<c2<<endl;
	cout<<"after c4 = c2++, c4 = "<<c4<<endl;
	return 0;
}
