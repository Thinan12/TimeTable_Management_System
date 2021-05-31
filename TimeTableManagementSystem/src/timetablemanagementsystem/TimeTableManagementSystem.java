/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem;

import java.awt.geom.Rectangle2D;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author thina
 */
public class TimeTableManagementSystem extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/Sprint 2-Interface 5.fxml")); //
        
        Scene scene = new Scene(root);
//        Screen screen = Screen.getPrimary();
//        javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();
//
//        stage.setX(bounds.getMinX());
//        stage.setY(bounds.getMinY());
//        stage.setWidth(bounds.getWidth());
//        stage.setHeight(bounds.getHeight());

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
