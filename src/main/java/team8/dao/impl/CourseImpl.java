package team8.dao.impl;

import team8.dao.CourseDAO;
import team8.jdbc.JDBCUtil;
import team8.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 课程 数据库操作定义接口 实现
 * 方法：查询全部课程、根据班级名称查询未安排课程
 * Author:zPolari
 * Time:2020-12-18
 */

public class CourseImpl implements CourseDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    @Override
    public ArrayList<String> findAll() {
        ArrayList<String> arrayList = new ArrayList<>();
        Connection connection = JDBCUtil.getConnection();

        try {
            ps = connection.prepareStatement("SELECT * FROM Course");
            rs = ps.executeQuery();
            while (rs.next()) {
                arrayList.add(rs.getString(1));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, connection);
        }
        return arrayList;

    }

    @Override
    public ArrayList<String> findClassNoSelect(String c) {
        ArrayList<String> selected = new ArrayList<>();
        ArrayList<String> all = Course.GetCourse();
        System.out.println(all);

        Connection connection = JDBCUtil.getConnection();

        try {
            ps = connection.prepareStatement("SELECT CourseName FROM CTC WHERE ClassName=?");
            ps.setString(1, c);
            rs = ps.executeQuery();
            while (rs.next()) {
                selected.add(rs.getString(1));

            }
        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            JDBCUtil.close(rs, ps, connection);
        }

        for (String s : selected
        ) {
            all.remove(s);
        }


        return all;
    }
}
