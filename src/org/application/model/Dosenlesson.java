/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
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
@Table(name = "dosenlesson")
public class Dosenlesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "idlesson")
    private int idlesson;

    public Dosenlesson() {
    }

    public Dosenlesson(String username, int idlesson) {
        this.username = username;
        this.idlesson = idlesson;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdlesson() {
        return idlesson;
    }

    public void setIdlesson(int idlesson) {
        this.idlesson = idlesson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        hash += (int) idlesson;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dosenlesson)) {
            return false;
        }
        Dosenlesson other = (Dosenlesson) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        if (this.idlesson != other.idlesson) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.application.model.DosenlessonPK[ username=" + username + ", idlesson=" + idlesson + " ]";
    }
    
}
