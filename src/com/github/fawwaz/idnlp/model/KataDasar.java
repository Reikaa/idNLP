/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fawwaz.idnlp.model;

import java.io.Serializable;

/**
 *
 * @author Fawwaz Muhammad
 */
public class KataDasar implements Serializable{
    
    // --- Constant ---
    private static final long serialVersionUID = 1L;
    
    // --- Properties ---
    private Long id_katadasar;
    private String katadasar;
    private String tipe_katadasar;

    public Long getId_katadasar() {
        return id_katadasar;
    }

    public void setId_katadasar(Long id_katadasar) {
        this.id_katadasar = id_katadasar;
    }

    public String getKatadasar() {
        return katadasar;
    }

    public void setKatadasar(String katadasar) {
        this.katadasar = katadasar;
    }

    public String getTipe_katadasar() {
        return tipe_katadasar;
    }

    public void setTipe_katadasar(String tipe_katadasar) {
        this.tipe_katadasar = tipe_katadasar;
    }
    
    // --- Object Override ---
    @Override
    public boolean equals(Object other) {        
        return (other instanceof KataDasar) && (id_katadasar != null) ? id_katadasar.equals(((KataDasar) other).id_katadasar) : (other == this);
    }

    @Override
    public int hashCode() {
        return (id_katadasar != null) ? (this.getClass().hashCode()+id_katadasar.hashCode()) : super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Kata Dasar [id_katadasar=%d,katadasar=%s,tipe_katadasar=%s]", id_katadasar,katadasar,tipe_katadasar);
    }
    
}
