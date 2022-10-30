/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.assignment.Group;
import model.assignment.Lecturer;
import model.assignment.Session;
import model.assignment.Student;
import model.assignment.Student_Group;

/**
 *
 * @author ADMIN
 */
public class GroupDBContext extends dal.DBContext<Group> {
    public ArrayList<Group> findDataByGname(String gname){
         ArrayList<Group> groups = new ArrayList<>();
        try {
            String sql = "select g.gid, g.gname,s.stdid, s.stdname,ses.date, ses.attanded, lec.lname from [Group] g\n"
                    + "\n"
                    + "INNER JOIN [Student_Group] sg ON sg.gid = g.gid\n"
                    + "INNER JOIN [Student] s ON s.stdid = sg.stdid\n"
                    + "INNER JOIN [Session] ses ON ses.gid = g.gid\n"
                    + "INNER JOIN [Lecturer] lec ON lec.lid = ses.lid\n"
                    + "where  gname = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, gname);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                 Group group= new Group();
                Session ses = new Session();
                Lecturer lec = new Lecturer();
                Student s = new Student();
                Student_Group sg = new Student_Group();
                
                group.setGid(rs.getInt("gid"));
                group.setName(rs.getString("gname"));
                
                ses.setDate(rs.getDate("date"));                
                ses.setAttandated(rs.getBoolean("attanded"));
                
                lec.setId(rs.getInt("lid"));
                lec.setName(rs.getString("lname"));
                group.setLec(lec);

                 s.setId(rs.getInt("stdid"));
                 s.setName(rs.getString("gname"));

                groups.add(group);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;
     }
    
    

    @Override
    public void insert(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Group get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Group> list() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
}
