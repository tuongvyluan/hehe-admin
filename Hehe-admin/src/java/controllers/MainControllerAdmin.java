/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import admin.AdminDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import studentInCourses.StudentInCourseDAO;
import studentInCourses.StudentInCourseModel;
import students.StudentDTO;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "MainControllerAdmin", urlPatterns = {"/MainControllerAdmin"})
public class MainControllerAdmin extends HttpServlet {

    // Controller param
    private final String ADMIN = "Admin";
    private final String STUDENT = "Student";
    private final String AUTHOR = "Author";
    private final String COURSE = "Course";
    private final String LOG_OUT = "LogOut";
    private final String AUTHOR_REGISTER = "RegisterAuthor";
    private final String CHANGE_STATUS = "ChangeStatus";
    private final String CATEGORY = "AddCategory";
    private final String VIEW_CATEGORY = "Category";
    private final String UPDATE = "UpdateCategory";

    // Controller, Destination String
    private final String ERROR = "error.jsp";
    private final String ADMIN_CONTROLLER = "AdminController";
    private final String STUDENT_CONTROLLER = "StudentController";
    private final String AUTHOR_CONTROLLER = "AuthorController";
    private final String COURSE_CONTROLLER = "CourseControllerAdmin";
    private final String CATEGORY_CONTROLLER = "CategoryController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        HttpSession session = request.getSession();

        System.out.println("1");
        try {
            String controller = request.getParameter("controller");
            System.out.println("controller: " + controller);

            switch (controller) {
                case ADMIN: {
                    url = ADMIN_CONTROLLER;
                    break;
                }
                case AUTHOR_REGISTER: {
                    url = ADMIN_CONTROLLER;
                    break;
                }
                case CATEGORY: {
                    url = ADMIN_CONTROLLER;
                    break;
                }
                case LOG_OUT: {
                    url = ADMIN_CONTROLLER;
                    break;
                }
                case VIEW_CATEGORY: {
                    url = CATEGORY_CONTROLLER;
                    break;
                }
                case UPDATE: {
                    url = CATEGORY_CONTROLLER;
                    break;
                }

                case STUDENT: {
                    System.out.println("Admin check case student");
                    url = STUDENT_CONTROLLER;
                    break;
                }
                case AUTHOR: {
                    System.out.println("Admin check case author");
                    url = AUTHOR_CONTROLLER;
                    break;
                }
                case COURSE: {
                    System.out.println("Admin check case course");
                    url = COURSE_CONTROLLER;
                    break;
                }
                case CHANGE_STATUS: {
                    System.out.println("Change status");
                    url = STUDENT_CONTROLLER;
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
