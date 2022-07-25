package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import topics.TopicDAO;

public class TopicController extends HttpServlet {

    // Action string:
    private final String CREATE_TOPIC = "CreateTopic";
    private final String EDIT_TOPIC = "EditTopic";
    private final String EDIT_TOPIC_NAME = "EditTopicName";
    private final String DELETE_TOPIC = "DeleteTopic";
    private final String ADD_TOPIC_TO_SECTION = "AddTopicToSection";
    private final String EDIT_DESCRIPTION = "EditDescription";

    // Destination string:
    private final String CREATE_TOPIC_PAGE = "createTopic.jsp";
    private final String EDIT_TOPIC_CONTENT_PAGE = "editTopicContent.jsp";
    private final String EDIT_TOPIC_PAGE = "editTopic.jsp";
    private final String DELETE_TOPIC_PAGE = "deleteTopic.jsp";
    private final String EDIT_COURSE_CONTENT = "editCourseContent.jsp";
    private final String ADD_TOPIC_TO_SECTION_PAGE = "addTopicToSection.jsp";
    private final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String url = "";
            switch (action) {
                case CREATE_TOPIC: {
                    String topicName = request.getParameter("txtTopicName");
                    String topicDescription = "";
                    int topicCourseId = Integer.parseInt(request.getParameter("txtTopicCourseId"));
                    int topicSectionId = Integer.parseInt(request.getParameter("txtTopicSectionId"));
                    int topicDisplayIndex = TopicDAO.getDisplayIndex(topicCourseId, topicSectionId) + 1;
                    String status = "Active";
                    boolean result = TopicDAO.createTopic(topicSectionId, topicCourseId, topicName, topicDescription, status, topicDisplayIndex);
                    if (result == true) {
                        url = EDIT_COURSE_CONTENT;
                    } else {
                        url = ERROR;
                    }
                    break;
                }

                case EDIT_TOPIC: {
                    int topicIdToEdit = Integer.parseInt(request.getParameter("txtTopicToEdit"));
                    String topicName = request.getParameter("txtTopicNewName");
                    String topicDescription = request.getParameter("txtTopicNewDescription");
                    int topicCourseId = Integer.parseInt(request.getParameter("txtTopicNewCourseId"));
                    int topicSectionId = Integer.parseInt(request.getParameter("txtTopicNewSectionId"));
                    String topicStatus = request.getParameter("txtTopicNewStatus");
                    int topicDisplayIndex = Integer.parseInt(request.getParameter("txtTopicNewDisplayIndex"));
                    boolean result = TopicDAO.editTopic(topicIdToEdit, topicSectionId, topicCourseId, topicName, topicDescription, topicStatus, topicDisplayIndex);
                    if (result == true) {
                        url = EDIT_TOPIC_PAGE;
                    } else {
                        url = ERROR;
                    }
                    break;
                }
                
                case EDIT_TOPIC_NAME: {
                    int topicIdToEdit = Integer.parseInt(request.getParameter("TopicToEdit"));
                    String topicName = request.getParameter("txtTopicName");
                    boolean result = TopicDAO.editTopicName(topicIdToEdit, topicName);
                    if (result == true) {
                        url = EDIT_COURSE_CONTENT;
                    } else {
                        url = ERROR;
                    }
                    break;
                }

                case DELETE_TOPIC: {
                    int topicIdToDelete = Integer.parseInt(request.getParameter("TopicToDelete"));
                    boolean result = TopicDAO.deleteTopic(topicIdToDelete);
                    if (result == true) {
                        url = DELETE_TOPIC_PAGE;
                    } else {
                        url = ERROR;
                    }
                    break;
                }

                case ADD_TOPIC_TO_SECTION: {
                    int courseIdToAddTopic = Integer.parseInt(request.getParameter("txtCourseToAddTopic"));
                    int sectionIdToAddTopic = Integer.parseInt(request.getParameter("txtSectionToAddTopic"));
                    int topicIdToAdd = Integer.parseInt(request.getParameter("txtTopicToAdd"));
                    boolean result = TopicDAO.addTopicToSection(courseIdToAddTopic, sectionIdToAddTopic, topicIdToAdd);
                    if (result == true) {
                        url = ADD_TOPIC_TO_SECTION_PAGE;
                    } else {
                        url = ERROR;
                    }
                    out.println("<p>" + result + "</p>");
                    break;
                }

                case EDIT_DESCRIPTION: {
                    int topicIdToEditDescription = Integer.parseInt(request.getParameter("TopicToEditDescription"));
                    String descriptionToAdd = request.getParameter("txtDescriptionToEdit");
                    boolean result = TopicDAO.editDescription(topicIdToEditDescription, descriptionToAdd);
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
