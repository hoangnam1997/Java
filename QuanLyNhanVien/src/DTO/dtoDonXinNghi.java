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
public class dtoDonXinNghi {
    private int MADON;
    private String LYDO;
    private Date ThoiGianLap;
    private Date ThoiGianBatDau;
    private Date ThoiGianKetThuc;
    private int MANV;

    public dtoDonXinNghi(int MADON, String LYDO, Date ThoiGianLap, Date ThoiGianBatDau, Date ThoiGianKetThuc, int MANV) {
        this.MADON = MADON;
        this.LYDO = LYDO;
        this.ThoiGianLap = ThoiGianLap;
        this.ThoiGianBatDau = ThoiGianBatDau;
        this.ThoiGianKetThuc = ThoiGianKetThuc;
        this.MANV = MANV;
    }

    public dtoDonXinNghi() {
    }

    public void setMADON(int MADON) {
        this.MADON = MADON;
    }

    public void setLYDO(String LYDO) {
        this.LYDO = LYDO;
    }

    public void setThoiGianLap(Date ThoiGianLap) {
        this.ThoiGianLap = ThoiGianLap;
    }

    public void setThoiGianBatDau(Date ThoiGianBatDau) {
        this.ThoiGianBatDau = ThoiGianBatDau;
    }

    public void setThoiGianKetThuc(Date ThoiGianKetThuc) {
        this.ThoiGianKetThuc = ThoiGianKetThuc;
    }

    public void setMANV(int MANV) {
        this.MANV = MANV;
    }

    public int getMADON() {
        return MADON;
    }

    public String getLYDO() {
        return LYDO;
    }

    public Date getThoiGianLap() {
        return ThoiGianLap;
    }

    public Date getThoiGianBatDau() {
        return ThoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return ThoiGianKetThuc;
    }

    public int getMANV() {
        return MANV;
    }
    
    
}
