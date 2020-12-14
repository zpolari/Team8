package team8.model;

import team8.dao.impl.BookTypeImpl;

import java.util.ArrayList;

public class BookType {

    private ArrayList<bookTypeInfo> bookType = new ArrayList<bookTypeInfo>();
    BookTypeImpl bookTypeImpl = new BookTypeImpl();
    private static BookType instance = new BookTypeImpl().findAll();

    public static BookType getInstance(){
        return instance;
    }

    public BookType(ArrayList<bookTypeInfo> bookType) {
        this.bookType = bookType;
    }

    public BookType() {

    }

    public String addBookType(String string) {
        int no = isBookTypeExit(string);
        if (no > -1) {
            return "新增失败";

        }

        bookType.add(new bookTypeInfo(string));
        bookTypeImpl.add(string);
        return "新增成功";

    }

    public String delBookType(String string) {
        int no = isBookTypeExit(string);
        if (no > -1) {
            bookTypeImpl.del(string);
            return "删除成功" + bookType.remove(no).getBookType();
        }
        return "删除失败";
    }

    //need change 54
    public String  update(String old,String newS){
        int no = isBookTypeExit(newS);
        if (no > -1) {
            System.out.println("不能修改");
            return "不能修改";
        }
        delBookType(old);
        addBookType(newS);
        System.out.println("修改成功");
        return "修改成功";

    }


    public int isBookTypeExit(String string) {
        for (int i = 0; i < bookType.size(); i++) {
            if (bookType.get(i).getBookType().equals(string)) {
                return i;
            }
        }
        return -1;
    }

    //根据no返回教科书类型名称
    public String getBookType(int no) {
        System.out.println("this get book");
        return bookType.get(no).getBookType();
    }


    //返回教科书种类数量
    public int getSize() {
        return bookType.size();
    }

    public ArrayList<bookTypeInfo> getArr() {
        return bookType;
    }


    //为了TableView自动化填充工工厂能自动读取
    public class bookTypeInfo {
        public String bookType;

        public bookTypeInfo(String bookType) {
            this.bookType = bookType;
        }

        public String getBookType() {
            return bookType;
        }

        public void setBookType(String bookType) {
            this.bookType = bookType;
        }
    }

//    public void showList() {
//        ObservableList<test> list = FXCollections.observableList(new BookTypeImpl().findAll().getArr());
//        colUsername.setCellValueFactory(new PropertyValueFactory("bookType"));//映射
//        System.out.println(list);
//        tview.setItems(list); //tableview添加list
//    }

}
