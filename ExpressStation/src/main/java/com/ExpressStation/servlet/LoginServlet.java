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


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u_id = req.getParameter("u_id");
        String u_pwd = req.getParameter("u_pwd");
        User u = new User();
        u.setU_id(u_id);
        u.setPwd(u_pwd);

        //实现登录服务层的业务逻辑层
        LoginService l = new LoginServiceImpl();
        User user = l.loginService(u);

        //user为空，跳转登陆界面，不为空，跳转主页面
        if(user != null){
            if(user.getRole() == 0) {
                ExpressService es = new ExpressServiceImpl();
                ArrayList<Express> arr = es.getAllExpress();
                req.setAttribute("user", user);
                req.setAttribute("arr", arr);
                req.getRequestDispatcher("adminLoginMainPage.jsp").forward(req, resp);
            }else{
                req.setAttribute("user",user);
                req.getRequestDispatcher("userLoginMainPage.jsp").forward(req,resp);
            }

        }else{
            req.setAttribute("error","账户和密码不一致");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }
}
