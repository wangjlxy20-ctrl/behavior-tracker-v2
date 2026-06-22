package com.tracker.controller;

import com.tracker.service.b_Tracker_Service;
import com.tracker.service.b_Tracker_ServiceImple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/behavior/update")
public class UpdateBehaviorServlet extends HttpServlet {

    private final b_Tracker_Service service =
            new b_Tracker_ServiceImple();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(
                request.getParameter("id"));

        String type =
                request.getParameter("type");

        int value = Integer.parseInt(
                request.getParameter("value"));

        service.updateTypeIntensity(
                id,
                type,
                value);

        response.sendRedirect(
                request.getContextPath()
                        + "/behavior/list");
    }
}