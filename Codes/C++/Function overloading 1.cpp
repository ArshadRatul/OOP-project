#include<iostream>
using namespace std;
class student
{
private:
    string name;
    int id;
    float cg;
public:
    void set_cg(int x)
    {
        cg=x;
    }
    void add_cg(int x)
    {
        cg=cg+x;
    }
    void add_cg()
    {
        cg++;
    }
    void add_cg(double x)
    {
        cg=cg+x;
    }
    void add_cg(double x,int y)
    {
        cg=cg+x;
        cg=cg-y;
    }
    void show_cg()
    {
        cout<<"\nCG: "<<cg;
    }

};

int main()
{
    student refat;
    refat.set_cg(0);
    refat.show_cg();
    refat.add_cg(2.2);
    refat.show_cg();
    refat.add_cg();
    refat.show_cg();
    refat.add_cg(2.2,1);
    refat.show_cg();

    return 0;
}
