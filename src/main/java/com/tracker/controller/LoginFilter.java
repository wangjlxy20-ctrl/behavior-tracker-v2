package com.tracker.controller;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/behavior/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        //Obtain the current visit path
        String path = httpServletRequest.getServletPath();

        //access to login page,don't identify the session
        if(path.equals("/behavior/login.jsp") || path.equals("/login")){
            chain.doFilter(request,response);
        }

        //Obtain the identifier of the logged-in user from Session
        Object loginUser = httpServletRequest.getSession().getAttribute("username");


        //intercept unauthenticated users and redirect to login page
        if (loginUser == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "login.jsp");
            return;
        }

        //authenticated,Release access to business pages
        chain.doFilter(request,response);


    }
}
