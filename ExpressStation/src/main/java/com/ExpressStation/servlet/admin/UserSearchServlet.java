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

@WebServlet("/userSearchServlet")
public class UserSearchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        UserService us = new UserServiceImpl();

        //��ȡ����Ա��Ϣ
        String id =req.getParameter("id");
        User adminU = us.getAdmin(id);

        //��ѯ�û�
        String v = req.getParameter("v");
        User u = us.getFileByNameOrId(v);
        ArrayList<User> arr = new ArrayList<User>();
        arr.add(u);


        req.setAttribute("user",adminU);
        if(u != null){
            req.setAttribute("arr",arr);
            req.getRequestDispatcher("manageMainPage.jsp").forward(req,resp);
        }else {
            UserService f =new UserServiceImpl();
            ArrayList<User> arr2 = f.getAllUser();
            req.setAttribute("arr",arr2);
            req.getRequestDispatcher("manageMainPage.jsp").forward(req,resp);
        }

    }
}