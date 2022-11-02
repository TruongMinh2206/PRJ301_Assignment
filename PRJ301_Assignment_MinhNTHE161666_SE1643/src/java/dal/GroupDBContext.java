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
import model.assignment.Subject;

/**
 *
 * @author ADMIN
 */
public class GroupDBContext extends dal.DBContext<Group> {

    public ArrayList<Group> findByGid(int gid) {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            String sql = "select g.gid, g.gname, s.subname,s.numOfSlot, lec.lid,lname, g.sem, g.[year] from [Group] g\n"
                    + "\n"
                    + "INNER JOIN Subject s ON s.subid = g.subid\n"
                    + "INNER JOIN Lecturer lec ON lec.lid = g.lid\n"
                    + "where g.lid = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                Subject sub = new Subject();
                Lecturer lec = new Lecturer();
                

                group.setGid(rs.getInt("gid"));
                group.setName(rs.getString("gname"));

                
                lec.setId(rs.getInt("lid"));
                lec.setName(rs.getString("lname"));
                group.setLec(lec);

                sub.setId(rs.getInt("stdid"));
                sub.setName(rs.getString("gname"));
                sub.setNumOfSlot(rs.getInt("numOfSlot"));
                group.setSubject(sub);
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

    public Group get(int gid) {
        try {
            String sql = "select g.gid, g.gname, s.subname,s.numOfSlot, lec.lid,lname, g.sem, g.[year] from [Group] g\n"
                    + "\n"
                    + "INNER JOIN Subject s ON s.subid = g.subid\n"
                    + "INNER JOIN Lecturer lec ON lec.lid = g.lid\n"
                    + "where g.lid = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                Subject sub = new Subject();
                Lecturer lec = new Lecturer();
                

                group.setGid(rs.getInt("gid"));
                group.setName(rs.getString("gname"));

                
                lec.setId(rs.getInt("lid"));
                lec.setName(rs.getString("lname"));
                group.setLec(lec);

                sub.setId(rs.getInt("stdid"));
                sub.setName(rs.getString("gname"));
                sub.setNumOfSlot(rs.getInt("numOfSlot"));
                group.setSubject(sub);
                return group;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Group> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

}
