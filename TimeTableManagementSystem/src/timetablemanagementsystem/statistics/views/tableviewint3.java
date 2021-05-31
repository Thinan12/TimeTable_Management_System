/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.statistics.views;

/**
 *
 * @author IT18184440 T.E.Kahawandala
 */
public class tableviewint3 {
    private String ID;
    private String LecturersName;
    private String Subjects;
    private String LecturersDate;
    private String SubGroup;

    public tableviewint3(String ID, String LecturersName, String Subjects, String LecturersDate, String SubGroup) {
        this.ID = ID;
        this.LecturersName = LecturersName;
        this.Subjects = Subjects;
        this.LecturersDate = LecturersDate;
        this.SubGroup = SubGroup;
    }

    public String getID() {
        return ID;
    }

    public String getLecturersName() {
        return LecturersName;
    }

    public String getSubjects() {
        return Subjects;
    }

    public String getLecturersDate() {
        return LecturersDate;
    }

    public String getSubGroup() {
        return SubGroup;
    }

    
    
    
    
    
    
    
    
    
}
