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

public class RegistrationServlet extends HttpServlet {

    public boolean isValidMobileNumber(String mobileNumber) {
        if (mobileNumber == null || mobileNumber.length() != 11) {
            return false; // mobile number should be 11 digits long
        }

        if (!mobileNumber.startsWith("01")) {
            return false; // first two digits should be "01"
        }

        char thirdDigit = mobileNumber.charAt(2);
        if (thirdDigit < '3' || thirdDigit > '9') {
            return false; // third digit should be between 3 and 9 (inclusive)
        }

        // all criteria passed, mobile number is valid
        return true;
    }

    private static final Logger logger = Logger.getLogger(RegistrationServlet.class.getName());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("title", "Registration");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String birthdate = req.getParameter("birthdate");
        String mobile = req.getParameter("mobile");
        String email = req.getParameter("email");
        String dept = req.getParameter("dept");
        //String password = req.getParameter("password");
        //String confirmPassword = req.getParameter("confirm_password");
        boolean flag = true;

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
        boolean temp = isValidMobileNumber(mobile);
        if(!temp){
            req.setAttribute("mobileErrMsg", "Mobile number is not valid");
            flag = false;
        }


            if (flag) {
                try {
                    UserRepository userRepository = new UserRepository();
                    boolean res = userRepository.register(name, age, birthdate, mobile, email,dept );

                    if (res) {
                        req.setAttribute("errMsg", "Registration successful...");
                    }
                    else {
                        req.setAttribute("errMsg", "Registration failed...");
                    }
                } catch (NamingException var9) {
                    logger.log(Level.SEVERE, "Naming exception occurred while accessing UserRepository");
                    logger.log(Level.SEVERE, var9.getMessage());
                } catch (SQLException var10) {
                    logger.log(Level.SEVERE, "SQL exception occurred while accessing UserRepository");
                    logger.log(Level.SEVERE, var10.getMessage());
                }
            }


        req.setAttribute("email", email);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/registration.jsp");
        requestDispatcher.forward(req, resp);
    }
}
