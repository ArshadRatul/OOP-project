
package ClassesUsed;

public class User implements serializable{
    private String Name;
    private String Username;
    private String Password;
    protected String Email;
    protected String Category; 
    protected int Mobile;
    protected date DOB;

    public User(String Name, String Username, String Password, String Email, String Category, int Mobile, date DOB) {
        this.Name = Name;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Category = Category;
        this.Mobile = Mobile;
        this.DOB = DOB;
    }
   
    
    public String getEmail() {
        return Email;
    }

    public String getCategory() {
        return Category;
    }

    public int getMobile() {
        return Mobile;
    }
    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
