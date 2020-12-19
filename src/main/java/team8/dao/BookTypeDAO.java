package team8.dao;


import java.util.ArrayList;

/**
 * 教科书 类型数据库操作定义接口
 * 方法：查询全部教科书类型、新增教科书类型、删除教科书类型、更新教科书类型
 * Author:zPolari
 * Time:2020-12-18
 */


public interface BookTypeDAO {

    /**
     * 查询所有教科书类型
     * @return
     */
     ArrayList<String> findAll();

    /**
     * 新增教科书类型
     */
     String add(String string);

    /**
     * 删除教科书类型
     */
     String del(String string);

     String update(String old,String newT);


}
