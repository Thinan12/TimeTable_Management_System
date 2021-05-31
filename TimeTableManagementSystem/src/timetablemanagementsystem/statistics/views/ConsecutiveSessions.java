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
public class ConsecutiveSessions implements Initializable {

    private ComboBox<String> S2y1;

    private ComboBox<String> S2s1;

    private ComboBox<String> S2cs1;

    @FXML
    private TableView<Consecative> Tvsession;
    @FXML
    private TableColumn<Consecative, Integer> colID;

    @FXML
    private TableColumn<Consecative, String> colYear;

    @FXML
    private TableColumn<Consecative, String> colSem;

    @FXML
    private TableColumn<Consecative, String> colProgram;

    @FXML
    private TableColumn<Consecative, String> colRoom;

    @FXML
    private TableColumn<Consecative, String> colCS;

    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnde;
    @FXML
    private ComboBox<String> ComboYear;
    @FXML
    private ComboBox<String> ComboSemmester;
    @FXML
    private ComboBox<String> Comboprograme;
    @FXML
    private ComboBox<String> Comboroom;
    @FXML
    private ComboBox<String> ComboCs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboYear.getItems().addAll(getYear());
        ComboSemmester.getItems().addAll(getSemmester());
        Comboprograme.getItems().addAll(getPrograme());
        Comboroom.getItems().addAll(getRoom());
        ComboCs.getItems().addAll(getConsecutivesession());
        populate();

        btnUpdate.setOnAction((event) -> {
            newConsecative();
            populate();
        });

        Tvsession.setContextMenu(createContextMenu());
    }

    private List<String> getYear() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM viewtable");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("Year"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<String> getSemmester() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM viewtable");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("Semester"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<String> getPrograme() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM programdetails");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("p_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
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
            prepS = connection.prepareStatement("SELECT * FROM building_allocations");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("room"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<String> getConsecutivesession() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM consecutive_session");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("subjectname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<Consecative> getConsecative() {
        List<Consecative> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();
        Consecative consecative = null;

        try {
            prepS = connection.prepareStatement("SELECT * FROM consecativetable");
            resS = prepS.executeQuery();

            while (resS.next()) {
                consecative = new Consecative();
                consecative.setId(resS.getInt("id"));
                consecative.setYear(resS.getString("Year"));
                consecative.setSemmester(resS.getString("Semmester"));
                consecative.setPrograme(resS.getString("Programe"));
                consecative.setRoom(resS.getString("Room"));
                consecative.setConsecutivesession(resS.getString("consecutivesession"));

                list.add(consecative);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private void newConsecative() {
        Connection connection = null;
        PreparedStatement prepS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("INSERT INTO consecativetable(Year, Semmester, Programe, Room, consecutivesession) VALUES(?, ?, ?, ?,?)");

            prepS.setString(1, ComboYear.getValue());
            prepS.setString(2, ComboSemmester.getValue());
            prepS.setString(3, Comboprograme.getValue());
            prepS.setString(4, Comboroom.getValue());
            prepS.setString(5, ComboCs.getValue());

            prepS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void populate() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colSem.setCellValueFactory(new PropertyValueFactory<>("Semmester"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("Programe"));
        colRoom.setCellValueFactory(new PropertyValueFactory<>("Room"));
        colCS.setCellValueFactory(new PropertyValueFactory<>("consecutivesession"));

        Tvsession.getItems().setAll(getConsecative());
    }

    private ContextMenu createContextMenu() {
        ContextMenu cMenu = new ContextMenu();

        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction((event) -> {
            deleteConsecativeWindow();
        });

        cMenu.getItems().addAll(delete);

        return cMenu;
    }

    private void deleteConsecativeWindow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmatio Box");
        alert.setHeaderText("Remove Consecative");
        alert.setContentText("Do you want to remove the consecative?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            deleteConsecative(Tvsession.getSelectionModel().getSelectedItem().getId());
            populate();
        }
    }

    private void deleteConsecative(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement prepS = connection.prepareStatement("DELETE FROM consecativetable WHERE id = ?");
            prepS.setInt(1, id);

            prepS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConsecutiveSessions.class.getName()).log(Level.SEVERE, null, ex);
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
