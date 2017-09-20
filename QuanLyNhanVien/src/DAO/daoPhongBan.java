/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.dtoPhongBan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NT
 */
public class daoPhongBan {

    private static daoPhongBan instance;

    public static daoPhongBan getInstance() {
        if (instance == null) {
            instance = new daoPhongBan();
        }
        return instance;
    }

    public daoPhongBan() {
    }

    public ArrayList<dtoPhongBan> getDanhSachPhongBan(String Ten) {
        ArrayList<dtoPhongBan> result = new ArrayList<>();
        String query = "select *from `phongban` where TENPB like ?";
        ArrayList<Object> arr = new ArrayList<>();
        Ten = "%" + Ten + "%";
        arr.add(Ten);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new dtoPhongBan(rs.getInt("MAPB"), rs.getString("TENPB"), rs.getString("DIACHI")));
            }
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        DataProvider.getIntance().close();
        return result;
    }

    public ArrayList<dtoPhongBan> getDanhSachPhongBan() {
        ArrayList<dtoPhongBan> result = new ArrayList<>();
        String query = "select *from `phongban`";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new dtoPhongBan(rs.getInt("MAPB"), rs.getString("TENPB"), rs.getString("DIACHI")));
            }
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        DataProvider.getIntance().close();
        return result;
    }

    public boolean insertPhongBan(int MAPB, String ten,String DiaChi) {
        String query="insert into phongban values(?,?,?)";
        int result;
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MAPB);arr.add(ten);arr.add(DiaChi);
        DataProvider.getIntance().open();
        result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result>0;
    }
    public boolean updatePhongBan(int MAPB, String ten,String DiaChi) {
        String query="update phongban set TENPB=?,DIACHI=? where MAPB=?";
        int result;
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(ten);arr.add(DiaChi);arr.add(MAPB);
        DataProvider.getIntance().open();
        result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result>0;
    }
    public boolean deletePhongBan(int MAPB) {
        String query="delete from phongban where MAPB=?";
        int result;
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MAPB);
        DataProvider.getIntance().open();
        result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result>0;
    }
    public dtoPhongBan getPhongBan(int MAPB) {
        dtoPhongBan result = null;
        String query = "select *from `phongban` where MAPB =?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MAPB);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result=(new dtoPhongBan(rs.getInt("MAPB"), rs.getString("TENPB"), rs.getString("DIACHI")));
            }
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        DataProvider.getIntance().close();
        return result;
    }

}
