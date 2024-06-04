
package form;

import static form.FromCTKH.dataModelKH;
import connect.Connect;
import dao.CT_HDBanHang_Dao;
import dao.HoaDonBH_Dao;
import dao.KhachHang_Dao;
import entity.CT_HDBanHang;
import entity.HDBanHang;
import entity.KhachHang;
import entity.SanPham;
import entity.TaiKhoan;
import static form.FromCTKH.tableKH;
import gui.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class FormThongKeKH extends javax.swing.JPanel implements ActionListener, MouseListener {

    /**
     * Creates new form FormTKSPBC
     */
    private DefaultTableModel dataModelHDBH;
    private HoaDonBH_Dao hd_dao;

    private ArrayList<HDBanHang> List;
    DecimalFormat df = new DecimalFormat("#,##0 VND");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public FormThongKeKH() {

        try {
            Connect.getInstance().connect();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        initComponents();
        table.fixTable(jScrollPane);
        table.addMouseListener((MouseListener) this);
        hd_dao = new HoaDonBH_Dao();
        updateTable();
    }

    private void updateTable() {
        List = hd_dao.getAllHDBH();
        dataModelHDBH = (DefaultTableModel) table.getModel();
        for (HDBanHang hdbh : List) {
            dataModelHDBH.addRow(new Object[]{hdbh.getMaHDBH(), hdbh.getKhachHang().getTenKH(), df.format(hdbh.getTongTien())});
        }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnTim = new swing.Button();
        jLabel15 = new javax.swing.JLabel();
        cbbThangKH = new swing.Combobox();
        cbbNgayKH = new swing.Combobox();
        jLabel12 = new javax.swing.JLabel();
        cbbNamKH = new swing.Combobox();
        RbtnNgayKH = new javax.swing.JRadioButton();
        RbtnThangKH = new javax.swing.JRadioButton();
        RbtnNamKH = new javax.swing.JRadioButton();
        btnCT = new swing.Button();
        btnIn = new swing.Button();
        jScrollPane = new javax.swing.JScrollPane();
        table = new swing.Table();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Khách Hàng Mua Nhiều Theo Tổng Tiền");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), null), "Thống Kê", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Tháng:");

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loupe.png"))); // NOI18N
        btnTim.setText("Thống Kê");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Ngày:");

        cbbThangKH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cbbNgayKH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        cbbNgayKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNgayKHActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Năm:");

        cbbNamKH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả", "2021", "2022" }));

        RbtnNgayKH.setText("Thống Kê Theo Ngày");

        RbtnThangKH.setText("Thống Kê Theo Tháng");

        RbtnNamKH.setText("Thống Kê Theo Năm");

        btnCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/file.png"))); // NOI18N
        btnCT.setText("Xem Chi Tiết ");
        btnCT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCTActionPerformed(evt);
            }
        });

        btnIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/file.png"))); // NOI18N
        btnIn.setText("In Báo Cáo");
        btnIn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(cbbNgayKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(RbtnNgayKH))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(cbbThangKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(RbtnThangKH))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbNamKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(RbtnNamKH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCT, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(303, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbNgayKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbThangKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNamKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RbtnNgayKH)
                        .addComponent(RbtnThangKH)
                        .addComponent(RbtnNamKH))
                    .addComponent(btnCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Tổng Tiền"
            }
        ));
        table.setShowGrid(true);
        table.setShowVerticalLines(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(table);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THỐNG KÊ KHÁCH HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE)
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1323, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE)
                    .addGap(51, 51, 51)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(798, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed

        String ngay = cbbNgayKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbNgayKH.getSelectedItem().toString().trim();
        String thang = cbbThangKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbThangKH.getSelectedItem().toString().trim();
        String nam = cbbNamKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbNamKH.getSelectedItem().toString().trim();
        if (RbtnNgayKH.isSelected()) {
            if (BatLoiNgay()) {

                xoaModel(table);
                ArrayList<HDBanHang> Lis = new ArrayList<HDBanHang>();
                Lis = hd_dao.getNgay(ngay, thang, nam);

                if (Lis.size() > 0) {

                    for (HDBanHang hdbh : Lis) {
                        dataModelHDBH.addRow(new Object[]{hdbh.getKhachHang().getMaKH(), hdbh.getKhachHang().getTenKH(), df.format(hdbh.getTongTien())});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không Có Dữ Liệu Phù Hợp");
                    xoaModel(table);
                    updateTable();
                }
            }
        } else if (RbtnThangKH.isSelected()) {
            if (BatLoiThang()) {

                xoaModel(table);
                ArrayList<HDBanHang> Lis = new ArrayList<HDBanHang>();
                Lis = hd_dao.getThang(thang, nam);

                if (Lis.size() > 0) {

                    for (HDBanHang hdbh : Lis) {
                        dataModelHDBH.addRow(new Object[]{hdbh.getKhachHang().getMaKH(), hdbh.getKhachHang().getTenKH(), df.format(hdbh.getTongTien())});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không Có Dữ Liệu Phù Hợp");
                    xoaModel(table);
                    updateTable();
                }
            }
        } else if (RbtnNamKH.isSelected()) {
            if (BatLoiNam()) {

                xoaModel(table);
                ArrayList<HDBanHang> Lis = new ArrayList<HDBanHang>();
                Lis = hd_dao.getNam(nam);

                if (Lis.size() > 0) {

                    for (HDBanHang hdbh : Lis) {
                        dataModelHDBH.addRow(new Object[]{hdbh.getKhachHang().getMaKH(), hdbh.getKhachHang().getTenKH(), df.format(hdbh.getTongTien())});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không Có Dữ Liệu Phù Hợp");
                    xoaModel(table);
                    updateTable();
                }
            }
        }


    }//GEN-LAST:event_btnTimActionPerformed
    public void xoaModel(JTable table) {
        DefaultTableModel del = (DefaultTableModel) table.getModel();
        del.getDataVector().removeAllElements();
    }
    private void cbbNgayKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNgayKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNgayKHActionPerformed

    private void btnCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCTActionPerformed
        String ngay = cbbNgayKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbNgayKH.getSelectedItem().toString().trim();
        String thang = cbbThangKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbThangKH.getSelectedItem().toString().trim();
        String nam = cbbNamKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbNamKH.getSelectedItem().toString().trim();
        int r = table.getSelectedRow();
        if (r != -1) {
            new FromCTKH().setVisible(true);
            String makh = (String) table.getValueAt(r, 0);
            FromCTKH.txtMaKH=makh;
            if (RbtnNgayKH.isSelected()) {
                if (BatLoiNgay()) {
                    dataModelKH = (DefaultTableModel) tableKH.getModel();
                    xoaModel(tableKH);
                    ArrayList<HDBanHang> Lis = new ArrayList<HDBanHang>();
                    Lis = hd_dao.getCTNgay(makh, ngay, thang, nam);
                    if (Lis.size() > 0) {

                        for (HDBanHang hdbh : Lis) {
                            dataModelKH.addRow(new Object[]{hdbh.getMaHDBH(), hdbh.getKhachHang().getTenKH(), df.format(hdbh.getTongTien())});
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Không Có Dữ Liệu Phù Hợp");
                        xoaModel(tableKH);

                    }
                }
            } else if (RbtnThangKH.isSelected()) {
                if (BatLoiThang()) {
                    dataModelKH = (DefaultTableModel) tableKH.getModel();
                    xoaModel(tableKH);
                    ArrayList<HDBanHang> Lis = new ArrayList<HDBanHang>();
                    Lis = hd_dao.getCTThang(makh, thang, nam);
                    if (Lis.size() > 0) {

                        for (HDBanHang hdbh : Lis) {
                            dataModelKH.addRow(new Object[]{hdbh.getMaHDBH(), hdbh.getKhachHang().getTenKH(), df.format(hdbh.getTongTien())});
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Không Có Dữ Liệu Phù Hợp");
                        xoaModel(tableKH);

                    }
                }
            } else if (RbtnNamKH.isSelected()) {
                if (BatLoiNam()) {
                    dataModelKH = (DefaultTableModel) tableKH.getModel();
                    xoaModel(tableKH);
                    ArrayList<HDBanHang> Lis = new ArrayList<HDBanHang>();
                    Lis = hd_dao.getCTNam(makh, nam);
                    if (Lis.size() > 0) {
                        for (HDBanHang hdbh : Lis) {
                            dataModelKH.addRow(new Object[]{hdbh.getMaHDBH(), hdbh.getKhachHang().getTenKH(), df.format(hdbh.getTongTien())});
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Không Có Dữ Liệu Phù Hợp");
                        xoaModel(tableKH);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnCTActionPerformed
    public void printBillNam(String data,TaiKhoan tk, String source) {
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport(source);
            map.put("txtNam", data);
            map.put("ma", tk.getNhanVien().getMaNV().toString());
            map.put("ten", tk.getNhanVien().getTenNV().toString());
            map.put("cv", tk.getNhanVien().getChucVu().getTenCV().toString());
            JasperPrint p = JasperFillManager.fillReport(report, map, con);
            JasperViewer.viewReport(p, false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void printBillThang(String data, String data1,TaiKhoan tk, String source) {
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Hashtable map = new Hashtable();
            JasperReport report;
            report = JasperCompileManager.compileReport(source);
            map.put("txtThang", data);
            map.put("txtNam", data1);
            map.put("ma", tk.getNhanVien().getMaNV().toString());
            map.put("ten", tk.getNhanVien().getTenNV().toString());
            map.put("cv", tk.getNhanVien().getChucVu().getTenCV().toString());
            JasperPrint p = JasperFillManager.fillReport(report, map, con);
            JasperViewer.viewReport(p, false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void printBillNgay(String data, String data1, String data2,TaiKhoan tk, String source) {
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Hashtable map = new Hashtable();
            JasperReport report;
            report = JasperCompileManager.compileReport(source);
            map.put("txtNgay", data);
            map.put("txtThang", data1);
            map.put("txtNam", data2);
            map.put("ma", tk.getNhanVien().getMaNV().toString());
            map.put("ten", tk.getNhanVien().getTenNV().toString());
            map.put("cv", tk.getNhanVien().getChucVu().getTenCV().toString());
            JasperPrint p = JasperFillManager.fillReport(report, map, con);
            JasperViewer.viewReport(p, false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        String ngay = cbbNgayKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbNgayKH.getSelectedItem().toString().trim();
        String nam = cbbNamKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbNamKH.getSelectedItem().toString().trim();
        String thang = cbbThangKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbThangKH.getSelectedItem().toString().trim();

        if (RbtnNgayKH.isSelected()) {
            if (BatLoiNgay()) {
                printBillNgay(ngay, thang, nam,Main.tkDN, "src\\main\\java\\report\\reportKHNgay.jrxml");
            }
        } else if (RbtnThangKH.isSelected()) {
            if (BatLoiThang()) {
                printBillThang(thang, nam, Main.tkDN,"src\\main\\java\\report\\reportKHThang.jrxml");
            }
        } else if (RbtnNamKH.isSelected()) {
            if (BatLoiNam()) {
                printBillNam(nam,Main.tkDN, "src\\main\\java\\report\\reportKHNam.jrxml");
            }
        }
    }//GEN-LAST:event_btnInActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
//        int r = table.getSelectedRow();
//        if (r != -1) {
//            FromCTKH.txtMaKH = table.getValueAt(r, 0).toString();
     //   }
    }//GEN-LAST:event_tableMouseClicked

    private boolean BatLoiNam() {
        String nam = cbbNamKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbNamKH.getSelectedItem().toString().trim();
        if (!(nam.length() > 0)) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Năm");
            return false;
        }
        return true;

    }

    private boolean BatLoiThang() {
        String thang = cbbThangKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbThangKH.getSelectedItem().toString().trim();
        String nam = cbbNamKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbNamKH.getSelectedItem().toString().trim();
        if (!(thang.length() > 0)) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Tháng");
            return false;
        }
        if (!(nam.length() > 0)) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Năm");
            return false;
        }

        return true;

    }

    private boolean BatLoiNgay() {
        String ngay = cbbNgayKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbNgayKH.getSelectedItem().toString().trim();
        String thang = cbbThangKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbThangKH.getSelectedItem().toString().trim();
        String nam = cbbNamKH.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbNamKH.getSelectedItem().toString().trim();
        if (!(ngay.length() > 0)) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Ngày");
            return false;
        }
        if (!(thang.length() > 0)) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Tháng");
            return false;
        }
        if (!(nam.length() > 0)) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Năm");
            return false;
        }

        return true;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JRadioButton RbtnNamKH;
    public static javax.swing.JRadioButton RbtnNgayKH;
    public static javax.swing.JRadioButton RbtnThangKH;
    private swing.Button btnCT;
    private swing.Button btnIn;
    private swing.Button btnTim;
    public static swing.Combobox cbbNamKH;
    public static swing.Combobox cbbNgayKH;
    public static swing.Combobox cbbThangKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private swing.Table table;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

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