package form;

import connect.Connect;
import dao.KhachHang_Dao;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhanVien;
import static form.FormNhanVien.ma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormKhachHang extends javax.swing.JPanel implements ActionListener, MouseListener {

    public FormKhachHang() {
        try {
            Connect.getInstance().connect();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        initComponents();
        table.fixTable(jScrollPane1);
        table.addMouseListener(this);
        kh_dao = new KhachHang_Dao();
        updateTable();
        if (ma != null) {
            upTableTim();
            ma = null;
        }
    }

    private KhachHang_Dao kh_dao;
    private DefaultTableModel dataModel;
    public static String ma = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.Table();
        btnSua = new swing.Button();
        btnXoa = new swing.Button();
        txtTim = new swing.TextField();
        btnTim = new swing.Button();
        txtTen = new swing.TextField();
        txtSDT = new swing.TextField();
        txtDiaChi = new swing.TextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnThem = new swing.Button();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setToolTipText("");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Địa Chỉ"
            }
        ));
        table.setShowGrid(true);
        table.setShowVerticalLines(false);
        jScrollPane1.setViewportView(table);

        btnSua.setText("Sửa Khách Hàng");
        btnSua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa Khách Hàng");
        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtTim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTim.setHintText("Tìm theo số điên thọai");

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loupe.png"))); // NOI18N
        btnTim.setColor2(new java.awt.Color(0, 102, 204));
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        txtTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTen.setHintText("Nguyễn Văn A");

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSDT.setHintText("0900090009");

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDiaChi.setHintText("Số,Đường,Phường,Quận,Thành Phố");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tìm:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Số Điện Thoại:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tên Khách Hàng:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Địa Chỉ:");

        btnThem.setText("Thêm Khách Hàng");
        btnThem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN KHÁCH HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(468, 636, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        jLabel2.getAccessibleContext().setAccessibleName("sd");
    }// </editor-fold>//GEN-END:initComponents
public void upTableTim() {
        KhachHang kh = kh_dao.getKH(ma);
        xoaModel(table);
      
                dataModel.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getsDT(), kh.getDiaChi()});

    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        Object o = evt.getSource();

        if (o.equals(btnThem)) {
            KhachHang kh = null;
            if (validData(kh)) {
                kh = reverSPFromTextFile();
                if (kh_dao.themKH(kh)) {
                    xoaModel(table);
                    updateTable();
                    JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công");
                }
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        Object o = evt.getSource();
        if (o.equals(btnSua)) {
            int r = table.getSelectedRow();
            if (r >= 0) {
                String tenNCC = txtTen.getText().toString();
                String diaChi = txtDiaChi.getText().toString();
                String sdt = txtSDT.getText().toString();

                KhachHang kh = new KhachHang(ma, tenNCC, sdt, diaChi);
                int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa", "Thông Báo", 2);
                if (click == JOptionPane.OK_OPTION) {
                    if (validData(kh)) {
                        if (kh_dao.sua(kh)) {
                            table.setValueAt(txtTen.getText(), r, 1);
                            table.setValueAt(txtSDT.getText(), r, 2);
                            table.setValueAt(txtDiaChi.getText(), r, 3);
                            JOptionPane.showMessageDialog(null, "Sửa khách hàng thành công");
                            xoaRongTextfields();
                        } else {
                            if (click == JOptionPane.CANCEL_OPTION) {
                                this.setVisible(true);
                            }

                        }
                    }

                }

            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        Object o = evt.getSource();
        if (o.equals(btnXoa)) {
            int r = table.getSelectedRow();
            if (r >= 0) {
                String maKH = (String) table.getValueAt(r, 0);
                int click = JOptionPane.showConfirmDialog(null, "Bạn có chắc xóa khách hàng này", "Thông Báo", 2);
                if (click == JOptionPane.OK_OPTION) {
                    if (kh_dao.xoa(maKH)) {
                        JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công");
                    }
                    dataModel.removeRow(r);
                    xoaRongTextfields();
                } else {
                    if (click == JOptionPane.CANCEL_OPTION) {
                        this.setVisible(true);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Xin Chọn Khách Hàng Cần Xóa");

            }
        }


    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String sdt = txtTim.getText().toString();
        if (sdt.length() == 10) {
            try {
                if (kh_dao.TimKHTheoSDT(sdt) != null) {
                    KhachHang kh = kh_dao.TimKHTheoSDT(sdt);
                    xoaModel(table);
                    dataModel.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getsDT(), kh.getDiaChi()});
                } else {
                    JOptionPane.showMessageDialog(null, "Không Tìm Thấy Khách Hàng");
                    xoaModel(table);
                    updateTable();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Số Điện Thoại Không Hợp Lệ");
            xoaModel(table);
            updateTable();

        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void xoaRongTextfields() {
        txtTen.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");

    }

    private boolean validData(KhachHang kh) {
        String ten = txtTen.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String sdt = txtSDT.getText().trim();
        if (!(ten.length() > 0)) {
            JOptionPane.showInternalMessageDialog(null, "Tên Khách Hàng Không Được Rỗng");
            return false;
        }
        if (!(diaChi.length() > 0)) {
            JOptionPane.showInternalMessageDialog(null, "Địa Chỉ Không Được Rỗng");
            return false;
        }
        if (!(sdt.length() > 0 && sdt.matches("[0-9]{10}"))) {
            JOptionPane.showInternalMessageDialog(null, "Số điện thoại gồm 10 chữ số");
            return false;
        }

        ArrayList<KhachHang> lskh = kh_dao.getAllKH();
        if (kh != null) {
            for (KhachHang s : lskh) {
                if (s.getMaKH().equals(kh.getMaKH())) {
                    lskh.remove(s);
                    break;
                }
            }
        }
        for (KhachHang s : lskh) {
            if (s.getsDT().equals(sdt)) {
                JOptionPane.showMessageDialog(null, "Số điện thoại đã được đăng ký");
                return false;
            }
        }

        return true;

    }

    public void xoaModel(JTable table) {
        DefaultTableModel del = (DefaultTableModel) table.getModel();
        del.getDataVector().removeAllElements();
    }

    private KhachHang reverSPFromTextFile() {
        String tenKH = txtTen.getText().toString();
        String diaChi = txtDiaChi.getText().toString();
        String sdt = txtSDT.getText().toString();

        return new KhachHang(tenKH, sdt, diaChi);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnSua;
    private swing.Button btnThem;
    private swing.Button btnTim;
    private swing.Button btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.Table table;
    private swing.TextField txtDiaChi;
    private swing.TextField txtSDT;
    private swing.TextField txtTen;
    private swing.TextField txtTim;
    // End of variables declaration//GEN-END:variables
public void updateTable() {
        dataModel = (DefaultTableModel) table.getModel();
        ArrayList<KhachHang> ListKH = kh_dao.getAllKH();
        for (KhachHang kh : ListKH) {
            dataModel.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getsDT(), kh.getDiaChi()});
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int r = table.getSelectedRow();
        ma = table.getValueAt(r, 0).toString();
        txtTen.setText(table.getValueAt(r, 1).toString());
        txtSDT.setText(table.getValueAt(r, 2).toString());
        txtDiaChi.setText(table.getValueAt(r, 3).toString());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
