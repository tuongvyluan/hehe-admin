<%-- 
    Document   : addTopicToSection
    Created on : Jul 16, 2022, 11:47:55 PM
    Author     : Harry
--%>

<%@page import="topics.TopicDTO"%>
<%@page import="topics.TopicBUS"%>
<%@page import="sections.SectionDTO"%>
<%@page import="sections.SectionBUS"%>
<%@page import="java.util.ArrayList"%>
<%@page import="courses.CourseDTO"%>
<%@page import="courses.CourseBUS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Topic Page</title>
    </head>
    <body>
        <%@include file="miniHeader.jsp" %>
        <form action="MainController" method="POST">
            <table>
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
                        <select style="width: 175px" name="txtCourseToAddTopic" onchange="location.href = 'addTopicToSection.jsp?courseId=' + this.value;">
                                <option value = 0>Select Course</option>
                            <%
                                for (CourseDTO course : courseList) {
                                    if (request.getParameter("courseId") != null && course.getCourseId() == Integer.parseInt(request.getParameter("courseId"))) {
                            %>
                            <option selected="selected" value="<%= course.getCourseId()%>">
                                <%= course.getCourseId()%> <%= course.getCourseName()%>
                            </option>
                            <%
                            } else {
                            %>
                            <option value="<%= course.getCourseId()%>">
                                <%= course.getCourseId()%> <%= course.getCourseName()%>
                            </option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Section in this course:</th>
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
                        <select style="width: 175px" name ="txtSectionToAddTopic" onchange="location.href = 'addTopicToSection.jsp?courseId=' +${param.courseId} + '&sectionId=' + this.value">
                            <option value = 0>Select Section</option>
                            <%
                                for (SectionDTO section : sectionList) {
                                    if (request.getParameter("sectionId") != null && section.getSectionId() == Integer.parseInt(request.getParameter("sectionId"))) {
                            %>
                            <option selected="selected" value="<%= section.getSectionId()%>">
                                <%= section.getSectionId()%> <%= section.getSectionName()%>
                            </option>
                            <%
                            } else {
                            %>
                            <option value="<%= section.getSectionId()%>">
                                <%= section.getSectionId()%> <%= section.getSectionName()%>
                            </option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Topic in this section:</th>
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
                        <select style="width: 175px" onchange="location.href = 'addTopicToSection.jsp?courseId=' +${param.courseId} + '&sectionId=' +${param.sectionId} + '&topicId=' + this.value">
                            <option value = 0>Select Topic</option>
                            <%
                                for (TopicDTO topic : topicList) {
                                    if (request.getParameter("topicId") != null && topic.getTopicId() == Integer.parseInt(request.getParameter("topicId"))) {
                            %>
                            <option selected="selected" value="<%= topic.getTopicName()%>">
                                <%= topic.getTopicId()%> <%= topic.getTopicName()%>
                            </option>
                            <%
                            } else {
                            %>
                            <option value="<%= topic.getTopicId()%>">
                                <%= topic.getTopicId()%> <%= topic.getTopicName()%>
                            </option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Add topic:</td>
                    <td>
                        <select name="txtTopicToAdd">
                            <% 
                            topicList = topicBUS.getTopics();
                            for (TopicDTO topic : topicList) {
                            %>
                            <option value="<%= topic.getTopicId()%>">
                                <%= topic.getTopicId()%> <%= topic.getTopicName()%>
                            </option>
                            <%        
                            }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                       <button type="submit" name="action" value="AddTopicToSection">Add</button> 
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
