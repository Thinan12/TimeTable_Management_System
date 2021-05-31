/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.statistics.views;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author thina
 */
public class RoomsWithGroups implements Initializable {

    @FXML
    private TableView<Groups> tvTable;

    @FXML
    private TableColumn<Groups, String> colGroup;

    @FXML
    private TableColumn<Groups, String> colSub;

    @FXML
    private TableColumn<Groups, String> S2tr1;

    @FXML
    private TableColumn<Groups, String> colStart;

    @FXML
    private TableColumn<Groups, String> colEnd;

    @FXML
    private ComboBox<String> comboGroup;

    @FXML
    private ComboBox<String> comboSub;

    @FXML
    private ComboBox<String> comboRoom;

    @FXML
    private Button btnDelete;

    @FXML
    private ComboBox<String> comboStart;

    @FXML
    private ComboBox<String> comboEnd;

    @FXML
    private Button btnUpdate;
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboGroup.getItems().addAll(getGroup());
        comboSub.getItems().addAll(getSubGroup());
        comboRoom.getItems().addAll(getRoom());
        comboStart.getItems().addAll(getStartTime());
        comboEnd.getItems().addAll(getEndTime());
        populate();

        btnDelete.setOnAction((event) -> {
            newGroups();
            populate();
        });

        tvTable.setContextMenu(createContextMenu());
    }

    private List<String> getGroup() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM groupdetails");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("group_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<String> getSubGroup() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM groupdetails");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(String.valueOf(resS.getInt("sgroup_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<String> getRoom() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM room");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("tfRoom"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<String> getStartTime() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM parallelsession");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("startingtime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
 
    private List<String> getEndTime() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM parallelsession");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("endtime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<Groups> getGroups() {
        List<Groups> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();
        Groups groups;

        try {
            prepS = connection.prepareStatement("SELECT * FROM groups");
            resS = prepS.executeQuery();

            while (resS.next()) {
                groups = new Groups();
                
                groups.setGroup(resS.getString("groupN"));
                groups.setStartTime(resS.getString("startTime"));
                groups.setSubGroup(resS.getString("subgroup"));
                groups.setEndTime(resS.getString("endTime"));
                groups.setRoom(resS.getString("room"));
                

                list.add(groups);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private void newGroups() {
        Connection connection = null;
        PreparedStatement prepS = null;
        connection = getConnection();
        Groups groups = null;

        try {
            prepS = connection.prepareStatement("INSERT INTO groups(groupN, startTime, subgroup, endTime, room) VALUES(?, ?, ?, ?, ?)");

            prepS.setString(1, comboGroup.getValue());
            prepS.setString(2, comboSub.getValue());
            prepS.setString(3, comboRoom.getValue());
            prepS.setString(4, comboStart.getValue());
            prepS.setString(5, comboEnd.getValue());

            prepS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void populate() {
        colGroup.setCellValueFactory(new PropertyValueFactory<>("groupN"));
        colSub.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        S2tr1.setCellValueFactory(new PropertyValueFactory<>("subgroup"));
        colStart.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        colEnd.setCellValueFactory(new PropertyValueFactory<>("room"));
      

        tvTable.getItems().setAll(getGroups());
    }

    private ContextMenu createContextMenu() {
        ContextMenu cMenu = new ContextMenu();

        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction((event) -> {
            deleteGroupsWindow();
        });

        cMenu.getItems().addAll(delete);

        return cMenu;
    }

    private void deleteGroupsWindow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmatio Box");
        alert.setHeaderText("Remove Groups");
        alert.setContentText("Do you want to remove the Groups?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            deleteGroups(tvTable.getSelectionModel().getSelectedItem().getID());
            populate();
        }
    }

    private void deleteGroups(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement prepS = connection.prepareStatement("DELETE FROM groups WHERE id = ?");
            prepS.setInt(1, id);

            prepS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithGroups.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetablesystem", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

}
