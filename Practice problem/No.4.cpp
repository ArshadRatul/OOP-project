#include<iostream>
using namespace std;

class Author {
// fields: authorName (string), authorEmail(string),
private:
    string autorName, authorEmail;
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    friend istream& operator>>(istream& in, Author& a);
    friend ostream& operator<<(ostream& out, Author& a);
};

class Book {
// fields:
//bookName (string), authorList(Author*), noOfAuthors (int), price (float), isbn (string)
private:
    string bookName, isbn;
    int noOfAuthors;
    float price;
    Author* authourList= new Author[10];
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    friend istream& operator>>(istream& in, Book& b);
    friend ostream& operator<<(ostream& out, Book& b);
};

class Course {
// fields: courseId (string), courseTitle (string), noOfCredits (int), textBook (Book)
private:
    string courseId,courseTitle;
    int noOfCredits;
    Book textbook;
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    friend istream& operator>>(istream& in, Course& c);
    friend ostream& operator<<(ostream& out, Course& c);
    int getCredit(){return noOfCredits;}
};

istream& operator>>(istream& in, Author& a)
{
    cout<<"\nEnter author name: ";
    in>>a.autorName;
    cout<<"Enter author email: ";
    in>>a.authorEmail;
    return in;
}
istream& operator>>(istream& in, Book& b)
{
    cout<<"\nEnter book name: ";
    in>>b.bookName;
    cout<<"Enter isbn: ";
    in>>b.isbn;
    cout<<"Enter price: ";
    in>>b.price;
    cout<<"Enter no. of authors: ";
    in>>b.noOfAuthors;
    for(int i=0;i<b.noOfAuthors;i++)
    {
        cin>>b.authourList[i];
    }
    return in;
}
istream& operator>>(istream& in, Course& c)
{
    cout<< "\nEnter courseID: ";
    in>>c.courseId;
    cout<< "Enter course title: ";
    in>>c.courseTitle;
    cout<< "Enter course credit: ";
    in>>c.noOfCredits;
    cin>>c.textbook;
    return in;
}
ostream& operator<<(ostream& out, Author& a)
{
    cout<<"\nAuthor name: "<<a.autorName;
    cout<<"\nAuthor email: "<<a.authorEmail;
    return out;
}
ostream& operator<<(ostream& out, Book& b)
{
    cout<<"\nBook name: "<<b.bookName;
    cout<<"\nisbn: "<<b.isbn;
    cout<<"\nPrice: "<<b.price;
    cout<<"\nNo. of authors: "<<b.noOfAuthors;
    for(int i=0;i<b.noOfAuthors;i++)
    {
        cout<<b.authourList[i];
    }
    return out;
}
ostream& operator<<(ostream& out, Course& c)
{
    cout<< "\nCourseID: "<<c.courseId;
    cout<< "\nCourse title: "<<c.courseTitle;
    cout<< "\nCourse credit: "<<c.noOfCredits;
    cout<<c.textbook;
    return out;
}
void operator+=(int& a,Course c)
{
    a=a+c.getCredit();
}
//Complete the following global function
void allocateMemory (Course CArr[],int n)
{
    // complete the function
    for(int i=0;i<n;i++)
    {
        //take input for each course.
        cout<<"\nCourse "<<i+1<<":";
        cin>>CArr[i];
    }
}
int main(){
    int n, i;
    cout<<"How many courses? "; cin>>n;
    Course* courseArr = new Course[n];
    allocateMemory(courseArr, n); //it is a global function
    for(i=0;i<n;i++){cout<<"\n"<<courseArr[i];}//displaying values.
    //for(i=0;i<n;i++)courseArr[i].populateCourse().displayCourse();
    int totalCredits = 0;
    for(i=0;i<n;i++) totalCredits += courseArr[i];
    cout<<"\nTotal no of credits of these courses is: "<<totalCredits<<endl;
    return 0;
}
