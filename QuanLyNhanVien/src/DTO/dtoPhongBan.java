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
public class dtoPhongBan {
    private int MAPB;
    private String TenPB;
    private String DiaChi;

    public dtoPhongBan(int MAPB, String TenPB, String DiaChi) {
        this.MAPB = MAPB;
        this.TenPB = TenPB;
        this.DiaChi = DiaChi;
    }

    public dtoPhongBan() {
    }

    public void setMAPB(int MAPB) {
        this.MAPB = MAPB;
    }

    public void setTenPB(String TenPB) {
        this.TenPB = TenPB;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getMAPB() {
        return MAPB;
    }

    public String getTenPB() {
        return TenPB;
    }

    public String getDiaChi() {
        return DiaChi;
    }
}
