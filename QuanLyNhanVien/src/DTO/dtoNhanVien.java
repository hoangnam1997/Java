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
public class dtoNhanVien {
    private int MANV;
    private String TENNV;
    private int GioiTinh;
    private String SDT;
    private String DiaChi;
    private String TAIKHOAN;
    private int MAHD;

    public dtoNhanVien() {
    }

    public dtoNhanVien(int MANV, String TENNV, int GioiTinh, String SDT, String DiaChi, String TAIKHOAN, int MAHD) {
        this.MANV = MANV;
        this.TENNV = TENNV;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.TAIKHOAN = TAIKHOAN;
        this.MAHD = MAHD;
    }

    public void setMANV(int MANV) {
        this.MANV = MANV;
    }

    public void setTENNV(String TENNV) {
        this.TENNV = TENNV;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setTAIKHOAN(String TAIKHOAN) {
        this.TAIKHOAN = TAIKHOAN;
    }

    public void setMAHD(int MAHD) {
        this.MAHD = MAHD;
    }

    public int getMANV() {
        return MANV;
    }

    public String getTENNV() {
        return TENNV;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getTAIKHOAN() {
        return TAIKHOAN;
    }

    public int getMAHD() {
        return MAHD;
    }
}
