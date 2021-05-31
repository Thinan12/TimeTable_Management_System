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
public class viewtable {
    
    private String id;
    private String Year;
    private String Semester;
    private String Batch;
    private String Group;
    private String Subgroup;

    public viewtable(String id, String Year, String Semester, String Batch, String Group, String Subgroup) {
        this.id = id;
        this.Year = Year;
        this.Semester = Semester;
        this.Batch = Batch;
        this.Group = Group;
        this.Subgroup = Subgroup;
    }

    viewtable() {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String Batch) {
        this.Batch = Batch;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String Group) {
        this.Group = Group;
    }

    public String getSubgroup() {
        return Subgroup;
    }

    public void setSubgroup(String Subgroup) {
        this.Subgroup = Subgroup;
    }

    
    
            
            
}
