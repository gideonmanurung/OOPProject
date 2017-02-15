/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
public class QuizController implements Initializable
{
    @FXML
    private Label labelKuis;
    @FXML
    private Label labelPertanyaan;
    @FXML
    private RadioButton rdBtn1;
    @FXML
    private RadioButton rdBtn2;
    @FXML
    private RadioButton rdBtn3;
    @FXML
    private RadioButton rdBtn4;
    
    private TestDao tDao;
    private UserDao uDao;
    private LessonDao lDao;
    private Test test;
    private int idTest = 0;
    private int idLesson;
    public QuizController()
    {
        tDao = new TestDaoImplHibernate();
        uDao = new UserDaoImplHibernate();
        lDao = new LessonDaoImplHibernate();
    }
    
    @FXML
    public void btnSubmit(ActionEvent event)
    {
        User user;
        user = uDao.getUser(1);
        double nilai = 0;
        for(Test t : tDao.getAllTest())
        {
            if(t.getUsername().matches(user.getUsername()))
            {
                this.idTest = t.getIdtest();
                break;
            }
        }
        this.test = tDao.getTest(idTest);
        this.idLesson = test.getIdlesson();
        if(rdBtn1.isSelected())
        {
            nilai = 100;
        }
        test.setNilai(nilai);
        tDao.updateTest(test);
    }

    public void loadData()
    {
        Lesson lesson = lDao.getLesson(idLesson);
        labelKuis.setText(lesson.getTitle());
        labelPertanyaan.setText(test.getPertanyaan()+" ?");
        rdBtn1.setText(""+test.getJawaban());
        rdBtn2.setText(""+test.getJawaban()*2);
        rdBtn3.setText(""+test.getJawaban()*5);
        rdBtn4.setText(""+test.getJawaban()*4);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        loadData();
    }
}
