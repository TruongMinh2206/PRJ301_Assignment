/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.lecturer;

import dal.AttendanceDBContext;
import dal.GroupDBContext;
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


public class list_attendanceController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
        int lid = Integer.parseInt(request.getParameter("lid"));
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest( request,response);
//        int sesid = Integer.parseInt(request.getParameter("id"));
//        SessionDBContext sesDB = new SessionDBContext();
//        Session ses = sesDB.get(sesid);
//        request.setAttribute("ses", ses);
//        request.getRequestDispatcher("/view/list_attendance.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest( request,response);
//        Session ses = new Session();
//        ses.setId(Integer.parseInt(request.getParameter("sesid")));
//        String[] stdids = request.getParameterValues("stdid");
//        for (String stdid : stdids) {
//            Attendance a =new Attendance();
//            Student s = new Student();
//            a.setStudent(s);
//            a.setDescription(request.getParameter("description"+stdid));
//            a.setPresent(request.getParameter("present"+stdid).equals("present"));
//            s.setId(Integer.parseInt(stdid));
//            ses.getAttandances().add(a);
//        }
//        SessionDBContext db = new SessionDBContext();
//        db.update(ses);
//        response.sendRedirect("takeatt?id="+ses.getId());
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
