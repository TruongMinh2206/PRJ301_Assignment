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
        <link rel="stylesheet" href="css/listatts.css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="listatts.css"/>
    </head>
    <body>
        
        <c:forEach  items="${requestScope.group.sessions}" var="ses"  begin="0" end="0">
                <b>   Status attendance of group: ${ses.group.name}</b> <br/>
                Lecturer: ${ses.lecturer.name} <br/>
                Subject: ${ses.group.subject.name} <br/>
                Room: ${ses.room.name}
            </c:forEach>

            <table class="container" border="1px">
                <thead>
                <tr >
                    <th>No.</th>
                    <th>Group</th>
                    <th>Student ID</th>
                    <th>Full Name</th>
                    
                    <c:forEach items="${requestScope.group.sessions}" var="ses" varStatus="loop">
                    <th> Slot ${loop.index+1} <br>
                   
                           
                        </th>
                    </c:forEach>
                    <th>Absent</th>           
                    
                </tr>
               </thead> 
               <tbody>
                <c:forEach items="${requestScope.group.students}" var="std" varStatus="loop"> 
                     
                    <tr>
                        <c:set var="count" value="0"/>
                    <c:set var="absent" value="0"/>
                        <td>${loop.index+1}</td>
                        <td>${requestScope.group.id}</td>
                        <td>${std.id}</td>                
                        <td>${std.name}</td> 
                        
                        <c:forEach items="${requestScope.group.sessions}" var="a">  
                            <c:set var="count" value="${count+1}"/>
                            <c:forEach items="${a.attandances}" var="b">
                                
                                <c:if test="${b.student.id eq std.id}">
                                    <td>
                                    <c:choose>
                                         <c:when test="${b.present}">
                                                <p style="color: green; font-weight: bold"> P </p>
                                         </c:when>
                                                
                                                <c:when test="${!a.attandated}">
                                                <p style="color: #6b90da; font-weight: bold">  Not yet </p>
                                            </c:when> 
                                            <c:when test="${!b.present}">
                                                <p  style="color: red; font-weight: bold"> A </p>
                                                 <c:set var="absent" value="${absent+1}"/>
                                            </c:when>
                                                
                                    </c:choose>
                                                </td>
                                
                                           
                                                
                                                
                                    </c:if>            
                            
                      </c:forEach>   
                                                
                                  </c:forEach> 
                                        <th>
                                                <c:if test="${absent/count <= 0.2}">
                                       <p style="color:green"> ${absent/count*100}/100%</p>
                                        </c:if>
                                        <c:if test="${absent/count > 0.2}">
                                        <p style="color:red"> ${absent/count*100}/100%</p>
                                        </c:if>
                                    </th>
                    </c:forEach>    
                                                
                </tr>
                </tbody>
            </table>
                
                <c:forEach  items="${requestScope.group.sessions}" var="ses"  begin="0" end="0">
                <a style="font-size: 20px" href="timetable?lid=${ses.lecturer.id}">Back</a>
                     </c:forEach>
    </body>
</html>