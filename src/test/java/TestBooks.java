import org.junit.Test;
import team8.dao.impl.BooksImpl;
import team8.model.Books;

import java.util.ArrayList;

public class TestBooks {

    @Test
   public void TestBooks(){
        Books books=Books.getInstance();

        ArrayList<Books.Book> arrayList=books.getArr();

        for (Books.Book book:arrayList             ) {
            System.out.println(book.toString());
        }

        System.out.println(books.addBook(books.new Book("test", "test", "test", "普通教材", "test", "test")));
        for (Books.Book book:arrayList             ) {
            System.out.println(book.toString());
        }

        System.out.println(books.delBook("test"));
        for (Books.Book book:arrayList             ) {
            System.out.println(book.toString());
        }
        System.out.println(books.delBook("test"));
        for (Books.Book book:arrayList             ) {
            System.out.println(book.toString());
        }

        arrayList.get(books.isBookExit("203")).setAuthor("321");
        books.updateBook(arrayList.get(books.isBookExit("203")));

    }


}
