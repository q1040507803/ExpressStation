package com.ExpressStation.dao;

import com.ExpressStation.bean.Express;
import com.ExpressStation.bean.User;

import java.util.ArrayList;

public interface UserDao {

    User getAdmin(String id);       //获取管理员用户

    ArrayList<User> getAllUser();   //获取所有用户

    User getFileByNameOrId(String v);   //根据名字或uid查询用户

    void delUser(String user);      //删除用户

    ArrayList<Express> getSelfExpress(User adminU);    //用户查询自己快递

    void upDateUser(String userId, String a, String b, String c);   //更新用户
}
