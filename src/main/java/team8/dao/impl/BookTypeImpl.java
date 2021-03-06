package team8.dao.impl;

import team8.dao.BookTypeDAO;
import team8.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 教科书类型 数据库操作定义接口 实现
 * 方法：查询全部教科书类型、新增教科书类型、删除教科书类型、更新教科书类型
 * Author:zPolari
 * Time:2020-12-18
 */

public class BookTypeImpl implements BookTypeDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    @Override
    public ArrayList<String> findAll() {
        ArrayList<String> arrayList = new ArrayList<>();
        Connection connection = JDBCUtil.getConnection();

        try {
            String sql = "select BookType from BookType ";
            assert connection != null;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                arrayList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, connection);
        }
        return arrayList;
    }

    @Override
    public String add(String string) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "INSERT INTO BookType VALUES (?)";
        try {
            assert connection != null;
            ps = connection.prepareStatement(sql);
            ps.setString(1, string);
            ps.execute();

        } catch (Exception e) {
            return "新增失败 该教科书类型已存在";
        }
        return "新增成功 教科书类型为：" + string;
    }

    @Override
    public String del(String string) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "DELETE FROM BookType WHERE booktype=" + string;
        try {
            assert connection != null;
            ps = connection.prepareStatement(sql);
            ps.execute();

        } catch (Exception e) {
            return "删除失败，请确认无此类型教科书后尝试";
        }
        return "删除成功 教科书类型为：" + string;
    }

    @Override
    public String update(String old, String newT) {
        Connection connection = JDBCUtil.getConnection();

        try {
            ps = connection.prepareStatement("UPDATE BookType SET BookType =? WHERE BookType =?");
            ps.setString(1, newT);
            ps.setString(2, old);
            ps.execute();
        } catch (Exception e) {
            return "无法修改";
        }
        return "修改成功";
    }

}
