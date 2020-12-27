package team8.dao.impl;

import team8.dao.CTCDAO;
import team8.jdbc.JDBCUtil;
import team8.model.CTC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * 任课安排 数据库操作定义接口 实现
 * 方法：根据教师UnionID查询该教师任课安排、新增任课安排、删除任课安排、更新任课安排
 * Author:zPolari
 * Time:2020-12-18
 */

public class CTCImpl implements CTCDAO {


    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    @Override
    public ArrayList<CTC> findByUnion(String Union) {
        ArrayList<CTC> arrayList = new ArrayList<>();
        Connection connection = JDBCUtil.getConnection();

        try {
            if (Union.equals("all")) {
                ps = connection.prepareStatement("SELECT CTC.ClassName,CTC.CourseName,CTC.UnionID,Teacher.`Name`,TechBook.ISBN,TechBook.Bname\n" +
                        "FROM CTC LEFT JOIN TechBook ON(CTC.ISBN=TechBook.ISBN) LEFT JOIN Teacher ON(CTC.UnionID=Teacher.UnionID)");
            } else {
                ps = connection.prepareStatement("SELECT CTC.ClassName,CTC.CourseName,CTC.UnionID,Teacher.`Name`,TechBook.ISBN,TechBook.Bname\n" +
                        "FROM CTC LEFT JOIN TechBook ON(CTC.ISBN=TechBook.ISBN) LEFT JOIN Teacher ON(CTC.UnionID=Teacher.UnionID) WHERE CTC.UnionID=?");
                ps.setString(1, Union);
            }
            rs = ps.executeQuery();

            while (rs.next()) {
                arrayList.add(new CTC(rs.getString("ClassName"), rs.getString("CourseName"), rs.getString("UnionID"), rs.getString("Name"), rs.getString("ISBN"), rs.getString("Bname")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrayList;

    }

    @Override
    public String addCTC(CTC ctc) {

        Connection connection = JDBCUtil.getConnection();

        try {
            ps = connection.prepareStatement("INSERT INTO CTC (UnionID, ClassName, CourseName) VALUES (?,?,?)");
            ps.setString(1, ctc.getUnionID());
            ps.setString(2, ctc.getClassName());
            ps.setString(3, ctc.getCourseName());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return "新增任课安排失败";
        }
        return "新增任课安排成功";

    }

    @Override
    public boolean delCTC(CTC ctc) {
        Connection connection = JDBCUtil.getConnection();

        try {
            ps = connection.prepareStatement("Delete FROM CTC WHERE UnionID=? AND ClassName=? AND CourseName=? ");
            ps.setString(1, ctc.getUnionID());
            ps.setString(2, ctc.getClassName());
            ps.setString(3, ctc.getCourseName());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String updateCTC(CTC old, CTC newC) {
        Connection connection = JDBCUtil.getConnection();

        try {
            ps = connection.prepareStatement("UPDATE CTC SET   UnionID=?,ClassName=?,CourseName=?,ISBN=? WHERE UnionID=? AND ClassName=? AND CourseName=? ");

            ps.setString(1, newC.getUnionID());
            ps.setString(2, newC.getClassName());
            ps.setString(3, newC.getCourseName());
            ps.setString(4, newC.getISBN());
            ps.setString(5, old.getUnionID());
            ps.setString(6, old.getClassName());
            ps.setString(7, old.getCourseName());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return "修改教科书安排失败";
        }
        return "修改教科书安排成功";

    }

}
