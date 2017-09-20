/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.dtoNgayLamViec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author NT
 */
public class daoNgayLamViec {

    private static daoNgayLamViec instance;

    public static daoNgayLamViec getInstance() {
        if (instance == null) {
            instance = new daoNgayLamViec();
        }
        return instance;
    }

    public daoNgayLamViec() {
    }

    public dtoNgayLamViec getNgayLamViec(int MANV, Date time) {
        dtoNgayLamViec result = null;
        String query = "call USP_getNgayLamViec(?,?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(time);
        arr.add(MANV);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = new dtoNgayLamViec(rs.getDate("NgayLamViec"), rs.getInt("MANV"));
            }
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        DataProvider.getIntance().close();
        return result;
    }

    public boolean insertNgayLamViec(int MANV, Date time) {
        int result = -1;
        String query = "insert into ngaylamviec values(?,?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(time);
        arr.add(MANV);
        DataProvider.getIntance().open();
        result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public boolean deleteNgayLamViec(int MANV) {
        int result = -1;
        String query = "delete from ngaylamviec where MANV=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MANV);
        DataProvider.getIntance().open();
        result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
}
