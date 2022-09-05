package com.ExpressStation.service;

import com.ExpressStation.bean.User;
import com.ExpressStation.bean.Express;

import java.util.ArrayList;

public interface ExpressService {
    User getAdmin(String id);

    ArrayList<Express> getAllExpress();

    ArrayList<Express> getExpress(String v);

    void del(String express);

    void add(String a, String b, String c, String d, String e);

    void add2(String a, String admId, String b, String c);

    ArrayList<Express> getExpressByStatus(User adminU);


    void upDate(String a, String eId, String b, String c);
}
