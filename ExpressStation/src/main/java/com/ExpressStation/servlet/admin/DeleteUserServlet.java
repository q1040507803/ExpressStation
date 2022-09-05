package com.ExpressStation.servlet.admin;

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

@WebServlet("/delUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adm = req.getParameter("id");
        String user = req.getParameter("v");
        UserService us = new UserServiceImpl();
        us.delUser(user);

        User admin = us.getAdmin(adm);
        ArrayList<User> arr = us.getAllUser();
        req.setAttribute("user",admin);
        req.setAttribute("arr",arr);
        req.getRequestDispatcher("manageMainPage.jsp").forward(req,resp);
    }
}