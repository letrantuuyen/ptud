package form;

import connect.Connect;
import entity.*;
import dao.*;
import static form.FormBanHang.tfDC;
import static form.FormBanHang.tfSDT;
import static form.FormBanHang.tfTenKH;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class FormHDBH extends javax.swing.JPanel {

    private DefaultTableModel dataModelHDBH;
    private HoaDonBH_Dao hdbh_dao;
    private CT_HDBanHang_Dao ctbh_dao;
    private ArrayList<HDBanHang> ListHDBH;
    DecimalFormat df = new DecimalFormat("#,##0 VND");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public FormHDBH() {

        try {
            Connect.getInstance().connect();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        initComponents();
        tableHDBH.fixTable(jScrollPane);
        hdbh_dao = new HoaDonBH_Dao();
        ctbh_dao = new CT_HDBanHang_Dao();
        updateTable();
    }

    private void updateTable() {
        ListHDBH = hdbh_dao.getAllHDBH();
        for (HDBanHang hdbh : ListHDBH) {
            dataModelHDBH.addRow(new Object[]{hdbh.getMaHDBH(), hdbh.getNhanVien().getTenNV(), hdbh.getKhachHang().getTenKH(), sdf.format(hdbh.getNgayLapHDBH()), df.format(hdbh.getTongTien())});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        txtTim = new swing.TextField();
        btnTim = new swing.Button();
        btnCT = new swing.Button();
        btnXoa = new swing.Button();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tableHDBH = new swing.Table();
        jLabel5 = new javax.swing.JLabel();
        btnIn = new swing.Button();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(204, 204, 255));
        setToolTipText("");

        txtTim.setHintText("Tìm hóa đơn");

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loupe.png"))); // NOI18N
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/file.png"))); // NOI18N
        btnCT.setText("Xem Chi Tiết");
        btnCT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCTActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoa.setText("Xóa ");
        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh Sách Hóa Đơn Bán Hàng");

        tableHDBH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Nhân Viên", "Khách Hàng", "Ngày Lập Hóa Đơn", "Tổng Tiền"
            }
        ));
        tableHDBH.setShowGrid(true);
        tableHDBH.setShowVerticalLines(false);
        dataModelHDBH = (DefaultTableModel) tableHDBH.getModel();
        jScrollPane.setViewportView(tableHDBH);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tìm Hóa Đơn Theo Số Điện Thoại:");

        btnIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/file.png"))); // NOI18N
        btnIn.setText("In Báo Cáo");
        btnIn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(190, 471, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(467, 467, 467))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(941, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(548, 548, 548)
                    .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(548, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(389, 389, 389)
                    .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(390, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void printBill(String data, String source) {
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport(source);
            map.put("maHDBH", data);
            JasperPrint p = JasperFillManager.fillReport(report, map, con);
            JasperViewer.viewReport(p, false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void btnCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCTActionPerformed
        int r = tableHDBH.getSelectedRow();
        if (r != -1) {
            String ma = dataModelHDBH.getValueAt(r, 0).toString();
            System.out.println(ma);
            printBill(ma, "src\\main\\java\\report\\reportHDBH.jrxml");
        } else {
            JOptionPane.showMessageDialog(null, "Xin chọn hóa cần xem chi tiết");
        }
    }//GEN-LAST:event_btnCTActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int r = tableHDBH.getSelectedRow();
        if (r != -1) {
            int click = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xóa Đơn Bán Hàng Này", "Thông Báo", 2);
            if (click == JOptionPane.OK_OPTION) {
                String ma = dataModelHDBH.getValueAt(r, 0).toString();
                if (ctbh_dao.xoa(ma)) {
                    if (hdbh_dao.xoa(ma)) {
                        dataModelHDBH.removeRow(r);
                        JOptionPane.showMessageDialog(null, "Xóa Đơn Bán Hàng Thành Công");
                    }
                }
            } else if (click == JOptionPane.CANCEL_OPTION) {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Xin Chọn Đơn Bán Hàng Cần Xóa");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        xoaModel(tableHDBH);
        String sdt = txtTim.getText().toString().trim();
        if (sdt.length() == 10) {
            ArrayList<HDBanHang> dshdbh = hdbh_dao.getHDTheoSDT(sdt);
            if (dshdbh.size() > 0) {
                for (HDBanHang hdbh : dshdbh) {
                    dataModelHDBH.addRow(new Object[]{hdbh.getMaHDBH(), hdbh.getNhanVien().getTenNV(), hdbh.getKhachHang().getTenKH(), sdf.format(hdbh.getNgayLapHDBH()), df.format(hdbh.getTongTien())});
                }
            } else {
                updateTable();
                JOptionPane.showMessageDialog(null, "Không Tìm Thấy Hóa Đơn Phù Hợp");
            }
        } else {
            updateTable();
            JOptionPane.showMessageDialog(null, "Số Điện Thoại Không Hợp Lệ");
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
   
    }//GEN-LAST:event_btnInActionPerformed
    public void xoaModel(JTable table) {
        DefaultTableModel del = (DefaultTableModel) tableHDBH.getModel();
        del.getDataVector().removeAllElements();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnCT;
    private swing.Button btnIn;
    private swing.Button btnTim;
    private swing.Button btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane;
    private swing.Table tableHDBH;
    private swing.TextField txtTim;
    // End of variables declaration//GEN-END:variables
}
