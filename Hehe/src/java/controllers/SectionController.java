/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sections.SectionDAO;

/**
 *
 * @author Harry
 */
public class SectionController extends HttpServlet {
    
    // Action String
    private final String CREATE_SECTION = "CreateSection";
    private final String DELETE_SECTION = "DeleteSection";
    
    // Destination String
    private final String ERROR = "error.jsp";
    private final String EDIT_COURSE_PAGE = "editCourse.jsp";
    private final String DELETE_SECTION_PAGE = "deleteSection.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String url = "";
            switch(action){
                case CREATE_SECTION: {
                    int sectionCourseId = Integer.parseInt(request.getParameter("txtSectionCourseId"));
                    String sectionName = request.getParameter("txtSectionName");
                    String sectionDescription = request.getParameter("txtSectionDescription");
                    int sectionDisplayIndex = Integer.parseInt(request.getParameter("txtSectionDisplayIndex"));
                    boolean result = SectionDAO.createSection(sectionCourseId, sectionName, sectionDescription, sectionDisplayIndex);
                    if (result == true) {
                        url = EDIT_COURSE_PAGE;
                    } else {
                        url = ERROR;
                    }
                    break;
                }
                
                case DELETE_SECTION: {
                    int sectionToDelete = Integer.parseInt(request.getParameter("txtSectionToDelete"));
                    boolean result = SectionDAO.deleteSection(sectionToDelete);
                    if (result == true) {
                        url = DELETE_SECTION_PAGE;
                    } else {
                        url = ERROR;
                    }
                    break;
                }
            }
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
