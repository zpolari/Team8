package team8.dao;

import team8.model.Book;

import java.util.ArrayList;

/**
 * 教科书 数据库操作定义接口
 * 方法：查询全部教科书、新增教科书、删除教科书、更新教科书
 * Author:zPolari
 * Time:2020-12-18
 */

public interface BooksDao {

    ArrayList<Book> findAll();

    String addBook(Book book);

    boolean delBook(String isbn);

    String updateBook(Book book);

}
