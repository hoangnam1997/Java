/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.busChucVu;
import BUS.busHopDong;
import BUS.busPhongBan;
import DTO.dtoChucVu;
import DTO.dtoHopDong;
import DTO.dtoPhongBan;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NT
 */
public class jfrmThemHopDong extends javax.swing.JInternalFrame {

    private static ArrayList<dtoPhongBan> listPhongBan;
    private static ArrayList<dtoChucVu> listChucVuSearch;
    private static ArrayList<dtoChucVu> listChucVu;

    /**
     * Creates new form jfrmThemHopDong
     */
    public jfrmThemHopDong() {
        initComponents();
        loadPhongBan();
        loadhopDong();
        loadbinDing();
        jdtpkThoiGianBatDau.setDate(Calendar.getInstance().getTime());
        jdtpkThoiGianHetHan.setDate(Calendar.getInstance().getTime());
    }

    //load dnah sách phòng ban
    void loadPhongBan() {
        listPhongBan = busPhongBan.getInstance().getDanhSachPhongBan();
        for (dtoPhongBan item : listPhongBan) {
            jcbPhongBan.addItem(String.valueOf(item.getTenPB()));
            jcbPhongBanSearch.addItem(String.valueOf(item.getTenPB()));
        }
    }

    //lay tat ca danh sach chuc vu len cb theo phòng ban
    void loadChucVu(JComboBox cb, ArrayList<dtoChucVu> arr) {
        cb.removeAllItems();
        ArrayList<dtoChucVu> list = arr;
        for (dtoChucVu item : list) {
            cb.addItem(String.valueOf(item.getTenChucVu()));
        }
    }
//thuc hien binding

    void loadbinDing() {
        jtbHopDong.getSelectionModel().addListSelectionListener((e) -> {
            if (jtbHopDong.getSelectedRow() >= 0) {
                Object MAHD = jtbHopDong.getValueAt(jtbHopDong.getSelectedRow(), 0);
                Object MACV = jtbHopDong.getValueAt(jtbHopDong.getSelectedRow(), 1);
                Object NGAYBATDAU = jtbHopDong.getValueAt(jtbHopDong.getSelectedRow(), 2);
                Object NGAYHETHAN = jtbHopDong.getValueAt(jtbHopDong.getSelectedRow(), 3);
                Object TIENLUONG = jtbHopDong.getValueAt(jtbHopDong.getSelectedRow(), 4);

                jtxtMaHopDong.setText(MAHD.toString());
                jdtpkThoiGianBatDau.setDate((Date) NGAYBATDAU);
                jdtpkThoiGianHetHan.setDate((Date) NGAYHETHAN);
                jtxtTienLuong.setText(TIENLUONG.toString());
                dtoChucVu chucVu = busChucVu.getInstance().getChucVu((int) MACV);
                for (int i = 0; i < jcbPhongBan.getItemCount(); i++) {
                    if (listPhongBan.get(i).getMAPB() == (chucVu.getMAPB())) {
                        jcbPhongBan.setSelectedIndex(i);
                        break;
                    }
                }
                for (int i = 0; i < jcbChucVu.getItemCount(); i++) {
                    if (listChucVu.get(i).getMACV() == ((int) MACV)) {
                        jcbChucVu.setSelectedIndex(i);
                        break;
                    }
                }

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbHopDong = new javax.swing.JTable();
        jtxtMaHopDong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtTienLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcbChucVu = new javax.swing.JComboBox<>();
        jdtpkThoiGianBatDau = new org.jdesktop.swingx.JXDatePicker();
        jdtpkThoiGianHetHan = new org.jdesktop.swingx.JXDatePicker();
        jbtnXoa = new javax.swing.JButton();
        jbtnSua = new javax.swing.JButton();
        jbtnThem = new javax.swing.JButton();
        jtxtXem = new javax.swing.JTextField();
        jbtnXem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcbPhongBan = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jcbPhongBanSearch = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jcbChucVuSearch = new javax.swing.JComboBox<>();
        jbtnXemTatCa = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Hợp đồng");
        setAutoscrolls(true);

        jtbHopDong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtbHopDong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hợp đồng", "Mã chức vụ", "Ngày bắt đầu", "Ngày hết hạn", "Tiền lương"
            }
        ));
        jtbHopDong.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtbHopDong);
        if (jtbHopDong.getColumnModel().getColumnCount() > 0) {
            jtbHopDong.getColumnModel().getColumn(1).setMinWidth(0);
            jtbHopDong.getColumnModel().getColumn(1).setPreferredWidth(0);
            jtbHopDong.getColumnModel().getColumn(1).setMaxWidth(0);
            jtbHopDong.getColumnModel().getColumn(4).setMinWidth(0);
            jtbHopDong.getColumnModel().getColumn(4).setPreferredWidth(0);
            jtbHopDong.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jtxtMaHopDong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtxtMaHopDong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtMaHopDongKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Mã hợp đồng:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Chức vụ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Ngày bắt đầu:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Ngày hết hạn:");

        jtxtTienLuong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtxtTienLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtTienLuongKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Tiền lương:");

        jcbChucVu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jbtnXoa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnXoa.setText("Xóa");
        jbtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoaActionPerformed(evt);
            }
        });

        jbtnSua.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnSua.setText("Sửa");
        jbtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSuaActionPerformed(evt);
            }
        });

        jbtnThem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnThem.setText("Thêm");
        jbtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemActionPerformed(evt);
            }
        });

        jtxtXem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtxtXem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtXemKeyTyped(evt);
            }
        });

        jbtnXem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnXem.setText("Xem");
        jbtnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXemActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Mã hợp đồng:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Phòng ban:");

        jcbPhongBan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbPhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPhongBanActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Phòng ban:");

        jcbPhongBanSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbPhongBanSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPhongBanSearchActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Chức vụ");

        jcbChucVuSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbChucVuSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbChucVuSearchActionPerformed(evt);
            }
        });

        jbtnXemTatCa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnXemTatCa.setText("Tất cả");
        jbtnXemTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXemTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbPhongBanSearch, 0, 220, Short.MAX_VALUE)
                            .addComponent(jcbChucVuSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtXem, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnXem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnXemTatCa)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtxtMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbPhongBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdtpkThoiGianBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                    .addComponent(jdtpkThoiGianHetHan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtxtTienLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jcbPhongBanSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcbChucVuSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtXem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnXem)
                    .addComponent(jLabel6)
                    .addComponent(jbtnXemTatCa))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jdtpkThoiGianBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jdtpkThoiGianHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtTienLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jcbPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jcbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//thực hiện xem dnah sách hợp đồng theo tên
    private void jbtnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXemActionPerformed
        DefaultTableModel model = (DefaultTableModel) jtbHopDong.getModel();
        while (jtbHopDong.getRowCount() > 0) {
            model.removeRow(0);
        }
        int index= jcbChucVuSearch.getSelectedIndex();
        ArrayList<dtoHopDong> list = busHopDong.getInstance().getDanhSachHopDong(listChucVuSearch.get(index).getMACV());

        for (dtoHopDong item : list) {
            model.addRow(new Object[]{item.getMAHD(), item.getMACV(), item.getNgayBatDau(), item.getNgayKetThuc(), String.format("%.1f",item.getTIENLUONG())});
        }
    }//GEN-LAST:event_jbtnXemActionPerformed
