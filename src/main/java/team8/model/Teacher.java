package team8.model;

/**
 * 任课教师信息记录类
 * 属性：教师UnionID、登录账户名、账户密码、名称、年龄、电话
 * Author:zPolari
 * Time:2020-12-19
 */

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
        return "教师信息  {" +
                "\n唯一ID  =  " + UnionID +
                " \n账户名  =  " + Account +
                " \n登录密码  =  " + Password +
                " \n姓名  =  " + Name +
                " \n年龄  =  " + Age +
                " \n电话  =  " + Telephone +
                "\n}";
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



