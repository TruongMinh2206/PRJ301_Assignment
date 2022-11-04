/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.lecturer;

import controller.auth.lecturer.BaseAuthenticationController;
import controller.auth.lecturer.BaseAuthorizationController;
import dal.AttendanceDBContext;
import dal.GroupDBContext;
import dal.LecturerDBContext;
import dal.SessionDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.assignment.Attendance;
import model.assignment.Group;
import model.assignment.Session;
import model.assignment.Student;
import model.assignment.Account;

public class list_attendanceController extends BaseAuthorizationController{
 

       protected void processRequest(HttpServletRequest request, HttpServletResponse response, Account account)
    throws ServletException, IOException {
        LecturerDBContext ldb = new LecturerDBContext();
        int lid = ldb.getLecturerAccount(account.getUsername()).getId();
            GroupDBContext gdb = new GroupDBContext();
            ArrayList<Group> groups = gdb.findByGid(lid);
             
             request.setAttribute("groups", groups);
             int gid = Integer.parseInt(request.getParameter("gid"));
            Group group = gdb.get(gid);

            SessionDBContext sesdb = new SessionDBContext();
            ArrayList<Session> sessions = sesdb.getDataSesInGroup(gid);

            StudentDBContext sdb = new StudentDBContext();
            ArrayList<Student> students = sdb.getAllStudentInGroup(gid);

            AttendanceDBContext attdb = new AttendanceDBContext();
            ArrayList<Attendance> atts = attdb.reportAttend(gid);

            request.setAttribute("sessions", sessions);
            request.setAttribute("group", group);
            request.setAttribute("students", students);
            request.setAttribute("atts", atts);
             request.getRequestDispatcher("/view/list_attendance.jsp");
             
             
    }


    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
        processRequest(request, response, account);
    }

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
         processRequest(request, response, account);
    }

}
