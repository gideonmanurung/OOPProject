/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gideon
 */
@Entity
@Table(name = "lesson")
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlesson")
    private Integer idlesson;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "topic")
    private String topic;
    @Basic(optional = false)
    @Column(name = "tingkat")
    private String tingkat;
    @Basic(optional = false)
    @Column(name = "file")
    private byte[] file;

    public Lesson() {
    }

    public Lesson(int idlesson) {
        this.idlesson = idlesson;
    }

    public Lesson(int idLesson,String title, String topic,String tingkat, byte[] file) {
        this.idlesson = idLesson;
        this.title = title;
        this.topic = topic;
        this.tingkat = tingkat;
        this.file = file;
    }

    public Integer getIdlesson() {
        return idlesson;
    }

    public void setIdlesson(Integer idlesson) {
        this.idlesson = idlesson;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTingkat() {
        return tingkat;
    }

    public void setTingkat(String tingkat) {
        this.tingkat = tingkat;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlesson != null ? idlesson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lesson)) {
            return false;
        }
        Lesson other = (Lesson) object;
        if ((this.idlesson == null && other.idlesson != null) || (this.idlesson != null && !this.idlesson.equals(other.idlesson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.application.model.Lesson[ idlesson=" + idlesson + " ]";
    }
    
}
