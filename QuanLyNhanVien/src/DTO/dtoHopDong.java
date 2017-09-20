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
public class dtoHopDong {
    private int MAHD;
    private int MACV;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private float  TIENLUONG;

    public dtoHopDong(int MAHD, int MACV, Date NgayBatDau, Date NgayKetThuc, float TIENLUONG) {
        this.MAHD = MAHD;
        this.MACV = MACV;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.TIENLUONG = TIENLUONG;
    }

    public dtoHopDong() {
    }

    public void setMAHD(int MAHD) {
        this.MAHD = MAHD;
    }

    public void setMACV(int MACV) {
        this.MACV = MACV;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public void setTIENLUONG(float TIENLUONG) {
        this.TIENLUONG = TIENLUONG;
    }

    public int getMAHD() {
        return MAHD;
    }

    public int getMACV() {
        return MACV;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public float getTIENLUONG() {
        return TIENLUONG;
    }
    
}
