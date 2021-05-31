/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.statistics.views;

/**
 *
 * @author thina
 */
public class Groups {
    
    private int ID;
    private String group;
    private String startTime;
    private String subGroup;
    private String endTime;
    private String room;
    
    public Groups() {
    }

    public Groups(int ID) {
        this.ID = ID;
    }
    
    public Groups(String group, String startTime, String subGroup, String endTime, String room) {
        
        this.group = group;
        this.startTime = startTime;
        this.subGroup = subGroup;
        this.endTime = endTime;
        this.room = room;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

   

    public String getGroup() {
        return group;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getRoom() {
        return room;
    }

    

    public void setGroup(String group) {
        this.group = group;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
    
    
}
