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
@Table(name = "progress")
public class Progress implements Serializable {

    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "idlesson")
    private int idlesson;
    @Basic(optional = false)
    @Column(name = "persentasi")
    private int persentasi;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprogress")
    private Integer idprogress;

    public Progress() {
    }

    public Progress(Integer idprogress) {
        this.idprogress = idprogress;
    }

    public Progress(Integer idprogress, String username, int idlesson, int persentasi) {
        this.idprogress = idprogress;
        this.username = username;
        this.idlesson = idlesson;
        this.persentasi = persentasi;
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

    public int getPersentasi() {
        return persentasi;
    }

    public void setPersentasi(int persentasi) {
        this.persentasi = persentasi;
    }

    public Integer getIdprogress() {
        return idprogress;
    }

    public void setIdprogress(Integer idprogress) {
        this.idprogress = idprogress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprogress != null ? idprogress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Progress)) {
            return false;
        }
        Progress other = (Progress) object;
        if ((this.idprogress == null && other.idprogress != null) || (this.idprogress != null && !this.idprogress.equals(other.idprogress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.application.model.Progress[ idprogress=" + idprogress + " ]";
    }
    
}
