<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="list.css"/>
    </head>
    <body>
        
        <form action="list_attendance" method="GET">
             <input type="hidden" name="lid" value="${param.lid}"/>
             List attendance of 
             <select name="gid">
                 <c:forEach items="${requestScope.groups}" var="group">
                    <option
                        <c:if test="${requestScope.group.id eq group.id}">
                            selected="selected"
                        </c:if>
                        value="${group.id}">${group.name} </option>
                </c:forEach>
                    
            </select>
        </form>
    </body>
</html>