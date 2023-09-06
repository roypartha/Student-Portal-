package project.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("title", "Home");
       // req.setAttribute();
        String id = req.getParameter("id");
        String set = req.getParameter("set");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/addStudent.jsp");
        requestDispatcher.forward(req, resp);
    }



}
