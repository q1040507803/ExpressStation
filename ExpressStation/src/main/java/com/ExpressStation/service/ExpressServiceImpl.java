package com.ExpressStation.service;

import com.ExpressStation.bean.Express;
import com.ExpressStation.bean.User;
import com.ExpressStation.dao.ExpressDao;
import com.ExpressStation.dao.ExpressDaoImpl;

import java.util.ArrayList;

public class ExpressServiceImpl implements ExpressService{

    ExpressDao es = new ExpressDaoImpl();
    @Override
    public User getAdmin(String id) {
        return es.getAdmin(id);
    }

    @Override
    public ArrayList<Express> getAllExpress() {
        return es.getAllExpress();
    }

    @Override
    public ArrayList<Express> getExpress(String v) {
        return es.getExpress(v);
    }

    @Override
    public void del(String express) {
        es.del(express);
    }

    @Override
    public void add(String a, String b, String c, String d, String e) {
        es.add(a,b,c,d,e);
    }

    @Override
    public void add2(String a, String admId, String b, String c) {
        es.add2(a,admId,b,c);
    }

    @Override
    public ArrayList<Express> getExpressByStatus(User adminU) {
        return es.getExpressByStatus(adminU);
    }

    @Override
    public void upDate(String a, String eId, String b, String c) {
        es.upDate(a,eId,b,c);
    }


}
