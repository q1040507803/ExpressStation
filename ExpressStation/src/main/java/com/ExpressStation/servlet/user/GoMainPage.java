package com.ExpressStation.servlet.user;

import com.ExpressStation.bean.User;
import com.ExpressStation.service.UserService;
import com.ExpressStation.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//¿ìµÝ
@WebServlet("/goMainPage")
public class GoMainPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String admId = req.getParameter("admId");
        UserService us = new UserServiceImpl();
        User user = us.getAdmin(admId);
        ArrayList<User> arr = us.getAllUser();
        req.setAttribute("user",user);
        req.setAttribute("arr",arr);
        req.getRequestDispatcher("manageMainPage.jsp").forward(req,resp);

    }
}