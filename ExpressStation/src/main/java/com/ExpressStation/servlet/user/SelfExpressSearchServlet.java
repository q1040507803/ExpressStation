package com.ExpressStation.servlet.user;

import com.ExpressStation.bean.Express;
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

@WebServlet("/selfExpressSearchServlet")
public class SelfExpressSearchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        UserService us = new UserServiceImpl();

        //获取管理员信息
        String id =req.getParameter("id");
        User adminU = us.getAdmin(id);
        ArrayList<Express> arr = us.getSelfExpress(adminU);

        req.setAttribute("user",adminU);
        req.setAttribute("arr",arr);
        req.getRequestDispatcher("userLoginMainPage.jsp").forward(req,resp);

    }
}
