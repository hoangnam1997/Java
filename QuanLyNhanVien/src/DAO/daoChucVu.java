/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.dtoChucVu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NT
 */
public class daoChucVu {
    private static daoChucVu instance;

    public static daoChucVu getInstance() {
        if(instance==null)instance=new daoChucVu();
        return instance;
    }

    public daoChucVu() {
    }
    //Lay danh sach cuc vu boi ma phong ban
    public ArrayList<dtoChucVu> getDanhSachChucVu(int MAPB)
    {
        ArrayList<dtoChucVu> result = new ArrayList<>();
        String query="select *from chucvu where MAPB=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MAPB);
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new dtoChucVu(rs.getInt("MACV"),rs.getString("TENCV"),rs.getInt("MAPB")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    public ArrayList<dtoChucVu> getDanhSachChucVu()
    {
        ArrayList<dtoChucVu> result = new ArrayList<>();
        String query="select *from chucvu";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new dtoChucVu(rs.getInt("MACV"),rs.getString("TENCV"),rs.getInt("MAPB")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    public ArrayList<dtoChucVu> getDanhSachChucVu(String Ten, int MAPB)
    {
        ArrayList<dtoChucVu> result = new ArrayList<>();
        String query="select *from chucvu where TENCV like ? and MAPB=?";
        ArrayList<Object> arr = new ArrayList<>();
        Ten="%"+Ten+"%";
        arr.add(Ten);
        arr.add(MAPB);
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new dtoChucVu(rs.getInt("MACV"),rs.getString("TENCV"),rs.getInt("MAPB")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    public boolean insertChucVu(int MACV,String TENCV,int MAPB)
    {
        String query="insert into chucvu values(?,?,?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MACV);arr.add(TENCV);arr.add(MAPB);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result >0;
    }
    public boolean updateChucVu(int MACV,String TENCV,int MAPB)
    {
        String query="update chucvu set TENCV=?,MAPB=? where MACV=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(TENCV);arr.add(MAPB);arr.add(MACV);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result >0;
    }
    public boolean deleteChucVu(int MACV)
    {
        String query="delete from chucvu where MACV=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MACV);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result >0;
    }
    public dtoChucVu getChucVu(int MACV)
    {
        dtoChucVu result = null;
        String query="select *from chucvu where MACV = ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MACV);
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            result=(new dtoChucVu(rs.getInt("MACV"),rs.getString("TENCV"),rs.getInt("MAPB")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
}
