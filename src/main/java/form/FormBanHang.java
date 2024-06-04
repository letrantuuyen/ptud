package form;

import connect.Connect;
import dao.*;
import entity.*;
import gui.Main;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class FormBanHang extends javax.swing.JPanel {

    public static String maDH = null;
    public static String sdtKHDT = null;
    public static String tenKh = null;
    public static String sdtKH = null;
    public static String dcKH = null;
    private DefaultTableModel dataModelSP;
    private DefaultTableModel dataModelBH;
    private SanPham_Dao sp_dao;
    private DanhMuc_Dao dm_dao;
    private KhachHang_Dao kh_dao;
    private NhanVien_Dao nv_dao;
    private HoaDonBH_Dao hd_dao;
    private CT_HDBanHang_Dao cthdbh_dao;
    private NhaSX_Dao nsx_dao;
    private MauSac_Dao ms_dao;
    private KichCo_Dao kc_dao;
    private DatHang_Dao dh_dao;
    private CT_DatHang_Dao ctdh_dao;
    private ArrayList<SanPham> dstt = null;
    private ArrayList<SanPham> ListTimSP;
    private ArrayList<SanPham> ListSP;
    private int soLuongTon = 0;
    private double tongTien;
    private KhachHang tkh = null;
    private double tientra;
    DecimalFormat df = new DecimalFormat("#,##0 VND");

    public FormBanHang() {
        try {
            Connect.getInstance().connect();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        initComponents();
        tableSP.fixTable(jScrollPane1);
        tableDH.fixTable(jScrollPane2);
        ListSP = new ArrayList<SanPham>();
        dstt = new ArrayList<SanPham>();
        dm_dao = new DanhMuc_Dao();
        sp_dao = new SanPham_Dao();
        kh_dao = new KhachHang_Dao();
        hd_dao = new HoaDonBH_Dao();
        cthdbh_dao = new CT_HDBanHang_Dao();
        dh_dao = new DatHang_Dao();
        ctdh_dao = new CT_DatHang_Dao();
        nsx_dao = new NhaSX_Dao();
        ms_dao = new MauSac_Dao();
        kc_dao = new KichCo_Dao();
        nv_dao = new NhanVien_Dao();

        upcomBoBox();
        updateTable();
        setTextKH(tenKh, sdtKH, dcKH);
        tenKh = null;
        sdtKH = null;
        dcKH = null;
    }

    public void setTextKH(String tenKh, String sdtKH, String dcKH) {
        tfTenKH.setText(tenKh);
        tfSDT.setText(sdtKH);
        tfDC.setText(dcKH);
    }

    public void upcomBoBox() {
        ArrayList<DanhMucSP> dsDM = dm_dao.getAllDM();
        ArrayList<NhaSX> dsNSX = nsx_dao.getAllNSX();
        ArrayList<MauSac> dsMS = ms_dao.getAllMS();
        ArrayList<KichCo> dsKC = kc_dao.getAllKC();
        for (DanhMucSP dm : dsDM) {
            cbbDM.addItem(dm.getTenDanhMuc());
        }
        for (NhaSX nsx : dsNSX) {
            cbbNSX.addItem(nsx.getTenNSX());
        }
        for (MauSac ms : dsMS) {
            cbbMS.addItem(ms.getTenMS());
        }
        for (KichCo kc : dsKC) {
            cbbKC.addItem(kc.getTenKC());
        }
    }

    private void updateTable() {
        ListSP = sp_dao.getAllSP();
        for (SanPham sp : ListSP) {
            for (SanPham s : dstt) {
                if (sp.getMaSP().equals(s.getMaSP())) {
                    sp.setSoLuong(sp.getSoLuong() - s.getSoLuong());
                }
            }
        }
        for (SanPham sp : ListSP) {
            dataModelSP.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getDanhMuc().getTenDanhMuc(), df.format(sp.getDonGia()), sp.getSoLuong(), sp.getChatLieu().getTenCL(), sp.getMauSac().getTenMS(), sp.getKichCo().getTenKC(), sp.getnSX().getTenNSX(), sp.getAnh()});
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
        tableSP = new swing.Table();
        lblAnh = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThemSP = new swing.Button();
        jLabel5 = new javax.swing.JLabel();
        SpinnerSl = new javax.swing.JSpinner();
        button3 = new swing.Button();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDH = new swing.Table();
        jLabel7 = new javax.swing.JLabel();
        btnTimKH = new swing.Button();
        tfTimSDT = new swing.TextField();
        tfSDT = new swing.TextField();
        tfTenKH = new swing.TextField();
        tfDC = new swing.TextField();
        tfTienKhach = new swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        lblTra = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnXoa = new swing.Button();
        btnHuy = new swing.Button();
        chkXuatHD = new swing.CheckBox();
        btnthanhToan = new swing.Button();
        btnDatHang = new swing.Button();
        jLabel6 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tfTenSP = new swing.TextField();
        jLabel2 = new javax.swing.JLabel();
        cbbDM = new swing.Combobox();
        btnTimSP = new swing.Button();
        cbbNSX = new swing.Combobox();
        jLabel8 = new javax.swing.JLabel();
        cbbMS = new swing.Combobox();
        jLabel10 = new javax.swing.JLabel();
        cbbKC = new swing.Combobox();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setToolTipText("");

        tableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Quần Áo", "Tên Quần Áo", "Danh Mục", "Đơn Giá", "Số Luọng", "Chất Liệu", "Màu sắc", "Kích Cỡ", "Nhà Sản Xuất"
            }
        ));
        tableSP.setShowGrid(true);
        tableSP.setShowVerticalLines(false);
        tableSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSP);
        dataModelSP = (DefaultTableModel) tableSP.getModel();

        lblAnh.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N

        btnThemSP.setText("Thêm");
        btnThemSP.setColor2(new java.awt.Color(0, 102, 204));
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Số Lượng");

        SpinnerSl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SpinnerSl.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        button3.setText("Làm mới");
        button3.setColor2(new java.awt.Color(0, 102, 204));
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        tableDH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Sản Phẩm", "Chất Liệu", "Màu Sắc", "Kích Thước", "Số lượng", "Đơn Giá", "Tổng Tiền"
            }
        ));
        jScrollPane2.setViewportView(tableDH);
        dataModelBH = (DefaultTableModel) tableDH.getModel();

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Thanh Toán");

        btnTimKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loupe.png"))); // NOI18N
        btnTimKH.setColor2(new java.awt.Color(0, 102, 204));
        btnTimKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKHActionPerformed(evt);
            }
        });

        tfTimSDT.setHintText("Nhập số điện thoại để tìm");

        tfSDT.setHintText("Số điện thoại");

        tfTenKH.setHintText("Tên khách hàng");

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Đơn Hàng");

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancellation.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setColor2(new java.awt.Color(255, 0, 51));
        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        chkXuatHD.setText("Xuất hóa đơn");
        chkXuatHD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnthanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pay.png"))); // NOI18N
        btnthanhToan.setText("Thanh toán");
        btnthanhToan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnthanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthanhToanActionPerformed(evt);
            }
        });

        btnDatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cargo.png"))); // NOI18N
        btnDatHang.setText("Đặt hàng");
        btnDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHangActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tổng tiên:");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTongTien.setForeground(java.awt.Color.red);
        lblTongTien.setText(" 0 VND");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), null), "Tìm Kiếm Quần Áo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfTenSP.setHintText("Tên sản phẩm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Danh Mục: ");

        cbbDM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả" }));

        btnTimSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loupe.png"))); // NOI18N
        btnTimSP.setColor2(new java.awt.Color(0, 102, 204));
        btnTimSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimSPActionPerformed(evt);
            }
        });

        cbbNSX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Nhà Sản Xuất:");

        cbbMS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Màu Sắc:");

        cbbKC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả" }));

        jLabel11.setText("Kích Cở:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tfTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(35, 35, 35)
                        .addComponent(cbbKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(cbbDM, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbMS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(cbbKC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(btnTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Tìm khách hàng:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel5)
                .addGap(55, 55, 55)
                .addComponent(SpinnerSl, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel9)))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfTienKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)
                                .addGap(1, 1, 1)
                                .addComponent(lblTra, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(chkXuatHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnthanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfTimSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDC, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpinnerSl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(tfTimSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(tfTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(btnTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(lblTongTien))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTienKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(lblTra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkXuatHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnthanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimSPActionPerformed
        // TODO add your handling code here:
        xoaModel(tableSP);
        ListTimSP = new ArrayList<SanPham>();
        ListTimSP = sp_dao.timSPNC(tfTenSP.getText().toString(), cbbDM.getSelectedItem().toString().trim(), cbbNSX.getSelectedItem().toString().trim(), cbbMS.getSelectedItem().toString().trim(), cbbKC.getSelectedItem().toString().trim());
        if (ListTimSP.size() > 0) {
            for (SanPham sp : ListTimSP) {
                for (SanPham s : dstt) {
                    if (sp.getMaSP().equals(s.getMaSP())) {
                        sp.setSoLuong(sp.getSoLuong() - s.getSoLuong());
                    }
                }
            }
            for (SanPham sp : ListTimSP) {
                dataModelSP.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getDanhMuc().getTenDanhMuc(), df.format(sp.getDonGia()), sp.getSoLuong(), sp.getChatLieu().getTenCL(), sp.getMauSac().getTenMS(), sp.getKichCo().getTenKC(), sp.getnSX().getTenNSX(), sp.getAnh()});
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không Có Sản Phẩm Nào Phù Hợp");
            updateTable();
//            ListTimSP = ListSP;
        }
    }//GEN-LAST:event_btnTimSPActionPerformed

    private void btnTimKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKHActionPerformed
        // TODO add your handling code here:
        String sdt = tfTimSDT.getText().toString();
        if (sdt.length() == 10) {
            try {
                if (kh_dao.TimKHTheoSDT(sdt) != null) {
                    tkh = kh_dao.TimKHTheoSDT(sdt);
                    tfTenKH.setText(tkh.getTenKH());
                    tfSDT.setText(tkh.getsDT());
                    tfDC.setText(tkh.getDiaChi());
                    tfTimSDT.setText("");

                } else {
                    JOptionPane.showMessageDialog(null, "Không Tìm Thấy Khách Hàng");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Số Điện Thoại Không Hợp Lệ");
        }
    }//GEN-LAST:event_btnTimKHActionPerformed

    public int vitriSP(SanPham sp) {
        int i = -1;
        if (dstt.contains(sp)) {
            return dstt.indexOf(sp);
        }
        return i;
    }

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        // TODO add your handling code here:
        int r = tableSP.getSelectedRow();
        if (r != -1) {
            soLuongTon = Integer.parseInt(dataModelSP.getValueAt(r, 4).toString());
            String maSP = (dataModelSP.getValueAt(r, 0).toString());
            SanPham sp = sp_dao.getSPTheoMa(maSP);
            int soluong = 0;
            double dongia = 0;
            try {
                soluong = (int) SpinnerSl.getValue();
                dongia = sp.getDonGia();
            } catch (Exception e) {

            }
            if (soluong <= 0) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Số Lượng Sản Phẩm");
                return;
            }
            sp.setSoLuong(soluong);
            int vitri = vitriSP(sp);
            double tien = 0;
            if (soLuongTon < sp.getSoLuong()) {
                JOptionPane.showMessageDialog(this, "Số Lượng Phải Nhỏ Hơn Hoặc Bằng Số Lượng Tồn");
                return;
            }
            if (vitri > -1) {
                Integer sl = dstt.get(vitri).getSoLuong() + sp.getSoLuong();
                dstt.get(vitri).setSoLuong(sl);
                tien = dstt.get(vitri).getSoLuong() * sp.getDonGia();
                dataModelBH.setValueAt(sl, vitri, 4);
                dataModelBH.setValueAt(df.format(tien), vitri, 6);
            } else {
                try {
                    dstt.add(sp);
                } catch (Exception e) {
                    System.out.println("loi");
                    e.printStackTrace();
                }
                dataModelBH = (DefaultTableModel) tableDH.getModel();
                tien = sp.getSoLuong() * sp.getDonGia();
                dataModelBH.addRow(new Object[]{
                    sp.getTenSP(), sp.getChatLieu().getTenCL(), sp.getMauSac().getTenMS(), sp.getKichCo().getTenKC(), sp.getSoLuong(), df.format(sp.getDonGia()), df.format(tien)
                });
            }
            soLuongTon -= sp.getSoLuong();
            dataModelSP.setValueAt(soLuongTon, r, 4);
            tongTien();

        } else {
            JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Sản Phẩm Trước Khi Mua");
        }
    }//GEN-LAST:event_btnThemSPActionPerformed
    public void tongTien() {
        tongTien = 0;
        for (SanPham s : dstt) {
            tongTien += (s.getSoLuong() * s.getDonGia());
        }
        lblTongTien.setText(df.format(tongTien));
    }

    public void huyDon(int r) {
        String maSP = dstt.get(r).getMaSP();
        int index = -1;
        for (SanPham s : ListSP) {
            if (s.getMaSP().endsWith(maSP)) {
                index = ListSP.indexOf(s);
                break;
            }
        }

        if (ListTimSP != null && ListTimSP.size() > 0) {
            System.out.println(ListTimSP);
            for (SanPham s : ListTimSP) {
                if (s.getMaSP().endsWith(maSP)) {
                    index = ListTimSP.indexOf(s);
                    break;
                }
            }
            for (SanPham sp : ListTimSP) {
                if (sp.getMaSP().equalsIgnoreCase(maSP)) {
                    System.out.println(sp.getMaSP());
                    dataModelSP.setValueAt(ListSP.get(index).getSoLuong(), index, 4);
                    break;
                }
            }
        } else {
            ListSP = sp_dao.getAllSP();
            dataModelSP.setValueAt(ListSP.get(index).getSoLuong(), index, 4);
        }
        System.out.println(index);
        // xóa trên table model
        dataModelBH.removeRow(r);
        // xóa trên ArrayList
        dstt.remove(r);
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:

        int r = tableDH.getSelectedRow();
        if (r != -1) {
            int click = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xóa Sản Phẩm Này", "Thông Báo", 2);
            if (click == JOptionPane.OK_OPTION) {
                huyDon(r);
                tongTien();
            } else if (click == JOptionPane.CANCEL_OPTION) {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Sản Phấm Trong Đơn Hàng Trước Khi Xóa");
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        int n = dstt.size();
        if (n > 0) {
            int click = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xóa Sản Phẩm Này", "Thông Báo", 2);
            if (click == JOptionPane.OK_OPTION) {
                for (int i = 0; i < n; i++) {
                    huyDon(0);
                }
                tableDH.removeAll();
                tongTien();
            } else if (click == JOptionPane.CANCEL_OPTION) {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Danh Sách Mua Hàng Rỗng");
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void tfTienKhachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTienKhachKeyReleased
        // TODO add your handling code here:
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

    public void thanhToan(KhachHang tkh) {
        if (tkh == null) {
            if (dstt.size() > 0) {
                List<KhachHang> ls = kh_dao.getAllKH();
                boolean bl = true;
                for (KhachHang k : ls) {
                    if (tfSDT.getText().toString().equalsIgnoreCase(k.getsDT())) {
                        JOptionPane.showMessageDialog(null, "Số Điện Thoại Đã Được Đăng Ký");
                        bl = false;
                        break;
                    }
                }
                if (bl) {
                    KhachHang kh = new KhachHang(tfTenKH.getText().toString(), tfSDT.getText().toString(), tfDC.getText().toString());
                    NhanVien nv = nv_dao.getNV(Main.tkDN.getNhanVien().getMaNV());
                    kh_dao.themKH(kh);
                    KhachHang khmoi = kh_dao.getKHMoi();
                    Date ngayLapHDBH = new Date();
                    HDBanHang hd = new HDBanHang(nv, khmoi, ngayLapHDBH, tongTien);
                    hd_dao.themHD(hd);
                    HDBanHang hdMoiThem = hd_dao.getHoaDonMoiNhat();
                    for (SanPham sp : dstt) {
                        try {
                            cthdbh_dao = new CT_HDBanHang_Dao();
                            CT_HDBanHang cthdbh = new CT_HDBanHang(sp.getSoLuong(), sp.getDonGia() * sp.getSoLuong(), hdMoiThem, sp);
                            cthdbh_dao.themCthd(cthdbh);
                        } catch (Exception e) {
                            return;
                        }
                    }
                    for (SanPham sp : dstt) {
                        SanPham spCu = null;
                        try {
                            spCu = sp_dao.getSPTheoMa(sp.getMaSP());
                        } catch (Exception e) {
                            System.out.println("loi sql");
                            e.printStackTrace();
                        }
                        if (spCu != null) {
                            sp_dao.capNhatSoLuong(spCu.getMaSP(), spCu.getSoLuong() - sp.getSoLuong());
                        }
                    }
                } else {
                    return;
                }
            }
        } else if (tkh != null) {
            if (dstt.size() > 0) {
                NhanVien nv = nv_dao.getNV(Main.tkDN.getNhanVien().getMaNV());
                Date ngayLapHDBH = new Date();
                HDBanHang hd = new HDBanHang(nv, tkh, ngayLapHDBH, tongTien);
                hd_dao.themHD(hd);
                HDBanHang hdMoiThem = hd_dao.getHoaDonMoiNhat();
                for (SanPham sp : dstt) {
                    try {
                        cthdbh_dao = new CT_HDBanHang_Dao();
                        CT_HDBanHang cthdbh = new CT_HDBanHang(sp.getSoLuong(), sp.getDonGia() * sp.getSoLuong(), hdMoiThem, sp);
                        cthdbh_dao.themCthd(cthdbh);
                    } catch (Exception e) {
                        return;
                    }
                }
                for (SanPham sp : dstt) {
                    SanPham spCu = null;
                    try {
                        spCu = sp_dao.getSPTheoMa(sp.getMaSP());
                    } catch (Exception e) {
                        System.out.println("loi sql");
                        e.printStackTrace();
                    }
                    if (spCu != null) {
                        sp_dao.capNhatSoLuong(spCu.getMaSP(), spCu.getSoLuong() - sp.getSoLuong());
                    }
                }
            }
            tkh = null;
        }

        if (chkXuatHD.isSelected()) {
            HDBanHang hdMoiThem = hd_dao.getHoaDonMoiNhat();
            printBill(hdMoiThem.getMaHDBH(), "src\\main\\java\\report\\reportHDBH.jrxml");
        }

        xoaModel(tableSP);
        int n = dstt.size();
        for (int i = 0; i < n; i++) {
            dstt.remove(0);
            dataModelBH.removeRow(0);
        }
        tongTien();
        updateTable();
        xoaTexfKH();
    }

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

    public void xoaTexfKH() {
        tfTenKH.setText("");
        tfSDT.setText("");
        tfDC.setText("");
        tfTienKhach.setText("");
    }

    public boolean ktrTextKH(boolean tt) {
        if (dstt.size() == 0) {
            JOptionPane.showMessageDialog(null, "Xin Chọn Sản Phẩm Cần Mua");
            return false;
        } else if (tfTenKH.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Xin Nhập Tên Khách Hàng");
            return false;
        } else if (tfSDT.getText().length() < 10) {
            JOptionPane.showMessageDialog(null, "Số Điện Thoại Không Hợp Lệ");
            return false;
        } else if (tfDC.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Xin Nhập Địa Chỉ Khách Hàng");
            return false;
        } else if (tt) {
            if (tfTienKhach.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Xin Nhập Tiền Khách Hàng Đưa");
                return false;
            } else if (tientra < 0) {
                JOptionPane.showMessageDialog(null, "Tiền Khách Hàng Đưa Không Đủ");
                return false;
            }
        }
        return true;
    }

    private void btnthanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthanhToanActionPerformed

        if (ktrTextKH(true)) {
            JOptionPane.showMessageDialog(null, "Thanh Toán Thành Công");
            thanhToan(tkh);
        }
    }//GEN-LAST:event_btnthanhToanActionPerformed

    public void datHang(DatHang dh, KhachHang tkh) {
        if (dh == null) {
            if (tkh == null) {
                if (dstt.size() > 0) {
                    List<KhachHang> ls = kh_dao.getAllKH();
                    boolean bl = true;
                    for (KhachHang k : ls) {
                        if (tfSDT.getText().toString().equalsIgnoreCase(k.getsDT())) {
                            JOptionPane.showMessageDialog(null, "Số Điện Thoại Đã Được Đăng Ký");
                            bl = false;
                            break;
                        }
                    }
                    if (bl) {
                        KhachHang kh = new KhachHang(tfTenKH.getText().toString(), tfSDT.getText().toString(), tfDC.getText().toString());
                        NhanVien nv = nv_dao.getNV(Main.tkDN.getNhanVien().getMaNV());
                        kh_dao.themKH(kh);
                        KhachHang khmoi = kh_dao.getKHMoi();
                        Date ngayDH = new Date();
                        DatHang dhnew = new DatHang(nv, khmoi, ngayDH, tongTien);
                        dh_dao.themDH(dhnew);
                        DatHang dhMoiThem = dh_dao.getDHMoiNhat();
                        for (SanPham sp : dstt) {
                            try {
                                ctdh_dao = new CT_DatHang_Dao();
                                CT_DatHang ctdh = new CT_DatHang(sp.getSoLuong(), sp.getDonGia() * sp.getSoLuong(), dhMoiThem, sp);
                                ctdh_dao.themCtdh(ctdh);
                            } catch (Exception e) {
                                return;
                            }
                        }
                        for (SanPham sp : dstt) {
                            SanPham spCu = null;
                            try {
                                spCu = sp_dao.getSPTheoMa(sp.getMaSP());
                            } catch (Exception e) {
                                System.out.println("loi sql");
                                e.printStackTrace();
                            }
                            if (spCu != null) {
                                sp_dao.capNhatSoLuong(spCu.getMaSP(), spCu.getSoLuong() - sp.getSoLuong());
                            }
                        }
                    } else {
                        return;
                    }
                }
            } else if (tkh != null) {
                if (dstt.size() > 0) {
                    NhanVien nv = nv_dao.getNV(Main.tkDN.getNhanVien().getMaNV());
                    Date ngayDH = new Date();
                    DatHang dhnew = new DatHang(nv, tkh, ngayDH, tongTien);
                    dh_dao.themDH(dhnew);
                    DatHang dhMoiThem = dh_dao.getDHMoiNhat();
                    for (SanPham sp : dstt) {
                        try {
                            ctdh_dao = new CT_DatHang_Dao();
                            CT_DatHang ctdh = new CT_DatHang(sp.getSoLuong(), sp.getDonGia() * sp.getSoLuong(), dhMoiThem, sp);
                            ctdh_dao.themCtdh(ctdh);
                        } catch (Exception e) {
                            return;
                        }
                    }
                    for (SanPham sp : dstt) {
                        SanPham spCu = null;
                        try {
                            spCu = sp_dao.getSPTheoMa(sp.getMaSP());
                        } catch (Exception e) {
                            System.out.println("loi sql");
                            e.printStackTrace();
                        }
                        if (spCu != null) {
                            sp_dao.capNhatSoLuong(spCu.getMaSP(), spCu.getSoLuong() - sp.getSoLuong());
                        }
                    }
                }
                tkh = null;
            }
        } else if (dh != null && tkh != null) {
            System.out.println("Sp Củ");
            for (SanPham sp : dstt) {
                try {
                    ctdh_dao = new CT_DatHang_Dao();
                    CT_DatHang ctdh = new CT_DatHang(sp.getSoLuong(), sp.getDonGia() * sp.getSoLuong(), dh, sp);
                    ArrayList<CT_DatHang> ls = ctdh_dao.getCTDHS(dh.getMaDH());
                    boolean flag = false;
                    for (CT_DatHang ct : ls) {
                        flag = false;
                        if (ct.getSanPham().getMaSP().equals(ctdh.getSanPham().getMaSP())) {
                            ctdh_dao.capNhatSoLuongDonGia(ctdh.getSanPham().getMaSP(), (ct.getSoLuong() + ctdh.getSoLuong()), (ct.getSoLuong() + ctdh.getSoLuong()) * sp.getDonGia());
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        ctdh_dao.themCtdh(ctdh);
                    }
                } catch (Exception e) {
                    return;
                }
            }
            for (SanPham sp : dstt) {
                SanPham spCu = null;
                try {
                    spCu = sp_dao.getSPTheoMa(sp.getMaSP());
                } catch (Exception e) {
                    System.out.println("loi sql");
                    e.printStackTrace();
                }
                if (spCu != null) {
                    sp_dao.capNhatSoLuong(spCu.getMaSP(), spCu.getSoLuong() - sp.getSoLuong());
                }
            }
            dh_dao.capNhatTongTien(dh.getMaDH(), dh.getTongTien() + tongTien);
            dh = null;
            tkh = null;
            maDH = null;
            sdtKHDT = null;
        }

        xoaModel(tableSP);
        int n = dstt.size();
        for (int i = 0; i < n; i++) {
            dstt.remove(0);
            dataModelBH.removeRow(0);
        }
        tongTien();
        updateTable();
        xoaTexfKH();
    }

    private void btnDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHangActionPerformed

        DatHang dh = dh_dao.getDH(maDH);
        if (ktrTextKH(false)) {
            if (dh == null) {
                datHang(dh, tkh);
                JOptionPane.showMessageDialog(null, "Đặt Hàng Thành Công");
            } else if (dh != null) {
                KhachHang kh = null;
                try {
                    kh = kh_dao.TimKHTheoSDT(sdtKHDT);
                    datHang(dh, kh);
                    JOptionPane.showMessageDialog(null, "Đặt Thêm hàng Thành Công");
                } catch (SQLException ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnDatHangActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        maDH = null;
        sdtKHDT = null;
        Main.panelTransaction.showForm(new FormBanHang());
    }//GEN-LAST:event_button3ActionPerformed

    public void upImage(String imageName) {
        ImageIcon icon = new ImageIcon("src\\main\\java\\images\\" + imageName);
        Image image = icon.getImage();
        ImageIcon icon1 = new ImageIcon(image.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH));
        lblAnh.setIcon(icon1);
    }

    private void tableSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSPMouseClicked

        int r = tableSP.getSelectedRow();
        var sp_dao = new SanPham_Dao();
        SanPham sp = sp_dao.getSPTheoMa(tableSP.getValueAt(r, 0).toString());
        upImage(sp.getAnh());
    }//GEN-LAST:event_tableSPMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinnerSl;
    private swing.Button btnDatHang;
    private swing.Button btnHuy;
    private swing.Button btnThemSP;
    private swing.Button btnTimKH;
    private swing.Button btnTimSP;
    private swing.Button btnXoa;
    private swing.Button btnthanhToan;
    private swing.Button button3;
    private swing.Combobox cbbDM;
    private swing.Combobox cbbKC;
    private swing.Combobox cbbMS;
    private swing.Combobox cbbNSX;
    private swing.CheckBox chkXuatHD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTra;
    private swing.Table tableDH;
    private swing.Table tableSP;
    public static swing.TextField tfDC;
    public static swing.TextField tfSDT;
    public static swing.TextField tfTenKH;
    private swing.TextField tfTenSP;
    private swing.TextField tfTienKhach;
    private swing.TextField tfTimSDT;
    // End of variables declaration//GEN-END:variables
}
