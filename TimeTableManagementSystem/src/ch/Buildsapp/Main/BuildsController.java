/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.Buildsapp.Main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * 
 */
public class BuildsController implements Initializable {

    @FXML
    private ComboBox<?> versionCombo;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> builds;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> release;
    @FXML
    private Button downloadButton;
    @FXML
    private Button installButton;
    @FXML
    private ComboBox<?> locCombo;
    @FXML
    private ComboBox<?> versionNo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
