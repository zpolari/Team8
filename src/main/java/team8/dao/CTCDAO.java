package team8.dao;

import team8.model.CTC;

import java.util.ArrayList;

public interface CTCDAO {

    ArrayList<CTC> findByUnion(String Union);

    String addCTC(CTC ctc);

    String delCTC(CTC ctc);

    String updateCTC(CTC old, CTC newC);


}
