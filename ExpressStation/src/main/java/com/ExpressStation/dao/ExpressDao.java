package com.ExpressStation.dao;

import com.ExpressStation.bean.Express;
import com.ExpressStation.bean.User;

import java.util.ArrayList;

public interface ExpressDao {
    User getAdmin(String id);       //获取管理员用户

    ArrayList<Express> getAllExpress(); //获取所有快递

    ArrayList<Express> getExpress(String v);    //通过eid或状态查询快递

    void del(String express);       //删除快递

    void add(String a, String b, String c, String d, String e); //管理员添加快递

    void add2(String a, String admId, String b, String c);      //用户添加自己快递

    ArrayList<Express> getExpressByStatus(User adminU);         //用户查询自己待寄快递

    void upDate(String a, String eId, String b, String c);      //更新快递
}
