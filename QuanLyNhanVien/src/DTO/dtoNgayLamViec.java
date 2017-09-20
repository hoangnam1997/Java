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
public class dtoNgayLamViec {
    private Date NgayLamViec;
    private int MANV;

    public dtoNgayLamViec(Date NgayLamViec, int MANV) {
        this.NgayLamViec = NgayLamViec;
        this.MANV = MANV;
    }

    public dtoNgayLamViec() {
    }

    public void setNgayLamViec(Date NgayLamViec) {
        this.NgayLamViec = NgayLamViec;
    }

    public void setMANV(int MANV) {
        this.MANV = MANV;
    }

    public Date getNgayLamViec() {
        return NgayLamViec;
    }

    public int getMANV() {
        return MANV;
    }
}
