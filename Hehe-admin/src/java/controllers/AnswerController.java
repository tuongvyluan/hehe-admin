/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import answers.AnswerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class AnswerController extends HttpServlet {

    //Action String
    private final String EDIT_ANSWER = "EditAnswer";
    private final String DELETE_ANSWER = "DeleteAnswer";
    private final String ADD_ANSWER_TO_QUIZ = "AddAnswerToQuiz";

    //Destination String
    private final String EDIT_TOPIC_CONTENT = "editTopicContent.jsp";
    private final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String url = "";
            switch (action) {
                case EDIT_ANSWER: {
                    int answerIdToEditAnswer = Integer.parseInt(request.getParameter("answerId"));
                    String answerContent = request.getParameter("txtAnswerToEditOrDelete");
                    boolean answerIsCorrect = Boolean.parseBoolean(request.getParameter("answerIsCorrect"));
                    boolean result = AnswerDAO.editAnswer(answerIdToEditAnswer, answerContent, answerIsCorrect);
                    if (result == true) {
                        url = EDIT_TOPIC_CONTENT;
                    } else {
                        url = ERROR;
                    }
                    break;
                }

                case DELETE_ANSWER: {
                    int answerIdToDeleteAnswer = Integer.parseInt(request.getParameter("answerId"));
                    boolean result = AnswerDAO.deleteAnswer(answerIdToDeleteAnswer);
                    if (result == true) {
                        url = EDIT_TOPIC_CONTENT;
                    } else {
                        url = ERROR;
                    }
                    break;
                }

                case ADD_ANSWER_TO_QUIZ: {
                    int quizIdToAddAnswer = Integer.parseInt(request.getParameter("quizToAddAnswer"));
                    String answerContent = request.getParameter("txtAnswerToAdd");
                    boolean answerIsCorrect = Boolean.parseBoolean(request.getParameter("answerIsCorrect"));
                    boolean result = AnswerDAO.addAnswerToQuiz(quizIdToAddAnswer, answerContent, answerIsCorrect);
                    if (result == true) {
                        url = EDIT_TOPIC_CONTENT;
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
