/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.application.dao.LessonDao;
import org.application.dao.TestDao;
import org.application.dao.UserDao;
import org.application.dao.impl.LessonDaoImplHibernate;
import org.application.dao.impl.TestDaoImplHibernate;
import org.application.dao.impl.UserDaoImplHibernate;
import org.application.model.Lesson;
import org.application.model.Test;
import org.application.model.User;

/**
 *
 * @author Gideon
 */
public class SMAController implements Initializable
{
    private UserDao uDao;
    private User user;
    private TestDao tDao;
    private Test test;
    private LessonDao lDao;
    private Lesson lesson;
    
    @FXML
    private TextField idKuisTF;
    @FXML
    private TextField idTF;
    
    @FXML
    private TableView<Lesson> lessonTB;
    
    @FXML
    private TableColumn<Lesson , Integer> columnID;
    @FXML
    private TableColumn<Lesson, String> columnTitle;
    @FXML
    private TableColumn<Lesson, String> columnTopic;
    
    ObservableList<Lesson> data;
    
    public SMAController()
    {
        tDao = new TestDaoImplHibernate();
        test = tDao.getTest(1);
        lDao = new LessonDaoImplHibernate();
        uDao = new UserDaoImplHibernate();
        this.user = uDao.getUser(1);
        lessonTB = new TableView<>();
    }
    
    public void loadData()
    {
        List<Lesson> lessons = new ArrayList<>();
        int i=0;
        for(Lesson l : lDao.getAllLesson())
        {
            if(l.getTingkat().equalsIgnoreCase("SMA"))
            {
                lessons.add(i, l);
                i++;
            }
        }
        data = FXCollections.observableArrayList(lessons);
        columnID.setCellValueFactory(new PropertyValueFactory<>("idlesson"));
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnTopic.setCellValueFactory(new PropertyValueFactory<>("topic"));
        lessonTB.setItems(data);
    }
    
    @FXML
    public void logOutBtn(ActionEvent event) throws IOException
    {
        uDao.deleteUser(user);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/BeforeLogin.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    public void downloadLesson(ActionEvent event) throws IOException
    {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(stage);
        String path = file.getPath();
        lesson = lDao.getLesson(Integer.parseInt(idTF.getText()));
        byte[] buffer = new byte[500];
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        bais.read(lesson.getFile());
        int read=-1;
        FileOutputStream fos = new FileOutputStream(path);
        while((read=bais.read(buffer))!=-1)
        {
            fos.write(buffer, 0, read);
        }
        fos.close();
        loadData();
    }
    
    @FXML
    public void linkKuis(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/kuis.fxml"));
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
