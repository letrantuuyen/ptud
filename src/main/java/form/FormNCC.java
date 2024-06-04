package form;

import connect.Connect;
import dao.NCC_Dao;

import entity.NhaCungCap;
import entity.SanPham;
import static form.FormSanPham.ma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormNCC extends javax.swing.JPanel implements ActionListener, MouseListener {

    public FormNCC() throws SQLException {
        try {
            Connect.getInstance().connect();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        initComponents();
        table.fixTable(jScrollPane1);
        table.addMouseListener(this);
        ncc_dao = new NCC_Dao();
        updateTable();
        if (ma != null) {
            upTableTim();
            ma = null;
        }
    }

    private NCC_Dao ncc_dao;
    private DefaultTableModel dataModel;
    public static String ma = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.Table();
        jPanel1 = new javax.swing.JPanel();
        txtsDT = new swing.TextField();
        txtTenNCC = new swing.TextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtEmail = new swing.TextField();
        txtDiaChi = new swing.TextField();
        btnSua = new swing.Button();
        btnXoa = new swing.Button();
        btnThem = new swing.Button();
        txtTim = new swing.TextField();
        btnTim = new swing.Button();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setToolTipText("");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "SĐT", "Email"
            }
        ));
        table.setShowGrid(true);
        table.setShowVerticalLines(false);
        jScrollPane1.setViewportView(table);
        table.getAccessibleContext().setAccessibleName("");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), null), "Nhà Cung Cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtsDT.setHintText("0900090009");

        txtTenNCC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenNCC.setHintText("Duy Huy");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Tên Nhà Cung Cấp:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Email:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Số Điện Thoại");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Địa Chỉ:");

        txtEmail.setHintText("banhang@gmai.com");

        txtDiaChi.setHintText("Số,Đường,Phường,Quận,TP");

        btnSua.setText("Sửa ");
        btnSua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa ");
        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm ");
        btnThem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        txtTim.setHintText("Theo SDT");

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loupe.png"))); // NOI18N
        btnTim.setText("Tìm Kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Tìm:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 402, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(388, 388, 388))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jLabel13)
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsDT, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("THÔNG TIN NHÀ CUNG CẤP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("dsad");
    }// </editor-fold>//GEN-END:initComponents
public void upTableTim() throws SQLException {
        NhaCungCap ncc = ncc_dao.TimNCCTheoMa(ma);
        xoaModel(table);
       dataModel.addRow(
                    new Object[]{ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChi(), ncc.getsDT(), ncc.getEmail()});

    }
    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String sdt = txtTim.getText().toString();
        if (sdt.length() == 10) {
            try {
                if (ncc_dao.TimNCCTheoSDT(sdt) != null) {
                    NhaCungCap ncc = ncc_dao.TimNCCTheoSDT(sdt);
                    xoaModel(table);
                    dataModel.addRow(
                            new Object[]{ncc.getMaNCC(), ncc.getTenNCC(), ncc.getsDT(), ncc.getDiaChi(), ncc.getEmail()});
                } else {
                    JOptionPane.showMessageDialog(null, "Không Tìm Thấy Nhà Cung Cấp");
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

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaActionPerformed
        Object o = evt.getSource();
        if (o.equals(btnXoa)) {
            int r = table.getSelectedRow();
            if (r >= 0) {
                String maNCC = (String) table.getValueAt(r, 0);
                int click = JOptionPane.showConfirmDialog(null, "Bạn có chắc xóa nhà cung cấp ", "Thông Báo", 2);
                if (click == JOptionPane.OK_OPTION) {
                    // else if (validData()) {
                    if (ncc_dao.xoa(maNCC)) {
                        JOptionPane.showMessageDialog(null, "Xóa nhà cung cấp thành công");
                    }
                    dataModel.removeRow(r);
                    xoaRongTextfields();
                } else {
                    if (click == JOptionPane.CANCEL_OPTION) {
                        this.setVisible(true);
                    }
                }

            }
        }
    }// GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
        Object o = evt.getSource();
        if (o.equals(btnSua)) {
            int r = table.getSelectedRow();
            if (r >= 0) {
                String tenNCC = txtTenNCC.getText().toString();
                String diaChi = txtDiaChi.getText().toString();
                String sdt = txtsDT.getText().toString();
                String email = txtEmail.getText().toString();
                NhaCungCap ncc = new NhaCungCap(ma, tenNCC, sdt, diaChi, email);
                int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa", "Thông Báo", 2);
                if (click == JOptionPane.OK_OPTION) {
                    if (validData(ncc)) {
                        if (ncc_dao.sua(ncc)) {
                            table.setValueAt(txtTenNCC.getText(), r, 1);
                            table.setValueAt(txtDiaChi.getText(), r, 2);
                            table.setValueAt(txtsDT.getText(), r, 3);
                            table.setValueAt(txtEmail.getText(), r, 4);
                            JOptionPane.showMessageDialog(null, "Sửa nhà cung cấp thành công");
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

    }// GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
        Object o = evt.getSource();
        NhaCungCap ncc = null;
        if (o.equals(btnThem)) {
            if (validData(ncc)) {
                ncc = reverSPFromTextFile();
                if (ncc_dao.themNhaCC(ncc)) {
                    xoaModel(table);
                    updateTable();
                    JOptionPane.showMessageDialog(null, "Thêm nhà cung cấp thành công");

                }
            }
        }

    }// GEN-LAST:event_btnThemActionPerformed

    private void xoaRongTextfields() {
        txtTenNCC.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        txtsDT.setText("");

    }

    // Pattern p = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
    // bắt Lỗi
    private boolean validData(NhaCungCap ncc) {
        String tenNCC = txtTenNCC.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String sdt = txtsDT.getText().trim();
        String email = txtEmail.getText().trim();
        if (!(tenNCC.length() > 0)) {
            JOptionPane.showInternalMessageDialog(null, "Tên Nhà Cung Cấp Không Được Rỗng");
            return false;
        }
        if (!(email.length() > 0 && email.matches(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))) {
            JOptionPane.showInternalMessageDialog(null, "Email mẫu:ten@gmai.com");
            return false;
        }
        if (!(sdt.length() > 0 && sdt.matches("[0-9]{10}"))) {
            JOptionPane.showInternalMessageDialog(null, "Số điện thoại gồm 10 chữ số");
            return false;
        }
        if (!(diaChi.length() > 0)) {
            JOptionPane.showInternalMessageDialog(null, "Địa Chỉ Nhà Cung Cấp Không Được Rỗng");
            return false;
        }

        ArrayList<NhaCungCap> lsncc = ncc_dao.getAllNCC();
        if (ncc != null) {
            for (NhaCungCap s : lsncc) {
                if (s.getMaNCC().equals(ncc.getMaNCC())) {
                    lsncc.remove(s);
                    break;
                }
            }
        }
        for (NhaCungCap s : lsncc) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                JOptionPane.showMessageDialog(null, "Email đã được đăng ký");
                return false;
            } else if (s.getsDT().equals(sdt)) {
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

    private NhaCungCap reverSPFromTextFile() {
        String tenNCC = txtTenNCC.getText().toString();
        String diaChi = txtDiaChi.getText().toString();
        String sdt = txtsDT.getText().toString();
        String email = txtEmail.getText().toString();
        return new NhaCungCap(tenNCC, sdt, diaChi, email);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnSua;
    private swing.Button btnThem;
    private swing.Button btnTim;
    private swing.Button btnXoa;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.Table table;
    private swing.TextField txtDiaChi;
    private swing.TextField txtEmail;
    private swing.TextField txtTenNCC;
    private swing.TextField txtTim;
    private swing.TextField txtsDT;
    // End of variables declaration//GEN-END:variables
	private void updateTable() {
        dataModel = (DefaultTableModel) table.getModel();
        ArrayList<NhaCungCap> ListNCC = ncc_dao.getAllNCC();
        for (NhaCungCap ncc : ListNCC) {
            dataModel.addRow(
                    new Object[]{ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChi(), ncc.getsDT(), ncc.getEmail()});
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
        txtTenNCC.setText(table.getValueAt(r, 1).toString());
        txtDiaChi.setText(table.getValueAt(r, 2).toString());
        txtsDT.setText(table.getValueAt(r, 3).toString());
        txtEmail.setText(table.getValueAt(r, 4).toString());

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
