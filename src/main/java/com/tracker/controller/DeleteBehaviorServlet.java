package com.tracker.controller;

import com.tracker.service.b_Tracker_Service;
import com.tracker.service.b_Tracker_ServiceImple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/behavior/delete")
public class DeleteBehaviorServlet extends HttpServlet {

    private final b_Tracker_Service service =
            new b_Tracker_ServiceImple();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id"));

        service.deleteTypeByUserId(id);

        response.sendRedirect(
                request.getContextPath()
                        + "/behavior/list");
    }
}