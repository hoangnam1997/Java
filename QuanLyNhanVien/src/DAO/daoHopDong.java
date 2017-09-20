/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.dtoHopDong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author NT
 */
public class daoHopDong {
    private static daoHopDong instance;

    public daoHopDong() {
    }

    public static daoHopDong getInstance() {
        if(instance==null)instance= new daoHopDong();
        return instance;
    }
    public ArrayList<dtoHopDong> getDanhSachHopDong()
    {
        ArrayList<dtoHopDong> result = new ArrayList<>();
        String query="select * from HOPDONG";
        ArrayList<Object> arr = new ArrayList<>();
        try{
            DataProvider.getIntance().open();
            ResultSet rs= DataProvider.getIntance().excuteQuery(query, arr);
            while(rs.next())
            {
                result.add(new dtoHopDong(rs.getInt("MAHD"),rs.getInt("MACV"),rs.getDate("NGAYBATDAU"),rs.getDate("NGAYHETHAN"),rs.getFloat("TIENLUONG")));
            }
            DataProvider.getIntance().close();
        }catch(SQLException ex)
        {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    // lay danh sach hop dong theo ma chuc 
    public ArrayList<dtoHopDong> getDanhSachHopDong(int MACV)
    {
        ArrayList<dtoHopDong> result = new ArrayList<>();
        String query="select * from HOPDONG where MACV =?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MACV);
        try{
            DataProvider.getIntance().open();
            ResultSet rs= DataProvider.getIntance().excuteQuery(query, arr);
            while(rs.next())
            {
                result.add(new dtoHopDong(rs.getInt("MAHD"),rs.getInt("MACV"),rs.getDate("NGAYBATDAU"),rs.getDate("NGAYHETHAN"),rs.getFloat("TIENLUONG")));
            }
            DataProvider.getIntance().close();
        }catch(SQLException ex)
        {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    //lay danh sach theo mahd gan dung
    public ArrayList<dtoHopDong> getDanhSachHopDongGanDung(int mahd)
    {
        
        ArrayList<dtoHopDong> result = new ArrayList<>();
        String query="select * from HOPDONG where MAHD like ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(mahd);
        try{
            DataProvider.getIntance().open();
            ResultSet rs= DataProvider.getIntance().excuteQuery(query, arr);
            while(rs.next())
            {
                result.add(new dtoHopDong(rs.getInt("MAHD"),rs.getInt("MACV"),rs.getDate("NGAYBATDAU"),rs.getDate("NGAYHETHAN"),rs.getFloat("TIENLUONG")));
            }
            DataProvider.getIntance().close();
        }catch(SQLException ex)
        {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public dtoHopDong getHopDong(int mahd)
    {
        
        dtoHopDong result = null;
        String query="select * from HOPDONG where MAHD = ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(mahd);
        try{
            DataProvider.getIntance().open();
            ResultSet rs= DataProvider.getIntance().excuteQuery(query, arr);
            while(rs.next())
            {
                result=(new dtoHopDong(rs.getInt("MAHD"),rs.getInt("MACV"),rs.getDate("NGAYBATDAU"),rs.getDate("NGAYHETHAN"),rs.getFloat("TIENLUONG")));
            }
            DataProvider.getIntance().close();
        }catch(SQLException ex)
        {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public dtoHopDong getHopDongtheoMaHD(int mahd)
    {
        dtoHopDong result = null;
        String query="select * from HOPDONG where mahd=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(mahd);
        try{
            DataProvider.getIntance().open();
            ResultSet rs= DataProvider.getIntance().excuteQuery(query, arr);
            if(rs.next())
            {
                result=(new dtoHopDong(rs.getInt("MAHD"),rs.getInt("MACV"),rs.getDate("NGAYBATDAU"),rs.getDate("NGAYHETHAN"),rs.getFloat("TIENLUONG")));
            }
            DataProvider.getIntance().close();
        }catch(SQLException ex)
        {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    
    public boolean insertHopDong(int MAHD, int MACV,Date TuNgay,Date denNgay,Float Tien)
    {
        String query="insert into hopdong values(?,?,?,?,?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MAHD);arr.add(MACV);arr.add(TuNgay);arr.add(denNgay);arr.add(Tien);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result>0;
    }
    public boolean updateHopDong(int MAHD, int MACV,Date TuNgay,Date denNgay,Float Tien)
    {
        String query="update hopdong set MACV=?,NGAYBATDAU=?,NGAYHETHAN=?,TIENLUONG=? where MAHD=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MACV);arr.add(TuNgay);arr.add(denNgay);arr.add(Tien);arr.add(MAHD);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result>0;
    }
    public boolean deleteHopDong(int MAHD)
    {
        String query="delete from hopdong where MAHD=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MAHD);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result>0;
    }
}
