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

public class ForgetPasswordServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ChangePasswordServlet.class.getName());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Forget Password");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/takeMail.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String id = req.getParameter("id");

        boolean flag = true;

        if (email == null || email.isEmpty()) {
            req.setAttribute("currentPasswordErrMsg", "Please fill up the current password");
            flag = false;
        }

        if (id == null || id.isEmpty()) {
            req.setAttribute("newPasswordErrMsg", "Please fill up the new password");
            flag = false;
        }




            if (flag) {
                try {
                  //  HttpSession httpSession = req.getSession();
                    UserRepository userRepository = new UserRepository();
                    boolean res = userRepository.CheckEmailId(email,id);
                    if (!res) {

                        req.setAttribute("title", "Forget Password");
                        resp.sendRedirect(req.getContextPath() + "/updatePassword");
                        return;
                    }
                    else {
                        req.setAttribute("errMsg", "Wrong Email or ID");
                    }
                } catch (NamingException var9) {
                    logger.log(Level.SEVERE, "Naming exception occurred while accessing UserRepository");
                    logger.log(Level.SEVERE, var9.getMessage());
                } catch (SQLException var10) {
                    logger.log(Level.SEVERE, "SQL exception occurred while accessing UserRepository");
                    logger.log(Level.SEVERE, var10.getMessage());
                }
            }
                resp.sendRedirect(req.getContextPath() + "/login");
        }

    }

