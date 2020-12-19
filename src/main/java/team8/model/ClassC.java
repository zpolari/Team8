package team8.model;

import team8.dao.impl.ClassImpl;

import java.util.ArrayList;


/**
 * 班级信息类
 * 属性：无
 * 因和教科书类型记录类相似，所以采用另一种编写方式
 * Author:zPolari
 * Time:2020-12-19
 */

public class ClassC {

    private static ArrayList<String> arrayList = new ClassImpl().findAll();

    public static ArrayList<String> GetClass() {
        return arrayList;
    }


    /**
     * 测试使用
     */
    public static void OutClass_TEST() {
        for (String s : arrayList
        ) {
            System.out.println(s);
        }
    }


}
