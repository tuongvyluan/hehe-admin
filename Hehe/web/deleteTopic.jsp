<%-- 
    Document   : deleteTopic
    Created on : Jul 7, 2022, 4:48:39 PM
    Author     : Harry
--%>

<%@page import="topics.TopicDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="topics.TopicDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Topic Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <table>
                <tr>
                    <td>Select topic to delete:</td>
                    <td>
                        <select name="txtTopicIdToDelete">
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
                    <td><button type="submit" name="action" value="DeleteTopic">Delete</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
