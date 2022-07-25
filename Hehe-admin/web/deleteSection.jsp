<%-- 
    Document   : deleteSection
    Created on : Jul 2, 2022, 5:17:33 PM
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
        <title>Delete Section Page</title>
    </head>
    <body>
        <%@include file="./miniHeader.jsp" %>
        <form action="MainController" method="POST">
            <table>
                <tr>
                    <td>
                        <label>Select a section to delete:</label>
                    </td>
                    <td>
                        <select name="txtSectionToDelete">
                            <%
                            int pageNumber = 1;
                            int rowsOfPage = 200;
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
                    <td>
                        <button type="submit" name="action" value="DeleteSection">Submit</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
