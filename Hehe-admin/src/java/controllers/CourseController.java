/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import authors.AuthorDTO;
import courses.CourseBUS;
import courses.CourseDAO;
import courses.CourseModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sections.SectionBUS;
import sections.SectionDTO;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "CourseController", urlPatterns = {"/CourseController"})
public class CourseController extends HttpServlet {

    //Action String
    private final String CREATE_COURSE = "CreateCourse";
    private final String EDIT_COURSE = "EditCourse";
    private final String EDIT_COURSE_NAME = "EditCourseName";
    private final String EDIT_COURSE_DURATION = "EditCourseDuration";
    private final String EDIT_COURSE_DESC = "EditCourseDesc";
    private final String EDIT_COURSE_CATEGORY = "EditCourseCategory";
    private final String DELETE_COURSE = "DeleteCourse";

    //Destination String
    private final String ERROR = "error.jsp";
    private final String AUTHOR_HOME_PAGE = "landing.jsp";
    private final String LOGIN_AUTHOR_PAGE = "loginAuthor.jsp";
    private final String EDIT_COURSE_PAGE = "editCourseContent.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            HttpSession session = request.getSession();
            String url = LOGIN_AUTHOR_PAGE;
            if (session != null) {
                AuthorDTO loginAuthor = (AuthorDTO) session.getAttribute("LOGIN_AUTHOR");
                if (loginAuthor != null) {
                    url = AUTHOR_HOME_PAGE;
                    switch (action) {
                        case CREATE_COURSE: {
                            String courseName = request.getParameter("txtCourseName");
                            String courseDescription = request.getParameter("txtCourseDescription");
                            int courseAuthorId = Integer.parseInt(request.getParameter("txtCourseAuthorId"));
                            int courseCategoryId = Integer.parseInt(request.getParameter("txtCourseCategoryId"));
                            double courseDuration = Double.parseDouble(request.getParameter("txtHour"));
                            CourseModel currentCourse = CourseDAO.createCourse(courseAuthorId, courseCategoryId, courseName, courseDescription, "Active", 0, courseDuration);
                            request.setAttribute("CURRENT_COURSE", currentCourse);
                            if (currentCourse != null) {
                                url = EDIT_COURSE_PAGE;
                            } else {
                                url = ERROR;
                            }
                            break;
                        }

                        case EDIT_COURSE: {
                            int courseToEdit = Integer.parseInt(request.getParameter("CourseToEdit"));
                            int courseNewCategoryId = Integer.parseInt(request.getParameter("CourseNewCategoryId"));
                            double courseDuration = Double.parseDouble(request.getParameter("NewHour"));
                            boolean result = CourseDAO.editCourse(courseToEdit, courseNewCategoryId, courseDuration);
                            if (result == true) {
                                url = AUTHOR_HOME_PAGE;
                            } else {
                                url = ERROR;
                            }
                            break;
                        }

                        case EDIT_COURSE_NAME: {
                            int courseToEdit = Integer.parseInt(request.getParameter("CourseToEdit"));
                            String courseNewName = request.getParameter("CourseNewName");
                            boolean result = CourseDAO.editCourseName(courseToEdit, courseNewName);
                            CourseModel currentCourse = CourseDAO.getCurrentCourse(courseToEdit);
                            request.setAttribute("CURRENT_COURSE", currentCourse);
                            if (currentCourse != null) {
                                url = EDIT_COURSE_PAGE;
                            } else {
                                url = ERROR;
                            }
                            break;
                        }

                        case EDIT_COURSE_DURATION: {
                            int courseToEdit = Integer.parseInt(request.getParameter("CourseToEdit"));
                            double courseDuration = Double.parseDouble(request.getParameter("Duration"));
                            boolean result = CourseDAO.editCourseDuration(courseToEdit, courseDuration);
                            CourseModel currentCourse = CourseDAO.getCurrentCourse(courseToEdit);
                            request.setAttribute("CURRENT_COURSE", currentCourse);
                            if (currentCourse != null) {
                                url = EDIT_COURSE_PAGE;
                            } else {
                                url = ERROR;
                            }
                            break;
                        }

                        case EDIT_COURSE_CATEGORY: {
                            int courseToEdit = Integer.parseInt(request.getParameter("CourseToEdit"));
                            int courseCategoryId = Integer.parseInt(request.getParameter("CourseNewCategoryId"));
                            boolean result = CourseDAO.editCourseCategory(courseToEdit, courseCategoryId);
                            CourseModel currentCourse = CourseDAO.getCurrentCourse(courseToEdit);
                            request.setAttribute("CURRENT_COURSE", currentCourse);
                            if (currentCourse != null) {
                                url = EDIT_COURSE_PAGE;
                            } else {
                                url = ERROR;
                            }
                            break;
                        }

                        case EDIT_COURSE_DESC: {
                            int courseToEdit = Integer.parseInt(request.getParameter("CourseToEdit"));
                            String courseDesc = request.getParameter("txtCourseNewDescription");
                            boolean result = CourseDAO.editCourseDesc(courseToEdit, courseDesc);
                            CourseModel currentCourse = CourseDAO.getCurrentCourse(courseToEdit);
                            request.setAttribute("CURRENT_COURSE", currentCourse);
                            if (currentCourse != null) {
                                url = EDIT_COURSE_PAGE;
                            } else {
                                url = ERROR;
                            }
                            break;
                        }

                        case DELETE_COURSE: {
                            int courseToDeleteId = Integer.parseInt(request.getParameter("CourseToDelete"));
                            boolean result = CourseDAO.deleteCourse(courseToDeleteId);
                            if (result == true) {
                                url = AUTHOR_HOME_PAGE;
                            } else {
                                url = ERROR;
                            }
                            break;
                        }
                    }
                }
            }
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
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
