package com.ExpressStation.service;

import com.ExpressStation.bean.Express;
import com.ExpressStation.bean.User;

import java.util.ArrayList;

public interface UserService {

    User getAdmin(String id);       //获取管理员信息

    ArrayList<User> getAllUser();    //查询所有用户

    User getFileByNameOrId(String v);   //通过名字或ID查询用户


    void delUser(String user);

    ArrayList<Express> getSelfExpress(User adminU);

    void upDateUser(String userId, String a, String b, String c);
}
