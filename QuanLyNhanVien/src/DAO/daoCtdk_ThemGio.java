/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.dtoCtdk_ThemGio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NT
 */
public class daoCtdk_ThemGio {

    private static daoCtdk_ThemGio instance;

    public static daoCtdk_ThemGio getInstance() {
        if (instance == null) {
            instance = new daoCtdk_ThemGio();
        }
        return instance;
    }

    public daoCtdk_ThemGio() {
    }

    public boolean insertCtdk_ThemGio(int MANV, int MADK) {
        String query = "insert ctdk_themgio values(?,?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MANV);
        arr.add(MADK);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    public boolean deleteCtdk_ThemGio(int MANV) {
        String query = "delete from ctdk_themgio where MANV=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MANV);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    public boolean deleteCtdk_ThemGio_MADK(int MADK) {
        String query = "delete from ctdk_themgio where MADKTHEMGIO=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MADK);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    public dtoCtdk_ThemGio getCTDK(int MANV, int MADK) {
        dtoCtdk_ThemGio result = null;
        String query = "select *from ctdk_themgio where manv =? and MADKTHEMGIO = ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MANV);
        arr.add(MADK);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = new dtoCtdk_ThemGio(rs.getInt("MANV"), rs.getInt("MADKTHEMGIO"));
            }
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
     public dtoCtdk_ThemGio getCTDK(int MADK) {
        dtoCtdk_ThemGio result = null;
        String query = "select *from ctdk_themgio where MADKTHEMGIO = ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MADK);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = new dtoCtdk_ThemGio(rs.getInt("MANV"), rs.getInt("MADKTHEMGIO"));
            }
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
}
