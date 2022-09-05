package com.ExpressStation.servlet.express;

import com.ExpressStation.bean.Express;
import com.ExpressStation.bean.User;
import com.ExpressStation.service.ExpressService;
import com.ExpressStation.service.ExpressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addExpressServlet")
public class AddExpressServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String admId = req.getParameter("admId");
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String c = req.getParameter("c");
        String d = req.getParameter("d");
        String e = req.getParameter("e");
        System.out.println(admId+" "+a+" "+b+" "+c+" "+d+" "+e);

        ExpressService es = new ExpressServiceImpl();
        es.add(a,b,c,d,e);

        User user = es.getAdmin(admId);
        ArrayList<Express> arr = es.getAllExpress();
        req.setAttribute("user",user);
        req.setAttribute("arr",arr);
        req.getRequestDispatcher("adminLoginMainPage.jsp").forward(req,resp);


    }
}
