/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.dtoDonXinNghi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author NT
 */
public class daoDonXinNghi {

    private static daoDonXinNghi instance;

    public static daoDonXinNghi getInstance() {
        if (instance == null) {
            instance = new daoDonXinNghi();
        }
        return instance;
    }

    public daoDonXinNghi() {
    }

    public boolean themDonXinNghi(String lyDo, Date thoiGianLap, Date thoiGianBatDau, Date thoiGianKetThuc, int MANV) {
        String query = "Call USP_insertDonXinNghi(?,?,?,?,?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(lyDo);
        arr.add(thoiGianLap);
        arr.add(thoiGianBatDau);
        arr.add(thoiGianKetThuc);
        arr.add(MANV);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    public boolean deleteDonXinNghi(int MANV) {
        String query = "delete from donxinnghi where MANV=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MANV);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
//lay danh sachs tuwf ngayf
    public ArrayList<dtoDonXinNghi> getListDonXinNgi(Date TuNgay) {
        ArrayList<dtoDonXinNghi> result = new ArrayList<dtoDonXinNghi>();
        String query = "Call USP_getDonXinNghi(?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(TuNgay);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new dtoDonXinNghi(rs.getInt("MADON"), rs.getString("LYDO"), rs.getDate("ThoiGianLap"), rs.getDate("THOIGIANBATDAU"), rs.getDate("ThoiGianKetThuc"), rs.getInt("MANV")));

            }
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        DataProvider.getIntance().close();
        return result;
    }
}
