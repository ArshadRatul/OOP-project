
package finalpackage;

public class Complex {
    int real, img;
    
    //add constructor and other necessary methods for input, output

    public Complex(int real, int img) {
        this.real = real;
        this.img = img;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
    String getComplex()
    {
        String complexno;
        complexno= Integer.toString(real)+(img>=0?"+":"")+Integer.toString(img);
        return complexno;
    }
    
    
}
