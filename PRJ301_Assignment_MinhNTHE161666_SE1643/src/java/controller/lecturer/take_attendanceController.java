/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.lecturer;

import controller.auth.lecturer.BaseAuthorizationController;
import dal.SessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.assignment.Account;
import model.assignment.Attendance;
import model.assignment.Session;
import model.assignment.Student;

/**
 *
 * @author sonnt
 */
public class take_attendanceController extends BaseAuthorizationController {
   
    

  

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
        Session ses = new Session();
        ses.setId(Integer.parseInt(request.getParameter("sesid")));
        String[] stdids = request.getParameterValues("stdid");
        for (String stdid : stdids) {
            
            Attendance a =new Attendance();
            Student s = new Student();
            a.setStudent(s);
            a.setDescription(request.getParameter("description"+stdid));
            
            a.setPresent(request.getParameter("present"+stdid).equals("present"));
            s.setId(Integer.parseInt(stdid));
            ses.getAttandances().add(a);
        }
        SessionDBContext db = new SessionDBContext();
        db.update(ses);
        response.sendRedirect("take_attendance?id="+ses.getId());
    }

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
      
         int sesid = Integer.parseInt(request.getParameter("id"));
        SessionDBContext sesDB = new SessionDBContext();
        Session ses = sesDB.get(sesid);
        request.setAttribute("ses", ses);
        request.getRequestDispatcher("/view/take_attendance.jsp").forward(request, response);
    }
      @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
