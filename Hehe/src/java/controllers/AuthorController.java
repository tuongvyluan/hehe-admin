package controllers;

import admin.AdminBUS;
import admin.AdminDTO;
import authors.AuthorDAO;
import authors.AuthorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorController extends HttpServlet {

    private final String LOGIN_AUTHOR = "LoginAuthor";
    private final String LOG_OUT = "Logout";
    private final String CHANGE_PASSWORD = "ChangePassword";

    private final String LOGIN = "loginAuthor.jsp";
    private final String ERROR = "error.jsp";
    private final String AUTHOR_HOME_PAGE = "landing.jsp";
    private final String CHANGE_PASSWORD_PAGE = "changePassword.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = null;
            AdminBUS adminBUS = new AdminBUS();
            String message;
            AuthorDTO author = null;
            String id = request.getParameter("id");
            String action = request.getParameter("action");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String url = null;
            switch (action) {
                case LOGIN_AUTHOR: {
                    session = request.getSession();
                    author = AuthorDAO.loginAuthor(email, password);
                    if (author != null) {
                        session.setAttribute("LOGIN_AUTHOR", author);
                        url = AUTHOR_HOME_PAGE;
                    } else {
                        request.setAttribute("ERROR", "Invalid Username or Password");
                        url = LOGIN;
                    }
                    break;
                }

                case LOG_OUT: {
                    session = request.getSession();
                    if (session != null) {
                        session.invalidate();
                        url = LOGIN;
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
