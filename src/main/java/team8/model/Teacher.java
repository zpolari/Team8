package team8.model;

public class Teacher {
    private String UnionID;
    private String Account;
    private String Password;
    private String Name;
    private String Age;
    private String Telephone;

    public Teacher() {
    }

    public Teacher(String unionID, String account, String password, String name, String age, String telephone) {
        UnionID = unionID;
        Account = account;
        Password = password;
        Name = name;
        Age = age;
        Telephone = telephone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "UnionID='" + UnionID + '\'' +
                ", Account='" + Account + '\'' +
                ", Password='" + Password + '\'' +
                ", Name='" + Name + '\'' +
                ", Age='" + Age + '\'' +
                ", Telephone='" + Telephone + '\'' +
                '}';
    }

    public String getUnionID() {
        return UnionID;
    }

    public void setUnionID(String unionID) {
        UnionID = unionID;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }
}



