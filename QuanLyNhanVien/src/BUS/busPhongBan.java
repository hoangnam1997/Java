/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoPhongBan;
import DTO.dtoPhongBan;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NT
 */
public class busPhongBan {

    private static busPhongBan instance;

    public static busPhongBan getInstance() {
        if (instance == null) {
            instance = new busPhongBan();
        }
        return instance;
    }

    public busPhongBan() {
    }

    public ArrayList<dtoPhongBan> getDanhSachPhongBan(String Ten) {
        return daoPhongBan.getInstance().getDanhSachPhongBan(Ten);
    }

    public ArrayList<dtoPhongBan> getDanhSachPhongBan() {
        return daoPhongBan.getInstance().getDanhSachPhongBan();
    }

    public boolean insertPhongBan(int MAPB, String ten, String DiaChi) {
        if (busPhongBan.getInstance().getPhongBan(MAPB) != null) {
            JOptionPane.showConfirmDialog(null, "Đã tồn tại phòng ban!", "Thông báo", -1, 2);
            return false;
        }
        return daoPhongBan.getInstance().insertPhongBan(MAPB, ten, DiaChi);
    }

    public dtoPhongBan getPhongBan(int MAPB) {
        return daoPhongBan.getInstance().getPhongBan(MAPB);
    }

    public boolean updatePhongBan(int MAPB, String ten, String DiaChi) {
        if (busPhongBan.getInstance().getPhongBan(MAPB) == null) {
            JOptionPane.showConfirmDialog(null, "Không tồn tại phòng ban!", "Thông báo", -1, 2);
            return false;
        }
        return daoPhongBan.getInstance().updatePhongBan(MAPB, ten, DiaChi);
    }

    public boolean deletePhongBan(int MAPB) {
        if (busChucVu.getInstance().getDanhSachChucVu(MAPB).size() > 0) {
            JOptionPane.showConfirmDialog(null, "Vui lòng xóa các chức vụ thuộc phòng ban trước!", "Thông báo", -1, 2);
            return false;
        }
        if (busPhongBan.getInstance().getPhongBan(MAPB) == null) {
            JOptionPane.showConfirmDialog(null, "Không tồn tại phòng ban!", "Thông báo", -1, 2);
            return false;
        }
        return daoPhongBan.getInstance().deletePhongBan(MAPB);
    }
}
