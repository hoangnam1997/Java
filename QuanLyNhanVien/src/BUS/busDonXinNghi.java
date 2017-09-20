/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DataProvider;
import DAO.daoDonXinNghi;
import DTO.dtoDonXinNghi;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author NT
 */
public class busDonXinNghi {
    private static  busDonXinNghi instance;

    public static busDonXinNghi getInstance() {
        if(instance==null)instance = new busDonXinNghi();
        return instance;
    }

    public busDonXinNghi() {
    }
    public boolean themDonXinNghi(String lyDo,Date thoiGianLap,Date thoiGianBatDau,Date thoiGianKetThuc,int MANV)
    {
        return daoDonXinNghi.getInstance().themDonXinNghi(lyDo, thoiGianLap, thoiGianBatDau, thoiGianKetThuc, MANV);
    }
    public boolean deleteDonXinNghi(int MANV)
    {
        return daoDonXinNghi.getInstance().deleteDonXinNghi( MANV);
    }
     public ArrayList<dtoDonXinNghi> getListDonXinNgi(Date TuNgay) {
         return daoDonXinNghi.getInstance().getListDonXinNgi(TuNgay);
     }
}
