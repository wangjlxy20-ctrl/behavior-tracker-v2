package com.tracker.controller;

import com.tracker.pojo.Type;
import com.tracker.service.b_Tracker_Service;
import com.tracker.service.b_Tracker_ServiceImple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/behavior/list")
public class BehaviorListServlet extends HttpServlet {

    private final b_Tracker_Service service =
            new b_Tracker_ServiceImple();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Type> list = service.getAllRecords(1);

        request.setAttribute("list", list);

        request.getRequestDispatcher("/behavior-list.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String type = request.getParameter("type");

        int value =
                Integer.parseInt(
                        request.getParameter("value"));

        int result =
                service.insertRecord(1, type, value);

        response.sendRedirect(
                request.getContextPath()
                        + "/behavior/list");
    }
}