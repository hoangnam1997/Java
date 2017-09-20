/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.dtoChamLuongNhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author NT
 */
public class daoChamLuongNhanVien {

    private static daoChamLuongNhanVien instance;

    public static daoChamLuongNhanVien getInstance() {
        if (instance == null) {
            instance = new daoChamLuongNhanVien();
        }
        return instance;
    }

    public daoChamLuongNhanVien() {
    }

    //xóa theo mã nhân viên
    public boolean deleteChamLuongNhanVien(int MACL) {
        String query = "delete from chamluongnhanvien where MACL=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MACL);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    public Date NgayChamLuongCuoiCung(int MANV) {
        Date date = null;
        try {
            String query = "SELECT MAX(`DENNGAY`) AS MAX FROM `chamluongnhanvien` WHERE MANV=?";
            ArrayList<Object> arr = new ArrayList<>();
            arr.add(MANV);
            DataProvider.getIntance().open();
            ResultSet result = DataProvider.getIntance().excuteQuery(query, arr);
            if (result.next()) {
                date = result.getDate("MAX");
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return date;
    }

    public int soNgayLamViec(int MANV) {
        int so = 0;
        try {
            ArrayList<Object> arr = new ArrayList<>();
            String query = "SELECT COUNT(DISTINCT `NgayLamViec`) as songaylamviec FROM `ngaylamviec` WHERE `MANV`=?";
            if (NgayChamLuongCuoiCung(MANV) != null) {
                query = "SELECT COUNT(DISTINCT `NgayLamViec`) as songaylamviec FROM `ngaylamviec` WHERE `MANV`=? and `NgayLamViec` > ?";
            }
            arr.add(MANV);
            if (NgayChamLuongCuoiCung(MANV) != null) {
                arr.add(NgayChamLuongCuoiCung(MANV));
            }
            DataProvider.getIntance().open();
            ResultSet result = DataProvider.getIntance().excuteQuery(query, arr);
            if (result.next()) {
                so = result.getInt("songaylamviec");
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return so;
    }

    public int soNgayLamViecTheoNgay(int MANV, Date Ngay, Date Ngaycuoi) {
        int so = 0;
        try {
            ArrayList<Object> arr = new ArrayList<>();
            String query = "SELECT COUNT(DISTINCT `NgayLamViec`) as songaylamviec FROM `ngaylamviec` WHERE `MANV`=? and `NgayLamViec` >= ? and `NgayLamViec` <= ?";
            arr.add(MANV);
            arr.add(Ngay);
            arr.add(Ngaycuoi);
            DataProvider.getIntance().open();
            ResultSet result = DataProvider.getIntance().excuteQuery(query, arr);
            if (result.next()) {
                so = result.getInt("songaylamviec");
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return so;
    }

    public int soGioLamThem(int MANV) {
        int so = 0;
        try {
            ArrayList<Object> arr = new ArrayList<>();
            String query = "SELECT SUM(SOGIODK) AS TONGSOGIO FROM `ctdk_themgio`,`dangkythemgio` WHERE ctdk_themgio.MADKTHEMGIO = dangkythemgio.MADKTHEMGIO and MANV=?";
            if (NgayChamLuongCuoiCung(MANV) != null) {
                query = "SELECT SUM(SOGIODK) AS TONGSOGIO FROM `ctdk_themgio`,`dangkythemgio` WHERE ctdk_themgio.MADKTHEMGIO = dangkythemgio.MADKTHEMGIO and MANV=? and NGAY > ?";
            }
            arr.add(MANV);
            if (NgayChamLuongCuoiCung(MANV) != null) {
                arr.add(NgayChamLuongCuoiCung(MANV));
            }
            DataProvider.getIntance().open();
            ResultSet result = DataProvider.getIntance().excuteQuery(query, arr);
            if (result.next()) {
                so = result.getInt("TONGSOGIO");
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return so;
    }

    public int soGioLamThemTheoNgay(int MANV, Date Ngay,Date Ngaycuoi) {
        int so = 0;
        try {
            ArrayList<Object> arr = new ArrayList<>();
            String query = "SELECT SUM(SOGIODK) AS TONGSOGIO FROM `ctdk_themgio`,`dangkythemgio` WHERE ctdk_themgio.MADKTHEMGIO = dangkythemgio.MADKTHEMGIO and MANV=? and NGAY >= ? and NGAY<= ?";
            arr.add(MANV);
            arr.add(Ngay);
            arr.add(Ngaycuoi);
            DataProvider.getIntance().open();
            ResultSet result = DataProvider.getIntance().excuteQuery(query, arr);
            if (result.next()) {
                so = result.getInt("TONGSOGIO");
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return so;
    }

    public boolean ChamLuongNhanVien(dtoChamLuongNhanVien IP) {
        String query = "INSERT INTO `quanlynhanvien`.`chamluongnhanvien` (`MANV`, `TUNGAY`, `DENNGAY`, `TONGLUONG`) VALUES (?, ?, ?, ?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(IP.getMANV());
        arr.add(IP.getTuNGay());
        arr.add(IP.getDenNgay());
        arr.add(IP.getTongLuong());
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public ArrayList<Date> NgayChamLuong(){
        ArrayList<Date> list = new ArrayList<>();
        String query="SELECT * FROM `chamluongnhanvien` group by `DENNGAY`";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            list.add(rs.getDate("DENNGAY"));
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return list;
    }
    public ArrayList<dtoChamLuongNhanVien> GetChamLuong(String Date){
        ArrayList<dtoChamLuongNhanVien> list = new ArrayList<>();
        String query="SELECT * FROM `chamluongnhanvien` WHERE `DENNGAY`=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(Date);
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            list.add(new dtoChamLuongNhanVien(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getFloat(5)));
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return list;
    }
    public boolean ChamLuongNhanVienMoi(int MANV) {
        String query = "INSERT INTO `quanlynhanvien`.`chamluongnhanvien` (`MANV`, `TUNGAY`, `DENNGAY`, `TONGLUONG`) VALUES (?, '2017-01-01', '2017-01-01', 0)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MANV);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    public float TinhLuongThemGio(int MANV) {
        float TienLamThem = 0;
        String query = "SELECT * FROM `ctdk_themgio`,`dangkythemgio` WHERE `ctdk_themgio`.`MADKTHEMGIO`=`dangkythemgio`.`MADKTHEMGIO` and MANV=?";
        if (NgayChamLuongCuoiCung(MANV) != null) {
            query = "SELECT * FROM `ctdk_themgio`,`dangkythemgio` WHERE `ctdk_themgio`.`MADKTHEMGIO`=`dangkythemgio`.`MADKTHEMGIO` and MANV=? and NGAY > ?";
        }
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MANV);
        if (NgayChamLuongCuoiCung(MANV) != null) {
            arr.add(NgayChamLuongCuoiCung(MANV));
        }
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                TienLamThem = +rs.getInt("SOGIODK") * rs.getFloat("HESOLUONG_1GIO");
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return TienLamThem;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().TinhLuongThemGio(1));
    }
}
