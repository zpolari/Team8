package team8.dao;

import team8.model.Book;

import java.util.ArrayList;

public interface BooksDao {

    ArrayList<Book> findAll();

    String addBook(Book book);

    String delBook(String isbn);

    String updateBook(Book book);

     Book findBook(String isbn);

}
