/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.statistics.views;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author thina
 */
public class BuildingRooms implements Initializable {

    @FXML
    private DatePicker S2text4;

    @FXML
    private TableView<BuildingNRooms> Int5_tbl;

    @FXML
    private TableColumn<BuildingNRooms, String> tbcl0;

    @FXML
    private TableColumn<BuildingNRooms, String> tbcl1;

    @FXML
    private TableColumn<BuildingNRooms, String> tbcl2;

    @FXML
    private TableColumn<BuildingNRooms, Integer> tbclID;
    
    @FXML
    private TextField S2text1;

    @FXML
    private TextField S2text3;

    @FXML
    private TextField S2text2;


    @FXML
    private TableColumn<BuildingNRooms, Date> tbcl3;

    @FXML
    private Button S2_clear;

    @FXML
    private TextField searchbar;

    @FXML
    private Button S2btn_delete;

    @FXML
    private Button S2btn_insert;

    @FXML
    private Button S2btn_update;
    @FXML
    private Button searchId;
    String searchid = null;

    @FXML
    void handleButtonAction(ActionEvent event) throws SQLException {
        
        if(event.getSource() == S2btn_update){
            System.out.println("chech Update button");
            if(searchid == null){
                searchbar.setPromptText("PLEASE ENTER ID TO SEARCH");
            }else{
                updateRecord();
                clear();
            }
        }else if (event.getSource() == S2btn_delete){
        if(searchid == null){
            searchbar.setPromptText("PLEASE ENTER ID TO SEARCH");
        }else{
            DeleteRecord();
            clear();
        }
    }else if (event.getSource() == S2_clear){
        clear();
    }else if (event.getSource() == searchId){
        if (!(searchbar.getText().isEmpty())){
            SearchRecord();
        }
        else{
            searchbar.setPromptText("PLEASE ENTER ID TO SEARCH");
        }
    }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populate();

        S2btn_insert.setOnAction((event) -> {
            bookBuilding();
            populate();
            clear();
        });

        S2_clear.setOnAction((event)->{
            clear();
        });
    }

    private void populate() {
        tbclID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcl0.setCellValueFactory(new PropertyValueFactory<>("building"));
        tbcl1.setCellValueFactory(new PropertyValueFactory<>("room"));
        tbcl2.setCellValueFactory(new PropertyValueFactory<>("tag"));
        tbcl3.setCellValueFactory(new PropertyValueFactory<>("day"));

        Int5_tbl.getItems().setAll(getAllocations());
    }

    private void bookBuilding() {
        String query = "INSERT INTO building_allocations (building, room, tag, day) VALUES(?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement prepS = null;

        connection = getconnection();
        try {
            prepS = connection.prepareStatement(query);

            prepS.setString(1, S2text1.getText());
            prepS.setString(2, S2text2.getText());
            prepS.setString(3, S2text3.getText());
            prepS.setDate(4, Date.valueOf(S2text4.getValue()));

            prepS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BuildingRooms.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private List<BuildingNRooms> getAllocations() {
        List<BuildingNRooms> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getconnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM building_allocations");
            resS = prepS.executeQuery();
            BuildingNRooms item = null;

            while (resS.next()) {
                item = new BuildingNRooms();

                item.setId(resS.getInt("id"));
                item.setBuilding(resS.getString("building"));
                item.setRoom(resS.getString("room"));
                item.setTag(resS.getString("tag"));
                item.setDay(resS.getDate("day"));

                list.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BuildingRooms.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(BuildingRooms.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private Connection getconnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetablesystem", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    private void clear() {
        S2text1.setText("");
        S2text2.setText("");
        S2text3.setText("");
        S2text4.setValue(null);
    }
    
    private void SearchRecord() throws SQLException {
        
        searchid = searchbar.getText();
        
        ObservableList<BuildingNRooms>  BuildingList = FXCollections.observableArrayList();
        Connection conn = getconnection();
        String query = "SELECT * FROM building_allocations  where id="+searchid+"";
        Statement st;
        ResultSet rs;
            
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
           
        while(rs.next()){
//            tfId.setText(rs.getString(""));
            S2text1.setText(rs.getString("building"));
            S2text2.setText(rs.getString("room"));
            S2text3.setText(rs.getString("tag"));
            S2text4.setValue(rs.getDate("day").toLocalDate());
            
        }
        
        }catch (Exception ex){
        ex.printStackTrace();
    }
        
        
    }
    
        private void updateRecord(){
            System.out.println("chech update methon");
            String query = "UPDATE building_allocations SET building= '" + S2text1.getText() + "' , room = '" 
                    + S2text2.getText() + "', tag = '" + S2text3.getText() + "', day = '" + S2text4.getValue()+ "'"
                    + "where id ="+searchid+"";
         
         executeQuery(query);
         populate();
         searchid = null;
     }
     
     private void DeleteRecord(){
        String query = "DELETE FROM building_allocations where id ="+searchid+"";
        executeQuery(query);
       populate();
        searchid = null;
    }
     
     private void executeQuery(String query) {
        Connection conn  = getconnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.execute(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
