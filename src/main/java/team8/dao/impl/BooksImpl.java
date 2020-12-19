package team8.dao.impl;

import team8.dao.BooksDao;
import team8.jdbc.JDBCUtil;
import team8.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BooksImpl implements BooksDao {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public ArrayList<Book> findAll() {
        ArrayList<Book> arrayList=new ArrayList<>();
        Connection connection= JDBCUtil.getConnection();

        try{
            ps=connection.prepareStatement("SELECT * FROM TechBook");
            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println("ADd Book");
                arrayList.add(new Book(rs.getString("ISBN"),rs.getString("Bname"),rs.getString("Author"),rs.getString("type"),rs.getString("publisher"),rs.getString("publishTime")));


            }
        }catch (Exception e){

            e.printStackTrace();

        }finally {
            JDBCUtil.close(rs,ps,connection);
        }

        return arrayList;
    }


    public Book findBook(String isbn) {

        Book book=new Book();
        Connection connection= JDBCUtil.getConnection();

        try{
            ps=connection.prepareStatement("SELECT * FROM TechBook WHERE ISBN=?");
            ps.setString(1,isbn);
            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println("get Book");
                book= new Book(rs.getString("ISBN"),rs.getString("Bname"),rs.getString("Author"),rs.getString("type"),rs.getString("publisher"),rs.getString("publishTime"));


            }
        }catch (Exception e){

            e.printStackTrace();

        }finally {
            JDBCUtil.close(rs,ps,connection);
        }

        return book;
    }

    public String addBook(Book book) {
        Connection connection=JDBCUtil.getConnection();


        try{
            ps=connection.prepareStatement("INSERT INTO TechBook (ISBN, Bname, Author, Type, Publisher, PublishTime) VALUES (?,?,?,?,?,?)");
            ps.setString(1,book.getISBN());
            ps.setString(2,book.getBName());
            ps.setString(3,book.getAuthor());
            ps.setString(4,book.getType());
            ps.setString(5,book.getPublisher());
            ps.setString(6,book.getPublishTime());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
            return "新增失败";
        }finally {
            JDBCUtil.close(rs,ps,connection);
        }
       return "新增成功";



    }

    public String delBook(String isbn) {

        Connection connection=JDBCUtil.getConnection();

        try{
            ps=connection.prepareStatement("DELETE FROM TechBook WHERE ISBN=?");
            ps.setString(1,isbn);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
            return  "删除教科书失败";
        }finally {
            JDBCUtil.close(rs,ps,connection);
        }

        return "删除教科书成功";


    }

    public String updateBook(Book book) {
        Connection connection=JDBCUtil.getConnection();

        try{
            ps=connection.prepareStatement("UPDATE TechBook SET Bname=? ,Author=? ,Type=?,Publisher=?,PublishTime=? WHERE ISBN=?");
            System.out.println(book.toString());
            ps.setString(1,book.getBName());
            ps.setString(2,book.getAuthor());
            ps.setString(3,book.getType());
            ps.setString(4,book.getPublisher());
            ps.setString(5,book.getPublishTime());
            ps.setString(6,book.getISBN());

            ps.execute();
            return  "修改成功";

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            JDBCUtil.close(rs,ps,connection);
        }
     return "修改失败";

    }
}
