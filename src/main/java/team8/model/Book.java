package team8.model;

/**
 * 教科书信息类
 * 属性：ISBN号、书名、作者名称、教科书类型、出版社、出版时间
 * Author:zPolari
 * Time:2020-12-19
 */
public class Book {

        private String ISBN;
        private String BName;
        private String Author;
        private String Type;
        private String Publisher;
        private String PublishTime;

        @Override
        public String toString() {
            return "教科书信息{" +
                    "\n ISBN=" + ISBN +
                    "\n 教材名  =  " + BName +
                    "\n 作者  =  " + Author +
                    "\n 类型  =  " + Type +
                    "\n 出版社  =  " + Publisher +
                    "\n 出版时间  =  " + PublishTime +
                    "\n }";
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



