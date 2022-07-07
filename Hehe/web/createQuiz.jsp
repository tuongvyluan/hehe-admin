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
                        <th>Select Course:</th>
                            <%
                                int pageNumber = 1;
                                int rowsOfPage = 100;
                                CourseBUS courseBUS = null;
                                courseBUS = new CourseBUS();
                                CourseDTO courseDTO= new CourseDTO();
                                ArrayList<CourseDTO> courseList = courseBUS.getCourses(pageNumber, rowsOfPage);
                            %>
                        <td>
                        <select name="txtQuizCourseId">
                            <%
                                for (CourseDTO course : courseList) {
                            %>
                            <option value="<%= course.getCourseId()%>">
                                <%= course.getCourseName()%>
                                <% courseDTO=course;%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    </tr>
                    <tr>
                        <th>Select Section:</th>
                            <%
                                SectionBUS sectionBUS = null;
                                sectionBUS = new SectionBUS();
                                SectionDTO sectionDTO = new SectionDTO();
                                ArrayList<SectionDTO> sectionList = sectionBUS.get(courseDTO.getCourseId());
                            %>
                        <td>
                            <select name ="txtQuizSectionId">
                                <%
                                    for (SectionDTO section : sectionList) {
                                %>
                                <option value="<%= section.getSectionId()%>">
                                    <%= section.getSectionName()%>
                                    <% sectionDTO=section;%>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Select Topic:</th>
                            <%
                                TopicBUS topicBUS = null;
                                topicBUS = new TopicBUS();
                                ArrayList<TopicDTO> topicList = topicBUS.get(sectionDTO.getSectionId());
                            %>
                        <td>
                            <select name ="txtQuizTopicId">
                                <%
                                    for (TopicDTO topic : topicList) {
                                %>
                                <option value="<%= topic.getTopicId()%>">
                                    <%= topic.getTopicName()%>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                </thead>
                <tbody>
                     <tr>
                    <td><label>Enter Quiz content:</label></td>
                    <td><textarea name="txtQuizContent" rows="10" cols="21"></textarea></td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" name="action" value="CreateQuiz">Submit</button>
                    </td>
                </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
