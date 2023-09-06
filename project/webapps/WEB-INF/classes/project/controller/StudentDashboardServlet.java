package project.controller;

import project.filter.AuthorizationFilter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class StudentDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if(session == null || session.getAttribute("email") == null) {
            // User is not logged in, redirect to login page
            System.out.println(",,,,,");
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        } else {
            // User is logged in, continue with the request
            HttpSession httpSession = req.getSession();
            String id = (String) httpSession.getAttribute("email"); // Use "id" instead of "email"
            System.out.println(",,,,,");
            if(id != null) {
                int id1 = Integer.parseInt(id);
                System.out.println(id1);
                System.out.println(",,,,,");
                if(id1 < 1000) {
                    req.setAttribute("title", "Student Portal");
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/studentDashboard.jsp");
                    requestDispatcher.forward(req, resp);
                } else {
                    // User is not logged in, redirect to login page
                    resp.sendRedirect(req.getContextPath() + "/logout");
                    return;
                }

            }
        }

    }

}