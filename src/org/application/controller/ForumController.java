/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.application.dao.AccountDao;
import org.application.dao.ForumDao;
import org.application.dao.LessonDao;
import org.application.model.Account;
import org.application.model.Forum;
import org.application.model.Lesson;

/**
 *
 * @author Gideon
 */
public class ForumController 
{
    @FXML
    private TableView<Forum> forumTB;
    
    @FXML
    private TextField pertanyaanTF;
    
    @FXML
    private TextField titleTF;
    
    @FXML
    private TextField topicTF;
    
    private ForumDao fDao;
    private LessonDao lDao;
    private Account account;
    private AccountDao aDao;
    private Lesson lesson;
    @FXML
    public void btnSubmit(ActionEvent event)
    {
        String title = titleTF.getText();
        String topic = topicTF.getText();
        String pertanyaan = pertanyaanTF.getText();
        int idLesson=0;
        String username="";
        for(Lesson l : lDao.getAllLesson())
        {
            if(l.getTitle().equalsIgnoreCase(title))
            {
                idLesson = l.getIdlesson();
                break;
            }
        }
        Forum forum = new Forum(0,pertanyaan,idLesson,username,title,topic);
        fDao.addForum(forum);
    }
    
    @FXML
    public void btnBack(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/Afterlogintodosen.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
