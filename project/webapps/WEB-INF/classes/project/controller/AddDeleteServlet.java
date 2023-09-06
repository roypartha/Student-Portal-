package project.controller;

import project.repository.UserRepository;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddDeleteServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(RegistrationServlet.class.getName());
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("title", "Home");

        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/addDelete.jsp");
        //requestDispatcher.forward(req, resp);

        String id = req.getParameter("id");
        String set = req.getParameter("set");

        boolean flag = true;

        // Validate and process the input fields as required

        if (id == null || id.isEmpty()) {
            req.setAttribute("nameErrMsg", "Name is required");
            flag = false;
        }

        if (set == null || set.isEmpty()) {
            req.setAttribute("ageErrMsg", "Age is required");
            flag = false;
        }

        if (flag) {

            try {
                if(set.equals("1")){

                    UserRepository userRepository = new UserRepository();
                    boolean res = userRepository.add(id);

                    if (!res) {

                        req.setAttribute("errMsg", " successful...");
                    }
                    else {

                        req.setAttribute("errMsg", "......... failed...");
                    }
                }
                else if (set.equals("2")){
                    UserRepository userRepository = new UserRepository();
                    boolean res = userRepository.deleteNew(id);
                    if (!res) {

                        req.setAttribute("errMsg", " successful...");
                    }
                    else {

                        req.setAttribute("errMsg", "......... failed...");
                    }
                }else if (set.equals("3")){
                    UserRepository userRepository = new UserRepository();
                    boolean res = userRepository.deleteStudent(id);
                    if (!res) {

                        req.setAttribute("errMsg", " successful...");
                    }
                    else {

                        req.setAttribute("errMsg", "......... failed...");
                    }
                }





            } catch (NamingException var9) {
                logger.log(Level.SEVERE, "Naming exception occurred while accessing UserRepository");
                logger.log(Level.SEVERE, var9.getMessage());
            } catch (SQLException var10) {
                logger.log(Level.SEVERE, "SQL exception occurred while accessing UserRepository");
                logger.log(Level.SEVERE, var10.getMessage());
            }
        }



        if(set.equals("1")||set.equals("2")){

            req.setAttribute("id", id);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/addStudent.jsp");
            requestDispatcher.forward(req, resp);
        } else if (set.equals("3")) {

            req.setAttribute("id", id);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/deleteStudent.jsp");
            requestDispatcher.forward(req, resp);
        }


    }


}
