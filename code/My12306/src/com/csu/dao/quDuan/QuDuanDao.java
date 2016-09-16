package com.csu.dao.quDuan;

import com.csu.domain.quDuan.QuDuan;

import java.util.List;

/**
 * Created by sx on 2016/9/12.
 */
public interface QuDuanDao {
    List<QuDuan> getAllQuDuans();//查询所有的区段
    QuDuan getQuDuanById(int quDuanId);//根据旅程区段编号查询区段
    boolean updateQuDuan(QuDuan quDuan);//修改旅程区段
}
