<%-- 
    Document   : editTopic
    Created on : Jul 7, 2022, 2:45:49 PM
    Author     : Harry
--%>

<%@page import="topics.TopicDAO"%>
<%@page import="topics.TopicDTO"%>
<%@page import="topics.TopicBUS"%>
<%@page import="topics.TopicModel"%>
<%@page import="courses.CourseDTO"%>
<%@page import="courses.CourseBUS"%>
<%@page import="sections.SectionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sections.SectionBUS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Topic Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <table>
                <tr>
                    <td>Select topic to start edit:</td>
                    <td>
                        <select name="txtTopicToEdit">
                            <%
                            ArrayList<TopicDTO> topicList = TopicDAO.get();
                            for (TopicDTO topic : topicList) {
                            %>
                            <option value="<%= topic.getTopicId() %>">
                                <%= topic.getTopicName() %>
                            </option>
                            <%        
                            }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>Enter new topic name:</label></td>
                    <td><input type="text" name="txtTopicNewName"></td>
                </tr>
                <tr>
                    <td><label>Enter new topic description:</label></td>
                    <td><textarea name="txtTopicNewDescription"></textarea></td>
                </tr>
                <tr>
                    <td>
                        <label>Choose new topic status:</label>
                    </td>
                    <td>
                        <select name="txtTopicNewStatus">
                            <option value="Active">
                                Available
                            </option>
                            <option value="Unactive">
                                Unavailable
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>Enter new topic display index:</label></td>
                    <td><input type="number" name="txtTopicNewDisplayIndex"></td>
                </tr>
                <tr>
                    <td>Change this topic to section:</td>
                    <td>
                        <select name="txtTopicNewSectionId">
                            <%
                                SectionBUS sectionBUS = new SectionBUS();
                                ArrayList<SectionDTO> sectionList = sectionBUS.get();
                                for (SectionDTO section : sectionList) {
                            %>
                            <option value="<%= section.getSectionId()%>">
                                <%= section.getSectionName()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Change this topic to course:</td>
                    <td>
                        <select name="txtTopicNewCourseId">
                            <%
                                int pageNumber = 1;
                                int rowsOfPage = 200;
                                CourseBUS courseBUS = new CourseBUS();
                                ArrayList<CourseDTO> courseList = courseBUS.getCourses(pageNumber, rowsOfPage);
                                for (CourseDTO course : courseList) {
                            %>
                            <option value="<%= course.getCourseId()%>">
                                <%= course.getCourseName()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><button type="submit" value="EditTopic" name="action">Submit</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
