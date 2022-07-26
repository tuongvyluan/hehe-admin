/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import admin.AdminBUS;
import admin.AdminDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import students.StudentBUS;
import students.StudentError;
import students.StudentModel;

/**
 *
 * @author triud
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

    //action
    private final String VIEW_STUDENT = "ViewStudent";
    private final String CHANGE_STATUS = "updateStatusAccount";
    private final String SEARCH = "Search";

//destination
    private final String STUDENT = "studentManagement.jsp";
    private final String LOGIN = "loginAdmin.jsp";
    private final String HOME = "admin.jsp";
    private final String STUDENT_SEARCH = "studentSearchManagement.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            response.setContentType("text/html;charset=UTF-8");
            String url = LOGIN;

            try {
                System.out.println("1");
                HttpSession session = request.getSession();
                AdminDTO admin;
                if (session != null) {
                    admin = (AdminDTO) session.getAttribute("ADMIN");
                    if (admin != null) {
                        url = HOME;
                        AdminBUS adminBUS = new AdminBUS();
                        String message;

                        String action = request.getParameter("action");
                        StudentBUS studentBUS = new StudentBUS();
                        switch (action) {

                            case VIEW_STUDENT: {
                                System.out.println("2");
                                String search = request.getParameter("search");
                                List<StudentModel> list = null;
                                int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
                                int rowsOfPage = Integer.parseInt(request.getParameter("rowsOfPage"));

                                if (search != null && search.isEmpty()) {
                                    list = studentBUS.get(pageNumber, rowsOfPage);
                                }
                                request.setAttribute("STUDENT_LIST", list);
                                url = STUDENT;
                                break;
                            }
                            case CHANGE_STATUS: {
                                int id = Integer.parseInt(request.getParameter("id"));
                                String status = request.getParameter("status");

                                if (status.equalsIgnoreCase("Active")) {
                                    System.out.println("Vào được if nè");
                                    students.StudentDAO.updateStudentStatus(id, "Inactive");
                                } else {
                                    students.StudentDAO.updateStudentStatus(id, "Active");
                                }

                                url = "StudentController?action=ViewStudent&pageNumber=1&rowsOfPage=15&search=";
                                break;
                            }
                            case SEARCH :{
                            String keyword = request.getParameter("txtSearch");
                                List<StudentModel> stu = students.StudentDAO.getStudentBySearch(keyword);
                                if (!stu.isEmpty()) {
                                    request.setAttribute("searchStu", stu);
                                    url = STUDENT_SEARCH;
                                } else {
                                    request.setAttribute("errorNotFound", "User not found!!!");
                                    url = "StudentController?action=ViewStudent&pageNumber=1&rowsOfPage=15&search=";
                                }
                            }
                        }
                    }
                }

            } catch (Exception e) {
                log("Error at MainController: " + e.toString());
            } finally {
                request.getRequestDispatcher(url).forward(request, response);
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
