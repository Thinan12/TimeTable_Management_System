/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.statistics.views;

import java.sql.Date;

/**
 *
 * @author thina
 */
public class BuildingNRooms {

    private int id;
    private String building;
    private String room;
    private String tag;
    private Date day;

    public BuildingNRooms() {
    }

    public BuildingNRooms(int id, String building, String room, String tag, Date day) {
        this.id = id;
        this.building = building;
        this.room = room;
        this.tag = tag;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

}
