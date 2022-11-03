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
import model.assignment.Student;

/**
 *
 * @author ADMIN
 */
public class StudentDBContext extends DBContext<Student>{
    
    public ArrayList<Student> getAllStudentInGroup(int gid) {
        ArrayList<Student> stds = new ArrayList<>();
        try{
        String sql = "SELECT S.stdid, stdname\n"
                + "		,G.gid\n"
                + "	FROM Student S\n"
                + "		INNER JOIN Student_Group SG ON S.stdid = SG.stdid\n"
                + "		INNER JOIN [Group] G ON SG.gid = G.gid\n"
                + "		WHERE G.gid = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, gid);
        ResultSet rs = stm.executeQuery();
        while (rs.next()){
            Student s = new Student();
            
            s.setId(rs.getInt("stdid"));
            s.setName(rs.getString("stdname"));
            
            stds.add(s);
        }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stds;
    }

    @Override
    public void insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Student> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
