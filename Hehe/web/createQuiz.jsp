<%-- 
    Document   : createQuiz
    Created on : Jul 6, 2022, 1:56:21 PM
    Author     : admin
--%>

<%@page import="courses.CourseDTO"%>
<%@page import="courses.CourseBUS"%>
<%@page import="sections.SectionDTO"%>
<%@page import="sections.SectionBUS"%>
<%@page import="topics.TopicDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="topics.TopicBUS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Quiz</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <table>
                <thead>
                    <tr>
                        <th>Course:</th>
                            <%
                                int pageNumber = 1;
                                int rowsOfPage = 100;
                                CourseBUS courseBUS = null;
                                courseBUS = new CourseBUS();
                                CourseDTO courseDTO = new CourseDTO();
                                ArrayList<CourseDTO> courseList = courseBUS.getCourses(pageNumber, rowsOfPage);
                            %>
                        <td>
                            <select style="width: 175px" txtQuizCourseId" name="txtQuizCourseId" onchange="location.href = 'createQuiz.jsp?courseId=' + this.value;">
                                <option value = 0>Select Course</option>
                                <%
                                    for (CourseDTO course : courseList) {
                                        if (request.getParameter("courseId") != null && course.getCourseId() == Integer.parseInt(request.getParameter("courseId"))) {
                                %>
                                <option selected="selected" value="<%= course.getCourseId()%>">
                                    <%= course.getCourseName()%>
                                </option>
                                <%
                                } else {
                                %>
                                <option value="<%= course.getCourseId()%>">
                                    <%= course.getCourseName()%>
                                </option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Section:</th>
                            <%
                                SectionBUS sectionBUS = null;
                                sectionBUS = new SectionBUS();
                                ArrayList<SectionDTO> sectionList = null;
                                if (request.getParameter("courseId") != null) {
                                    int courseId = Integer.parseInt(request.getParameter("courseId"));
                                    sectionList = sectionBUS.getByCourse(courseId);
                                } else {
                                    sectionList = sectionBUS.getByCourse(0);
                                }
                            %>
                        <td>
                            <select style="width: 175px" id="txtQuizSectionId" name ="txtQuizSectionId" onchange="location.href = 'createQuiz.jsp?courseId=' +${param.courseId} + '&sectionId=' + this.value">
                                <option value = 0>Select Section</option>
                                <%
                                    for (SectionDTO section : sectionList) {
                                        if (request.getParameter("sectionId") != null && section.getSectionId() == Integer.parseInt(request.getParameter("sectionId"))) {
                                %>
                                <option selected="selected" value="<%= section.getSectionId()%>">
                                    <%= section.getSectionName()%>
                                </option>
                                <%
                                } else {
                                %>
                                <option value="<%= section.getSectionId()%>">
                                    <%= section.getSectionName()%>
                                </option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Topic:</th>
                            <%
                                TopicBUS topicBUS = null;
                                topicBUS = new TopicBUS();
                                ArrayList<TopicDTO> topicList = null;
                                if (request.getParameter("sectionId") != null) {
                                    int sectionId = Integer.parseInt(request.getParameter("sectionId"));
                                    topicList = topicBUS.getBySection(sectionId);
                                } else {
                                    topicList = topicBUS.getBySection(0);
                                }
                            %>
                        <td>
                            <select style="width: 175px" id="txtQuizTopicId" name ="txtQuizTopicId" onchange="location.href = 'createQuiz.jsp?courseId=' +${param.courseId} + '&sectionId=' +${param.sectionId} + '&topicId=' + this.value">
                                <option value = 0>Select Topic</option>
                                <%
                                    for (TopicDTO topic : topicList) {
                                        if (request.getParameter("topicId") != null && topic.getTopicId() == Integer.parseInt(request.getParameter("topicId"))) {
                                %>
                                <option selected="selected" value="<%= topic.getTopicName()%>">
                                    <%= topic.getTopicName()%>
                                </option>
                                <%
                                } else {
                                %>
                                <option value="<%= topic.getTopicId()%>">
                                    <%= topic.getTopicName()%>
                                </option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><label for="quiz">Quiz content:</label></td>
                        <td><textarea id="quiz" name="txtQuizContent" rows="10" cols="21" placeholder="Write down your quiz here..."></textarea></td>
                    </tr>
                    <tr>
                        <td>
                            <button type="submit" name="action" value="CreateQuiz">Create quiz</button>
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
