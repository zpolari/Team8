package team8.model;


/**
 * 教学秘书信息记录类
 * 属性：教学秘书UnionID、登录账户名、账户密码、名称、年龄、电话
 * Author:zPolari
 * Time:2020-12-19
 */

public class Secretary {
    private String UnionID;
    private String Account;
    private String Password;
    private String Name;
    private String     Age;
    private String Telephone;

    public Secretary() {
    }

    public Secretary(String unionID, String account, String password, String name, String age, String telephone) {
        UnionID = unionID;
        Account = account;
        Password = password;
        Name = name;
        Age = age;
        Telephone = telephone;
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
