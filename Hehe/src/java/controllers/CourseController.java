    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

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
    private final String VIEW_COURSE = "ViewCourse";
    private final String CREATE_COURSE = "CreateCourse";
    private final String EDIT_COURSE = "EditCourse";
    private final String EDIT_COURSE_NAME = "EditCourseName";
    private final String EDIT_COURSE_DESC = "EditCourseDesc";
    private final String DELETE_COURSE = "DeleteCourse";

    //Destination String
    private final String ERROR = "error.jsp";
    private final String HOME = "home.jsp";
    private final String COURSE = "course.jsp";
    private final String AUTHOR_HOME_PAGE = "landing.jsp";
    private final String CREATE_COURSE_PAGE = "createCourse.jsp";
    private final String EDIT_COURSE_PAGE = "editCourseContent.jsp";
    private final String DELETE_COURSE_PAGE = "deleteCourse.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            HttpSession session = null;
            String url = "";
            switch (action) {
                case CREATE_COURSE: {
                    String courseName = request.getParameter("txtCourseName");
                    String courseDescription = request.getParameter("txtCourseDescription");
                    int courseAuthorId = Integer.parseInt(request.getParameter("txtCourseAuthorId"));
                    int courseCategoryId = Integer.parseInt(request.getParameter("txtCourseCategoryId"));
                    int hour = Integer.parseInt(request.getParameter("txtHour"));
                    int minute = Integer.parseInt(request.getParameter("txtMinute"));
                    int second = Integer.parseInt(request.getParameter("txtSecond"));
                    double courseDuration = (double)(hour * 3600 + minute * 60 + second) / 3600;
                    boolean result = CourseDAO.createCourse(courseAuthorId, courseCategoryId, courseName, courseDescription, "Active", 0, courseDuration);
                    CourseModel currentCourse = CourseDAO.getNewestCourse();
                    session.setAttribute("CURRENT_COURSE", currentCourse);
                    if (result == true) {
                        url = EDIT_COURSE_PAGE;
                    } else {
                        url = ERROR;
                    }
                    break;
                }

                case EDIT_COURSE: {
                    int courseToEdit = Integer.parseInt(request.getParameter("txtCourseToEdit"));
                    int courseNewCategoryId = Integer.parseInt(request.getParameter("txtCourseNewCategoryId"));
                    String courseNewName = request.getParameter("txtCourseNewName");
                    String courseNewDescription = request.getParameter("txtCourseNewDescription");
                    int hour = Integer.parseInt(request.getParameter("txtNewHour"));
                    int minute = Integer.parseInt(request.getParameter("txtNewMinute"));
                    int second = Integer.parseInt(request.getParameter("txtNewSecond"));
                    double courseDuration = (double) (hour * 3600 + minute * 60 + second) / 3600;
                    boolean result = CourseDAO.editCourse(courseToEdit, courseNewCategoryId, courseNewName, courseNewDescription, courseDuration);
                    if (result == true) {
                        url = AUTHOR_HOME_PAGE;
                    } else {
                        url = ERROR;
                    }
                    break;
                }
                
                case EDIT_COURSE_NAME: {
                    int courseToEdit = Integer.parseInt(request.getParameter("txtCourseToEdit"));
                    String courseNewName = request.getParameter("txtCourseNewName");
                    boolean result = CourseDAO.editCourseName(courseToEdit, courseNewName);
                    if (result == true) {
                        url = AUTHOR_HOME_PAGE;
                    } else {
                        url = ERROR;
                    }
                    break;
                }
                
                case EDIT_COURSE_DESC: {
                    int courseToEdit = Integer.parseInt(request.getParameter("CourseToEdit"));
                    String courseDesc = request.getParameter("txtCourseNewDescription");
                    boolean result = CourseDAO.editCourseDesc(courseToEdit, courseDesc);
                    if (result == true) {
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
            request.getRequestDispatcher(url).forward(request, response);
        } catch (SQLException ex) {
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
