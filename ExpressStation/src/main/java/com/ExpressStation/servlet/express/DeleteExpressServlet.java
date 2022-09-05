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

@WebServlet("/delExpressServlet")
public class DeleteExpressServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adm = req.getParameter("id");
        String express = req.getParameter("v");
        ExpressService es = new ExpressServiceImpl();
        es.del(express);

        User admin = es.getAdmin(adm);
        ArrayList<Express> arr = es.getAllExpress();
        req.setAttribute("user",admin);
        req.setAttribute("arr",arr);
        req.getRequestDispatcher("adminLoginMainPage.jsp").forward(req,resp);
    }
}
