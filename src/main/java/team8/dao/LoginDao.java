package team8.dao;

import team8.model.Secretary;
import team8.model.Teacher;


/**
 * 登录注册 数据库操作定义接口
 * 方法：教学秘书登录、教师登录、教学秘书注册、教师注册
 * Author:zPolari
 * Time:2020-12-18
 */

public interface LoginDao {

    Secretary secretaryLogin(String account,String password);

    Teacher teacherLogin(String account, String password);

    String secretarySignUp(Secretary secretary);

    String teacherSignUp(Teacher teacher);


}
