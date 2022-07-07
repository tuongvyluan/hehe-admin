/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
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
public class MainController extends HttpServlet {

    // Controller param
    private final String STUDENT = "Student";
    private final String AUTHOR = "Author";
    private final String COURSE = "Course";
    private final String VIEW_COURSE = "ViewCourse";
    private final String CREATE_COURSE = "CreateCourse";
    private final String EDIT_COURSE = "EditCourse";
    private final String DELETE_COURSE = "DeleteCourse";
    private final String CREATE_SECTION = "CreateSection";
    private final String EDIT_SECTION = "EditSection";
    private final String DELETE_SECTION = "DeleteSection";
    private final String ADD_SECTION_TO_COURSE = "AddSectionToCourse";
    private final String CREATE_TOPIC = "CreateTopic";
    private final String EDIT_TOPIC = "EditTopic";

    // Controller, Destination String
    private final String ERROR = "error.jsp";
    private final String STUDENT_CONTROLLER = "StudentController";
    private final String AUTHOR_CONTROLLER = "AuthorController";
    private final String COURSE_CONTROLLER = "CourseController";
    private final String SECTION_CONTROLLER = "SectionController";
    private final String STUDENT_IN_COURSE_CONTROLLER = "StudentInCourseController";
    private final String TOPIC_CONTROLLER = "TopicController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        HttpSession session = request.getSession();
        StudentDTO currentStudent = (StudentDTO) session.getAttribute("LOGIN_STUDENT");

        try {
            String controller = request.getParameter("action");
            switch (controller) {
                case STUDENT: {
                    url = STUDENT_CONTROLLER;
                    break;
                }

                case AUTHOR: {
                    url = AUTHOR_CONTROLLER;
                    break;
                }

                case COURSE: {
                    url = COURSE_CONTROLLER;
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

                case EDIT_COURSE: {
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
                
                case DELETE_SECTION: {
                    url = SECTION_CONTROLLER;
                    break;
                }
                
                case ADD_SECTION_TO_COURSE:{
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
