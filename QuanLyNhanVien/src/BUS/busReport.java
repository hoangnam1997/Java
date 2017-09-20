/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Admin
 */
public class busReport {

    private static String url = "jdbc:mysql://localhost:3306/quanlynhanvien?useUnicode=true&characterEncoding=UTF-8";
    private static String user = "root";
    private static String pass = "";

    public static void rpHopDong() {
        try {
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
            DriverManager.registerDriver(driver);// dang ky driver         
            Connection conn = DriverManager.getConnection(url, user, pass);
            try {
                String Rb = "src/Report/newReport.jrxml";
                JasperReport JASP = JasperCompileManager.compileReport(Rb);
                JasperPrint PR = JasperFillManager.fillReport(JASP, null, conn);
                JasperViewer.viewReport(PR, false);
            } catch (JRException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(busReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void rpHopDongTheoPhongBan(int MAPB) {
        try {
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
            DriverManager.registerDriver(driver);// dang ky driver         
            Connection conn = DriverManager.getConnection(url, user, pass);
            try {
                Hashtable hash = new Hashtable();
                hash.put("MAPB", new Integer(MAPB));
                String Rb = "src/Report/rpHDtheoPhongBan.jrxml";
                JasperReport JASP = JasperCompileManager.compileReport(Rb);
                JasperPrint PR = JasperFillManager.fillReport(JASP, hash, conn);
                JasperViewer.viewReport(PR, false);
            } catch (JRException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(busReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void rpChuyenCan(Date tungay, Date denngay) {
        try {
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
            DriverManager.registerDriver(driver);// dang ky driver         
            Connection conn = DriverManager.getConnection(url, user, pass);
            try {
                Hashtable hash = new Hashtable();
                hash.put("tungay", tungay);
                hash.put("denngay", denngay);
                String Rb = "src/Report/ChuyenCan.jrxml";
                JasperReport JASP = JasperCompileManager.compileReport(Rb);
                JasperPrint PR = JasperFillManager.fillReport(JASP, hash, conn);
                JasperViewer.viewReport(PR, false);
            } catch (JRException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(busReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void rpHopDongTheoChucVu(int MACV) {
        try {
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
            DriverManager.registerDriver(driver);// dang ky driver         
            Connection conn = DriverManager.getConnection(url, user, pass);
            try {
                Hashtable hash = new Hashtable();
                hash.put("MACV", new Integer(MACV));
                String Rb = "src/Report/rpHDtheoChucVu.jrxml";
                JasperReport JASP = JasperCompileManager.compileReport(Rb);
                JasperPrint PR = JasperFillManager.fillReport(JASP, hash, conn);
                JasperViewer.viewReport(PR, false);
            } catch (JRException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(busReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void rpLuong(String Date) {
        try {
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
            DriverManager.registerDriver(driver);// dang ky driver         
            Connection conn = DriverManager.getConnection(url, user, pass);
            try {
                Hashtable hash = new Hashtable();
                hash.put("ngay", new String(Date));
                String Rb = "src/Report/Luong.jrxml";
                JasperReport JASP = JasperCompileManager.compileReport(Rb);
                JasperPrint PR = JasperFillManager.fillReport(JASP, hash, conn);
                JasperViewer.viewReport(PR, false);
            } catch (JRException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(busReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        rpHopDongTheoChucVu(4);
    }
}
