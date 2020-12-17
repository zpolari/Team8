package team8.dao;

import java.util.ArrayList;

public interface CourseDAO {

    ArrayList<String> findAll();

    ArrayList<String > findClassNoSelect(String c);



}
