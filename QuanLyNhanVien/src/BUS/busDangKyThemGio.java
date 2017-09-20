/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoDangKyThemGio;
import DTO.dtoDangKyThemGio;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author NT
 */
public class busDangKyThemGio {
    private static busDangKyThemGio instance;

    public static busDangKyThemGio getInstance() {
        if(instance==null)instance=new busDangKyThemGio();
        return instance;
    }

    public busDangKyThemGio() {
    }
    public ArrayList<dtoDangKyThemGio> getDanhSachDangKy(Date tuNgay) {
        return daoDangKyThemGio.getInstance().getDanhSachDangKy(tuNgay);
    }
    public dtoDangKyThemGio getDangKyThemGio(int MADK) {
        return daoDangKyThemGio.getInstance().getDangKyThemGio(MADK);
    }
    public boolean insertDangKyThemGio(int MADK,String Ten,int SoGio,int Heso,Date Ngay)
    {
        if(busDangKyThemGio.getInstance().getDangKyThemGio(MADK)!=null)
        {
             JOptionPane.showConfirmDialog(null, "Đã tồn tại mã đăng ký!","Thông báo",-1,2);
            return false;
        }
        return daoDangKyThemGio.getInstance().insertDangKyThemGio(MADK, Ten, SoGio, Heso, Ngay);
    }
    public boolean updateDangKyThemGio(int MADK,String Ten,int SoGio,int Heso,Date Ngay)
    {
        if(busDangKyThemGio.getInstance().getDangKyThemGio(MADK)==null)
        {
            JOptionPane.showConfirmDialog(null, "Không tồn tại mã đăng ký!","Thông báo",-1,2);
            return false;
        }
        return daoDangKyThemGio.getInstance().updateDangKyThemGio(MADK, Ten, SoGio, Heso, Ngay);
    }
    public boolean deleteDangKyThemGio(int MADK)
    {
        if(busDangKyThemGio.getInstance().getDangKyThemGio(MADK)==null)
        {
            JOptionPane.showConfirmDialog(null, "Không tồn tại mã đăng ký!","Thông báo",-1,2);
            return false;
        }
        if(!busCtdk_ThemGio.getInstance().deleteCtdk_ThemGio_MADK(MADK))
        {
            
            return false;
        }
        return daoDangKyThemGio.getInstance().deleteDangKyThemGio(MADK);
    }
    
}
