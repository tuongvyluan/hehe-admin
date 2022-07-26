/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import admin.AdminBUS;
import admin.AdminDTO;
import categories.CategoryBUS;
import categories.CategoryDAO;
import categories.CategoryModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/CategoryController"})
public class CategoryController extends HttpServlet {

    private final String VIEW_CATEGORY = "ViewCategory";
    private final String CHANGE_STATUS = "updateStatusAccount";
    private final String SEARCH = "Search";
    private final String UPDATE = "updateData";
    private final String UPDATE_CATE = "UpdateCategory";

    private final String LOGIN = "loginAdmin.jsp";
    private final String HOME = "admin.jsp";
    private final String CATEGORY = "categoryManagement.jsp";
    private final String CATEGORY_SEARCH = "categorySearchManagement.jsp";
    private final String UPDATE_PAGE = "updateCategory.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            response.setContentType("text/html;charset=UTF-8");
            String url = LOGIN;

            try {
                System.out.println("Check admin trong course ne");
                HttpSession session = request.getSession();
                AdminDTO admin;
                if (session != null) {
                    admin = (AdminDTO) session.getAttribute("ADMIN");
                    if (admin != null) {
                        url = HOME;
                        AdminBUS adminBUS = new AdminBUS();
                        String message;

                        String action = request.getParameter("action");
                        CategoryBUS categoryBUS = new CategoryBUS();
                        switch (action) {
                            case VIEW_CATEGORY: {
                                System.out.println("Vao Category roi ne");
                                String search = request.getParameter("search");
                                List<CategoryModel> list = null;
                                int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
                                int rowsOfPage = Integer.parseInt(request.getParameter("rowsOfPage"));

                                if (search != null && search.isEmpty()) {
                                    list = categoryBUS.getCategories(pageNumber, rowsOfPage);
                                }
                                request.setAttribute("CATEGORY_LIST", list);
                                url = CATEGORY;
                                break;
                            }
                            case CHANGE_STATUS: {
                                int id = Integer.parseInt(request.getParameter("id"));
                                System.out.println("Id so:" + id);
                                String status = request.getParameter("status");

                                if (status.equalsIgnoreCase("Active")) {
                                    System.out.println("Vào được if course nè");
                                    CategoryDAO.updateCategoryStatus(id, "Inactive");
                                } else {
                                    CategoryDAO.updateCategoryStatus(id, "Active");
                                }

                                url = "CategoryController?action=ViewCategory&pageNumber=1&rowsOfPage=15&search=";
                                break;
                            }
                            case SEARCH: {
                                String keyword = request.getParameter("txtSearch");
                                List<CategoryModel> cate = CategoryDAO.getCategoryBySearch(keyword.trim());
                                if (!cate.isEmpty()) {
                                    request.setAttribute("searchCate", cate);
                                    url = CATEGORY_SEARCH;
                                } else {
                                    request.setAttribute("errorNotFound", "Category not found!!!");
                                    url = "CategoryController?action=ViewCategory&pageNumber=1&rowsOfPage=15&search=";
                                }
                                break;
                            }

                           
                            case UPDATE_CATE: {
                                session = request.getSession();
                                String name = request.getParameter("cateName");
                                String description = request.getParameter("cateDes");
                                int id = Integer.parseInt(request.getParameter("cateId"));
                                if (!name.isEmpty() && !description.isEmpty()) {
                                    if (categories.CategoryDAO.updateCategory(id, name, description)) {
                                        
                                    } else {
                                        request.setAttribute("errorCategory", "Update failed");
                                        url = CATEGORY;
                                    }
                                } else {
                                    request.setAttribute("errorCategory", "Input cannot be empty");
                                    url = CATEGORY;
                                }
                                url = "CategoryController?action=ViewCategory&pageNumber=1&rowsOfPage=15&search=";
                                break;
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
