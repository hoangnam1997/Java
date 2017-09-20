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
public class dtoChucVu {
    private int MACV;
    private String TenChucVu;
    private int MAPB;

    public void setMACV(int MACV) {
        this.MACV = MACV;
    }

    public void setTenChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }

    public void setMAPB(int MAPB) {
        this.MAPB = MAPB;
    }

    public int getMACV() {
        return MACV;
    }


    public String getTenChucVu() {
        return TenChucVu;
    }

    public int getMAPB() {
        return MAPB;
    }

    public dtoChucVu() {
    }

    public dtoChucVu(int MACV, String TenChucVu, int MAPB) {
        this.MACV = MACV;
        this.TenChucVu = TenChucVu;
        this.MAPB = MAPB;
    }
}
