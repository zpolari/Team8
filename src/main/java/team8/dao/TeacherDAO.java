package team8.dao;

import team8.model.Teacher;

import java.util.ArrayList;

public interface TeacherDAO {

    ArrayList<Teacher> findAll();

    String addTeacher(Teacher teacher);

    String delTeacher(String unionID);

    Teacher updateTeacher(Teacher teacher);


}
