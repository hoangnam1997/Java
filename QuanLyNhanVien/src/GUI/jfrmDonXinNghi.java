/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.busDonXinNghi;
import BUS.busNhanVien;
import DTO.dtoNhanVien;
import DTO.dtoTaiKhoan;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author NT
 */
public class jfrmDonXinNghi extends javax.swing.JInternalFrame {

    //Properties
    dtoTaiKhoan TaiKhoanLogin = null;
    /**
     * Creates new form jfrmDonXinNghi
     */
    public jfrmDonXinNghi(dtoTaiKhoan Taikhoan) {
        initComponents();
        this.TaiKhoanLogin = Taikhoan;
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
        jdtpkDenNgay = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtLyDo = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jbtnChapNhan = new javax.swing.JButton();
        jbtnThoat = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Lập đơn xin nghỉ");
        setAutoscrolls(true);
        addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                formHierarchyChanged(evt);
            }
        });

        jdtpkTuNgay.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jdtpkTuNgay.setFormats("dd/MM/yyyy");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Từ ngày:");

        jdtpkDenNgay.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jdtpkDenNgay.setFormats("dd/MM/yyyy");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Đến ngày:");

        jtxtLyDo.setColumns(20);
        jtxtLyDo.setRows(5);
        jScrollPane1.setViewportView(jtxtLyDo);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Lý do xin nghỉ:");

        jbtnChapNhan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnChapNhan.setText("Chấp nhận");
        jbtnChapNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnChapNhanActionPerformed(evt);
            }
        });

        jbtnThoat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnThoat.setText("Thoát");
        jbtnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdtpkTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdtpkDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(0, 448, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnChapNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdtpkTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jdtpkDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnChapNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnThoat))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Reset lại mặt định khi ttứ hoặc mở
    private void formHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formHierarchyChanged
        Calendar cal = Calendar.getInstance();
        jdtpkTuNgay.setDate(cal.getTime());
        jdtpkDenNgay.setDate(cal.getTime());
        jtxtLyDo.setText("");
    }//GEN-LAST:event_formHierarchyChanged
///thoát
    private void jbtnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtnThoatActionPerformed

    private void jbtnChapNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnChapNhanActionPerformed
        Calendar cal = Calendar.getInstance();
        Date tuNgay = jdtpkTuNgay.getDate();
        Date denNgay = jdtpkDenNgay.getDate();
        if(tuNgay.after(denNgay))
        {
            JOptionPane.showConfirmDialog(null, "Ngày bắt đầu nghỉ không được lớn hơn ngày kết thúc!","Thông báo",-1,2);
            return;
        }
        if(tuNgay.before(cal.getTime())||denNgay.before(denNgay))
        {
            JOptionPane.showConfirmDialog(null, "Thời gian không hợp lệ!","Thông báo",-1,2);
            return;
        }
        String lyDo=jtxtLyDo.getText();
        dtoNhanVien nhanvien= busNhanVien.getInstance().getNhanVientheoTaiKhoan(TaiKhoanLogin.getTAIKHOAN());
        if(nhanvien==null)
        {
            JOptionPane.showConfirmDialog(null, "Vui lòng thực hiện lại, Không tìm thấy nhân viên!","Thông báo",-1,2);
            return;
        }
        if(!busDonXinNghi.getInstance().themDonXinNghi(lyDo, cal.getTime(), tuNgay, tuNgay, nhanvien.getMANV()))
        {
            JOptionPane.showConfirmDialog(null, "Vui lòng thực hiện lại!","Thông báo",-1,2);
            return;
        }
        JOptionPane.showConfirmDialog(null, "Thêm đơn xin nghỉ thành công!","Thông báo",-1,1);
    }//GEN-LAST:event_jbtnChapNhanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnChapNhan;
    private javax.swing.JButton jbtnThoat;
    private org.jdesktop.swingx.JXDatePicker jdtpkDenNgay;
    private org.jdesktop.swingx.JXDatePicker jdtpkTuNgay;
    private javax.swing.JTextArea jtxtLyDo;
    // End of variables declaration//GEN-END:variables
}
