package project.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet

{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

    {

        HttpSession session = request.getSession(false); //getting to session object

        if(session!=null) // check if condition the session not null

        {

            session.invalidate(); //using this method to destroy the sesion object

            request.setAttribute("errMsg", "Logged out successfully"); //send "errorMSG" object on client side. And get using request.getAttribute() method

            response.sendRedirect(request.getContextPath() + "/login");
            System.out.println("you can logged out successfully");
            return;





        }

    }

}
