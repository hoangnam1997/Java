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
public class dtoDangKyThemGio {
    private int MADKTHEMGIO;
    private String TENDK;
    private int SOGIODK;
    private int HESOLUONG_1GIO;
    private Date NGAY;

    public dtoDangKyThemGio() {
    }

    public dtoDangKyThemGio(int MADKTHEMGIO, String TENDK, int SOGIODK, int HESOLUONG_1GIO, Date NGAY) {
        this.MADKTHEMGIO = MADKTHEMGIO;
        this.TENDK = TENDK;
        this.SOGIODK = SOGIODK;
        this.HESOLUONG_1GIO = HESOLUONG_1GIO;
        this.NGAY = NGAY;
    }

    public void setMADKTHEMGIO(int MADKTHEMGIO) {
        this.MADKTHEMGIO = MADKTHEMGIO;
    }

    public void setTENDK(String TENDK) {
        this.TENDK = TENDK;
    }

    public void setSOGIODK(int SOGIODK) {
        this.SOGIODK = SOGIODK;
    }

    public void setHESOLUONG_1GIO(int HESOLUONG_1GIO) {
        this.HESOLUONG_1GIO = HESOLUONG_1GIO;
    }

    public void setNGAY(Date NGAY) {
        this.NGAY = NGAY;
    }

    public int getMADKTHEMGIO() {
        return MADKTHEMGIO;
    }

    public String getTENDK() {
        return TENDK;
    }

    public int getSOGIODK() {
        return SOGIODK;
    }

    public int getHESOLUONG_1GIO() {
        return HESOLUONG_1GIO;
    }

    public Date getNGAY() {
        return NGAY;
    }
}
