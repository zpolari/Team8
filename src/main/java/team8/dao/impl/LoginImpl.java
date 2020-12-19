package team8.dao.impl;

import team8.dao.LoginDao;
import team8.jdbc.JDBCUtil;
import team8.model.Secretary;
import team8.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 登录注册 数据库操作定义接口 实现
 * 方法：教学秘书登录、教师登录、教学秘书注册、教师注册
 * Author:zPolari
 * Time:2020-12-18
 */


public class LoginImpl implements LoginDao {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    @Override
    public Secretary secretaryLogin(String account, String password) {
        Connection connection = JDBCUtil.getConnection();
        Secretary secretary = new Secretary();

        try {
            ps = connection.prepareStatement("SELECT * FROM Secretary WHERE Account=? LIMIT 1");
            ps.setString(1, account);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("123");
                if (rs.getString("password").equals(password)) {
                    secretary.setUnionID(rs.getString("unionid"));
                    secretary.setAccount(rs.getString("account"));
                    secretary.setPassword(rs.getString("password"));
                    secretary.setName(rs.getString("name"));
                    secretary.setAge(rs.getString("age"));
                    secretary.setTelephone(rs.getString("telephone"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, connection);
        }

        if (secretary.getAccount() != null) {
            return secretary;
        } else {
            return null;
        }

    }

    @Override
    public Teacher teacherLogin(String account, String password) {
        Connection connection = JDBCUtil.getConnection();
        Teacher teacher = new Teacher();

        try {
            ps = connection.prepareStatement("SELECT * FROM Teacher WHERE Account=? LIMIT 1");
            ps.setString(1, account);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    teacher.setName(rs.getString("name"));
                    teacher.setAge(rs.getString("age"));
                    teacher.setTelephone(rs.getString("telephone"));
                    teacher.setUnionID(rs.getString("unionid"));
                    teacher.setAccount(rs.getString("account"));
                    teacher.setPassword(rs.getString("password"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, connection);
        }

        if (teacher.getAccount() != null) {
            return teacher;
        } else {
            return null;
        }

    }

    @Override
    public String secretarySingUp(Secretary secretary) {
        Connection connection = JDBCUtil.getConnection();

        try {
            ps = connection.prepareStatement("SELECT UnionID FROM Secretary WHERE Account=? LIMIT 1");
            ps.setString(1, secretary.getAccount());
            rs = ps.executeQuery();
            System.out.println(rs);

            while (rs.next()) {
                return "此登录名已存在";
            }

            ps = connection.prepareStatement("INSERT INTO Secretary (UnionID, Account, Password, Name, Age, Telephone, LastLogin) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, secretary.getUnionID());
            ps.setString(2, secretary.getAccount());
            ps.setString(3, secretary.getPassword());
            ps.setString(4, secretary.getName());
            ps.setString(5, secretary.getAge());
            ps.setString(6, secretary.getTelephone());
            ps.setString(7, "1");
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return "请规范填写";
        } finally {
            JDBCUtil.close(rs, ps, connection);
        }

        return "新增成功";
    }

    @Override
    public String teacherSingUp(Teacher teacher) {
        Connection connection = JDBCUtil.getConnection();

        try {
            ps = connection.prepareStatement("SELECT UnionID FROM Teacher WHERE Account=? LIMIT 1");
            ps.setString(1, teacher.getAccount());
            rs = ps.executeQuery();
            System.out.println(rs);

            while (rs.next()) {
                return "此登录名已存在";
            }

            ps = connection.prepareStatement("INSERT INTO Teacher (UnionID, Account, Password, Name, Age, Telephone, LastLogin) VALUES (?,?,?,?,?,?,?)");
            ps.setString(4, teacher.getName());
            ps.setString(5, teacher.getAge());
            ps.setString(6, teacher.getTelephone());
            ps.setString(1, teacher.getUnionID());
            ps.setString(2, teacher.getAccount());
            ps.setString(3, teacher.getPassword());
            ps.setString(7, "1");

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return "请规范填写";
        } finally {
            JDBCUtil.close(rs, ps, connection);
        }

        return "新增成功";
    }
}




