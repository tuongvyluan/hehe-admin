/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quizzes.QuizDAO;

/**
 *
 * @author admin
 */
public class QuizController extends HttpServlet {

    //Action String
    private final String EDIT_QUIZ = "EditQuiz";
    private final String ADD_QUIZ_TO_TOPIC = "AddQuizToTopic";

    //Destination String
    private final String EDIT_TOPIC_CONTENT_PAGE = "editTopicContent.jsp";
    private final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String url = "";
            switch (action) {
                case EDIT_QUIZ: {
                    String quizContent = request.getParameter("txtQuizToEdit");
                    int topicIdToEditQuiz = Integer.parseInt(request.getParameter("TopicToEditQuiz"));
                    boolean result = QuizDAO.editQuiz(topicIdToEditQuiz, quizContent);
                    if (result == true) {
                        url = EDIT_TOPIC_CONTENT_PAGE;
                    } else {
                        url = ERROR;
                    }
                    break;
                }

                case ADD_QUIZ_TO_TOPIC: {
                    String quizContent = request.getParameter("txtQuizToAdd");
                    int topicIdToAddQuiz = Integer.parseInt(request.getParameter("TopicToAddQuiz"));
                    boolean result = QuizDAO.addQuiz(topicIdToAddQuiz, quizContent);
                    if (result == true) {
                        url = EDIT_TOPIC_CONTENT_PAGE;
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
