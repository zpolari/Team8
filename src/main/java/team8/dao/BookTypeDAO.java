package team8.dao;


import java.util.ArrayList;

public interface BookTypeDAO {

    /**
     * 查询所有教科书类型
     * @return
     */
    public ArrayList<String> findAll();

    /**
     * 新增教科书类型
     */
    public String add(String string);

    /**
     * 删除教科书类型
     */
    public String del(String string);

    public String update(String old,String newT);


}
