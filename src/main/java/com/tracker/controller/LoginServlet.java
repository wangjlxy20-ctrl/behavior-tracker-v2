package com.tracker.controller;

import com.tracker.pojo.my_users;
import com.tracker.service.b_Tracker_Service;
import com.tracker.service.b_Tracker_ServiceImple;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final b_Tracker_Service service =
            new b_Tracker_ServiceImple();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        if(service.login(username,password) == 1){

            my_users user =
                    service.getUserByUsername(username);

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "userId",
                    user.getUser_id());

            session.setAttribute(
                    "username",
                    user.getUsername());

            response.sendRedirect(
                    request.getContextPath()
                            + "/behavior/list");

        }else{

            response.sendRedirect(
                    request.getContextPath()
                            + "/login.jsp");
        }
    }
}