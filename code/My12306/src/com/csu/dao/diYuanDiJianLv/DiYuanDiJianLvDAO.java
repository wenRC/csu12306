package edu.perp.persistence;

import edu.perp.domain.DiYuanDiJianLv;

import java.util.ArrayList;

/**
 * Created by Asus_ on 2016/9/13.
 */
public interface DiYuanDiJianLvDAO {
    public DiYuanDiJianLv getDYDJLvByDYDJLID(String DYDJLID);
    public void addDYDJLv(String from,String to,double dYDJRate,double priceRate);
    public ArrayList<DiYuanDiJianLv> getDYDJLvs();
    public void changeDYDJLv(String from,String to,double dYDJRate,double priceRate);
    public void delDYDJLvById(String DYDJLID);
}
