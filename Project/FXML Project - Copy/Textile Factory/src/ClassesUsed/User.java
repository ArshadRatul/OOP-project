
package ClassesUsed;

public class User {
    private String Name;
    private String Username;
    private String Password;
    protected String Email;
    protected String Category; 
    protected int Moblie;
    protected address Address;
    protected date DateOfBirth;

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
