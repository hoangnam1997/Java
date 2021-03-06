/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.busCtdk_ThemGio;
import BUS.busDangKyThemGio;
import BUS.busNhanVien;
import DTO.dtoDangKyThemGio;
import DTO.dtoNhanVien;
import DTO.dtoTaiKhoan;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NT
 */
public final class jfrmDangKyLamThemGio extends javax.swing.JInternalFrame {

    //properties
    private dtoTaiKhoan TaiKhoanLogin=null;
    /**
     * Creates new form jfrmDangKyLamThemGio
     */
    public jfrmDangKyLamThemGio(dtoTaiKhoan TaiKhoan) {
        initComponents();
        this.TaiKhoanLogin=TaiKhoan;
        jdtpkTuNgay.setDate(Calendar.getInstance().getTime());
        jbtnXem.doClick();
        loadBindings();
    }
//load selectted model
    void loadBindings()
    {
        jtbDangKyThemGio.getSelectionModel().addListSelectionListener((e) -> {
           try{
               if(jtbDangKyThemGio.getSelectedRow()>=0)
                {
                    Object id= jtbDangKyThemGio.getValueAt(jtbDangKyThemGio.getSelectedRow(), 0);
                    jtxtMaDK.setText(id.toString());
                }
           }catch(Exception ex){
               System.out.println(ex.getMessage());
           }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdtpkTuNgay = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jbtnXem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbDangKyThemGio = new javax.swing.JTable();
        jbtnDangKy = new javax.swing.JButton();
        jtxtMaDK = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Đăng ký giờ làm thêm");
        setAutoscrolls(true);

        jdtpkTuNgay.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jdtpkTuNgay.setFormats("dd/MM/yyyy");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Từ ngày:");

        jbtnXem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnXem.setText("Xem");
        jbtnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXemActionPerformed(evt);
            }
        });

        jtbDangKyThemGio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtbDangKyThemGio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đăng ký", "Tên đăng ký", "Thời gian", "Hệ số lương", "Ngày"
            }
        ));
        jtbDangKyThemGio.setFillsViewportHeight(true);
        jtbDangKyThemGio.setFocusCycleRoot(true);
        jtbDangKyThemGio.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jtbDangKyThemGio);
        jtbDangKyThemGio.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jbtnDangKy.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnDangKy.setText("Đăng ký");
        jbtnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDangKyActionPerformed(evt);
            }
        });

        jtxtMaDK.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Mã đăng ký");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addComponent(jdtpkTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnXem))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtMaDK, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 597, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdtpkTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jbtnXem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtMaDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

// Lấy danh sách đăngk ý thêm giờ lên jTable
    private void jbtnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXemActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) jtbDangKyThemGio.getModel();
        while(jtbDangKyThemGio.getRowCount()>0) {
            model.removeRow(0);
        }

//Lấy danh sách
        ArrayList<dtoDangKyThemGio> list = busDangKyThemGio.getInstance().getDanhSachDangKy(jdtpkTuNgay.getDate());

        for (dtoDangKyThemGio item : list) {
            model.addRow(new Object[]{item.getMADKTHEMGIO(), item.getTENDK(), item.getSOGIODK(), item.getHESOLUONG_1GIO(), item.getNGAY()});
        }

    }//GEN-LAST:event_jbtnXemActionPerformed
//Thực hiện đăng ký làm thêm giờ
    private void jbtnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDangKyActionPerformed
        String MADK = jtxtMaDK.getText();
        int madk=-9999;
        try{
        madk=Integer.parseInt(MADK);
        }catch(Exception e){
            
        }
        if(MADK.equals(null)||MADK.equals("")||madk == -9999)
        {
            JOptionPane.showConfirmDialog(null, "Vui lòng nhập mã phiếu đăng ký!","Thông báo",-1,2);
            return;
        }
        dtoNhanVien nhanvien = busNhanVien.getInstance().getNhanVientheoTaiKhoan(TaiKhoanLogin.getTAIKHOAN());
        if(!busCtdk_ThemGio.getInstance().insertCtdk_ThemGio(nhanvien.getMANV(),madk ))
        {
            JOptionPane.showConfirmDialog(null, "Vui lòng thực hiện lại!","Thông báo",-1,2);
        }
        else
        {
            JOptionPane.showConfirmDialog(null, "Đăng ký thành công!","Thông báo",-1,1);
        }
    }//GEN-LAST:event_jbtnDangKyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnDangKy;
    private javax.swing.JButton jbtnXem;
    private org.jdesktop.swingx.JXDatePicker jdtpkTuNgay;
    private javax.swing.JTable jtbDangKyThemGio;
    private javax.swing.JTextField jtxtMaDK;
    // End of variables declaration//GEN-END:variables
}
