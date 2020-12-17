package team8.model;

import team8.dao.BooksDao;
import team8.dao.impl.BookTypeImpl;
import team8.dao.impl.BooksImpl;

import java.util.ArrayList;

public class Book {

    private ArrayList<Book> books = new ArrayList<>();


        private String ISBN;
        private String BName;
        private String Author;
        private String Type;
        private String Publisher;
        private String PublishTime;

        @Override
        public String toString() {
            return "Book{" +
                    "ISBN='" + ISBN + '\'' +
                    ", BName='" + BName + '\'' +
                    ", Author='" + Author + '\'' +
                    ", Type='" + Type + '\'' +
                    ", Publisher='" + Publisher + '\'' +
                    ", PublishTime='" + PublishTime + '\'' +
                    '}';
        }

        public Book() {
        }

        public Book(String ISBN, String BName, String author, String type, String publisher, String publishTime) {
            this.ISBN = ISBN;
            this.BName = BName;
            Author = author;
            Type = type;
            Publisher = publisher;
            PublishTime = publishTime;
        }

        public String getISBN() {
            return ISBN;
        }

        public void setISBN(String ISBN) {
            this.ISBN = ISBN;
        }

        public String getBName() {
            return BName;
        }

        public void setBName(String BName) {
            this.BName = BName;
        }

        public String getAuthor() {
            return Author;
        }

        public void setAuthor(String author) {
            Author = author;
        }

        public String getType() {
            return Type;
        }

        public void setType(String type) {
            Type = type;
        }

        public String getPublisher() {
            return Publisher;
        }

        public void setPublisher(String publisher) {
            Publisher = publisher;
        }

        public String getPublishTime() {
            return PublishTime;
        }

        public void setPublishTime(String publishTime) {
            PublishTime = publishTime;
        }
    }



