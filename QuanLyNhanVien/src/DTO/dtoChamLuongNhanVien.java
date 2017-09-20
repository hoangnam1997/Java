/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author NT
 */
public class dtoChamLuongNhanVien {
    private int MACL;
    private int MANV;
    private Date TuNGay;
    private Date DenNgay;
    private float TongLuong;

    public void setMACL(int MACL) {
        this.MACL = MACL;
    }

    public void setMANV(int MANV) {
        this.MANV = MANV;
    }

    public void setTuNGay(Date TuNGay) {
        this.TuNGay = TuNGay;
    }

    public void setDenNgay(Date DenNgay) {
        this.DenNgay = DenNgay;
    }

    public void setTongLuong(float TongLuong) {
        this.TongLuong = TongLuong;
    }

    public int getMACL() {
        return MACL;
    }

    public int getMANV() {
        return MANV;
    }

    public Date getTuNGay() {
        return TuNGay;
    }

    public Date getDenNgay() {
        return DenNgay;
    }

    public float getTongLuong() {
        return TongLuong;
    }

    public dtoChamLuongNhanVien() {
    }

    public dtoChamLuongNhanVien(int MACL, int MANV, Date TuNGay, Date DenNgay, float TongLuong) {
        this.MACL = MACL;
        this.MANV = MANV;
        this.TuNGay = TuNGay;
        this.DenNgay = DenNgay;
        this.TongLuong = TongLuong;
    }
}
