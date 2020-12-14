package team8.dao;

import team8.model.Secretary;
import team8.model.Teacher;

public interface LoginDao {

    Secretary secretaryLogin(String account,String password);

    Teacher teacherLogin(String account, String password);

    String  secretarySingUp(Secretary secretary);

    String teacherSingUp(Teacher teacher);


}
