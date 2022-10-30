/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.assignment;

/**
 *
 * @author ADMIN
 */
public class Student_Group {
    private int stdid;
    private int gid;

    public Student_Group() {
    }

    public Student_Group(int stdid, int gid) {
        this.stdid = stdid;
        this.gid = gid;
    }

    public int getStdid() {
        return stdid;
    }

    public void setStdid(int stdid) {
        this.stdid = stdid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }
    
}
