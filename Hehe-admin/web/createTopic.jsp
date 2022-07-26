<%-- 
    Document   : createTopic
    Created on : Jul 7, 2022, 11:49:05 AM
    Author     : Harry
--%>

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
        <title>Create Topic Page</title>
    </head>
    <body>
        <%@include file="./miniHeader.jsp" %>
        <form action="MainController" method="POST">
            <table>
                <tr>
                    <td><label>Enter topic name:</label></td>
                    <td><input type="text" name="txtTopicName"></td>
                </tr>
                <tr>
                    <td><label>Enter topic description:</label></td>
                    <td><textarea name="txtTopicDescription"></textarea></td>
                </tr>
                <tr>
                    <td>
                        <label>Choose topic status:</label>
                    </td>
                    <td>
                        <select name="txtTopicStatus">
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
                    <td><label>Enter topic display index:</label></td>
                    <td><input type="number" name="txtTopicDisplayIndex"></td>
                </tr>
                <tr>
                    <td>Add this topic to section:</td>
                    <td>
                        <select name="txtTopicSectionId">
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
                    <td>Add this topic to course:</td>
                    <td>
                        <select name="txtTopicCourseId">
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
                    <td><button type="submit" value="CreateTopic" name="action">Submit</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
