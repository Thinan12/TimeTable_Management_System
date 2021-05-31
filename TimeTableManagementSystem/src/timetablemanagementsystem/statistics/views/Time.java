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
public class Time {
    
   private int id;
    private String Building;
    private String Room;
    private String day;
    private String StartTime;
    private String Endtime;

    public Time(int id, String Building, String Room, String day, String StartTime, String Endtime) {
        this.id = id;
        this.Building = Building;
        this.Room = Room;
        this.day = day;
        this.StartTime = StartTime;
        this.Endtime = Endtime;
    }

    public Time() {
    }
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuilding() {
        return Building;
    }

    public void setBuilding(String Building) {
        this.Building = Building;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String Room) {
        this.Room = Room;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public String getEndtime() {
        return Endtime;
    }

    public void setEndtime(String Endtime) {
        this.Endtime = Endtime;
    }
    
    
    
}
