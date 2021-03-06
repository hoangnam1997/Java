/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class jfrmThongKeLuong extends javax.swing.JInternalFrame {

    /**
     * Creates new form jfrmThongKeLuong
     */
    public jfrmThongKeLuong() {
        initComponents();
        LoadCB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbNgayCham = new javax.swing.JComboBox<>();
        btnXem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableChamLuong = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Báo cáo lương");

        jLabel1.setText("Lần tính lương:");

        cbNgayCham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNgayChamActionPerformed(evt);
            }
        });

        btnXem.setText("Xem");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });

        jtableChamLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Tiền Lương"
            }
        ));
        jScrollPane1.setViewportView(jtableChamLuong);

        jButton2.setText("IN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbNgayCham, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXem)
                .addContainerGap(344, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbNgayCham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void LoadCB(){
        ArrayList<Date> listDate= BUS.busChamLuong.getInstance().NgayChamLuong();
        for(Date date : listDate){
            cbNgayCham.addItem(date.toString());
        }
    }
    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        DefaultTableModel model = (DefaultTableModel) jtableChamLuong.getModel();
        ArrayList<DTO.dtoChamLuongNhanVien> list = null;
        while (jtableChamLuong.getRowCount() > 0) {
            model.removeRow(0);
        }
        list= BUS.busChamLuong.getInstance().GetChamLuong(cbNgayCham.getSelectedItem().toString());
        for (DTO.dtoChamLuongNhanVien item : list) {
            model.addRow(new Object[]{item.getMANV(), BUS.busNhanVien.getInstance().getNhanVientheoMANV(item.getMANV()).getTENNV(), String.format("%.1f",item.getTongLuong())});
        }
    }//GEN-LAST:event_btnXemActionPerformed

    private void cbNgayChamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNgayChamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNgayChamActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        BUS.busReport.rpLuong(cbNgayCham.getSelectedItem().toString());
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXem;
    private javax.swing.JComboBox<String> cbNgayCham;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableChamLuong;
    // End of variables declaration//GEN-END:variables
}
