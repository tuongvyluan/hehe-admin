<%-- 
    Document   : createQuiz
    Created on : Jul 6, 2022, 1:56:21 PM
    Author     : admin
--%>

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
                        <th>Select Topic:</th>
                            <%
                                int pageNumber = 1;
                                int rowsOfPage = 100;
                                TopicBUS topicBUS = null;
                                topicBUS = new TopicBUS();
                                ArrayList<TopicDTO> topicList = topicBUS.getTopic(pageNumber, rowsOfPage);
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
                                    {
                                %>
                            </select>
                        </td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
