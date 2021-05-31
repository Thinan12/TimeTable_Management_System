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
 * @author thina
 */
public class FXMLinterface3Controller implements Initializable {
    
     @FXML
    private TableView<tableviewint3> Int3_tbl;
    @FXML
    private TableColumn<tableviewint3, String> tbcl0;
    @FXML
    private TableColumn<tableviewint3, String> tbcl1;
    @FXML
    private TableColumn<tableviewint3, String> tbcl2;
    @FXML
    private TableColumn<tableviewint3, String> tbcl3;
    @FXML
    private TableColumn<tableviewint3, String> tbcl4;
    
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
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private TextField text3;
    @FXML
    private TextField text4;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         showtableviewint3details(); 
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
    
    
    public ObservableList<tableviewint3> gettableviewint3list(){
        ObservableList<tableviewint3> tableviewint3list = FXCollections.observableArrayList();
        Connection conn = getconnection();
        String query = "SELECT * FROM tableviewobj";
        Statement st;
        ResultSet rs;
          
        try {
            
        st = conn.createStatement();
        rs = st.executeQuery(query);
        tableviewint3 tableviewobj;
        while(rs.next()){
            tableviewobj = new tableviewint3(rs.getString("ID"),rs.getString("LecturersName"), rs.getString("Subjects"), rs.getString("LecturersDate"), rs.getString("SubGroup"));
            tableviewint3list.add(tableviewobj);
            
        }
    }catch (Exception ex){
        ex.printStackTrace();
    }
        return tableviewint3list;
   }
    
    
    public void showtableviewint3details(){
        ObservableList<tableviewint3> list = gettableviewint3list();
        tbcl0.setCellValueFactory(new PropertyValueFactory<tableviewint3 ,String>("ID"));
        tbcl1.setCellValueFactory(new PropertyValueFactory<tableviewint3 ,String>("LecturersName"));
        tbcl2.setCellValueFactory(new PropertyValueFactory<tableviewint3 ,String>("Subjects"));
        tbcl3.setCellValueFactory(new PropertyValueFactory<tableviewint3 ,String>("LecturersDate"));
        tbcl4.setCellValueFactory(new PropertyValueFactory<tableviewint3 ,String>("SubGroup"));
      
        
        Int3_tbl.setItems(list);
        
    }
    
    
    private void InsertRecord(){
        //String query = "INSERT INTO tableviewint3(Year,Semester,Batch,Group,Subgroup) VALUES('"+text1.getText()+"','"+text2.getText()+"','"+text3.getText()+"','"+text4.getText()+"','"+text5.getText()+"')";
        String query = "INSERT INTO tableviewint3(`ID`, `LecturersName`, `Subjects`, `LecturersDate`, `SubGroup`) VALUES(NULL,'"+text1.getText()+"','"+text2.getText()+"','"+text3.getText()+"','"+text4.getText()+"',)";
        executeQuery(query);
        showtableviewint3details();
        searchid = null;
    }
    private void UpdateRecord(){
        String query = "UPDATE tableviewint3 SET `LecturersName` = '" + text1.getText() + "' , `Subjects` = '" + text2.getText() + "', `LecturersDate` = '" + text3.getText() + "', `SubGroup` = '" + text4.getText()+ "', where ID ="+searchid+"";
        executeQuery(query);
        showtableviewint3details();
        searchid = null;
    }
    private void deleteButton(){
        String query = "DELETE FROM tableviewint3 where ID ="+searchid+"";
        executeQuery(query);
        showtableviewint3details();
        searchid = null;
    }
    private void CancelRecord(){
        
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        searchbar.setText("");
        
        showtableviewint3details();
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
        
        ObservableList<tableviewint3> tableviewint3list = FXCollections.observableArrayList();
        Connection conn = getconnection();
        String query = "SELECT * FROM tableviewint3 where ID="+searchid+"";
        Statement st;
        ResultSet rs;
            
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
           
        while(rs.next()){
            text1.setText(rs.getString("LecturersName"));
            text2.setText(rs.getString("Subjects"));
            text3.setText(rs.getString("LecturersDate"));
            text4.setText(rs.getString("SubGroup"));
          
            
        }
        
        }catch (Exception ex){
        ex.printStackTrace();
    }
    }
     
   
}
