package team8.dao;

import team8.model.CTC;

import java.util.ArrayList;


/**
 * 任课安排 数据库操作定义接口
 * 方法：根据教师UnionID查询该教师任课安排、新增任课安排、删除任课安排、更新任课安排
 * Author:zPolari
 * Time:2020-12-18
 */

public interface CTCDAO {

    ArrayList<CTC> findByUnion(String Union);

    String addCTC(CTC ctc);

    boolean delCTC(CTC ctc);

    String updateCTC(CTC old, CTC newC);


}
