<%@ page import="students.StudentModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Info</title>
</head>
<body>

        <%
            //Prevent everyone else except Admin go to this page
            StudentModel loginUser = (StudentModel) session.getAttribute("STUDENT");
            /* if (loginUser == null || !loginUser.getRoleID().equals("AD")) {
                response.sendRedirect("login.jsp");
                return;
            } */
        %>
<h1>Hello <%= loginUser %></h1>
</body>
</html>