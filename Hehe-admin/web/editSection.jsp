<%-- 
    Document   : editSection
    Created on : Jul 3, 2022, 2:50:16 PM
    Author     : Harry
--%>

<%@page import="sections.SectionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sections.SectionBUS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Section Page</title>
    </head>
    <body>
        <%@include file="./miniHeader.jsp" %>
        <form action="MainController" method="POST">
            <table>
                <tr>
                    <td><label>Select a section to edit:</label></td>
                    <td>
                        <select name="txtSectionToEdit">
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
                    <td><label>Enter section new name:</label></td>
                    <td><input type="text" name="txtSectionNewName"></td>
                </tr>
                <tr>
                    <td><label>Enter section new description:</label></td>
                    <td><textarea name="txtSectionNewDescription" rows="10" cols="21"></textarea></td>
                </tr>
                <tr>
                    <td><label>Enter section new display index:</label></td>
                    <td><input type="number" name="txtSectionNewDisplayIndex"></td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" name="action" value="EditSection">Submit</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
