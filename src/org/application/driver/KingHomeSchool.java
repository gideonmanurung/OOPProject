/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Gideon
 */
public class KingHomeSchool extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/BeforeLogin.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
