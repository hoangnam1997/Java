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
public class dtoCtdk_ThemGio {
    private int MANV;
    private int MADKTHEMGIO;

    public dtoCtdk_ThemGio(int MANV, int MADKTHEMGIO) {
        this.MANV = MANV;
        this.MADKTHEMGIO = MADKTHEMGIO;
    }

    public dtoCtdk_ThemGio() {
    }

    public void setMANV(int MANV) {
        this.MANV = MANV;
    }

    public void setMADKTHEMGIO(int MADKTHEMGIO) {
        this.MADKTHEMGIO = MADKTHEMGIO;
    }

    public int getMANV() {
        return MANV;
    }

    public int getMADKTHEMGIO() {
        return MADKTHEMGIO;
    }
}
