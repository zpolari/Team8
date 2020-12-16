import org.junit.Test;
import team8.dao.CTCDAO;
import team8.dao.impl.CTCImpl;
import team8.model.CTC;

import java.util.ArrayList;

public class TestCTC {

    @Test
    public void findAllCTC() {
        CTCDAO ctcdao=new CTCImpl();
        ArrayList<CTC>arrayList=ctcdao.findByUnion("all");

        for (CTC ctc:arrayList
             ) {
            System.out.println(ctc.toString());
        }
        System.out.println("\n\n\n");
        arrayList=ctcdao.findByUnion("1912120346");

        for (CTC ctc:arrayList
        ) {
            System.out.println(ctc.toString());
        }

    }
}
