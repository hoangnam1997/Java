/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoNhanVien;
import DTO.dtoNhanVien;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NT
 */
public class busNhanVien {

    private static busNhanVien instance;

    public static busNhanVien getInstance() {
        if (instance == null) {
            instance = new busNhanVien();
        }
        return instance;
    }

    public busNhanVien() {
    }

    public dtoNhanVien getNhanVientheoTaiKhoan(String TaiKhoan) {
        return daoNhanVien.getInstance().getNhanVientheoTaiKhoan(TaiKhoan);
    }

    public boolean updateNhanVien(int MANV, String TenNV, int GioiTinh, String SDT, String DiaChi, String TaiKhoan, int MAHD) {
        if (busNhanVien.getInstance().getNhanVientheoMANV(MANV) == null) {
            JOptionPane.showConfirmDialog(null, "Không tìm thấy nhân viên!", "Thông báo", -1, 2);
            return false;
        }
        return daoNhanVien.getInstance().updateNhanVien(MANV, TenNV, GioiTinh, SDT, DiaChi, TaiKhoan, MAHD);
    }

    public boolean insertNhanVien(int MANV, String TenNV, int GioiTinh, String SDT, String DiaChi, String TaiKhoan, int MAHD) {
        if (busNhanVien.getInstance().getNhanVientheoMANV(MANV) != null) {
            JOptionPane.showConfirmDialog(null, "Đã tồn tại mã nhân viên!", "Thông báo", -1, 2);
            return false;
        }
        return daoNhanVien.getInstance().insertNhanVien(MANV, TenNV, GioiTinh, SDT, DiaChi, TaiKhoan, MAHD);
    }

    public dtoNhanVien getNhanVientheoMANV(int MANV) {
        return daoNhanVien.getInstance().getNhanVientheoMANV(MANV);
    }

    public ArrayList<dtoNhanVien> getDanhSachNhanVien(String Ten) {
        return daoNhanVien.getInstance().getDanhSachNhanVien(Ten);
    }
    //Xoa tat ca cac bang lien quan
    public boolean deleteNhanVien(int MANV) {
        dtoNhanVien nv = busNhanVien.getInstance().getNhanVientheoMANV(MANV);
        if (nv == null) {
            JOptionPane.showConfirmDialog(null, "Không tồn tại mã nhân viên!", "Thông báo", -1, 2);
            return false;
        }
        
        if (!busDonXinNghi.getInstance().deleteDonXinNghi(nv.getMANV())) {
            return false;
        }
        if (!busCtdk_ThemGio.getInstance().deleteCtdk_ThemGio(nv.getMANV())) {
            return false;
        }
        if (!busChamLuong.getInstance().deleteChamLuongNhanVien(nv.getMANV())) {
            return false;
        }
        if (!busNgayLamViec.getInstance().deleteNgayLamViec(nv.getMANV())) {
            return false;
        }
        if (!daoNhanVien.getInstance().deleteNhanVien(MANV)) {
            return false;
        }
        if (!busTaiKhoan.getInstance().deleteTaiKhoan(nv.getTAIKHOAN())) {
            return false;
        }
        return true;
    }
     public dtoNhanVien getNhanVientheoMAHD(int MAHD) {
         return daoNhanVien.getInstance().getNhanVientheoMAHD(MAHD);
     }
     public int SoLuongNhanVienTheoMaHopDong(int MaHD){
         return daoNhanVien.getInstance().SoLuongNhanVienTheoMaHopDong(MaHD);
    }
}
