package team8.model;

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
        return "CTC{" +
                "ClassName='" + ClassName + '\'' +
                ", CourseName='" + CourseName + '\'' +
                ", UnionID='" + UnionID + '\'' +
                ", TeachName='" + TeachName + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", BName='" + BName + '\'' +
                '}';
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