/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.statistics.views;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author IT18184440.T.E.Kahawandala
 */
public class FXMLInterface5Controller implements Initializable {

    @FXML
    private TableView<viewtable> Int5_tbl;
    @FXML
    private TableColumn<viewtable, String> tbcl0;
    @FXML
    private TableColumn<viewtable, String> tbcl1;
    @FXML
    private TableColumn<viewtable, String> tbcl2;
    @FXML
    private TableColumn<viewtable, String> tbcl3;
    @FXML
    private TableColumn<viewtable, String> tbcl4;
    @FXML
    private TableColumn<viewtable, String> tbcl5;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private TextField text3;
    @FXML
    private TextField text4;
    @FXML
    private TextField text5;
    @FXML
    private Label Int5_sb;
    @FXML
    private Button btn_insert;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_update;
    @FXML
    private TextField searchbar;
    @FXML
    private Button search;

    /**
     * Initializes the controller class.
     */
    
    String searchid = null;
    @FXML
    private Button clear;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showviewtabledetails();
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        if(event.getSource() == btn_insert){
        InsertRecord();
        CancelRecord();
    }else if(event.getSource() == btn_update){
        if(searchid == null){
            searchbar.setPromptText("PLEASE ENTER ID TO SEARCH");
        }else{
            UpdateRecord();
            CancelRecord();
        }
    }else if (event.getSource() == btn_delete){
        if(searchid == null){
            searchbar.setPromptText("PLEASE ENTER ID TO SEARCH");
        }else{
            deleteButton();
            CancelRecord();
        }
    }else if (event.getSource() == clear){
        CancelRecord();
    }else if (event.getSource() == search){
        if (!(searchbar.getText().isEmpty())){
            SearchRecord();
        }
        else{
            searchbar.setPromptText("PLEASE ENTER ID TO SEARCH");
        }
    }
    }
    
    
    public Connection getconnection(){
         Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetablesystem","root","");
            return conn;
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
}
    
    
    public ObservableList<viewtable> getviewtablelist(){
        ObservableList<viewtable> Viewtablelist = FXCollections.observableArrayList();
        Connection conn = getconnection();
        String query = "SELECT * FROM viewtable";
        Statement st;
        ResultSet rs;
          
        try {
            
        st = conn.createStatement();
        rs = st.executeQuery(query);
        viewtable Viewtable;
        while(rs.next()){
            Viewtable = new viewtable(rs.getString("id"),rs.getString("Year"), rs.getString("Semester"), rs.getString("Batch"), rs.getString("Group"), rs.getNString("Subgroup"));
            Viewtablelist.add(Viewtable);
            
        }
    }catch (Exception ex){
        ex.printStackTrace();
    }
        return Viewtablelist;
   }
    
    
    public void showviewtabledetails(){
        ObservableList<viewtable> list = getviewtablelist();
        tbcl0.setCellValueFactory(new PropertyValueFactory<viewtable ,String>("id"));
        tbcl1.setCellValueFactory(new PropertyValueFactory<viewtable ,String>("Year"));
        tbcl2.setCellValueFactory(new PropertyValueFactory<viewtable ,String>("Semester"));
        tbcl3.setCellValueFactory(new PropertyValueFactory<viewtable ,String>("Batch"));
        tbcl4.setCellValueFactory(new PropertyValueFactory<viewtable ,String>("Group"));
        tbcl5.setCellValueFactory(new PropertyValueFactory<viewtable ,String>("Subgroup"));
        
        
        Int5_tbl.setItems(list);
        
    }
    
    
    private void InsertRecord(){
        //String query = "INSERT INTO viewtable(Year,Semester,Batch,Group,Subgroup) VALUES('"+text1.getText()+"','"+text2.getText()+"','"+text3.getText()+"','"+text4.getText()+"','"+text5.getText()+"')";
        String query = "INSERT INTO viewtable(`id`, `Year`, `Semester`, `Batch`, `Group`, `Subgroup`) VALUES(NULL,'"+text1.getText()+"','"+text2.getText()+"','"+text3.getText()+"','"+text4.getText()+"','"+text5.getText()+"')";
        executeQuery(query);
        showviewtabledetails();
        searchid = null;
    }
    private void UpdateRecord(){
        String query = "UPDATE viewtable SET `Year` = '" + text1.getText() + "' , `Semester` = '" + text2.getText() + "', `Batch` = '" + text3.getText() + "', `Group` = '" + text4.getText()+ "', `Subgroup` = '"+ text5.getText() +"' where id ="+searchid+"";
        executeQuery(query);
        showviewtabledetails();
        searchid = null;
    }
    private void deleteButton(){
        String query = "DELETE FROM viewtable where id ="+searchid+"";
        executeQuery(query);
        showviewtabledetails();
        searchid = null;
    }
    private void CancelRecord(){
        
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        text5.setText("");
        searchbar.setText("");
        
        showviewtabledetails();
    }

    private void executeQuery(String query) {
       Connection conn = getconnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        } 
    
    }
    
    private void SearchRecord() throws SQLException {
        
        searchid = searchbar.getText();
        
        ObservableList<viewtable> viewtablelist = FXCollections.observableArrayList();
        Connection conn = getconnection();
        String query = "SELECT * FROM viewtable where id="+searchid+"";
        Statement st;
        ResultSet rs;
            
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
           
        while(rs.next()){
            text1.setText(rs.getString("Year"));
            text2.setText(rs.getString("Semester"));
            text3.setText(rs.getString("Batch"));
            text4.setText(rs.getString("Group"));
            text5.setText(rs.getString("Subgroup"));
            
        }
        
        }catch (Exception ex){
        ex.printStackTrace();
    }
    }
    
    
}
