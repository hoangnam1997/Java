/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoNgayLamViec;
import DTO.dtoNgayLamViec;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author NT
 */
public class busNgayLamViec {

    private static busNgayLamViec instance;

    public static busNgayLamViec getInstance() {
        if (instance == null) {
            instance = new busNgayLamViec();
        }
        return instance;
    }

    public busNgayLamViec() {
    }

    public dtoNgayLamViec getNgayLamViec(int MANV, Date time) {
        return daoNgayLamViec.getInstance().getNgayLamViec(MANV, time);
    }
    public boolean insertNgayLamViec(int MANV, Date time) {
        if(busNgayLamViec.getInstance().getNgayLamViec(MANV, time)!=null)
        {
            JOptionPane.showConfirmDialog(null,"Đã chấm công ngày hôm nay!","Thông báo",-1,1);
            return false;
        }
        return daoNgayLamViec.getInstance().insertNgayLamViec(MANV, time);
    }
        public boolean deleteNgayLamViec(int MANV) {
            return daoNgayLamViec.getInstance().deleteNgayLamViec(MANV);
        }
}

