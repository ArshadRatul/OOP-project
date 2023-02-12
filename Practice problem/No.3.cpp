#include<iostream>
using namespace std;

class Author {
// MUST have ID (int), name (string) and email (string) as private fields.
private:
    int ID;
    string name, email;
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    string getName(){return name;}
    friend istream& operator>>(istream& in, Author& a);
    friend ostream& operator<<(ostream& out, Author& a);
};
class Book {
// MUST have title (string), ISBN_No (string), price (float) and the following as private fields.
private:

    float price;
    string title, ISBN_No;
    int noOfAuthor;
    Author* ptr=new Author[10];
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
    Book()
    {
        price=0;
        title="N/A";
        ISBN_No="N/A";
        noOfAuthor=0;
    }
    Book(string a,string b,float c)
    {
        price=c;
        title=a;
        ISBN_No=b;
        noOfAuthor=0;
    }
    friend istream& operator>>(istream& in, Book& b);
    friend ostream& operator<<(ostream& out, Book& b);
    string getTitle(){return title;}
    float getPrice(){return price;}
    bool matchAuthor(string a)
    {
        for(int i=0;i<noOfAuthor;i++)
        {
            if(ptr[i].getName()==a){return true;}
        }
        return false;
    }
};
istream& operator>>(istream& in, Author& a)
{
    in>>a.name;
    cout<<"Enter id: ";
    in>>a.ID;
    cout<<"Enter email: ";
    in>>a.email;
}
istream& operator>>(istream& in, Book& b)
{
    cout<<"\nEnter Title: ";
    in>>b.title;
    cout<<"Enter ISBN_No: ";
    in>>b.ISBN_No;
    cout<<"Enter price: ";
    in>>b.price;
    cout<<"Enter no. of authors: ";
    in>>b.noOfAuthor;
    for(int i=0;i<b.noOfAuthor;i++)
    {
        cout<<"/nEnter name "<<i+1<<": ";
        cin>>b.ptr[i];
    }
    return in;
}
ostream& operator<<(ostream& out, Author& a)
{
    cout<<"\nName: "<<a.name;
    cout<<"\nid: "<<a.ID;
    cout<<"\nEmail: "<<a.email;
}
ostream& operator<<(ostream& out, Book& b)
{
    cout<<"\n\nTitle: "<<b.title;
    cout<<"\nISBN_No: "<<b.ISBN_No;
    cout<<"\nPrice: "<<b.price;
    cout<<"\nNo. of authors: "<<b.noOfAuthor;
    for(int i=0;i<b.noOfAuthor;i++)
    {
        cout<<b.ptr[i];
    }
    return out;
}
int main()
{
    Book b1, b2("Data Structures", "978-0-7334-2609-4", 550);
    //parameterized constructor also ask for no of authors and their details
    cout << "Give input for book 1: " << endl;
    cin >> b1;
    //Should ask title, ISBN_No, price.
    //Then ask #ofAuthors & author info (id, name and email) for all authors.
    cout << "Complete information of the books are: " << endl;
    cout<< b1 << b2 << endl;
    cout<<"For The book titled: "<< b1.getTitle() <<endl;
    if(b1.getPrice() <= 1000 || b1.matchAuthor("Ataul Karim") == true)
    {
        cout<<"Ataul Karim is an author, or the price is <= 1000"<<endl;
    }
    else
    {
        cout<<"Ataul Karim is NOT an author & price is > 1000"<<endl;
    }
    return 0;
}
