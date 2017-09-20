/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoHopDong;
import DTO.dtoChucVu;
import DTO.dtoHopDong;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author NT
 */
public class busHopDong {

    private static busHopDong instance;

    public static busHopDong getInstance() {
        if (instance == null) {
            instance = new busHopDong();
        }
        return instance;
    }

    public busHopDong() {
    }

    public ArrayList<dtoHopDong> getDanhSachHopDong(int MACV) {
        return daoHopDong.getInstance().getDanhSachHopDong(MACV);
    }

    public ArrayList<dtoHopDong> getDanhSachHopDongTheoPhongBan(int MAPB) {
        ArrayList<dtoChucVu> listCV = busChucVu.getInstance().getDanhSachChucVu(MAPB);
        ArrayList<dtoHopDong> list= new ArrayList<>();
        for (dtoChucVu item : listCV) {
            list.addAll(daoHopDong.getInstance().getDanhSachHopDong(item.getMACV()));
        }
        return list;
    }

    public ArrayList<dtoHopDong> getDanhSachHopDong() {
        return daoHopDong.getInstance().getDanhSachHopDong();
    }

    public ArrayList<dtoHopDong> getDanhSachHopDongGanDung(int MAHD) {
        return daoHopDong.getInstance().getDanhSachHopDongGanDung(MAHD);
    }

    public boolean insertHopDong(int MAHD, int MACV, Date TuNgay, Date denNgay, Float Tien) {
        if (daoHopDong.getInstance().getHopDongtheoMaHD(MAHD) != null) {
            JOptionPane.showConfirmDialog(null, "Đã tồn tại mã hợp đồng", "Thông báo", -1, 2);
            return false;
        }
        return daoHopDong.getInstance().insertHopDong(MAHD, MACV, TuNgay, denNgay, Tien);

    }

    public boolean updateHopDong(int MAHD, int MACV, Date TuNgay, Date denNgay, Float Tien) {
        if (daoHopDong.getInstance().getHopDongtheoMaHD(MAHD) == null) {
            JOptionPane.showConfirmDialog(null, "Không tồn tại mã hợp đồng", "Thông báo", -1, 2);
            return false;
        }
        return daoHopDong.getInstance().updateHopDong(MAHD, MACV, TuNgay, denNgay, Tien);

    }

    public boolean deleteHopDong(int MAHD) {
        if (busNhanVien.getInstance().getNhanVientheoMAHD(MAHD) != null) {
            JOptionPane.showConfirmDialog(null, "Có nhân viên thuộc hợp đồng! vui lòng xoa nhân viên!", "Thông báo", -1, 2);
            return false;
        }
        if (daoHopDong.getInstance().getHopDongtheoMaHD(MAHD) == null) {
            JOptionPane.showConfirmDialog(null, "Không tồn tại mã hợp đồng", "Thông báo", -1, 2);
            return false;
        }
        return daoHopDong.getInstance().deleteHopDong(MAHD);
    }

    public dtoHopDong getHopDong(int mahd) {
        return daoHopDong.getInstance().getHopDong(mahd);
    }
}
