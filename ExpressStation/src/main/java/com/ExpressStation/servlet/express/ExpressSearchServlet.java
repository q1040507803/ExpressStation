package com.ExpressStation.servlet.express;

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
import java.util.Iterator;

@WebServlet("/expressSearchServlet")
public class ExpressSearchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ExpressService es = new ExpressServiceImpl();

        //获取管理员信息
        String id =req.getParameter("id");
        User adminU = es.getAdmin(id);

        //查询快递
        String v = req.getParameter("v");
        ArrayList<Express> arr = es.getExpress(v);

        req.setAttribute("user",adminU);
        if(arr != null){
            req.setAttribute("arr",arr);
            req.getRequestDispatcher("adminLoginMainPage.jsp").forward(req,resp);
        }else {
            ArrayList<Express> arr2 = es.getAllExpress();
            req.setAttribute("arr",arr2);
            req.getRequestDispatcher("adminLoginMainPage.jsp").forward(req,resp);
        }

    }
}