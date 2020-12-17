package team8.model;

import team8.dao.impl.ClassImpl;

import java.util.ArrayList;

public class ClassC {

    private static ArrayList<String> arrayList = new ClassImpl().findAll();

    public static ArrayList<String> GetClass() {
        return arrayList;
    }

    public static void OutClass_TEST() {
        for (String s : arrayList
        ) {
            System.out.println(s);
        }
    }


}
