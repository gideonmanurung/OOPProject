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
@Table(name = "study")
public class Study implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstudy")
    private Integer idstudy;
    @Basic(optional = false)
    @Column(name = "idlesson")
    private int idlesson;
    @Basic(optional = false)
    @Column(name = "topic")
    private String topic;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;

    public Study() {
    }

    public Study(Integer idstudy) {
        this.idstudy = idstudy;
    }

    public Study(Integer idstudy, int idlesson, String username) {
        this.idstudy = idstudy;
        this.idlesson = idlesson;
        this.username = username;
    }

    public Integer getIdstudy() {
        return idstudy;
    }

    public void setIdstudy(Integer idstudy) {
        this.idstudy = idstudy;
    }

    public int getIdlesson() {
        return idlesson;
    }

    public void setIdlesson(int idlesson) {
        this.idlesson = idlesson;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstudy != null ? idstudy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Study)) {
            return false;
        }
        Study other = (Study) object;
        if ((this.idstudy == null && other.idstudy != null) || (this.idstudy != null && !this.idstudy.equals(other.idstudy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.application.model.Study[ idstudy=" + idstudy + " ]";
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
}
