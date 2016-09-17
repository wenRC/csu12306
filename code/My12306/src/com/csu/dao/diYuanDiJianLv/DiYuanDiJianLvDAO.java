package com.csu.dao.diYuanDiJianLv;

import com.csu.domain.diYuanDiJianLv.DiYuanDiJianLv;

import java.util.ArrayList;

/**
 * Created by Asus_ on 2016/9/13.
 */
public interface DiYuanDiJianLvDAO {
    public DiYuanDiJianLv getDYDJLvByDYDJLID(String DYDJLID);
    public int addDYDJLv(DiYuanDiJianLv diYuanDiJianLv);
    public ArrayList<DiYuanDiJianLv> getDYDJLvs();
    public int updateDYDJLv(DiYuanDiJianLv diYuanDiJianLv);
    public int delDYDJLvById(String DYDJLID);
}
