

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="helper" class="util.DateTimeHelper"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <style>
        body {
  font-family: 'Open Sans', sans-serif;
  font-weight: 200;
  line-height: 1.2em;
  color:#A7A1AE;
  background-color:#1F2739;

}
        
        .nav{
                font-weight: bold;
    font-size: 1em;
  text-align: left;
  color: #185875;
   
            }
            
        
         .attended {
                text-decoration: none;
                color: green;
            }
            .not_yet {
                text-decoration: none;
                color: red;
            }
    </style>
    <body>
        Lecturer: <input type="text" readonly="readonly" value="${requestScope.lecturer.name}"/>
        <form action="timetable" method="GET">
            <input type="hidden" name="lid" value="${param.lid}"/>
            From: <input type="date" name="from" value="${requestScope.from}"/>
            To: <input type="date" name="to" value="${requestScope.to}"/>
            <input type="submit" value="View"/> 
        </form>
        <table class="container" border="1px">
            <tr class="nav">
                <td> </td>
                <c:forEach items="${requestScope.dates}" var="d">
                    <td>${d}<br/>${helper.getDayNameofWeek(d)}</td>
                    </c:forEach>
            </tr>
            <c:forEach items="${requestScope.slots}" var="slot">
                <tr>
                 
                    <td>${slot.description}</td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <td>
                            <c:forEach items="${requestScope.sessions}" var="ses">
                                <c:if test="${helper.compare(ses.date,d) eq 0 and (ses.timeslot.id eq slot.id)}">
                                    <a class="ses" style="color:gray;" href="take_attendance?id=${ses.id}">${ses.group.name}-${ses.group.subject.name}</a>
                                    
                                    <br/>
                                     <a style="color:gray;" href="list_attendance?gid=${ses.group.id}&lid=${ses.lecturer.id}&subid=${ses.group.subject.id}">List</a>
                                    at ${ses.room.name}
                                    <c:if test="${ses.attandated}">
                                        <span class="attended"> (Attended)</span>
                                    </c:if>
                                    <c:if test="${!ses.attandated}">
                                        <span class="not_yet"> (Not Yet) </span>
                                    </c:if>
                                </c:if>
                                  
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
