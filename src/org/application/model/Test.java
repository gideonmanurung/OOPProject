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
@Table(name = "test")
public class Test implements Serializable {

    @Basic(optional = false)
    @Column(name = "idlesson")
    private int idlesson;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtest")
    private Integer idtest;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "pertanyaan")
    private String pertanyaan;
    @Basic(optional = false)
    @Column(name = "jawaban")
    private Integer jawaban;
    @Basic(optional = false)
    @Column(name = "nilai")
    private double nilai;

    public Test() {
    }

    public Test(Integer idtest) {
        this.idtest = idtest;
    }

    public Test(Integer idtest, int idlesson, String username,String pertanyaan,Integer jawaban, double nilai) {
        this.idtest = idtest;
        this.idlesson = idlesson;
        this.username = username;
        this.pertanyaan = pertanyaan;
        this.jawaban = jawaban;
        this.nilai = nilai;
    }

    public int getIdlesson() {
        return idlesson;
    }

    public void setIdlesson(int idlesson) {
        this.idlesson = idlesson;
    }

    public Integer getIdtest() {
        return idtest;
    }

    public void setIdtest(Integer idtest) {
        this.idtest = idtest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public Integer getJawaban() {
        return jawaban;
    }

    public void setJawaban(Integer jawaban) {
        this.jawaban = jawaban;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtest != null ? idtest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.idtest == null && other.idtest != null) || (this.idtest != null && !this.idtest.equals(other.idtest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.application.model.Test[ idtest=" + idtest + " ]";
    }
    
}
