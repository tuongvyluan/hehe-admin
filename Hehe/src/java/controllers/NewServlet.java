/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import courses.CourseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Harry
 */
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            switch (action) {
                case "CreateCourse": {
                    String courseName = request.getParameter("txtCourseName");
                    String courseDescription = request.getParameter("txtCourseDescription");
                    int courseAuthorId = Integer.parseInt(request.getParameter("txtCourseAuthorId"));
//                    int courseAuthorId = 7;
                    int courseCategoryId = Integer.parseInt(request.getParameter("txtCourseCategoryId"));
                    String courseStatus = request.getParameter("txtCourseStatus");
                    double coursePrice = Double.parseDouble(request.getParameter("txtPrice"));
                    int hour = Integer.parseInt(request.getParameter("txtHour"));
                    int minute = Integer.parseInt(request.getParameter("txtMinute"));
                    int second = Integer.parseInt(request.getParameter("txtSecond"));
                    double courseDuration = (hour * 3600 + minute * 60 + second) / 3600;
                    boolean result = CourseDAO.createCourse(courseAuthorId, courseCategoryId, courseName, courseDescription, courseStatus, coursePrice, courseDuration);
                    if (result == true) {
                        response.sendRedirect("home.jsp");
                    } else {
                        response.sendRedirect("error.jsp");
                    }
                    break;
                }

                case "EditCourse": {
                    int courseToEdit = Integer.parseInt(request.getParameter("txtCourseToEdit"));
                    int courseNewCategoryId = Integer.parseInt(request.getParameter("txtCourseNewCategoryId"));
                    String courseNewName = request.getParameter("txtCourseNewName");
                    String courseNewDescription = request.getParameter("txtCourseNewDescription");
                    String courseNewStatus = request.getParameter("txtCourseNewStatus");
                    double courseNewPrice = Double.parseDouble(request.getParameter("txtCourseNewPrice"));
                    int hour = Integer.parseInt(request.getParameter("txtNewHour"));
                    int minute = Integer.parseInt(request.getParameter("txtNewMinute"));
                    int second = Integer.parseInt(request.getParameter("txtNewSecond"));
                    double courseDuration = (double) (hour * 3600 + minute * 60 + second) / 3600;
                    boolean result = CourseDAO.editCourse(courseToEdit, courseNewCategoryId, courseNewName, courseNewDescription, courseNewStatus, courseNewPrice, courseDuration);
                    if (result == true) {
                        response.sendRedirect("home.jsp");
                    } else {
                        response.sendRedirect("error.jsp");
                    }
                    break;
                }
            }

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
