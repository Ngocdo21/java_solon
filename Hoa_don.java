/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsalontocnam;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Hoa_don {
    String mahd, makh, manv, madv, ngaythanhtoan, hinhthucthanhtoan;
    float  tongtien;

    public Hoa_don(String mahd, String makh, String manv, String madv, String ngaythanhtoan, String hinhthucthanhtoan, float chietkhau, float tongtien) {
        this.mahd = mahd;
        this.makh = makh;
        this.manv = manv;
        this.madv = madv;
        this.ngaythanhtoan = ngaythanhtoan;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.tongtien = tongtien;
    }

    public Hoa_don() {
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMadv() {
        return madv;
    }

    public void setMadv(String madv) {
        this.madv = madv;
    }

    public String getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(String ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }
    
    public String getHinhthucthanhtoan() {
        return hinhthucthanhtoan;
    }

    public void setHinhthucthanhtoan(String hinhthucthanhtoan) {
        this.hinhthucthanhtoan = hinhthucthanhtoan;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }
    
}
