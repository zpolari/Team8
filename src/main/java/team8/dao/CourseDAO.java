package team8.dao;

import java.util.ArrayList;


/**
 * 课程 数据库操作定义接口
 * 方法：查询全部课程、根据班级名称查询未安排课程
 * Author:zPolari
 * Time:2020-12-18
 */

public interface CourseDAO {

    ArrayList<String> findAll();

    ArrayList<String > findClassNoSelect(String c);



}
