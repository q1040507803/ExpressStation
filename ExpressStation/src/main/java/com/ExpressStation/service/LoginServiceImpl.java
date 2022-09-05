package com.ExpressStation.service;

import com.ExpressStation.bean.User;
import com.ExpressStation.dao.LoginDao;
import com.ExpressStation.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

    @Override
    public User loginService(User u) {
        LoginDao ld = new LoginDaoImpl();
        return ld.logindao(u);
    }
}
