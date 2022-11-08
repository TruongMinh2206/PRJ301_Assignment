/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.lecturer;

import controller.auth.lecturer.BaseAuthenticationController;
import controller.auth.lecturer.BaseAuthorizationController;
import dal.LecturerDBContext;
import dal.SessionDBContext;
import dal.TimeSlotDBContext;

import dal.TimeSlotDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import model.assignment.Account;
import model.assignment.Lecturer;
import model.assignment.Session;
import model.assignment.TimeSlot;
import util.DateTimeHelper;


public class TimetableController extends BaseAuthorizationController {
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response,Account account)
    throws ServletException, IOException {
        
//        int lid = Integer.parseInt(request.getParameter("lid"));
        int lid = account.getId();
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        java.sql.Date from = null;
        java.sql.Date to = null;
        if(raw_from ==null || raw_from.length() ==0)
        {
            Date today = new Date();
            int todayOfWeek = DateTimeHelper.getDayofWeek(today);
            Date e_from = DateTimeHelper.addDays(today, 2 - todayOfWeek);
            Date e_to = DateTimeHelper.addDays(today, 8-todayOfWeek);
            from = DateTimeHelper.toDateSql(e_from);
            to = DateTimeHelper.toDateSql(e_to);
        }
        else
        {
            from = java.sql.Date.valueOf(raw_from);
            to = java.sql.Date.valueOf(raw_to);
        }
        //request.setAttribute("lid", lid);
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("dates", DateTimeHelper.getDateList(from, to));
        
        TimeSlotDBContext slotDB = new TimeSlotDBContext();
        ArrayList<TimeSlot> slots = slotDB.list();
        request.setAttribute("slots", slots);
        
        SessionDBContext sesDB = new SessionDBContext();
        ArrayList<Session> sessions = sesDB.filter(lid, from, to);
        request.setAttribute("sessions", sessions);
        
        LecturerDBContext lecDB = new LecturerDBContext();
        Lecturer lecturer = lecDB.getInforSes(lid);
        request.setAttribute("lecturer", lecturer);
        
        request.getRequestDispatcher("/view/tabletime.jsp").forward(request, response);
        //response.sendRedirect("tabletime?lid="+lecturer.getId());
       
        //response.sendRedirect("tabletime");
    } 


    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
            processRequest(req, resp, account);
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
            processRequest(req, resp, account);
    }

    
       
  
   
    

    


}
