package team8.model;


/**
 * 任课安排信息记录类
 *
 * 属性：班级名称、课程名称、
 * 教师UnionID、教师名称、
 * 书籍ISBN号、书籍名称
 *
 * Author:zPolari
 * Time:2020-12-19
 */

public class CTC {
    private String ClassName;
    private String CourseName;

    private String UnionID;
    private String TeachName;

    private String ISBN;
    private String BName;


    public CTC(String className, String courseName, String unionID, String teachName, String ISBN, String BName) {
        ClassName = className;
        CourseName = courseName;
        UnionID = unionID;
        TeachName = teachName;
        this.ISBN = ISBN;
        this.BName = BName;
    }

    @Override
    public String toString() {
        return "任课安排{" +
                "\n 班级名称  =  " + ClassName +
                "\n 课程名  =  " + CourseName +
                "\n 教师ID  =  " + UnionID +
                "\n 教师名称  =  " + TeachName +
                "\n ISBN  =  " + ISBN +
                "\n 教材名  =  " + BName +
                "\n }";
    }

    public CTC() {
    }



    public String getUnionID() {
        return UnionID;
    }

    public void setUnionID(String unionID) {
        UnionID = unionID;
    }

    public String getBName() {
        return BName;
    }

    public void setBName(String BName) {
        this.BName = BName;
    }


    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getTeachName() {
        return TeachName;
    }

    public void setTeachName(String teachName) {
        TeachName = teachName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
