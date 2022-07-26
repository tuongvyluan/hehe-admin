/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sections.SectionBUS;
import sections.SectionDTO;
import studentInCourses.StudentInCourseModel;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "StudentInCourseController", urlPatterns = {"/StudentInCourseController"})
public class StudentInCourseController extends HttpServlet {

    //Action String
    private final String VIEW_COURSE = "ViewCourse";

    //Destination String
    private final String ERROR = "error.jsp";
    private final String HOME = "home.jsp";
    private final String COURSE = "course.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = HOME;
        StudentInCourseModel studentCourse;
        SectionBUS sectionBUS = new SectionBUS();
        try {
            String action = request.getParameter("action");
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            switch (action) {
                case VIEW_COURSE: {
                    studentCourse = (StudentInCourseModel) request.getAttribute("STUDENT_COURSE");
                    ArrayList<SectionDTO> sections = sectionBUS.getByCourse(courseId);
                    request.setAttribute("STUDENT_COURSE", studentCourse);
                    request.setAttribute("SECTION_LIST", sections);
                    url = COURSE;
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
