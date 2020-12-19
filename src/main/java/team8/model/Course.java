package team8.model;

import team8.dao.impl.CourseImpl;

import java.util.ArrayList;



/**
 * 课程信息类
 * 属性：无
 * Author:zPolari
 * Time:2020-12-19
 */

public class Course {

    private static ArrayList<String> arrayList = new CourseImpl().findAll();

    public static ArrayList<String> GetCourse() {
        ArrayList<String> tmp = new ArrayList<String>(arrayList);
        return tmp;
    }


    /**
     * 方法名：查找班级未选课程
     * 返回值：课程信息数组
     * 使用差集查询出参数 班级 未选课程 方便教学秘书进行任课安排
     * Author:zPolari
     * Time:2020-12-19
     */
    public static ArrayList<String> findClassNoSelect(String c) {
        return new CourseImpl().findClassNoSelect(c);
    }

    /**
     * 测试使用
     */
    public static void OutCourse_TEST() {
        for (String s : arrayList
        ) {
            System.out.println(s);
        }
    }


}




