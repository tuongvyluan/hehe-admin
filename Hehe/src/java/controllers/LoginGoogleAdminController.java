/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import accessGoogle.GooglePojo;
import accessGoogle.GoogleUtils;
import admin.AdminBUS;
import admin.AdminDAO;
import admin.AdminDTO;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.http.HttpSession;
import students.StudentBUS;
import students.StudentError;
import students.StudentModel;

@WebServlet("/login-google-admin")
public class LoginGoogleAdminController extends HttpServlet {

    private final String HOME = "home.jsp";
    private final String ADMIN_HOME_PAGE = "admin.jsp";
    private final String LOGIN = "loginAdmin.jsp";

    private static final long serialVersionUID = 1L;

    public LoginGoogleAdminController() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN;
        try {
            String code = request.getParameter("code");
            System.out.println(code);
            if (code == null || code.isEmpty()) {
                RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
                dis.forward(request, response);
            } else {
                String accessToken = GoogleUtils.getTokenAdmin(code);
                GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
                String email = googlePojo.getEmail();
                System.out.println(googlePojo.toString());
                AdminDTO admin = null;
                AdminBUS adminBUS = new AdminBUS();
                admin = AdminDAO.loginAdmin(email);
                if (admin == null) {
                    url = LOGIN;
                } else {
                    url = ADMIN_HOME_PAGE;
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_ADMIN", admin);
                }
            }
        } catch (IOException | ServletException e) {
            System.out.println("Error at LoginGoogleAdminController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
