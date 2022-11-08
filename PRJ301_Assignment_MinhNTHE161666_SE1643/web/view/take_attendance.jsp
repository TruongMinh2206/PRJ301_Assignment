

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="helper" class="util.DateTimeHelper"/>
<!DOCTYPE html>
<html>
    <style>
           body {
  font-family: 'Open Sans', sans-serif;
  font-weight: 300;
  line-height: 1.42em;
  color:#A7A1AE;
  background-color:#1F2739;

}
        .thead{
            color: #A7A1AE;
            background-color: #1F2739;
                text-align: center;
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/TakeattCss.css"/>
    </head>
    
    <body>
          <h1>Single activity Attendance</h1>
        Attendance for <span style="font-weight: 700;" > ${requestScope.ses.group.subject.name} </span>
         with lecturer <span style="font-weight: 700;" > ${requestScope.ses.lecturer.name} </span>
         at slot <span style="font-weight: 700;" > ${requestScope.ses.timeslot.description} </span> 
             on date <span style="font-weight: 700;" > ${requestScope.ses.date} </span> ,
             in  <span style="font-weight: 700;" > ${requestScope.ses.room.name}</span> <br>
             <br> 
        Attended: <span style="color: red;"> ${requestScope.ses.attandated?"Yes":"Not Yet"} </span> <br>
        <div class="table">
            <form action="take_attendance" method="POST">
            <input type="hidden" name="sesid" value="${param.id}"/>
            <table border="1px">
                <tr class="thead">
                    <td>No.</td>
                    <td>Student ID</td>
                    <td>Group</td>
                    <td>Full Name</td>
                    <td>Present</td>
                    <td>Absent</td>
                    <td>Description</td>
                    <td>taker</td>
                    
                   
                </tr>
                <c:forEach items="${requestScope.ses.attandances}" var="a" varStatus="loop">
                 <tr>
                    <td>${loop.index+1}</td>
                    <td>${a.student.id}
                    <input type="hidden" name="stdid" value="${a.student.id}"/>
                    </td>
                    <td>${requestScope.ses.group.name}</td>
                    <td>${a.student.name}</td>
                     <c:if test="${(helper.getDateForAtt(a.session.date) >0) and (helper.getDateForAtt(a.session.date) <= 2)}">
                    <td><input type="radio"
                               <c:if test="${a.present}">
                               checked="checked"
                               </c:if>
                               name="present${a.student.id}" value="present" /></td>
                    <td><input type="radio"
                               <c:if test="${!a.present}">
                               checked="checked"
                               </c:if>
                               name="present${a.student.id}" value="absent" /></td>
                    <td><input type="text" name="description${a.student.id}" value="${a.description}" /></td>
                  <td>${requestScope.ses.lecturer.name}</td>

                </tr>   
                     </c:if>
                <c:if test="${helper.getDateForAtt(a.session.date) >2}">
                    <td style="color:green">
                               <c:if test="${a.present}">
                              Present
                              </c:if>
                                </td>
                    <td style="color:red">
                               <c:if test="${!a.present}">
                               Absent
                               </c:if>
                    </td>
                    <td>${a.description}</td>
                     <td>${requestScope.ses.lecturer.name}</td>
                    </c:if>
                </c:forEach>
                
            </table>
            <input type="submit" value="Save"/>
        </form>
        </div>
        
    </body>
</html>
