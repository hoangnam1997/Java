/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;


import DAO.daoTaiKhoan;
import DTO.dtoTaiKhoan;
import javax.swing.JOptionPane;

/**
 *
 * @author NT
 */
public class busTaiKhoan {
    private static busTaiKhoan instance;

    public static busTaiKhoan getInstance() {
        if(instance==null) instance= new busTaiKhoan();
        return instance;
    }

    public busTaiKhoan() {
    }
    public dtoTaiKhoan layThongTinTaiKhoan(String TaiKhoan)
    {
        return daoTaiKhoan.getInstance().layThongTinTaiKhoan(TaiKhoan);       
    }
    public boolean updateTaiKhoan(String TaiKhoan,String MatKhau,int LV)
    {
        if(busTaiKhoan.getInstance().layThongTinTaiKhoan(TaiKhoan)==null)
        {
            JOptionPane.showConfirmDialog(null, "Không tồn tại tài khoản!","Thông báo",-1,2);
            return false;
        }
        return daoTaiKhoan.getInstance().updateTaiKhoan(TaiKhoan, MatKhau, LV);
    }
    public boolean insertTaiKhoan(String TaiKhoan,String MatKhau,int LV)
    {
        if(busTaiKhoan.getInstance().layThongTinTaiKhoan(TaiKhoan)!=null)
        {
            JOptionPane.showConfirmDialog(null, "Tài khoản đã tồn tại!","Thông báo",-1,2);
            return false;
        }
        return daoTaiKhoan.getInstance().insertTaiKhoan(TaiKhoan, MatKhau, LV);
    }
    public boolean deleteTaiKhoan(String TaiKhoan)
    {
        if(busTaiKhoan.getInstance().layThongTinTaiKhoan(TaiKhoan)==null)
        {
            JOptionPane.showConfirmDialog(null, "Không tìm thấy tài khoản!","Thông báo",-1,2);
            return false;
        }
        return daoTaiKhoan.getInstance().deleteTaiKhoan(TaiKhoan);
    }
}
