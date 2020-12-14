package team8.dao;


import team8.model.BookType;

public interface BookTypeDAO {

    /**
     * 查询所有教科书类型
     */
    public BookType findAll();

    /**
     * 新增教科书类型
     */
    public String add(String string);

    /**
     * 删除教科书类型
     */
    public String del(String string);


}