// thuc hien load danh sach hop dong

    void loadhopDong() {
        DefaultTableModel model = (DefaultTableModel) jtbHopDong.getModel();
        while (jtbHopDong.getRowCount() > 0) {
            model.removeRow(0);
        }
        ArrayList<dtoHopDong> list = busHopDong.getInstance().getDanhSachHopDong();

        for (dtoHopDong item : list) {
            model.addRow(new Object[]{item.getMAHD(), item.getMACV(), item.getNgayBatDau(), item.getNgayKetThuc(), String.format("%.1f",item.getTIENLUONG())});
        }
    }
//giới hạn số ký tự và mã
    private void jtxtMaHopDongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtMaHopDongKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
        if (jtxtMaHopDong.getText().length() >= 4) {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtMaHopDongKeyTyped

    private void jtxtTienLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTienLuongKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtTienLuongKeyTyped

    private void jtxtXemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtXemKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
        if (jtxtTienLuong.getText().length() >= 4) {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtXemKeyTyped
//Them hợp đồng
    private void jbtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemActionPerformed
        if (jtxtMaHopDong.getText().length() <= 0 || jtxtTienLuong.getText().length() <= 0) {
            JOptionPane.showConfirmDialog(null, "Vùi lòng nhập đầy đủ thông tin!", "Thông báo", -1, 2);
            return;
        }
        int MAHD = Integer.parseInt(jtxtMaHopDong.getText());
        int index = jcbChucVu.getSelectedIndex();
        if(index<0)return;
        int MACV = listChucVu.get(index).getMACV();
        Date NgayBatDau = jdtpkThoiGianBatDau.getDate();
        Date Denngay = jdtpkThoiGianHetHan.getDate();
        Float Tien = Float.valueOf(Float.parseFloat(jtxtTienLuong.getText()));
        if (!busHopDong.getInstance().insertHopDong(MAHD, MACV, NgayBatDau, Denngay, Tien)) {
            JOptionPane.showConfirmDialog(null, "Vùi lòng thực hiện lại!", "Thông báo", -1, 2);
            return;
        }
        JOptionPane.showConfirmDialog(null, "Thêm thành công!", "Thông báo", -1, 1);
        loadhopDong();
    }//GEN-LAST:event_jbtnThemActionPerformed
//Thực hiện sửa hợp đồng
    private void jbtnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSuaActionPerformed
        if (jtxtMaHopDong.getText().length() <= 0 || jtxtTienLuong.getText().length() <= 0) {
            JOptionPane.showConfirmDialog(null, "Vùi lòng nhập đầy đủ thông tin!", "Thông báo", -1, 2);
            return;
        }
        int MAHD = Integer.parseInt(jtxtMaHopDong.getText());
        int index = jcbChucVu.getSelectedIndex();
        if(index<0)return;
        int MACV = listChucVu.get(index).getMACV();
        Date NgayBatDau = jdtpkThoiGianBatDau.getDate();
        Date Denngay = jdtpkThoiGianHetHan.getDate();
        Float Tien = Float.valueOf(Float.parseFloat(jtxtTienLuong.getText()));
        if (!busHopDong.getInstance().updateHopDong(MAHD, MACV, NgayBatDau, Denngay, Tien)) {
            JOptionPane.showConfirmDialog(null, "Vui lòng thực hiện lại!", "Thông báo", -1, 2);
            return;
        }
        JOptionPane.showConfirmDialog(null, "Cập nhật thành công!", "Thông báo", -1, 1);
        loadhopDong();
    }//GEN-LAST:event_jbtnSuaActionPerformed
