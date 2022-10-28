/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.assignment;

import java.util.ArrayList;


public class Account {
    private int id;
    private String username;
    private String password;
    private String displayname;
    private ArrayList<Lecturer> lectures = new ArrayList<>();
    private ArrayList<Role> roles = new ArrayList<>();

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
    
   

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return displayname;
    }

    public void setUsername(String username) {
        this.displayname = username;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    public ArrayList<Lecturer> getLectures() {
        return lectures;
    }

    public void setLectures(ArrayList<Lecturer> lectures) {
        this.lectures = lectures;
    }
    
    
    
    
}
