/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsalontocnam;

/**
 *
 * @author Admin
 */
public class Dich_vu {
    String madv, tendv;
    int gia;

    public Dich_vu() {
    }

    public Dich_vu(String madv, String tendv, int gia) {
        this.madv = madv;
        this.tendv = tendv;
        this.gia = gia;
    }

    public String getMadv() {
        return madv;
    }

    public void setMadv(String madv) {
        this.madv = madv;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    
}
