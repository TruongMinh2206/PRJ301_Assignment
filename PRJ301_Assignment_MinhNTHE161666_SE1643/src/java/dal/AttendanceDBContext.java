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
import model.assignment.Lecturer;
import model.assignment.Session;
import model.assignment.Student;

public class AttendanceDBContext extends DBContext<Attendance> {

    public ArrayList<Attendance> reportAttend(int gid) {
        ArrayList<Attendance> atts = new ArrayList<>();
        try {
            String sql = "SELECT S.stdid, S.stdname,SS.sesid, attanded,A.present\n"
                    + "FROM Student S\n"
                    + "       INNER JOIN Student_Group SG ON S.stdid = SG.stdid\n"
                    + "       INNER JOIN [Group] G ON SG.gid = G.gid\n"
                    + "       INNER JOIN [Session] SS ON SS.gid = G.gid\n"
                    + "       LEFT JOIN Attandance A ON A.stdid = S.stdid AND SS.sesid = A.sesid\n"
                    + "        WHERE G.gid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance att = new Attendance();
                Student s = new Student();
                Session ses = new Session();

                s.setId(rs.getInt("stdid"));
                s.setName(rs.getString("stdname"));
                att.setStudent(s);

                ses.setId(rs.getInt("sesid"));
                ses.setAttandated(rs.getBoolean("attanded"));
                att.setSession(ses);

                att.setPresent(rs.getBoolean("present"));

                atts.add(att);
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
    public Attendance get(int id) {
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
