package com.ExpressStation.servlet;

import com.ExpressStation.bean.Express;
import com.ExpressStation.bean.User;
import com.ExpressStation.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/userToExpress")
public class UserToExpress extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("admId");

        UserService us = new UserServiceImpl();
        User user = us.getAdmin(uid);
        ExpressService es = new ExpressServiceImpl();
        ArrayList<Express> arr = es.getAllExpress();
        req.setAttribute("user",user);
        req.setAttribute("arr",arr);
        req.getRequestDispatcher("adminLoginMainPage.jsp").forward(req, resp);

    }
}
