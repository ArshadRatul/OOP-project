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

};

int main(){
	ComplexNo c1, c2, c3, c4, c5, c6;
	c1.setComplexNo(); 	c2.setComplexNo(); 	c3.setComplexNo();
	c4 = c1.add(c2);		//c1+c2;
	c5 = c4 + c3;			//c5 = c4.operaotr+(c3);
	cout<<"Complex no c1 = "; c1.showComplexNo();
	cout<<"Complex no c2 = "; c2.showComplexNo();
	cout<<"Complex no c3 = "; c3.showComplexNo();
	cout<<"Complex no c4 (c1+c2) = "; c4.showComplexNo();
	cout<<"Complex no c5 (c4+c3) = "; c5.showComplexNo();

	c6 = c1.add(c2).add(c3);    //method chaining
	//c6 = c1 + c2 + c3;
}
*/
//--------------------------
#include<iostream>
using namespace std;

class Person{
    int tipsEarned=0;
    public:
	//void buyFoodFromMarket(){
	Person& buyFoodFromMarket(){
		cout<<"Food is bought."<<endl;
		//we need to return the client object itself
		tipsEarned += 50;
		return *this;
	}
	Person& organizeLivingRoom(){
		cout<<"Living room is organized."<<endl;
		tipsEarned += 50;
		return *this;
	}

	//void serveFood(){
    Person& serveFood(){
		cout<<"Food is served."<<endl;
		tipsEarned += 50;
		return *this;
	}

    void showTipsAmount(){
        cout<<"Total tips earned = "<<tipsEarned<<" taka"<<endl;
    }
};

int main(){
	Person babu, selim;
	//babu.buyFoodFromMarket();
	//babu.organizeLivingRoom();
	//babu.serveFood();

	babu.buyFoodFromMarket().organizeLivingRoom().serveFood();
    babu.showTipsAmount();

	return 0;
}
//==================
/*
#include<iostream>
using namespace std;

struct Employee{
	int empId; string empName; float salary;
};

int main(){
	Employee farid; //int x; cin>>x;
	cout<<"Enter employee ID: "; cin>>farid.empId; cin.ignore();
	cout<<"Enter employee Name: "; getline(cin, farid.empName);
	cout<<"Enter employee Salary: "; cin>>farid.salary;
	cout<<"Id="<<farid.empId<<", Name="<<farid.empName<<", Salary="<<farid.salary<<endl;
	return 0;
}
*/
//-------------------------------------------------------------------
/*
#include<iostream>
using namespace std;

class Student{
    public:
	int studId; string studName; float cgpa;
};

int main(){
	Student asif, luna;
	cout<<"Enter student ID: "; cin>>asif.studId; cin.ignore();
	cout<<"Enter student Name: "; getline(cin, asif.studName);
	cout<<"Enter cgpa: "; cin>>asif.cgpa;
	cout<<"Id="<<asif.studId<<", Name="<<asif.studName<<", Cgpa="<<asif.cgpa<<endl;
	return 0;
}
*/
//------------------------------------------------------------------
/*
#include<iostream>
using namespace std;
struct Employee{
	int empId; string empName; float salary; //member data, a.k.a field

	void setEmpInfo(){	//member function, a.k.a method
		cout<<"Enter employee ID: "; cin>>empId; cin.ignore();
		cout<<"Enter employee Name: "; getline(cin, empName);
		cout<<"Enter employee Salary: "; cin>>salary;
	}
	void showEmpInfo(){
        cout<<"Id="<<empId<<", Name="<<empName<<", Salary="<<salary<<endl;
	}
	float getSalary(){ return salary;}
};

int main(){
	Employee farid, luna;
	farid.setEmpInfo();	//luna.setEmpInfo();
    farid.showEmpInfo();
    float sal = farid.getSalary();
	return 0;
}
*/
//------------------------------------------------------------------
/*
#include<iostream>
using namespace std;

class Student{
	int studId; string studName; float cgpa;
    public:
	void setStudInfo(){
		cout<<"Enter student ID: "; cin>>studId; cin.ignore();
		cout<<"Enter student Name: "; getline(cin, studName);
		cout<<"Enter cgpa: "; cin>>cgpa;
	}
	void showStudInfo(){class ComplexNo{
	int real,img;
	public:
	void setComplexNo(){
		cout<<"Enter real value: "; cin>>real;
		cout<<"Enter imaginary value: "; cin>>img;
	}
	void showComplexNo(){
		cout<<real;
		if(img>=0) cout<<"+";
		cout<<img<<"i"<<endl;

		cout<<real<<(img>=0?"+":"")<<img<<"i"<<endl;
	}

	 ComplexNo add(ComplexNo c){
		ComplexNo temp;
		temp.real = real + c.real;
		temp.img = img + c.img;
		return temp;
	}

};

int main(){
	ComplexNo c1, c2, c3, c4;
	c1.setComplexNo(); 	c2.setComplexNo(); 	c3.setComplexNo();
	c4 = c1.add(c2);		//c1+c2;


}
        	cout<<"Id="<<studId<<", Name="<<studName<<", Cgpa="<<cgpa<<endl;
	}
	void submitAssignment(){
        conductSurvey();
	}
	private:
    void conductSurvey(){
        //....
    }
};

int main(){
	Student asif, luna;
	//cout<<"Enter student ID: "; cin>>asif.studId; cin.ignore();
	//cout<<"Enter student Name: "; getline(cin, asif.studName);
	//cout<<"Enter cgpa: "; cin>>asif.cgpa;
	//cout<<"Id="<<asif.studId<<", Name="<<asif.studName<<", Cgpa="<<asif.cgpa<<endl;
	asif.setStudInfo();
	asif.showStudInfo();
	asif.submitAssignment();
	return 0;
}
*/
//-----------------------------------------------
/*
#include<iostream>
using namespace std;
int main(){
    int x = 35, y;
    y = x<<2;
    cout<<y;	//140
	return 0;
}
*/
//---------------------------------------------------
