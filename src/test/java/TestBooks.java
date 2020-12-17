import org.junit.Test;
import team8.dao.impl.BooksImpl;
import team8.model.Book;

import java.util.ArrayList;

public class TestBooks {

    @Test
   public void TestBooks(){

        ArrayList<Book> arrayList=new BooksImpl().findAll();

        for (Book book:arrayList             ) {
            System.out.println(book.toString());
        }

        System.out.println(new BooksImpl().addBook(new Book("test", "test", "test", "普通教材", "test", "test")));
        for (Book book:arrayList             ) {
            System.out.println(book.toString());
        }

        System.out.println(new BooksImpl().delBook("test"));
        for (Book book:arrayList             ) {
            System.out.println(book.toString());
        }
        System.out.println(new BooksImpl().delBook("test"));
        for (Book book:arrayList             ) {
            System.out.println(book.toString());
        }


    }


}
