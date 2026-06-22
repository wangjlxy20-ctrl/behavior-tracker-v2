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

        HttpSession session =
                request.getSession();

        Integer userId =
                (Integer) session.getAttribute("userId");

        // Login Verification
        if(userId == null){
            response.sendRedirect(
                    request.getContextPath()
                            + "/login.jsp");
            return;
        }

        List<Type> list =
                service.getAllRecords(userId);

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

        HttpSession session =
                request.getSession();

        Integer userId =
                (Integer)session.getAttribute("userId");

        //Login Verification
        if(userId == null){
            response.sendRedirect(
                    request.getContextPath()
                            + "/login.jsp");
            return;
        }

        service.insertRecord(
                userId,
                type,
                value);

        response.sendRedirect(
                request.getContextPath()
                        + "/behavior/list");
    }
}