import org.junit.Test;
import team8.dao.impl.CourseImpl;
import team8.model.Course;

import java.util.ArrayList;

public class TestCourse {


    @Test
    public void TestCourse(){
        Course.OutCourse_TEST();
    }

    @Test
    public void TestNoSelect(){
        String c="初一3班";
        ArrayList<String> arrayList=new Course().findClassNoSelect(c);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

    }

}
