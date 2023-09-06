package project.controller;

import project.repository.UserRepository;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Update");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/update1.jsp");
        requestDispatcher.forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        boolean flag = true;
        if (id == null || id.isEmpty()) {
            req.setAttribute("emailErrMsg", "id is required");
            flag = false;
        }

        RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("views/update.jsp");
        requestDispatcher2.forward(req, resp);

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String birthdate = req.getParameter("birthdate");
        String mobile = req.getParameter("mobile");
        String email = req.getParameter("email");
        String dept = req.getParameter("dept");
        String pass = req.getParameter("pass");



// Validate and process the input fields as required

        if (name == null || name.isEmpty()) {
            req.setAttribute("nameErrMsg", "Name is required");
            flag = false;
        }

        if (age == null || age.isEmpty()) {
            req.setAttribute("ageErrMsg", "Age is required");
            flag = false;
        }

        if (birthdate == null || birthdate.isEmpty()) {
            req.setAttribute("birthdateErrMsg", "Birthdate is required");
            flag = false;
        }

        if (mobile == null || mobile.isEmpty()) {
            req.setAttribute("mobileErrMsg", "Mobile number is required");

            flag = false;
        }

        if (email == null || email.isEmpty()) {
            req.setAttribute("emailErrMsg", "Email is required");
            flag = false;
        }




        if (flag) {
            try {
                UserRepository userRepository = new UserRepository();
                boolean res = userRepository.update(id,name, age, birthdate, mobile, email, dept,pass );
                resp.sendRedirect(req.getContextPath() + "/adminDashboard");
                return;

            } catch (NamingException var9) {
                logger.log(Level.SEVERE, "Naming exception occurred while accessing UserRepository");
                logger.log(Level.SEVERE, var9.getMessage());
            } catch (SQLException var10) {
                logger.log(Level.SEVERE, "SQL exception occurred while accessing UserRepository");
                logger.log(Level.SEVERE, var10.getMessage());
            }
        }


        req.setAttribute("id", id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/update1.jsp");
        requestDispatcher.forward(req, resp);


    }
}