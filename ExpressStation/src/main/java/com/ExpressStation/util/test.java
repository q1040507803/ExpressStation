package com.ExpressStation.util;

import com.ExpressStation.bean.User;
import com.ExpressStation.service.UserService;
import com.ExpressStation.service.UserServiceImpl;
import com.ExpressStation.service.LoginService;
import com.ExpressStation.service.LoginServiceImpl;

public class test {
    public static void main(String[] args) {
        UserService fs = new UserServiceImpl();
        String studentId = "1001";
        LoginService ls = new LoginServiceImpl();
        User u = new User("1001","ะกร๗","123456","13812612345",1);
        ls.loginService(u);

    }
}
