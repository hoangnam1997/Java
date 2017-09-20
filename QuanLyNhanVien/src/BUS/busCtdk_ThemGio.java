/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoCtdk_ThemGio;
import DTO.dtoCtdk_ThemGio;
import javax.swing.JOptionPane;

/**
 *
 * @author NT
 */
public class busCtdk_ThemGio {
    private static busCtdk_ThemGio instance;

    public static busCtdk_ThemGio getInstance() {
        if(instance==null)instance=new busCtdk_ThemGio();
        return instance;
    }

    public busCtdk_ThemGio() {
    }
    public boolean insertCtdk_ThemGio(int MANV, int MADK)
    {
        if(busDangKyThemGio.getInstance().getDangKyThemGio(MADK)==null)
        {
            JOptionPane.showConfirmDialog(null, "Không tồn tại mã đăng ký!","Thông báo",-1,2);
            return false;
        }
        if(busCtdk_ThemGio.getInstance().getCTDK(MANV,MADK)!=null)
        {
            JOptionPane.showConfirmDialog(null, "Bạn đã đăng ký mã đăng ký này trước đó!","Thông báo",-1,2);
            return false;
        }
        return daoCtdk_ThemGio.getInstance().insertCtdk_ThemGio(MANV, MADK);
    }
    public dtoCtdk_ThemGio getCTDK(int MANV, int MADK) {
        return daoCtdk_ThemGio.getInstance().getCTDK(MANV, MADK);
    }
    public boolean deleteCtdk_ThemGio(int MANV) {
        return daoCtdk_ThemGio.getInstance().deleteCtdk_ThemGio(MANV);
    }
    public boolean deleteCtdk_ThemGio_MADK(int MADK) {
        return daoCtdk_ThemGio.getInstance().deleteCtdk_ThemGio_MADK(MADK);
    }
     public dtoCtdk_ThemGio getCTDK(int MADK) {

        return daoCtdk_ThemGio.getInstance().getCTDK(MADK);
    }
}
