package com.csu.dao.quDuan;

import com.csu.domain.quDuan.QuDuan;

import java.util.List;

/**
 * Created by sx on 2016/9/12.
 */
public interface QuDuanDao {
    List<QuDuan> getAllQuDuans();
    QuDuan getQuDuanById(int quDuanId);
    boolean updateQuDuan(QuDuan quDuan);
}
