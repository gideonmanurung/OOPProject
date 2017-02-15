/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.controller;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.application.dao.UserDao;
import org.application.dao.impl.UserDaoImplHibernate;
import org.application.model.User;

/**
 *
 * @author Gideon
 */
public class AfterLoginController implements Initializable
{
    private UserDao uDao;
    private User user;
    @FXML
    private Label labelNama;
    
    public AfterLoginController()
    {
        uDao = new UserDaoImplHibernate();
        this.user = uDao.getUser(1);
    }
    public void loadData()
    {
        labelNama.setText(user.getName());
    }
    
    @FXML
    public void kirimSD(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/SD.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    public void kirimSMP(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/SMP.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    public void kirimSMA(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/SMA.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void logOut(ActionEvent event) throws IOException
    {
        uDao.deleteUser(user);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/BeforeLogin.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        loadData();
    }
}
