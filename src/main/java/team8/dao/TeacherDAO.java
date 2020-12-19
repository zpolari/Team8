package team8.dao;

import team8.model.Teacher;

import java.util.ArrayList;


/**
 * 任课教师 数据库操作定义接口
 * 方法：查询全部任课教师、增加任课教师、删除任课教师、更新任课教师信息
 * Author:zPolari
 * Time:2020-12-18
 */

public interface TeacherDAO {

    ArrayList<Teacher> findAll();

    String addTeacher(Teacher teacher);

    boolean delTeacher(String unionID);

    String updateTeacher(Teacher teacher);


}
