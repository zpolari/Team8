import org.junit.Test;
import team8.model.BookType;

public class TestBookType {

    @Test
    public void findAllBookType() {

        BookType bookType=BookType.getInstance();
        for (BookType.bookTypeInfo bookTypeInfo :bookType.getArr()             ) {
            System.out.print(bookTypeInfo.getBookType()+"#");
        }
        System.out.println();

        bookType.addBookType("312");

        for (BookType.bookTypeInfo bookTypeInfo :bookType.getArr()             ) {
            System.out.print(bookTypeInfo.getBookType()+"#");
        }
        System.out.println();

        bookType.delBookType("312");
        bookType.delBookType("312");
        for (BookType.bookTypeInfo bookTypeInfo :bookType.getArr()             ) {
            System.out.print(bookTypeInfo.getBookType()+"#");
        }
        System.out.println();

        bookType.update("习题集","123");



    }


}
