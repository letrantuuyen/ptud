package form;

import connect.Connect;
import dao.*;
import gui.Main;
import entity.*;
import form.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

public class FormDatHang extends javax.swing.JPanel {

    private DefaultTableModel dataModelDH;
    private ArrayList<DatHang> listDH;
    private HoaDonBH_Dao hd_dao;
    private CT_HDBanHang_Dao ctbh_dao;
    private DatHang_Dao dh_dao;
    private CT_DatHang_Dao ctdh_dao;
    private KhachHang_Dao kh_dao;
    private SanPham_Dao sp_dao;
    private KhachHang kh;
    private KhachHang tkh = null;
    private double tientra;
    private double tongTien;
    DecimalFormat df = new DecimalFormat("#,##0 VND");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public FormDatHang() {

        try {
            Connect.getInstance().connect();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        initComponents();
        tableDH.fixTable(jScrollPane1);
        dh_dao = new DatHang_Dao();
        kh_dao = new KhachHang_Dao();
        ctdh_dao = new CT_DatHang_Dao();
        sp_dao = new SanPham_Dao();
        hd_dao = new HoaDonBH_Dao();
        ctdh_dao = new CT_DatHang_Dao();
        updateTable();
    }

    public void updateTable() {
        listDH = dh_dao.getAllDH();
        for (DatHang dh : listDH) {
            dataModelDH.addRow(new Object[]{dh.getMaDH(), dh.getNhanVien().getTenNV(), dh.getKhachHang().getTenKH(), sdf.format(dh.getNgayDH()), df.format(dh.getTongTien())});
        }
    }

    public void xoaModel(JTable table) {
        DefaultTableModel del = (DefaultTableModel) table.getModel();
        del.getDataVector().removeAllElements();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDH = new swing.Table();
        tfTimSDT = new swing.TextField();
        btnTim = new swing.Button();
        jLabel7 = new javax.swing.JLabel();
        tfSDT = new swing.TextField();
        tfTenKH = new swing.TextField();
        tfDC = new swing.TextField();
        tfTienKhach = new swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        lblTra = new javax.swing.JLabel();
        btnHuy = new swing.Button();
        bntCT = new swing.Button();
        chkXuatHD = new swing.CheckBox();
        btnThanhToan = new swing.Button();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        btnDatThem = new swing.Button();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setToolTipText("");

        tableDH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Nhân Viên", "Khách Hàng", "Ngày Lập Hóa Đơn", "Tổng Tiền"
            }
        ));
        tableDH.setShowGrid(true);
        tableDH.setShowVerticalLines(false);
        dataModelDH = (DefaultTableModel) tableDH.getModel();
        tableDH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDH);

        tfTimSDT.setForeground(new java.awt.Color(25, 25, 25));
        tfTimSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfTimSDT.setHintText("Tìm khách hàng đặt hàng");

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loupe.png"))); // NOI18N
        btnTim.setColor2(new java.awt.Color(0, 102, 204));
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Khách Hàng");

        tfSDT.setEditable(false);
        tfSDT.setHintText("Số điện thoại");

        tfTenKH.setEditable(false);
        tfTenKH.setHintText("Tên khách hàng");

        tfDC.setEditable(false);
        tfDC.setHintText("Địa chỉ");

        tfTienKhach.setHintText("Tiền khách đưa");
        tfTienKhach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTienKhachKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tiền trả lại: ");

        lblTra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTra.setForeground(java.awt.Color.red);
        lblTra.setText("0 VND");

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancellation.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setColor2(new java.awt.Color(255, 0, 51));
        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        bntCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/file.png"))); // NOI18N
        bntCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCTActionPerformed(evt);
            }
        });

        chkXuatHD.setText("Xuất hóa đơn");
        chkXuatHD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pay.png"))); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Danh Sách Đơn Đặt Hàng");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tổng tiền:");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTongTien.setForeground(java.awt.Color.red);
        lblTongTien.setText("0 VND");

        btnDatThem.setText("Mua Thêm");
        btnDatThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatThemActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Chi Tiết Đặt Hàng:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tìm Khách hàng Theo Số Điện Thoại:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTimSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(60, 60, 60))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDatThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntCT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(chkXuatHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(tfTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(114, 114, 114)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfTienKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDC, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblTra, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(527, 527, 527)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTimSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(28, 28, 28)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel3)
                                                .addComponent(lblTongTien)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblTra)
                                                .addComponent(jLabel1))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfTienKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(chkXuatHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(bntCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDatThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatThemActionPerformed
        int r = tableDH.getSelectedRow();
        if (r != -1) {
            FormBanHang.maDH = dataModelDH.getValueAt(r, 0).toString();
            FormBanHang.sdtKHDT = tfSDT.getText().toString().trim();
            KhachHang kh;
            try {
                kh = kh_dao.TimKHTheoSDT(tfSDT.getText().toString().trim());
                FormBanHang.tenKh = kh.getTenKH();
                FormBanHang.sdtKH = kh.getsDT();
                FormBanHang.dcKH = kh.getDiaChi();
            } catch (SQLException ex) {
                Logger.getLogger(FormDatHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            Main.panelTransaction.showForm(new FormBanHang());
        } else {
            JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Đơn Đặt Hàng");
        }
    }//GEN-LAST:event_btnDatThemActionPerformed

    public void upTableTim(ArrayList<DatHang> lsdh) {
        for (DatHang dh : lsdh) {
            dataModelDH.addRow(new Object[]{dh.getMaDH(), dh.getNhanVien().getTenNV(), dh.getKhachHang().getTenKH(), sdf.format(dh.getNgayDH()), df.format(dh.getTongTien())});
        }
    }

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed

        String sdt = tfTimSDT.getText().toString();
        if (sdt.length() == 10) {
            try {
                if (kh_dao.TimKHTheoSDT(sdt) != null) {
                    tkh = kh_dao.TimKHTheoSDT(sdt);
                    tfTenKH.setText(tkh.getTenKH());
                    tfSDT.setText(tkh.getsDT());
                    tfDC.setText(tkh.getDiaChi());
                    tfTimSDT.setText("");
                    xoaModel(tableDH);
                    ArrayList<DatHang> lsdh = dh_dao.getDHMaKH(tkh.getMaKH());
                    upTableTim(lsdh);
                } else {
                    xoaModel(tableDH);
                    updateTable();
                    JOptionPane.showMessageDialog(null, "Không Tìm Thấy Khách Hàng");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Số Điện Thoại Không Hợp Lệ");
            xoaModel(tableDH);
            updateTable();
        }


    }//GEN-LAST:event_btnTimActionPerformed

    private void tableDHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDHMouseClicked

        int r = tableDH.getSelectedRow();
        String ma = dataModelDH.getValueAt(r, 0).toString();
        DatHang dh = dh_dao.getDH(ma);
        KhachHang kh = kh_dao.getKH(dh.getKhachHang().getMaKH());
        tfTenKH.setText(kh.getTenKH());
        tfSDT.setText(kh.getsDT());
        tfDC.setText(kh.getDiaChi());
        tongTien = dh.getTongTien();
        lblTongTien.setText(df.format(tongTien));
    }//GEN-LAST:event_tableDHMouseClicked

    public void printBillDH(String data, String source) {
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport(source);
            map.put("maDH", data);
            JasperPrint p = JasperFillManager.fillReport(report, map, con);
            JasperViewer.viewReport(p, false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void printBillBH(String data, String source) {
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

    private void bntCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCTActionPerformed
        int r = tableDH.getSelectedRow();
        String ma = dataModelDH.getValueAt(r, 0).toString();
        printBillDH(ma, "src\\main\\java\\report\\reportDH.jrxml");
    }//GEN-LAST:event_bntCTActionPerformed

    private void tfTienKhachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTienKhachKeyReleased
        try {
            if (!"".equals(tfTienKhach.getText())) {
                double tien = Double.parseDouble(tfTienKhach.getText().toString());
                tientra = tien - tongTien;
                lblTra.setText(df.format(tientra));
            } else {
                lblTra.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tfTienKhachKeyReleased

    public void Huy() {

    }

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed

        int r = tableDH.getSelectedRow();
        if (r != -1) {
            int click = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Hủy Đơn Đặt Hàng Này", "Thông Báo", 2);
            if (click == JOptionPane.OK_OPTION) {
                String ma = dataModelDH.getValueAt(r, 0).toString();
                ArrayList<SanPham> lssp = sp_dao.getAllSP();
                ArrayList<CT_DatHang> lsctdh = ctdh_dao.getCTDHS(ma);
                for (SanPham sp : lssp) {
                    for (CT_DatHang ct : lsctdh) {
                        if (sp.getMaSP().equals(ct.getSanPham().getMaSP())) {
                            sp_dao.capNhatSoLuong(sp.getMaSP(), (sp.getSoLuong() + ct.getSoLuong()));
                        }
                    }
                }
                if (ctdh_dao.xoa(ma)) {
                    if (dh_dao.xoa(ma)) {
                        dataModelDH.removeRow(r);
                        xoaTexfKH();
                        JOptionPane.showMessageDialog(null, "Hủy Đơn Đặt Hàng Thành Công");
                    }
                }
            } else if (click == JOptionPane.CANCEL_OPTION) {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Xin Chọn Đơn Đặt Hàng Cần Hủy");
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    public void thanhToan() {
        int r = tableDH.getSelectedRow();
        if (r != -1) {
            Date ngayLapHDBH = new Date();
            String ma = dataModelDH.getValueAt(r, 0).toString();
            DatHang dh = dh_dao.getDH(ma);
            ArrayList<CT_DatHang> lsctdh = ctdh_dao.getCTDHS(ma);
            HDBanHang hd = new HDBanHang(Main.tkDN.getNhanVien(), dh.getKhachHang(), ngayLapHDBH, dh.getTongTien());
            hd_dao.themHD(hd);
            HDBanHang hdMoiThem = hd_dao.getHoaDonMoiNhat();
            for (CT_DatHang ctdh : lsctdh) {
                ctbh_dao = new CT_HDBanHang_Dao();
                CT_HDBanHang cthdbh = new CT_HDBanHang(ctdh.getSoLuong(), ctdh.getThanhTien(), hdMoiThem, ctdh.getSanPham());
                ctbh_dao.themCthd(cthdbh);
            }
            if (ctdh_dao.xoa(ma)) {
                if (dh_dao.xoa(ma)) {
                    dataModelDH.removeRow(r);
                    xoaTexfKH();
                }
            }
            if (chkXuatHD.isSelected()) {
                printBillBH(hdMoiThem.getMaHDBH(), "src\\main\\java\\report\\reportHDBH.jrxml");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Xin Chọn Đơn Đặt Hàng Cần Thanh Toán");
        }
    }

    public void xoaTexfKH() {
        tfTenKH.setText("");
        tfSDT.setText("");
        tfDC.setText("");
        tfTienKhach.setText("");
    }

    public boolean ktrTextKH() {
        int r = tableDH.getSelectedRow();
        if (r == -1) {
            JOptionPane.showMessageDialog(null, "Xin Chọn Đơn Đặt Hàng");
            return false;
        } else if (tfTienKhach.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Xin Nhập Tiền Khách Hàng Đưa");
            return false;
        } else if (tientra < 0) {
            JOptionPane.showMessageDialog(null, "Tiền Khách Hàng Đưa Không Đủ");
            return false;
        }
        return true;
    }
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

        if (ktrTextKH()) {
            JOptionPane.showMessageDialog(null, "Thanh Toán Đơn Đặt Hàng Thành Công");
            thanhToan();
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button bntCT;
    private swing.Button btnDatThem;
    private swing.Button btnHuy;
    private swing.Button btnThanhToan;
    private swing.Button btnTim;
    private swing.CheckBox chkXuatHD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTra;
    private swing.Table tableDH;
    private swing.TextField tfDC;
    private swing.TextField tfSDT;
    private swing.TextField tfTenKH;
    private swing.TextField tfTienKhach;
    private swing.TextField tfTimSDT;
    // End of variables declaration//GEN-END:variables
}
