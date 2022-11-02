/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.assignment;

import java.util.ArrayList;

/**
 *
 * @author Ngo Tung Son
 */
public class Subject {
    private int id;
    private String name;    
    private int numOfSlot;
    private ArrayList<Group> groups = new ArrayList<>();

    public Subject() {
    }

    public Subject(int id, String name, int numOfSlot) {
        this.id = id;
        this.name = name;
        this.numOfSlot = numOfSlot;
    }
    
    public int getId() {
        return id;
    }

    public int getNumOfSlot() {
        return numOfSlot;
    }

    public void setNumOfSlot(int numOfSlot) {
        this.numOfSlot = numOfSlot;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
    
}
