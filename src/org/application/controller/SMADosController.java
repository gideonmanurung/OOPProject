/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.controller;

import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
public class SMADosController implements Initializable
{
    private Desktop desktop = Desktop.getDesktop();
    
    @FXML
    private TextField titleTF;
    @FXML
    private TextField pathTF;
    @FXML
    private TextField topicTF;
    @FXML
    private TextField titleKuisTF;
    @FXML
    private TextField pertanyaanTF;
    @FXML
    private TextField jawabanTF;
    
    @FXML
    private TableView<Lesson> lessonTB;
    @FXML
    private TableColumn<Lesson, Integer> columnID;
    @FXML
    private TableColumn<Lesson, String> columnTitle;
    @FXML
    private TableColumn<Lesson, String> columnTopic;
    private LessonDao lDao;
    private UserDao uDao;
    private TestDao tDao;
    private User user;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObservableList<Lesson> data;
    
    public SMADosController()
    {
        lDao = new LessonDaoImplHibernate();
        uDao = new UserDaoImplHibernate();
        tDao = new TestDaoImplHibernate();
        lessonTB = new TableView<>();
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
    
    @FXML
    public void logOutBtn(ActionEvent event) throws IOException
    {
        user = uDao.getUser(1);
        uDao.deleteUser(user);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/BeforeLogin.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    public void browseFile(ActionEvent event) throws IOException
    {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[500];
        int read=-1;
        while((read=inputFile.read(buffer))>0)
        {
            baos.write(buffer, 0, read);
        }
        inputFile.close();    
        pathTF.setText(file.getPath());
    }
    
    @FXML
    public void updateMateri(ActionEvent event)
    {
        String title = titleTF.getText();
        String topic = topicTF.getText();
        String pathFile = pathTF.getText();
        String tingkat = "SMA";
        Lesson lesson = new Lesson(0,title,topic,tingkat,baos.toByteArray());
        lDao.addLesson(lesson);
        loadData();
    }
    
    @FXML
    public void updateKuis(ActionEvent event) throws IOException
    {
        String title = titleKuisTF.getText();
        String pertanyaan = pertanyaanTF.getText();
        int idLesson = 0;
        int jawaban = Integer.parseInt(jawabanTF.getText());
        User user;
        List<Lesson> lessons = lDao.getAllLesson();
        if(lessons==null)
        {
            Stage stage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource("/org/application/view/EmptyLesson.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        }
        for(Lesson l : lessons)
        {
            if(l.getTitle().equalsIgnoreCase(title))
            {
                idLesson = l.getIdlesson();
                break;
            }
        }
        user = uDao.getUser(1);
        Test test = new Test(idLesson,0,user.getUsername(),pertanyaan,jawaban,0);
        tDao.addTest(test);
        loadData();
    }
    
    public void openFile(File file) throws IOException
    {
        desktop.open(file);
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
        titleTF.setText("");
        topicTF.setText("");
        pathTF.setText("");
        titleKuisTF.setText("");
        jawabanTF.setText("");
        pertanyaanTF.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        loadData();
    }
}
