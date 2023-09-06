package project.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("title", "Home");
        String dept = req.getParameter("dept");

        if(dept.equals("cse")){
            System.out.println("CSE");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/studentListCse.jsp");
            requestDispatcher.forward(req, resp);
        }
        else if(dept.equals("eee")){
            System.out.println("EEE");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/studentListEee.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

}
