/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.dtoTaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NT
 */
public class daoTaiKhoan {
    private static daoTaiKhoan instance;

    public static daoTaiKhoan getInstance() {
        if(instance==null) instance= new daoTaiKhoan();
        return instance;
    }

    public daoTaiKhoan() {
    }
    public dtoTaiKhoan layThongTinTaiKhoan(String TaiKhoan)
    {
        ResultSet rs;
        dtoTaiKhoan result = null;
         
        String query = "select *from taikhoan where taikhoan=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(TaiKhoan);
        try{
        DataProvider.getIntance().open();
        rs =DataProvider.getIntance().excuteQuery(query, arr);
        
        while(rs.next())
        {
            result = new dtoTaiKhoan(rs.getString("TAIKHOAN"),rs.getString("MATKHAU"),rs.getInt("LV"));
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex)
        {
            DataProvider.getIntance().displayError(ex);
        }
        return result;       
    }
    public boolean updateTaiKhoan(String TaiKhoan,String MatKhau,int LV)
    {
        String query="update taikhoan set MATKHAU=?,LV=? where TAIKHOAN=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MatKhau);arr.add(LV);arr.add(TaiKhoan);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result>0;
    }
    public boolean insertTaiKhoan(String TaiKhoan,String MatKhau,int LV)
    {
        String query="insert taikhoan values(?,?,?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(TaiKhoan);arr.add(MatKhau);arr.add(LV);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result>0;
    }
    public boolean deleteTaiKhoan(String TaiKhoan)
    {
        String query="delete from taikhoan where TAIKHOAN=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(TaiKhoan);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result>0;
    }
}
