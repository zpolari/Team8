package team8.model;

import team8.dao.impl.CourseImpl;

import java.util.ArrayList;

public class Course {

    private static ArrayList<String> arrayList = new CourseImpl().findAll();

    public static ArrayList<String> GetCourse() {
        ArrayList<String> tmp = new ArrayList<String>(arrayList);
        return tmp;
    }

    public static ArrayList<String> findClassNoSelect(String c) {
        return new CourseImpl().findClassNoSelect(c);
    }

    public static void OutCourse_TEST() {
        for (String s : arrayList
        ) {
            System.out.println(s);
        }
    }


}




