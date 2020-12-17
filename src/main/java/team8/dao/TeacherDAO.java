package team8.dao;

import team8.model.Teacher;

import java.util.ArrayList;

public interface TeacherDAO {

    ArrayList<Teacher> findAll();

    String addTeacher(Teacher teacher);

    boolean delTeacher(String unionID);

    String updateTeacher(Teacher teacher);


}
