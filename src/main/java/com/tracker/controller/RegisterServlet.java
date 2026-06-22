package com.tracker.controller;

import com.tracker.service.b_Tracker_Service;
import com.tracker.service.b_Tracker_ServiceImple;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final b_Tracker_Service service =
            new b_Tracker_ServiceImple();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        String confirmPassword =
                request.getParameter("confirmPassword");

        int result =
                service.register(
                        username,
                        password,
                        confirmPassword);

        if(result == 1){

            response.sendRedirect(
                    request.getContextPath()
                            + "/login.jsp");

        }else if(result == -1){

            response.getWriter().println(
                    "Passwords do not match!");

        }else if(result == -2){

            response.getWriter().println(
                    "Username already exists!");

        }
    }
}
