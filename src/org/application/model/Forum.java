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
@Table(name = "forum")
public class Forum implements Serializable {

    @Column(name = "description")
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idforum")
    private Integer idforum;
    @Basic(optional = false)
    @Column(name = "idlesson")
    private Integer idlesson;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "topic")
    private String topic;

    public Forum() {
    }

    public Forum(Integer idforum) {
        this.idforum = idforum;
    }

    public Forum(Integer idforum, String description, Integer idlesson, String username, String title, String topic) {
        this.idforum = idforum;
        this.description = description;
        this.idlesson = idlesson;
        this.username = username;
        this.title = title;
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdforum() {
        return idforum;
    }

    public void setIdforum(Integer idforum) {
        this.idforum = idforum;
    }

    public Integer getIdlesson() {
        return idlesson;
    }

    public void setIdlesson(Integer idlesson) {
        this.idlesson = idlesson;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idforum != null ? idforum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forum)) {
            return false;
        }
        Forum other = (Forum) object;
        if ((this.idforum == null && other.idforum != null) || (this.idforum != null && !this.idforum.equals(other.idforum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.application.model.Forum[ idforum=" + idforum + " ]";
    }
    
}
