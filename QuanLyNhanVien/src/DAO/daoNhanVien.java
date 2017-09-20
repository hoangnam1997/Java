/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.dtoNhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NT
 */
public class daoNhanVien {

    private static daoNhanVien instance;

    public static daoNhanVien getInstance() {
        if (instance == null) {
            instance = new daoNhanVien();
        }
        return instance;
    }

    public daoNhanVien() {
    }

    public dtoNhanVien getNhanVientheoMANV(int MANV) {
        dtoNhanVien result = null;
        String query = "Select * from NhanVien where MANV=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MANV);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = new dtoNhanVien(rs.getInt("MANV"), rs.getString("TENNV"), rs.getInt("GioiTinh"),
                        rs.getString("SDT"), rs.getString("DiaChi"), rs.getString("TaiKhoan"), rs.getInt("MAHD"));

            }
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        DataProvider.getIntance().close();
        return result;
    }

    public dtoNhanVien getNhanVientheoMAHD(int MAHD) {
        dtoNhanVien result = null;
        String query = "Select * from NhanVien where MAHD=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MAHD);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = new dtoNhanVien(rs.getInt("MANV"), rs.getString("TENNV"), rs.getInt("GioiTinh"),
                        rs.getString("SDT"), rs.getString("DiaChi"), rs.getString("TaiKhoan"), rs.getInt("MAHD"));

            }
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        DataProvider.getIntance().close();
        return result;
    }

    public dtoNhanVien getNhanVientheoTaiKhoan(String TaiKhoan) {
        dtoNhanVien result = null;
        String query = "Select * from NhanVien where taikhoan=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(TaiKhoan);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = new dtoNhanVien(rs.getInt("MANV"), rs.getString("TENNV"), rs.getInt("GioiTinh"),
                        rs.getString("SDT"), rs.getString("DiaChi"), rs.getString("TaiKhoan"), rs.getInt("MAHD"));

            }
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        DataProvider.getIntance().close();
        return result;
    }

    public boolean updateNhanVien(int MANV, String TenNV, int GioiTinh, String SDT, String DiaChi, String TaiKhoan, int MAHD) {
        String query = "Call USP_updateNhanVien(?,?,?,?,?,?,?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MANV);
        arr.add(TenNV);
        arr.add(GioiTinh);
        arr.add(SDT);
        arr.add(DiaChi);
        arr.add(TaiKhoan);
        arr.add(MAHD);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    public boolean insertNhanVien(int MANV, String TenNV, int GioiTinh, String SDT, String DiaChi, String TaiKhoan, int MAHD) {
        String query = "insert nhanvien values(?,?,?,?,?,?,?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MANV);
        arr.add(TenNV);
        arr.add(GioiTinh);
        arr.add(SDT);
        arr.add(DiaChi);
        arr.add(TaiKhoan);
        arr.add(MAHD);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    public boolean deleteNhanVien(int MANV) {
        String query = "delete from nhanvien where MANV =?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MANV);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    public ArrayList<dtoNhanVien> getDanhSachNhanVien(String Ten) {
        ArrayList<dtoNhanVien> result = new ArrayList<>();
        Ten = '%' + Ten + '%';
        String query = "select *from nhanvien where TENNV like ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(Ten);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new dtoNhanVien(rs.getInt("MANV"), rs.getString("TENNV"), rs.getInt("GioiTinh"),
                        rs.getString("SDT"), rs.getString("DiaChi"), rs.getString("TaiKhoan"), rs.getInt("MAHD")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }
     public int SoLuongNhanVienTheoMaHopDong(int MaHD) {
        int sl=0;
        String query = "SELECT COUNT(MANV) AS soluong FROM `nhanvien` WHERE MAHD=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MaHD);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                sl=rs.getInt("soluong");
            }
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        DataProvider.getIntance().close();
        return sl;
    }
}

