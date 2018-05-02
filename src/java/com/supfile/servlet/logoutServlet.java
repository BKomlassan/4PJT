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


/**
 *
 * @author Nassima
 */
public class logoutServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       
        
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        
        String accessToken;
        try {
        	accessToken = facebook.getOAuthAccessToken().getToken();

            //Supp permissions pour app fb
            facebook.deleteAllPermissions();

        } catch (Exception e) 
        {
            throw new ServletException(e);
        }

        // session invalide
        request.getSession().invalidate();

        //se deco de facebook
        StringBuffer next = request.getRequestURL();
        int index = next.lastIndexOf("/");
        next.replace(index+1, next.length(), "");
        
        //cf ici la redirection
        response.sendRedirect("http://www.facebook.com/logout.php?next=" + next.toString() + "&access_token=" + accessToken);
        
    }
        
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
        
    }

  

}
