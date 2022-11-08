

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
 

      protected void processRequest(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
          int gid = Integer.parseInt(req.getParameter("gid"));
        int lid = Integer.parseInt(req.getParameter("lid"));
        int subid = Integer.parseInt(req.getParameter("subid"));
     
        if(req.getParameter("sesid") != null){
             int sesid = Integer.parseInt(req.getParameter("sesid"));
            SessionDBContext sesdb = new SessionDBContext();
            Session ses = sesdb.getInforSes(sesid);
            req.setAttribute("ses", ses);
        }
        GroupDBContext gdb = new GroupDBContext();
        Group group = gdb.listInGoups(gid, lid, subid);
        
        req.setAttribute("group", group);
        req.getRequestDispatcher("/view/list_attendance.jsp").forward(req, resp);
    }

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        processRequest(req,resp,account);
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
         processRequest(req,resp,account);
       
    }
}
