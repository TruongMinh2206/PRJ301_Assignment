<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="helper" class="util.DateTimeHelper"/>
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
        
        <c:forEach  items="${requestScope.group.sessions}" var="ses"  begin="0" end="0">
                <b>   Status attendance of group: ${ses.group.name}</b> <br/>
                Lecturer: ${ses.lecturer.name} <br/>
                Subject: ${ses.group.subject.name} <br/>
                Room: ${ses.room.name}
            </c:forEach>

            <table class="table" border="1px">
                <thead>
                <tr class="thead">
                    <th>No.</th>
                    <th>Group</th>
                    <th>Student ID</th>
                    <th>Full Name</th>
                    <c:forEach items="${requestScope.group.sessions}" var="ses" varStatus="loop">
                    <th> Slot ${loop.index+1} <br>
                   
                           
                        </th>
                    </c:forEach>
                    <th>Absent</th>           
                    <th>Count Present</th>
                </tr>
</thead>
                <c:forEach items="${requestScope.group.students}" var="std" varStatus="loop"> 
                     
                    <tr>
                        <c:set var="total" value="0"/>
                    <c:set var="absent" value="0"/>
                        <td>${loop.index+1}</td>
                        <td>${requestScope.group.id}</td>
                        <td>${std.id}</td>                
                        <td>${std.name}</td> 
                        
                        <c:forEach items="${requestScope.group.sessions}" var="a">  
                            <c:forEach items="${a.attandances}" var="b">
                                
                                <c:if test="${b.student.id eq std.id}">
                                    
                                
                                            <c:if test="${b.present}">
                                                <td style="color: green"> P </td>
                                            </c:if> 
                                            <c:if test="${!b.present}">
                                                <td  style="color: red"> A </td>
                                            </c:if>   
                                                
                                    </c:if>            
                            
                      </c:forEach>   
                                                
                                  </c:forEach>  
                                    
                    </c:forEach>    
                                                
                </tr>   
            </table>
                <c:forEach  items="${requestScope.group.sessions}" var="ses"  begin="0" end="0">
                <a style="font-size: 20px" href="timetable?lid=${ses.lecturer.id}">Back</a>
                     </c:forEach>
    </body>
</html>