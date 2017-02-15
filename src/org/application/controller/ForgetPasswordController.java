/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.controller;

import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.application.dao.AccountDao;
import org.application.dao.impl.AccountDaoImplHibernate;
import org.application.model.Account;

/**
 *
 * @author Gideon
 */
public class ForgetPasswordController {

    @FXML
    private TextField usernameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField rPasswordTF;

    private AccountDao aDao;

    public ForgetPasswordController() {
        aDao = new AccountDaoImplHibernate();
    }

    @FXML
    public void btnBack(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/BeforeLogin.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void refreshForm()
    {
        usernameTF.setText("");
        passwordTF.setText("");
        rPasswordTF.setText("");
    }
    
    @FXML
    public void btnKirim(ActionEvent event) throws IOException {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        String rPassword = rPasswordTF.getText();
        List<Account> accounts = aDao.getAllAccount();
        if (password.matches(rPassword)) {
            for (Account a : accounts) {
                if (a.getUsername().matches(username)) {
                    a.setPassword(password);
                    aDao.updateAccount(a);
                    Stage primaryStage = new Stage();
                    refreshForm();
                    Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/SuccessUpdate.fxml"));
                    Scene scene = new Scene(parent);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    break;
                }
            }
        } else {
            Stage primaryStage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/ErrorRegister.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
}
