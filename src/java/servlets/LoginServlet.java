/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

/**
 *
 * @author 821320
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        //session.invalidate();
        //session = request.getSession();
        //response.sendRedirect("login");
        
        
            
        if (request.getParameter("logOut") != null){
                
            request.setAttribute("message", "You have been successfully logged out");
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                
        } else if (session.getAttribute("username") != null){
            
            response.sendRedirect("home");
        
        } else {
        
            request.setAttribute("message", "");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        }

        
        
        return;
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        if (request.getParameter("username") == null || request.getParameter("username").equals("") || 
                request.getParameter("password") == null || request.getParameter("password").equals("")){
            
            request.setAttribute("message", "Missing login credentials");
            request.setAttribute("username", request.getParameter("username"));
            request.setAttribute("password", request.getParameter("password"));
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        } else {
        
            AccountService as = new AccountService();
   
            if (as.login(request.getParameter("username"), request.getParameter("password")) == null) {
                
                request.setAttribute("message", "Invalid login credentials");
                request.setAttribute("username", request.getParameter("username"));
                request.setAttribute("password", request.getParameter("password"));
                
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
            } else if (as.login(request.getParameter("username"), request.getParameter("password")) != null){
            
                HttpSession session = request.getSession();
                session.setAttribute("username", request.getParameter("username"));
            
                response.sendRedirect("home");
            }
        }
        return;
    }


}
