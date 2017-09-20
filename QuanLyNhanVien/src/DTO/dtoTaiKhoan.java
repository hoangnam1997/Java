/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author NT
 */
public class dtoTaiKhoan {
    private String TAIKHOAN;
    private String MATKHAU;
    private int LV;
    public dtoTaiKhoan() {
    }
    public dtoTaiKhoan(String TAIKHOAN, String MATKHAU, int LV) {
        this.TAIKHOAN = TAIKHOAN;
        this.MATKHAU = MATKHAU;
        this.LV = LV;
    }
    public void setTAIKHOAN(String TAIKHOAN) {
        this.TAIKHOAN = TAIKHOAN;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public void setLV(int LV) {
        this.LV = LV;
    }

    public String getTAIKHOAN() {
        return TAIKHOAN;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public int getLV() {
        return LV;
    }
}
