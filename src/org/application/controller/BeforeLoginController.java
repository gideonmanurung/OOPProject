/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.application.dao.AccountDao;
import org.application.dao.UserDao;
import org.application.dao.impl.AccountDaoImplHibernate;
import org.application.dao.impl.UserDaoImplHibernate;
import org.application.model.Account;
import org.application.model.User;

/**
 *
 * @author Gideon
 */
public class BeforeLoginController implements Initializable
{
    private AccountDao aDao; 
    private UserDao uDao;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField namaTF;
    @FXML
    private TextField alamatTF;
    @FXML
    private TextField pRegisterTF;
    @FXML
    private TextField cRegisterTF;
    @FXML
    private CheckBox checkStatus;
    @FXML
    private ComboBox cbRole;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField usernameLoginTF;
    
    ObservableList<String> type = FXCollections.observableArrayList("Pelajar","Dosen");
    
    public BeforeLoginController()
    {
        aDao = new AccountDaoImplHibernate();
        uDao = new UserDaoImplHibernate();
    }
    
    public void resetTF()
    {
        usernameTF.setText("");
        namaTF.setText("");
        alamatTF.setText("");
        pRegisterTF.setText("");
        cRegisterTF.setText("");
        usernameLoginTF.setText("");
        passwordTF.setText("");
    }
    
    @FXML
    public void kirimRegister(ActionEvent event) throws IOException
    {
        String username = usernameTF.getText();
        String nama = namaTF.getText();
        String alamat = alamatTF.getText();
        String pRegister = pRegisterTF.getText();
        String cRegister = cRegisterTF.getText();
        String role = cbRole.getSelectionModel().getSelectedItem().toString();
        if(pRegister.matches(cRegister)&&checkStatus.isSelected())
        {
            resetTF();
            Account account = new Account(username,pRegister,nama,alamat,role);
            aDao.addAccount(account);
            Stage primaryStage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/RegisterBerhasil.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else
        {
            Stage primaryStage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/ErrorRegister.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    @FXML
    public void kirimLogin(ActionEvent event) throws IOException
    {
        boolean isLogin = false;
        User user= new User();
        String username = usernameLoginTF.getText();
        String password = passwordTF.getText();
        int id = 1;
        List<Account> accounts = aDao.getAllAccount();
        for(Account a : accounts)
        {
            if(a.getUsername().matches(username))
            {
                if(a.getPassword().matches(password)&&a.getRole().equalsIgnoreCase("dosen"))
                {
                    user.setId(id);
                    user.setUsername(a.getUsername());
                    user.setName(a.getNama());
                    uDao.addUser(user);
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                    Stage primaryStage = new Stage();
                    Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/Afterlogintodosen.fxml"));
                    Scene scene = new Scene(parent);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    isLogin=true;
                    break;
                }
                if(a.getPassword().matches(password)&&a.getRole().equalsIgnoreCase("pelajar"))
                {
                    user.setId(id);
                    user.setUsername(a.getUsername());
                    user.setName(a.getNama());
                    uDao.addUser(user);
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                    Stage primaryStage = new Stage();
                    Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/Afterlogin.fxml"));
                    Scene scene = new Scene(parent);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    isLogin=true;
                    break;
                }
            }
        }
        if(isLogin==true)
        {
        }
        else
        {
            resetTF();
            Stage primaryStage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/ErrorLogin.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        
    }
    
    @FXML
    public void kirimSD(ActionEvent event) throws IOException
    {
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/LoginNotification.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    public void kirimSMP(ActionEvent event) throws IOException
    {
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/LoginNotification.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    public void linkForgotPassword(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/ForgetPassword.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    public void kirimSMA(ActionEvent event) throws IOException
    {
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/LoginNotification.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        cbRole.setItems(type);
    }
}
