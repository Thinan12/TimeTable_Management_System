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
public class Consecative {

    private int id;
    private String Year;
    private String Semmester;
    private String Programe;
    private String Room;
    private String consecutivesession;

    public Consecative(int id, String Year, String Semmester, String Programe, String Room, String consecutivesession) {
        this.id = id;
        this.Year = Year;
        this.Semmester = Semmester;
        this.Programe = Programe;
        this.Room = Room;
        this.consecutivesession = consecutivesession;
    }

    Consecative() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getSemmester() {
        return Semmester;
    }

    public void setSemmester(String Semmester) {
        this.Semmester = Semmester;
    }

    public String getPrograme() {
        return Programe;
    }

    public void setPrograme(String Programe) {
        this.Programe = Programe;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String Room) {
        this.Room = Room;
    }

    public String getConsecutivesession() {
        return consecutivesession;
    }

    public void setConsecutivesession(String consecutivesession) {
        this.consecutivesession = consecutivesession;
    }

}
