/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoChucVu;
import DTO.dtoChucVu;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NT
 */
public class busChucVu {

    private static busChucVu instance;

    public static busChucVu getInstance() {
        if (instance == null) {
            instance = new busChucVu();
        }
        return instance;
    }

    public busChucVu() {
    }

    public ArrayList<dtoChucVu> getDanhSachChucVu(int MAPB) {
        return daoChucVu.getInstance().getDanhSachChucVu(MAPB);
    }

    public ArrayList<dtoChucVu> getDanhSachChucVu() {
        return daoChucVu.getInstance().getDanhSachChucVu();
    }
     public ArrayList<dtoChucVu> getDanhSachChucVu(String Ten,int MAPB)
    {
        return daoChucVu.getInstance().getDanhSachChucVu(Ten,MAPB);
    }
     public boolean insertChucVu(int MACV,String TENCV,int MAPB)
    {
        if(busChucVu.getInstance().getChucVu(MACV)!=null)
        {
            JOptionPane.showConfirmDialog(null, "Đã tồn tại chức vụ!","Thông báo",-1,2);
            return false;
        }
        return daoChucVu.getInstance().insertChucVu(MACV, TENCV, MAPB);
    }
     public boolean updateChucVu(int MACV,String TENCV,int MAPB)
    {
        if(busChucVu.getInstance().getChucVu(MACV)==null)
        {
            JOptionPane.showConfirmDialog(null, "Không tồn tại chức vụ!","Thông báo",-1,2);
            return false;
        }
        return daoChucVu.getInstance().updateChucVu(MACV, TENCV, MAPB);
    }
     public boolean deleteChucVu(int MACV)
    {
         if(busChucVu.getInstance().getChucVu(MACV)==null)
        {
            JOptionPane.showConfirmDialog(null, "Không tồn tại chức vụ!","Thông báo",-1,2);
            return false;
        }
        if(busHopDong.getInstance().getDanhSachHopDong(MACV).size()>0)
        {
            JOptionPane.showConfirmDialog(null, "Tồn tại danh sách hợp đồng thuộc chức vụ!","Thông báo",-1,2);
            return false;
        }     
        return daoChucVu.getInstance().deleteChucVu(MACV);
    }
     public dtoChucVu getChucVu(int MACV)
    {
        return daoChucVu.getInstance().getChucVu(MACV);
    }
}
