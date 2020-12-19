package team8.dao.impl;

import com.mysql.jdbc.MysqlDataTruncation;
import team8.dao.TeacherDAO;
import team8.jdbc.JDBCUtil;
import team8.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class TeacherImpl implements TeacherDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public ArrayList<Teacher> findAll() {
        Connection connection= JDBCUtil.getConnection();
        ArrayList<Teacher> arrayList=new ArrayList<Teacher>();

        try {
            ps=connection.prepareStatement("SELECT UnionID,Account,Password,Name,Age,Telephone FROM Teacher");
            rs=ps.executeQuery();
            while (rs.next()){
                arrayList.add(new Teacher(rs.getString("UnionID"),rs.getString("Account"),rs.getString("Password"),rs.getString("Name"),rs.getString("Age"),rs.getString("Telephone")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return arrayList;



    }



    public String addTeacher(Teacher teacher) {

        return new LoginImpl().teacherSingUp(teacher);

    }

    public boolean delTeacher(String unionID) {

        Connection connection=JDBCUtil.getConnection();

        try{
            ps=connection.prepareStatement("DELETE FROM Teacher WHERE UnionID=?");
            ps.setString(1,unionID);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
            return  true;
        }finally {
            JDBCUtil.close(rs,ps,connection);
        }

        return false;


    }

    public String updateTeacher(Teacher teacher) {

        Connection connection=JDBCUtil.getConnection();

        try{
            ps=connection.prepareStatement("UPDATE Teacher SET Account=? ,Password=? ,Name=?,Age=?,Telephone=? WHERE UnionID=?");
            ps.setString(1,teacher.getAccount());
            ps.setString(2,teacher.getPassword());
            ps.setString(3,teacher.getName());
            ps.setString(4,teacher.getAge());
            ps.setString(5,teacher.getTelephone());
            ps.setString(6,teacher.getUnionID());
            ps.execute();
            return  "保存成功";

        }catch (MysqlDataTruncation e){
            e.printStackTrace();
            return "请规范输入";

        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            return "账户名已被使用，请换一个";
        }catch (Exception e){
            e.printStackTrace();
            return "出现异常，请重试";
        }finally {
            JDBCUtil.close(rs,ps,connection);
        }


    }



}
