/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facebook4j.Facebook; //librairie facebook4j
import facebook4j.FacebookException;
import facebook4j.auth.AccessToken;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Nassima
 */
public class tokenInfo extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        try {
            AccessToken info = facebook.getOAuthAccessTokenInfo();
            request.setAttribute("token", info);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/token.jsp");
        dispatcher.forward(request, response);
    }
        
        
    

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   
}
