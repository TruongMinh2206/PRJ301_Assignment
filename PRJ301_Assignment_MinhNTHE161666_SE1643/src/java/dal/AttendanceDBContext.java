/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.assignment.Attendance;
import model.assignment.Group;
import model.assignment.Lecturer;
import model.assignment.Room;
import model.assignment.Session;
import model.assignment.Student;
import model.assignment.Subject;
import model.assignment.TimeSlot;

public class AttendanceDBContext extends DBContext<Attendance> {

    public ArrayList<Attendance> reportAttend(int stdid, Date from, Date to) {
        ArrayList<Attendance> atts = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "                    	ses.sesid,ses.[date],ses.[index],ses.attanded\n"
                    + "						,S.stdid, S.stdname\n"
                    + "						,L.lid, L.lname\n"
                    + "                    	,g.gid,g.gname\n"
                    + "                    	,sub.subid,sub.subname,numbOfSLot\n"
                    + "                    	,r.rid,r.rname\n"
                    + "                    	,t.tid,t.[description]\n"
                    + "						,ISNULL(A.present,0) present\n"
                    + "                    FROM [Session] ses\n"
                    + "							INNER JOIN Lecturer L ON L.lid = SES.lid\n"
                    + "                    		INNER JOIN [Group] g ON g.gid = ses.gid\n"
                    + "							INNER JOIN Student_Group SG ON SG.gid = G.gid\n"
                    + "							INNER JOIN Student S ON S.stdid = SG.stdid\n"
                    + "                    			INNER JOIN [Subject] sub ON sub.subid = g.subid\n"
                    + "                    			INNER JOIN Room r ON r.rid = ses.rid\n"
                    + "                    			INNER JOIN TimeSlot t ON t.tid = ses.tid\n"
                    + "								LEFT JOIN Attandance A ON A.sesid = SES.sesid AND A.stdid = S.stdid\n"
                    + "                    WHERE\n"
                    + "                    S.stdid = ?\n"
                    + "                    AND ses.[date] >= ?\n"
                    + "                   AND ses.[date] <= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
             stm.setInt(1, stdid);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                Session session = new Session();
                Lecturer l = new Lecturer();
                Room r = new Room();
                Group g = new Group();
                TimeSlot t = new TimeSlot();
                Subject sub = new Subject();

                session.setId(rs.getInt("sesid"));
                session.setDate(rs.getDate("date"));
                session.setIndex(rs.getInt("index"));
                session.setAttandated(rs.getBoolean("attanded"));

                l.setId(rs.getInt("lid"));
                l.setName(rs.getString("lname"));
                session.setLecturer(l);

                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                session.setGroup(g);

                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));
                sub.setNumOfSlot(rs.getInt("numOfSlot"));
                g.setSubject(sub);

                r.setId(rs.getInt("rid"));
                r.setName(rs.getString("rname"));
                session.setRoom(r);

                t.setId(rs.getInt("tid"));
                t.setDescription(rs.getString("description"));
                session.setTimeslot(t);

                a.setSession(session);
                a.setPresent(rs.getBoolean("present"));
                atts.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

    @Override
    public void insert(Attendance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Attendance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Attendance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Attendance getInforSes(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Attendance> list() {
        ArrayList<Attendance> attendances = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Session> sessions = new ArrayList<>();
        String sql = "SELECT * FROM Attendance";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                int aid = rs.getInt("aid");
                int sesid = rs.getInt("sesid");
                int stdid = rs.getInt("stdid");
                boolean present = rs.getBoolean("present");
                String des = rs.getString("description");
                a.setId(aid);
                a.setPresent(present);
                a.setDescription(des);

                for (Student s : students) {
                    if (s.getId() == stdid) {
                        Student st = s;
                        a.setStudent(st);
                    }
                }
                for (Session se : sessions) {
                    if (se.getId() == sesid) {
                        Session ses = se;
                        a.setSession(ses);
                    }
                }

                attendances.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return attendances;
    }

}
