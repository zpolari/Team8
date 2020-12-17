package team8.dao.impl;

import team8.dao.ClassDAO;
import team8.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClassImpl implements ClassDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    @Override
    public ArrayList<String> findAll() {
        ArrayList<String>arrayList=new ArrayList<>();
        Connection connection= JDBCUtil.getConnection();

        try{
            ps=connection.prepareStatement("SELECT * FROM Class");
            rs=ps.executeQuery();
            while (rs.next()){
                arrayList.add(rs.getString(1));

            }
        }catch (Exception e){

            e.printStackTrace();

        }finally {
            JDBCUtil.close(rs,ps,connection);
        }

        return arrayList;



    }
}
