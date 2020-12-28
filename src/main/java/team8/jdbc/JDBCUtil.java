package team8.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 数据库连接获取和关闭
 * 方法：获取数据库连接、关闭（连接、结果集、准备器）
 * Author:zPolari
 * Time:2020-12-18
 */

public class JDBCUtil {
    static Connection conn = null;
//    static final String DB_URL = "jdbc:mysql://116.255.186.125:3306/test";
//    static final String USER = "db_ssg_MPM";
//    static final String PASS = "jHsx2LeRSYk4Zy6W";

    static final String DB_URL = "jdbc:mysql://192.168.16.100:3306/JCGL";
    static final String USER = "root";
    static final String PASS = "root";



    public static Connection getConnection() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            return conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void close(ResultSet rs, Statement stmt, Connection connection) {//栈式关闭（最先连接，最后关闭连接）
        try {//关闭结果集
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {//关闭sql语句
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {//关闭连接
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
