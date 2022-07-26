/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import admin.AdminBUS;
import admin.AdminDAO;
import admin.AdminDTO;
import admin.AdminModels;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.dbcp.pool2.PoolUtils;

/**
 *
 * @author triud
 */
@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {

    // Action String
    private final String ADMIN = "Admin";
    private final String LOGIN_ADMIN = "LoginAdmin";
    private final String MANAGE_STUDENT = "ManageStudent";
    private final String MANAGE_AUTHOR = "ManageAuthor";
    private final String MANAGE_COURSE = "ManageCourse";
    private final String LOG_OUT = "LogOut";
    private final String REGISTER_AUTHOR = "RegisterAuthor";
    private final String CATEGORY = "AddCategory";

    // Destination String
    private final String ERROR = "error.jsp";
    private final String LOGIN = "loginAdmin.jsp";
    private final String HOME = "admin.jsp";
    private final String STUDENT = "studentManagement.jsp";
    private final String AUTHOR = "authorManagement.jsp";
    private final String COURSE = "courseManagement.jsp";
    private final String AUTHOR_REGISTER = "registerAuthor.jsp";
    private final String ADD_CATEGORY = "addCategory.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN;

        try {
            System.out.println("1");
            HttpSession session;
            AdminBUS adminBUS = new AdminBUS();
            String message;
            AdminDTO admin;
            String error = null;
            String action = request.getParameter("action");
            String id = request.getParameter("id");

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            switch (action) {

                case LOGIN_ADMIN: {
                    System.out.println("2");
                    session = request.getSession();
                    admin = AdminDAO.getAdmin(email, password);
                    if (admin != null) {
                        session.setAttribute("ADMIN", admin);
                        System.out.println("3");
                        url = HOME;
                    } else {
                        request.setAttribute("error", "Invalid Username or Password");
                        url = LOGIN;
                    }
                    break;
                }
                case LOG_OUT: {
                    session = request.getSession();
                    if (session != null) {
                        session.invalidate();
                        url = LOGIN;
                    }

                    break;
                }
                case REGISTER_AUTHOR: {
                    session = request.getSession();
                    String authorEmail = request.getParameter("txtemail");
                    String authorPassword = request.getParameter("txtpassword");
                    String status = "Active";
                    String firstName = request.getParameter("txtfirstName");
                    String lastName = request.getParameter("txtlastName");
                    String phone = request.getParameter("txtphoneNumber");
                    if (!authorEmail.isEmpty() && !authorPassword.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !phone.isEmpty()) {
                        if (authors.AuthorDAO.createAuthor(firstName, lastName, authorEmail, status, phone, authorPassword)) {
                            url = HOME;
                        } else {
                            request.setAttribute("errorAuthor", "Create failed");
                            url = AUTHOR_REGISTER;
                        }
                    } else {
                        request.setAttribute("errorAuthor", "Input cannot be empty");
                        url = AUTHOR_REGISTER;
                    }
                    break;
                }

                case CATEGORY: {
                    session = request.getSession();
                    String name = request.getParameter("txtname");
                    String description = request.getParameter("txtdescription");
                    String status = "Active";
                    if (!name.isEmpty() && !description.isEmpty()) {
                        if (categories.CategoryDAO.createCAtegory(name, description, status)) {
                            url = HOME;
                        } else {
                            request.setAttribute("errorCategory", "Create failed");
                            url = ADD_CATEGORY;
                        }
                    } else {
                        request.setAttribute("errorCategory", "Input cannot be empty");
                        url = ADD_CATEGORY;
                    }
                    break;
                }
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
