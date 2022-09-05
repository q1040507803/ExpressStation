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

@WebServlet("/updateSelfExpress")
public class UpdateSelfExpressServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String admId = req.getParameter("admId");
        String eId = req.getParameter("eId");
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String c = req.getParameter("c");
        System.out.println(eId+" "+a+" "+b+" "+c);

        UserService us = new UserServiceImpl();
        ExpressService es = new ExpressServiceImpl();
        es.upDate(a,eId,b,c);

        User user = es.getAdmin(admId);
        ArrayList<Express> arr = us.getSelfExpress(user);
        req.setAttribute("user",user);
        req.setAttribute("arr",arr);
        req.getRequestDispatcher("userLoginMainPage.jsp").forward(req,resp);


    }
}
