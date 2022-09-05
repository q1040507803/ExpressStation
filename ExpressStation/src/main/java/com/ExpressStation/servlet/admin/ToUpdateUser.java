package com.ExpressStation.servlet.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toUpdateUser")
public class ToUpdateUser extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String admId = req.getParameter("admId");
        String userId = req.getParameter("userId");
        System.out.println(admId);
        System.out.println(userId);
        req.setAttribute("admId",admId);
        req.setAttribute("userId",userId);
        req.getRequestDispatcher("updateUser.jsp").forward(req,resp);
    }
}
