/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import admin.AdminDTO;
import courses.CourseDAO;
import courses.CourseModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import studentInCourses.StudentInCourseDAO;
import studentInCourses.StudentInCourseModel;
import students.StudentDTO;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    // Controller param
    private final String ADMIN = "Admin";
    private final String STUDENT = "Student";
    private final String AUTHOR = "Author";
    private final String COURSE = "Course";
    private final String LOGIN_AUTHOR = "LoginAuthor";
    private final String VIEW_COURSE = "ViewCourse";
    private final String CREATE_COURSE = "CreateCourse";
    private final String EDIT_COURSE = "EditCourse";
    private final String EDIT_COURSE_NAME = "EditCourseName";
    private final String EDIT_COURSE_DURATION = "EditCourseDuration";
    private final String EDIT_COURSE_DESC = "EditCourseDesc";
    private final String EDIT_COURSE_CATEGORY = "EditCourseCategory";
    private final String DELETE_COURSE = "DeleteCourse";
    private final String CREATE_SECTION = "CreateSection";
    private final String EDIT_SECTION = "EditSection";
    private final String EDIT_SECTION_NAME = "EditSectionName";
    private final String DELETE_SECTION = "DeleteSection";
    private final String ADD_SECTION_TO_COURSE = "AddSectionToCourse";
    private final String CREATE_TOPIC = "CreateTopic";
    private final String EDIT_TOPIC = "EditTopic";
    private final String EDIT_TOPIC_NAME = "EditTopicName";
    private final String DELETE_TOPIC = "DeleteTopic";
    private final String ADD_TOPIC_TO_SECTION = "AddTopicToSection";
    private final String EDIT_DESCRIPTION = "EditDescription";
    private final String EDIT_QUIZ = "EditQuiz";
    private final String ADD_QUIZ_TO_TOPIC = "AddQuizToTopic";
    private final String EDIT_ANSWER = "EditAnswer";
    private final String DELETE_ANSWER = "DeleteAnswer";
    private final String ADD_ANSWER_TO_QUIZ = "AddAnswerToQuiz";
    private final String LOG_OUT = "Logout";
    private final String CHANGE_PASSWORD = "ChangePassword";
    private final String VIEW_COURSE_TO_EDIT = "ViewCourseToEdit";
    private final String BACK_TO_EDIT_COURSE = "backToEditCourse";

    // Controller, Destination String
    private final String ERROR = "error.jsp";
    private final String AUTHOR_CONTROLLER = "AuthorController";
    private final String AUTHOR_ONLY_CONTROLLER = "AuthorOnlyController";
    private final String COURSE_CONTROLLER = "CourseController";
    private final String SECTION_CONTROLLER = "SectionController";
    private final String STUDENT_IN_COURSE_CONTROLLER = "StudentInCourseController";
    private final String TOPIC_CONTROLLER = "TopicController";
    private final String QUIZ_CONTROLLER = "QuizController";
    private final String ANSWER_CONTROLLER = "AnswerController";
    private final String EDIT_COURSE_CONTENT = "editCourseContent.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        HttpSession session = request.getSession();
        StudentDTO currentStudent = (StudentDTO) session.getAttribute("LOGIN_STUDENT");

        try {
            String action = request.getParameter("action");
            System.out.println(action);
            switch (action) {
                case LOGIN_AUTHOR: {
                    url = AUTHOR_ONLY_CONTROLLER;
                    break;
                }

                case VIEW_COURSE: {
                    if (currentStudent != null) {
                        StudentInCourseDAO studentInCourseDAO = new StudentInCourseDAO();
                        StudentInCourseModel studentCourse
                                = studentInCourseDAO.getModel(currentStudent.getId(),
                                        Integer.parseInt(request.getParameter("courseId")));
                        if (studentCourse != null) {
                            request.setAttribute("STUDENT_COURSE", studentCourse);
                            url = STUDENT_IN_COURSE_CONTROLLER;
                            break;
                        }
                    }
                    url = COURSE_CONTROLLER;
                    break;
                }

                case CREATE_COURSE: {
                    url = COURSE_CONTROLLER;
                    break;
                }

                case VIEW_COURSE_TO_EDIT: {
                    int courseId = Integer.parseInt(request.getParameter("courseId"));
                    CourseModel currentCourse = CourseDAO.getCurrentCourse(courseId);
                    request.setAttribute("CURRENT_COURSE", currentCourse);
                    url = EDIT_COURSE_CONTENT;
                    break;
                }

                case EDIT_COURSE: {
                    url = COURSE_CONTROLLER;
                    break;
                }

                case EDIT_COURSE_NAME: {
                    url = COURSE_CONTROLLER;
                    break;
                }

                case EDIT_COURSE_DURATION: {
                    url = COURSE_CONTROLLER;
                    break;
                }

                case EDIT_COURSE_CATEGORY: {
                    url = COURSE_CONTROLLER;
                    break;
                }

                case EDIT_COURSE_DESC: {
                    url = COURSE_CONTROLLER;
                    break;
                }

                case DELETE_COURSE: {
                    url = COURSE_CONTROLLER;
                    break;
                }

                case CREATE_SECTION: {
                    url = SECTION_CONTROLLER;
                    break;
                }

                case EDIT_SECTION: {
                    url = SECTION_CONTROLLER;
                    break;
                }

                case EDIT_SECTION_NAME: {
                    url = SECTION_CONTROLLER;
                    break;
                }

                case DELETE_SECTION: {
                    url = SECTION_CONTROLLER;
                    break;
                }

                case ADD_SECTION_TO_COURSE: {
                    url = SECTION_CONTROLLER;
                    break;
                }

                case CREATE_TOPIC: {
                    url = TOPIC_CONTROLLER;
                    break;
                }

                case EDIT_TOPIC: {
                    url = TOPIC_CONTROLLER;
                    break;
                }

                case EDIT_TOPIC_NAME: {
                    url = TOPIC_CONTROLLER;
                    break;
                }

                case DELETE_TOPIC: {
                    url = TOPIC_CONTROLLER;
                    break;
                }

                case ADD_TOPIC_TO_SECTION: {
                    url = TOPIC_CONTROLLER;
                    break;
                }

                case EDIT_DESCRIPTION: {
                    url = TOPIC_CONTROLLER;
                    break;
                }

                case EDIT_QUIZ: {
                    url = QUIZ_CONTROLLER;
                    break;
                }

                case ADD_QUIZ_TO_TOPIC: {
                    url = QUIZ_CONTROLLER;
                    break;
                }

                case EDIT_ANSWER: {
                    url = ANSWER_CONTROLLER;
                    break;
                }

                case DELETE_ANSWER: {
                    url = ANSWER_CONTROLLER;
                    break;
                }

                case ADD_ANSWER_TO_QUIZ: {
                    url = ANSWER_CONTROLLER;
                    break;
                }

                case CHANGE_PASSWORD: {
                    url = AUTHOR_ONLY_CONTROLLER;
                    break;
                }

                case BACK_TO_EDIT_COURSE: {
                    int courseId = Integer.parseInt(request.getParameter("courseId"));
                    CourseModel currentCourse = CourseDAO.getCurrentCourse(courseId);
                    request.setAttribute("CURRENT_COURSE", currentCourse);
                    url = EDIT_COURSE_CONTENT;
                    break;
                }

                case LOG_OUT: {
                    url = AUTHOR_ONLY_CONTROLLER;
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
