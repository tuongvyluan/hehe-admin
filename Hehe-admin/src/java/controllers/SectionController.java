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
    private final String EDIT_SECTION = "EditSection";
    private final String EDIT_SECTION_NAME = "EditSectionName";
    private final String DELETE_SECTION = "DeleteSection";
    private final String ADD_SECTION_TO_COURSE = "AddSectionToCourse";
    
    // Destination String
    private final String ERROR = "error.jsp";
    private final String CREATE_COURSE_PAGE = "createCourse.jsp";
    private final String EDIT_COURSE_PAGE = "editCourse.jsp";
    private final String EDIT_SECTION_PAGE = "editSection.jsp";
    private final String DELETE_SECTION_PAGE = "deleteSection.jsp";
    private final String EDIT_COURSE_CONTENT = "editCourseContent.jsp";
    private final String ADD_SECTION_TO_COURSE_PAGE = "addSectionToCourse.jsp";

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
                    String sectionDescription = "";
                    String status = "Active";
                    int sectionDisplayIndex = SectionDAO.getDisplayIndex(sectionCourseId) + 1;
                    boolean result = SectionDAO.createSection(sectionCourseId, sectionName, sectionDescription, status, sectionDisplayIndex);
                    if (result == true) {
                        url = EDIT_COURSE_CONTENT;
                    } else {
                        url = ERROR;
                    }
                    break;
                }
                
                case EDIT_SECTION: {
                    int sectionId = Integer.parseInt(request.getParameter("txtSectionToEdit"));
                    String sectionNewName = request.getParameter("txtSectionNewName");
                    String sectionNewDescription = request.getParameter("txtSectionNewDescription");
                    int sectionNewDisplayIndex = Integer.parseInt(request.getParameter("txtSectionNewDisplayIndex"));
                    boolean result = SectionDAO.editSection(sectionId, sectionNewName, sectionNewDescription, sectionNewDisplayIndex);
                    if (result == true) {
                        url = EDIT_SECTION_PAGE;
                    } else {
                        url = ERROR;
                    }
                    break;
                }
                
                case EDIT_SECTION_NAME: {
                    int sectionId = Integer.parseInt(request.getParameter("SectionToEdit"));
                    String sectionNewName = request.getParameter("txtSectionName");
                    boolean result = SectionDAO.editSectionName(sectionId, sectionNewName);
                    if (result == true) {
                        url = EDIT_COURSE_CONTENT;
                    } else {
                        url = ERROR;
                    }
                    break;
                }
                
                case DELETE_SECTION: {
                    int sectionToDelete = Integer.parseInt(request.getParameter("SectionToDelete"));
                    boolean result = SectionDAO.deleteSection(sectionToDelete);
                    if (result == true) {
                        url = EDIT_COURSE_CONTENT;
                    } else {
                        url = ERROR;
                    }
                    break;
                }
                
                case ADD_SECTION_TO_COURSE:{
                    int courseIdToAddSection = Integer.parseInt(request.getParameter("txtCourseToAddSection"));
                    int sectionIdToAdd = Integer.parseInt(request.getParameter("txtSectionToAdd"));
                    boolean result = SectionDAO.AddSectionToCourse(courseIdToAddSection, sectionIdToAdd);
                    if (result == true) {
                        url = ADD_SECTION_TO_COURSE_PAGE;
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
