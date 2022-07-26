/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import admin.AdminBUS;
import admin.AdminDTO;
import authors.AuthorBUS;
import authors.AuthorDAO;
import authors.AuthorModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import students.StudentBUS;
import students.StudentModel;

/**
 *
 * @author triud
 */
@WebServlet(name = "AuthorController", urlPatterns = {"/AuthorController"})
public class AuthorController extends HttpServlet {
//controller

    private final String VIEW_AUTHOR = "ViewAuthor";
    private final String CHANGE_STATUS = "updateStatusAccount";
    private final String SEARCH = "Search";

//destination
    private final String LOGIN = "loginAdmin.jsp";
    private final String HOME = "admin.jsp";
    private final String AUTHOR = "authorManagement.jsp";
    private final String AUTHOR_SEARCH = "authorSearchManagement.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            response.setContentType("text/html;charset=UTF-8");
            String url = LOGIN;

            try {
                System.out.println("Check admin trong author ne");
                HttpSession session = request.getSession();
                AdminDTO admin;
                if (session != null) {
                    admin = (AdminDTO) session.getAttribute("ADMIN");
                    if (admin != null) {
                        url = HOME;
                        AdminBUS adminBUS = new AdminBUS();
                        String message;

                        String action = request.getParameter("action");
                        AuthorBUS authorBUS = new AuthorBUS();
                        switch (action) {
                            case VIEW_AUTHOR: {
                                System.out.println("Vao Author roi ne");
                                String search = request.getParameter("search");
                                List<AuthorModel> list = null;
                                int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
                                int rowsOfPage = Integer.parseInt(request.getParameter("rowsOfPage"));

                                if (search != null && search.isEmpty()) {
                                    list = authorBUS.get(pageNumber, rowsOfPage);
                                }
                                request.setAttribute("AUTHOR_LIST", list);
                                url = AUTHOR;
                                break;
                            }
                            case CHANGE_STATUS: {
                                int id = Integer.parseInt(request.getParameter("id"));
                                System.out.println("Id so:" + id);
                                String status = request.getParameter("status");

                                if (status.equalsIgnoreCase("Active")) {
                                    System.out.println("Vào được if author nè");
                                    authors.AuthorDAO.updateAuthorStatus(id, "Inactive");
                                } else {
                                    authors.AuthorDAO.updateAuthorStatus(id, "Active");
                                }

                                url = "AuthorController?action=ViewAuthor&pageNumber=1&rowsOfPage=15&search=";
                                break;
                            }
                            case SEARCH: {
                                String keyword = request.getParameter("txtSearch");
                                List<AuthorModel> acc = AuthorDAO.getAuthorBySearch(keyword);
                                if (!acc.isEmpty()) {
                                    request.setAttribute("searchAuth", acc);
                                    url = AUTHOR_SEARCH;
                                } else {
                                    request.setAttribute("errorNotFound", "User not found!!!");
                                    url = "AuthorController?action=ViewAuthor&pageNumber=1&rowsOfPage=15&search=";
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
