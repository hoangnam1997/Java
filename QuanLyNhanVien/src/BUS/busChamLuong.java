/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoChamLuongNhanVien;
import DTO.dtoChamLuongNhanVien;
import DTO.dtoHopDong;
import DTO.dtoNhanVien;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author NT
 */
public class busChamLuong {

    private static busChamLuong instance;

    public static busChamLuong getInstance() {
        if (instance == null) {
            instance = new busChamLuong();
        }
        return instance;
    }

    public float TinhLuong(int MANV) {
        dtoNhanVien nhanVien = busNhanVien.getInstance().getNhanVientheoMANV(MANV);
        dtoHopDong hopDong = busHopDong.getInstance().getHopDong(nhanVien.getMAHD());
        return daoChamLuongNhanVien.getInstance().soNgayLamViec(MANV) * hopDong.getTIENLUONG() + daoChamLuongNhanVien.getInstance().TinhLuongThemGio(MANV);
    }

    public busChamLuong() {
    }

    public int soNgayLamViec(int MANV) {
        return daoChamLuongNhanVien.getInstance().soNgayLamViec(MANV);
    }

    public int soNgayLamViecTheoNgay(int MANV, Date Ngay, Date NgayCuoi) {
        return daoChamLuongNhanVien.getInstance().soNgayLamViecTheoNgay(MANV, Ngay, NgayCuoi);
    }

    public int soGioLamThem(int MANV) {
        return daoChamLuongNhanVien.getInstance().soGioLamThem(MANV);
    }

    public int soGioLamThemTheoNgay(int MANV, Date Ngay, Date Ngaycuoi) {
        return daoChamLuongNhanVien.getInstance().soGioLamThemTheoNgay(MANV, Ngay, Ngaycuoi);
    }

    public boolean deleteChamLuongNhanVien(int MANV) {
        return daoChamLuongNhanVien.getInstance().deleteChamLuongNhanVien(MANV);
    }

    public ArrayList<Date> NgayChamLuong() {
        return daoChamLuongNhanVien.getInstance().NgayChamLuong();
    }

    public ArrayList<dtoChamLuongNhanVien> GetChamLuong(String Date) {
        return daoChamLuongNhanVien.getInstance().GetChamLuong(Date);
    }

    public boolean ChamLuongNhanVien(int MANV) {
        Date ngaychamcuoicung = daoChamLuongNhanVien.getInstance().NgayChamLuongCuoiCung(MANV);
        Calendar c = Calendar.getInstance();
        c.setTime(ngaychamcuoicung);
        c.add(Calendar.DATE, 1);
        ngaychamcuoicung = c.getTime();
        dtoNhanVien nhanVien = busNhanVien.getInstance().getNhanVientheoMANV(MANV);
        dtoHopDong hopDong = busHopDong.getInstance().getHopDong(nhanVien.getMAHD());
        float Luong = daoChamLuongNhanVien.getInstance().soNgayLamViec(MANV) * hopDong.getTIENLUONG() + daoChamLuongNhanVien.getInstance().TinhLuongThemGio(MANV);
        dtoChamLuongNhanVien IP = new dtoChamLuongNhanVien(0, MANV, ngaychamcuoicung, Calendar.getInstance().getTime(), Luong);
        return daoChamLuongNhanVien.getInstance().ChamLuongNhanVien(IP);
    }
}
