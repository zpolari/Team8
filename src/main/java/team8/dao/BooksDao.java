package team8.dao;

import team8.model.Books;

public interface BooksDao {

    Books findAll();

    String addBook(Books.Book book);

    String delBook(String isbn);

    Books.Book updateBook(Books.Book book);

     Books.Book findBook(String isbn);

}