//Thực hiện xóa hợp đồng
    private void jbtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoaActionPerformed
        if (jtxtMaHopDong.getText().length() <= 0) {
            JOptionPane.showConfirmDialog(null, "Vùi lòng nhập đầy đủ thông tin!", "Thông báo", -1, 2);
            return;
        }
        int MAHD = Integer.parseInt(jtxtMaHopDong.getText());
        if (!busHopDong.getInstance().deleteHopDong(MAHD)) {
            JOptionPane.showConfirmDialog(null, "Vui lòng thực hiện lại!", "Thông báo", -1, 2);
            return;
        }
        JOptionPane.showConfirmDialog(null, "Xóa thành công!", "Thông báo", -1, 1);
        loadhopDong();
    }//GEN-LAST:event_jbtnXoaActionPerformed
//hiển thị tất cả danh sách
    private void jbtnXemTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXemTatCaActionPerformed
        loadhopDong();
    }//GEN-LAST:event_jbtnXemTatCaActionPerformed
//load danh sach chức vụ theo mapb
    private void jcbPhongBanSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPhongBanSearchActionPerformed
        int index = jcbPhongBanSearch.getSelectedIndex();
        if (index < 0) {
            return;
        }
        listChucVuSearch = busChucVu.getInstance().getDanhSachChucVu(listPhongBan.get(index).getMAPB());
        loadChucVu(jcbChucVuSearch, listChucVuSearch);
    }//GEN-LAST:event_jcbPhongBanSearchActionPerformed
//load danh sach chức vụ theo mã phòng ban
    private void jcbPhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPhongBanActionPerformed
        int index = jcbPhongBan.getSelectedIndex();
        if (index < 0) {
            return;
        }
        listChucVu = busChucVu.getInstance().getDanhSachChucVu(listPhongBan.get(index).getMAPB());
        loadChucVu(jcbChucVu, listChucVu);
    }//GEN-LAST:event_jcbPhongBanActionPerformed

    private void jcbChucVuSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbChucVuSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbChucVuSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnSua;
    private javax.swing.JButton jbtnThem;
    private javax.swing.JButton jbtnXem;
    private javax.swing.JButton jbtnXemTatCa;
    private javax.swing.JButton jbtnXoa;
    private javax.swing.JComboBox<String> jcbChucVu;
    private javax.swing.JComboBox<String> jcbChucVuSearch;
    private javax.swing.JComboBox<String> jcbPhongBan;
    private javax.swing.JComboBox<String> jcbPhongBanSearch;
    private org.jdesktop.swingx.JXDatePicker jdtpkThoiGianBatDau;
    private org.jdesktop.swingx.JXDatePicker jdtpkThoiGianHetHan;
    private javax.swing.JTable jtbHopDong;
    private javax.swing.JTextField jtxtMaHopDong;
    private javax.swing.JTextField jtxtTienLuong;
    private javax.swing.JTextField jtxtXem;
    // End of variables declaration//GEN-END:variables
}