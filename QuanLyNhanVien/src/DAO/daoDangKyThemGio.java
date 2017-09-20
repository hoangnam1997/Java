/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.dtoDangKyThemGio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author NT
 */
public class daoDangKyThemGio {

    private static daoDangKyThemGio instance;

    public static daoDangKyThemGio getInstance() {
        if (instance == null) {
            instance = new daoDangKyThemGio();
        }
        return instance;
    }

    public daoDangKyThemGio() {
    }

    public ArrayList<dtoDangKyThemGio> getDanhSachDangKy(Date tuNgay) {
        ArrayList<dtoDangKyThemGio> result = new ArrayList<>();
        String query = "select *from dangkythemgio where NGAY>=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(tuNgay);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new dtoDangKyThemGio(rs.getInt("MADKTHEMGIO"), rs.getString("TENDK"),
                        rs.getInt("SOGIODK"), rs.getInt("HESOLUONG_1GIO"), rs.getDate("NGAY")));
            }
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        DataProvider.getIntance().close();
        return result;
    }

    public dtoDangKyThemGio getDangKyThemGio(int MADK) {
        dtoDangKyThemGio result = null;
        String query = "select *from dangkythemgio where MADKTHEMGIO=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MADK);
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            result= new dtoDangKyThemGio(rs.getInt("MADKTHEMGIO"), rs.getString("TENDK"),
                        rs.getInt("SOGIODK"), rs.getInt("HESOLUONG_1GIO"), rs.getDate("NGAY"));
        }
        }catch(SQLException ex)
        {
            DataProvider.getIntance().displayError(ex);
        }
        DataProvider.getIntance().close();
        return result;
    }
    public boolean insertDangKyThemGio(int MADK,String Ten,int SoGio,int Heso,Date Ngay)
    {
        String query = "insert dangkythemgio values(?,?,?,?,?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MADK);arr.add(Ten);arr.add(SoGio);arr.add(Heso);arr.add(Ngay);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public boolean updateDangKyThemGio(int MADK,String Ten,int SoGio,int Heso,Date Ngay)
    {
        String query = "update dangkythemgio set TENDK =?,SOGIODK=?,HESOLUONG_1GIO=?,NGAY=? where MADKTHEMGIO=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(Ten);arr.add(SoGio);arr.add(Heso);arr.add(Ngay);arr.add(MADK);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
     public boolean deleteDangKyThemGio(int MADK)
    {
        String query = "delete from dangkythemgio  where MADKTHEMGIO=?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(MADK);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
}
