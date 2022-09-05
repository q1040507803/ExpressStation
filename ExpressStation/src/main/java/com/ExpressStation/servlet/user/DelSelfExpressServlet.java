package com.ExpressStation.servlet.user;

import com.ExpressStation.bean.Express;
import com.ExpressStation.bean.User;
import com.ExpressStation.service.ExpressService;
import com.ExpressStation.service.ExpressServiceImpl;
import com.ExpressStation.service.UserService;
import com.ExpressStation.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/delSelfExpress")
public class DelSelfExpressServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adm = req.getParameter("id");
        String express = req.getParameter("v");

        UserService us = new UserServiceImpl();
        ExpressService es = new ExpressServiceImpl();
        es.del(express);

        User admin = es.getAdmin(adm);
        ArrayList<Express> arr = us.getSelfExpress(admin);
        req.setAttribute("user",admin);
        req.setAttribute("arr",arr);
        req.getRequestDispatcher("userLoginMainPage.jsp").forward(req,resp);
    }
}
