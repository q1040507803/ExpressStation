package com.ExpressStation.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toUpAddSelfExpress")
public class ToUpAddSelfExpress extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String admId = req.getParameter("admId");
        req.setAttribute("admId",admId);
        req.getRequestDispatcher("addSelfExpress.jsp").forward(req,resp);
    }
}