package com.ExpressStation.service;

import com.ExpressStation.bean.Express;
import com.ExpressStation.bean.User;
import com.ExpressStation.dao.UserDao;
import com.ExpressStation.dao.UserDaoImpl;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    UserDao us = new UserDaoImpl();
    @Override
    public ArrayList<User> getAllUser() {
        return us.getAllUser();
    }

    @Override
    public User getFileByNameOrId(String v) {
        return us.getFileByNameOrId(v);
    }

    @Override
    public User getAdmin(String id) {
        return us.getAdmin(id);
    }

    @Override
    public void delUser(String user) {
        us.delUser(user);
    }

    @Override
    public ArrayList<Express> getSelfExpress(User adminU) {
        return us.getSelfExpress(adminU);
    }

    @Override
    public void upDateUser(String userId, String a, String b, String c) {
        us.upDateUser(userId,a,b,c);
    }


}
