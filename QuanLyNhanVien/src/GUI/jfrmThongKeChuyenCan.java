/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.busChucVu;
import BUS.busHopDong;
import BUS.busNhanVien;
import BUS.busChamLuong;
import DTO.dtoChucVu;
import DTO.dtoHopDong;
import DTO.dtoNhanVien;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NT
 */
public class jfrmThongKeChuyenCan extends javax.swing.JInternalFrame {

    /**
     * Creates new form jfrmLapLuongNhanVien
     */
    public jfrmThongKeChuyenCan() {
        initComponents();
        LoadDanhSachNhanVien();
        loadbinDing();
    }

    void LoadDanhSachNhanVien() {
        ArrayList<dtoNhanVien> list = busNhanVien.getInstance().getDanhSachNhanVien("");
        DefaultTableModel model = (DefaultTableModel) jtbNhanVien.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (dtoNhanVien item : list) {
            dtoHopDong hopDong = busHopDong.getInstance().getHopDong(item.getMAHD());
            dtoChucVu chucVu = busChucVu.getInstance().getChucVu(hopDong.getMACV());
            model.addRow(new Object[]{item.getMANV(), item.getTENNV(), chucVu.getTenChucVu(), hopDong.getMAHD(),  busChamLuong.getInstance().soNgayLamViecTheoNgay(item.getMANV(),jdtpkTuNgay.getDate(),jdtpkDenNgay.getDate()), busChamLuong.getInstance().soGioLamThemTheoNgay(item.getMANV(),jdtpkTuNgay.getDate(),jdtpkDenNgay.getDate())});
        }
    }

    void loadbinDing() {
        jtbNhanVien.getSelectionModel().addListSelectionListener((e) -> {
            if (jtbNhanVien.getSelectedRow() >= 0) {
                Object MANV = jtbNhanVien.getValueAt(jtbNhanVien.getSelectedRow(), 0);
            }
        }
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbNhanVien = new javax.swing.JTable();
        btnIn = new javax.swing.JButton();
        jdtpkTuNgay = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        jdtpkDenNgay = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Lập lương nhân viên");
        setAutoscrolls(true);

        jbtnSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnSearch.setText("Xem");
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
            }
        });

        jtbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Chức vụ", "Mã hợp đồng", "Số ngày đi làm", "Số giờ làm thêm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbNhanVien);

        btnIn.setText("IN");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Từ ngày:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Đến ngày:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jdtpkTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jdtpkDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jdtpkDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnSearch))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jdtpkTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnIn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed
        LoadDanhSachNhanVien();
    }//GEN-LAST:event_jbtnSearchActionPerformed

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        BUS.busReport.rpChuyenCan(jdtpkTuNgay.getDate(), jdtpkDenNgay.getDate());
    }//GEN-LAST:event_btnInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnSearch;
    private org.jdesktop.swingx.JXDatePicker jdtpkDenNgay;
    private org.jdesktop.swingx.JXDatePicker jdtpkTuNgay;
    private javax.swing.JTable jtbNhanVien;
    // End of variables declaration//GEN-END:variables
}
