package team8.dao.impl;

import team8.dao.BookTypeDAO;
import team8.jdbc.JDBCUtil;
import team8.model.BookType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookTypeImpl implements BookTypeDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public BookType findAll() {
        BookType bookType = new BookType();
        Connection connection = JDBCUtil.getConnection();

        try {
            String sql = "select BookType from BookType ";
            assert connection != null;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bookType.addBookType(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, connection);
        }
        return bookType;
    }

    public String add(String string) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "INSERT INTO BookType VALUES (?)";
        try {
            assert connection != null;
            ps = connection.prepareStatement(sql);
            ps.setString(1, string);
            ps.execute();

        } catch (Exception e) {

            System.out.println("新增失败 该教科书类型已存在");
            return "新增失败 该教科书类型已存在";
        }
        System.out.println("新增成功 教科书类型为：" + string);
        return "新增成功 教科书类型为：" + string;
    }


    public String del(String string) {
        Connection connection = JDBCUtil.getConnection();


        String sql = "DELETE FROM BookType WHERE booktype=" + string;
        try {
            assert connection != null;
            ps = connection.prepareStatement(sql);
            ps.execute();

        } catch (Exception e) {

            System.out.println("删除失败，请确认无此类型教科书后尝试");
            return "删除失败，请确认无此类型教科书后尝试";
        }
        System.out.println("删除成功 教科书类型为：" + string);
        return "删除成功 教科书类型为：" + string;
    }

}
