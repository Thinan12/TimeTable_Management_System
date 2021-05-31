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
 * FXML Controller class
 *
 * @author thina
 */
public class RoomsWithSessionController implements Initializable {

    @FXML
    private TableView<Allocation> tab;
    @FXML
    private TableColumn<Allocation, Integer> TCol;
    @FXML
    private TableColumn<Allocation, String> Tb1;
    @FXML
    private TableColumn<Allocation, String> Ts2;
    @FXML
    private TableColumn<Allocation, String> S2Tag3;
    @FXML
    private TableColumn<Allocation, String> TSe4;
    @FXML
    private TableColumn<Allocation, String> Tsn5;
    @FXML
    private TableColumn<Allocation, String> Tln6;
    @FXML
    private TableColumn<Allocation, String> Trn7;
    @FXML
    private Button D1;
    @FXML
    private Button U1;
    @FXML
    private ComboBox<String> comboBuilding;
    @FXML
    private ComboBox<String> comboSubject;
    @FXML
    private ComboBox<String> comboTag;
    @FXML
    private ComboBox<String> comboSession;
    @FXML
    private ComboBox<String> comboSessionName;
    @FXML
    private ComboBox<String> comboLecture;
    @FXML
    private ComboBox<String> comboRoom;
    @FXML
    private Button D11;

    ObservableList<String> building = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBuilding.getItems().addAll(getBuildings());
        comboLecture.getItems().addAll(getLecture());
        comboRoom.getItems().addAll(getRooms());
        comboSubject.getItems().addAll(getSubjects());
        comboTag.getItems().addAll(getTags());
        populate();

        D11.setOnAction((event) -> {
            newAllocation();
            populate();
        });

        tab.setContextMenu(createContextMenu());
    }

    private List<String> getBuildings() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM building");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("buildingId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<String> getRooms() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM room");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(String.valueOf(resS.getInt("tfId")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<String> getTags() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM managetags");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("tname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<String> getLecture() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM lecturer");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
 
    private List<String> getSubjects() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM subject");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("subjectCode"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<Allocation> getAllocations() {
        List<Allocation> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();
        Allocation allocation = null;

        try {
            prepS = connection.prepareStatement("SELECT * FROM allocations");
            resS = prepS.executeQuery();

            while (resS.next()) {
                allocation = new Allocation();
                allocation.setId(resS.getInt("id"));
                allocation.setBuilding(resS.getString("building"));
                allocation.setSubject(resS.getString("subject"));
                allocation.setTag(resS.getString("tag"));
                allocation.setSessionId(resS.getString("session_id"));
                allocation.setSessionName(resS.getString("session_name"));
                allocation.setLecturerName(resS.getString("lecturer_name"));
                allocation.setRoom(resS.getString("room"));

                list.add(allocation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private void newAllocation() {
        Connection connection = null;
        PreparedStatement prepS = null;
        connection = getConnection();
        Allocation allocation = null;

        try {
            prepS = connection.prepareStatement("INSERT INTO allocations(building, subject, tag, session_id, session_name, lecturer_name, room) VALUES(?, ?, ?, ?, ?, ?, ?)");

            prepS.setString(1, comboBuilding.getValue());
            prepS.setString(2, comboSubject.getValue());
            prepS.setString(3, comboTag.getValue());
            prepS.setString(4, comboSession.getValue());
            prepS.setString(5, comboSessionName.getValue());
            prepS.setString(6, comboLecture.getValue());
            prepS.setString(7, comboRoom.getValue());

            prepS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void populate() {
        TCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        Tb1.setCellValueFactory(new PropertyValueFactory<>("building"));
        Ts2.setCellValueFactory(new PropertyValueFactory<>("subject"));
        S2Tag3.setCellValueFactory(new PropertyValueFactory<>("tag"));
        TSe4.setCellValueFactory(new PropertyValueFactory<>("sessionId"));
        Tsn5.setCellValueFactory(new PropertyValueFactory<>("sessionName"));
        Tln6.setCellValueFactory(new PropertyValueFactory<>("lecturerName"));
        Trn7.setCellValueFactory(new PropertyValueFactory<>("room"));

        tab.getItems().setAll(getAllocations());
    }

    private ContextMenu createContextMenu() {
        ContextMenu cMenu = new ContextMenu();

        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction((event) -> {
            deleteAllocationWindow();
        });

        cMenu.getItems().addAll(delete);

        return cMenu;
    }

    private void deleteAllocationWindow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmatio Box");
        alert.setHeaderText("Remove Allocation");
        alert.setContentText("Do you want to remove the allocation?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            deleteAllocation(tab.getSelectionModel().getSelectedItem().getId());
            populate();
        }
    }

    private void deleteAllocation(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement prepS = connection.prepareStatement("DELETE FROM allocations WHERE id = ?");
            prepS.setInt(1, id);

            prepS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RoomsWithSessionController.class.getName()).log(Level.SEVERE, null, ex);
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
