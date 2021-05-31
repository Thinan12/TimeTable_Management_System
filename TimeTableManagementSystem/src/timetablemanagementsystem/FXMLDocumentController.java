/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author thina
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button createbuttonsubject;
    @FXML
    private Button button_student;
    @FXML
    private Button button_lecture;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void handleButtonAction(ActionEvent event) throws IOException {
        
    }

    @FXML
    private void click(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("statistics/views/static_for_stu_lec_sub.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void onClickStatforStudent(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/FXMLInterface5.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleButtonActionlevture(ActionEvent event) throws IOException {
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/FXMLInterface 5_1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
}
