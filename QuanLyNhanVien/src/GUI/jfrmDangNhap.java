/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.busTaiKhoan;
import DTO.dtoTaiKhoan;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author NT
 */
public class jfrmDangNhap extends javax.swing.JFrame {
//Properties
    private static jfrmManHinhChinh jfrmMain = null;

    /**
     * Creates new form jfrmDangNhap
     */
    public jfrmDangNhap() {
        initComponents();
        loadForm();
    }

    //cài đặt hình ảnh form
    final void loadForm() {
        this.setLocationRelativeTo(null);
        URL iconURL = getClass().getResource("/IMG/Home-PNG-Pic.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        this.getRootPane().setDefaultButton(jbtnDangNhap);
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
        jLabel2 = new javax.swing.JLabel();
        jtxtTaiKhoan = new javax.swing.JTextField();
        jtxtMatKhau = new javax.swing.JPasswordField();
        jbtnThoat = new javax.swing.JButton();
        jbtnDangNhap = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tài khoản:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mật khẩu:");

        jtxtTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtxtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbtnThoat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnThoat.setText("Thoát");
        jbtnThoat.setMaximumSize(new java.awt.Dimension(100, 25));
        jbtnThoat.setMinimumSize(new java.awt.Dimension(100, 25));
        jbtnThoat.setPreferredSize(new java.awt.Dimension(100, 25));
        jbtnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThoatActionPerformed(evt);
            }
        });

        jbtnDangNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnDangNhap.setText("Đăng nhập");
        jbtnDangNhap.setMaximumSize(new java.awt.Dimension(100, 25));
        jbtnDangNhap.setMinimumSize(new java.awt.Dimension(100, 25));
        jbtnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDangNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtTaiKhoan)
                            .addComponent(jtxtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Thoát khỏi form
    private void jbtnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbtnThoatActionPerformed
//Thực hiện đăng nhập với username và pass
    private void jbtnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDangNhapActionPerformed
        String TaiKhoan = jtxtTaiKhoan.getText();
        String MatKhau = jtxtMatKhau.getText();
        if (TaiKhoan.equals(null) || TaiKhoan.equals("") || MatKhau.equals(null) || MatKhau.equals("")) {
            JOptionPane.showConfirmDialog(null, "Vui lòng nhập đầy đủ thông tin đăng nhập!", "Thông báo", -1, 0);
            return;
        }
        dtoTaiKhoan TaiKhoanLogin = busTaiKhoan.getInstance().layThongTinTaiKhoan(TaiKhoan);
        boolean isLogin = false;
        if (TaiKhoanLogin != null) {
            if (MatKhau.equals(TaiKhoanLogin.getMATKHAU())) {
                isLogin = true;
            }
        }
        if (isLogin) {
            this.dispose();
            if (jfrmMain == null) {
                jfrmMain = new jfrmManHinhChinh(TaiKhoanLogin);
            }
            jfrmMain.setVisible(true);
        } else {
            JOptionPane.showConfirmDialog(null, "Tài khoản hoặc mật khẩu sai!", "Thông báo", -1, 2);
        }
    }//GEN-LAST:event_jbtnDangNhapActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtnDangNhap;
    private javax.swing.JButton jbtnThoat;
    private javax.swing.JPasswordField jtxtMatKhau;
    private javax.swing.JTextField jtxtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
