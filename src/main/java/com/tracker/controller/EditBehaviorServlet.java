package com.tracker.controller;

import com.tracker.pojo.Type;
import com.tracker.service.b_Tracker_Service;
import com.tracker.service.b_Tracker_ServiceImple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/behavior/edit")
public class EditBehaviorServlet extends HttpServlet {

    private final b_Tracker_Service service =
            new b_Tracker_ServiceImple();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id"));

        List<Type> list =
                service.getAllRecords(1);

        for(Type item : list){
            if(item.getId() == id){
                request.setAttribute("record", item);
                break;
            }
        }

        request.getRequestDispatcher("/edit.jsp")
                .forward(request,response);
    }
}
