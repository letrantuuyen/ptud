package form;

import connect.Connect;
import dao.ChatLieu_Dao;
import dao.DanhMuc_Dao;
import dao.KichCo_Dao;
import dao.MauSac_Dao;
import dao.NCC_Dao;
import dao.NhaSX_Dao;
import dao.NhanVien_Dao;
import dao.SanPham_Dao;
import entity.CaLam;
import entity.ChatLieu;
import entity.ChucVu;
import entity.DanhMucSP;
import entity.KhachHang;
import entity.KichCo;
import entity.MauSac;
import entity.NhaCungCap;
import entity.NhaSX;
import entity.NhanVien;
import entity.SanPham;
import static form.FormKhachHang.ma;
import static gui.Main.panelTransaction;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormSanPham extends javax.swing.JPanel implements ActionListener, MouseListener {

    public FormSanPham() {
        try {
            Connect.getInstance().connect();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        initComponents();
        table.fixTable(jScrollPane1);
        ListSP = new ArrayList<SanPham>();
        table.addMouseListener(this);
        sp_dao = new SanPham_Dao();
        nsx_dao = new NhaSX_Dao();
        ms_dao = new MauSac_Dao();
        kc_dao = new KichCo_Dao();
        ncc_dao = new NCC_Dao();
        dm_dao = new DanhMuc_Dao();
        clieu_dao = new ChatLieu_Dao();
        list = sp_dao.getAllSP();
        updateTable();
        upcomBoBox();
        if (ma != null) {
            upTableTim();
            ma = null;
        }
    }
    private DefaultTableModel dataModel;
    private SanPham_Dao sp_dao;
    String imageName = null;
    private ArrayList<SanPham> ListSP;
    private DanhMuc_Dao dm_dao;
    private NhaSX_Dao nsx_dao;
    private MauSac_Dao ms_dao;
    private KichCo_Dao kc_dao;
    private NCC_Dao ncc_dao;
    private ChatLieu_Dao clieu_dao;
    DecimalFormat df = new DecimalFormat("#,##0 VND");
    ArrayList<SanPham> list = new ArrayList<>();
      public static String ma = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTen = new swing.TextField();
        txtDonGia = new swing.TextField();
        txtSL = new swing.TextField();
        btnThem = new swing.Button();
        button2 = new swing.Button();
        btnSua = new swing.Button();
        btnTim = new swing.Button();
        cbboxNSX = new swing.Combobox();
        lblAnh = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbboxCL = new swing.Combobox();
        cbboxMS = new swing.Combobox();
        cbboxDM = new swing.Combobox();
        jLabel21 = new javax.swing.JLabel();
        cbboxKC = new swing.Combobox();
        cbboxNCC = new swing.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.Table();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), null), "Quần Áo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTen.setHintText("Áo,Quần,Váy");

        txtDonGia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDonGia.setHintText("15000.00");

        txtSL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSL.setHintText("99");

        btnThem.setText("Thêm Quần Áo:");
        btnThem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        button2.setText("Xóa Quần Áo");
        button2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa Quần Áo");
        btnSua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loupe.png"))); // NOI18N
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        lblAnh.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anh1.PNG"))); // NOI18N
        lblAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Tìm Quần Áo:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Ảnh");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Tên Quần Áo:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Đơn Gía:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Danh Mục:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Màu sắc:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Chất Liệu:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Kích Cỡ:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Số Lượng:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Nhà Sản Xuất:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Nhà Cung Cấp:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbboxDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbboxCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(cbboxMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbboxNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbboxKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbboxNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(152, 152, 152))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbboxDM, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbboxNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbboxCL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbboxKC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbboxMS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbboxNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Quần Áo", "Tên Quàn Áo", "Danh Mục", "Đơn Giá", "Số Lượng", "Chất Liệu", "Màu sắc", "Kích Cỡ", "Nhà Sản Xuất", "Nhà Cung Cấp"
            }
        ));
        table.setShowGrid(true);
        table.setShowVerticalLines(false);
        jScrollPane1.setViewportView(table);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("THÔNG TIN QUẦN ÁO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    public void upcomBoBox() {
        ArrayList<DanhMucSP> dsDM = dm_dao.getAllDM();
        ArrayList<NhaSX> dsNSX = nsx_dao.getAllNSX();
        ArrayList<MauSac> dsMS = ms_dao.getAllMS();
        ArrayList<KichCo> dsKC = kc_dao.getAllKC();
        ArrayList<ChatLieu> dsclieu = clieu_dao.getAllCL();
        ArrayList<NhaCungCap> dsNCC = ncc_dao.getAllNCC();
        for (DanhMucSP dm : dsDM) {
            cbboxDM.addItem(dm.getTenDanhMuc());
        }
        for (NhaSX nsx : dsNSX) {
            cbboxNSX.addItem(nsx.getTenNSX());
        }
        for (MauSac ms : dsMS) {
            cbboxMS.addItem(ms.getTenMS());
        }
        for (KichCo kc : dsKC) {
            cbboxKC.addItem(kc.getTenKC());
        }
        for (ChatLieu cl : dsclieu) {
            cbboxCL.addItem(cl.getTenCL());
        }
        for (NhaCungCap ncc : dsNCC) {
            cbboxNCC.addItem(ncc.getTenNCC());
        }
    }

    public void upTableTim() {
        SanPham sp = sp_dao.getSPTheoMa(ma);
        xoaModel(table);

        dataModel.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getDanhMuc().getTenDanhMuc(), df.format(sp.getDonGia()), sp.getSoLuong(), sp.getChatLieu().getTenCL(), sp.getMauSac().getTenMS(), sp.getKichCo().getTenKC(), sp.getnSX().getTenNSX(), sp.getNcc().getTenNCC(), sp.getAnh()});

    }
    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        JFileChooser file = new JFileChooser("src\\main\\java\\images\\");
        int kq = file.showOpenDialog(file);
        if (kq == JFileChooser.APPROVE_OPTION) {
            imageName = file.getSelectedFile().getName();
            upImage(imageName);

        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn ảnh...");
        }

    }//GEN-LAST:event_lblAnhMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        try {
            SanPham sp= null;
           if(validData(sp)){
            sp = reverSPFromTextFile();
            if (sp_dao.them(sp)) {
                xoaModel(table);
                updateTable();
                JOptionPane.showMessageDialog(null, "Thêm Sản Phẩm Thành Công");
            }
        }} catch (ParseException ex) {
            Logger.getLogger(FormSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        int r = table.getSelectedRow();
        if (r >= 0) {
            String ma = (String) table.getValueAt(r, 0);

            int click = JOptionPane.showConfirmDialog(null, "Bạn có chắc xóa sản phẩm ", "Thông Báo", 2);
            if (click == JOptionPane.OK_OPTION) {
                // else if (validData()) {
                if (sp_dao.xoa(ma)) {

                    JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công");
                }
                dataModel.removeRow(r);
                // xoaRongTextfields();
            } else {
                if (click == JOptionPane.CANCEL_OPTION) {
                    this.setVisible(true);
                }
            }

        }
    }//GEN-LAST:event_button2ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int r = table.getSelectedRow();
        if (r >= 0) {
            String ma = (String) table.getValueAt(r, 0);
            DanhMucSP dm = dm_dao.getDanhMucTenDM(cbboxDM.getSelectedItem().toString());
            String ten = txtTen.getText().toString();
            MauSac ms = ms_dao.getMauSacTenMau(cbboxMS.getSelectedItem().toString());
            ChatLieu clieu = clieu_dao.getChatLieuTheoTen(cbboxCL.getSelectedItem().toString());
            NhaSX nsx = nsx_dao.getNhaSXTenNSX(cbboxNSX.getSelectedItem().toString());
            KichCo kc = kc_dao.getKichCoTenKC(cbboxKC.getSelectedItem().toString());
            NhaCungCap ncc = ncc_dao.getNCCTheoTen(cbboxNCC.getSelectedItem().toString());
            int sl = Integer.parseInt(txtSL.getText());
            double dg = Double.parseDouble(txtDonGia.getText().toString());
            String anh = imageName.toString();
            SanPham sp = new SanPham(ma, dm, ten, ms, clieu, nsx, kc, sl, dg, ncc, anh);
            int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa", "Thông Báo", 2);
            if (click == JOptionPane.OK_OPTION) {
                // if (validData()) {
                if (sp_dao.sua(sp)) {
                    table.setValueAt(txtTen.getText(), r, 1);
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                    //xoaRongTextfields();
                    xoaModel(table);
                    updateTable();

                } else {
                    if (click == JOptionPane.CANCEL_OPTION) {
                        this.setVisible(true);
                    }

                }

            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        panelTransaction.showForm(new FormTKSP());
    }//GEN-LAST:event_btnTimActionPerformed
    public void upImage(String imageName) {
        ImageIcon icon = new ImageIcon("src\\main\\java\\images\\" + imageName);
        Image image = icon.getImage();
        ImageIcon icon1 = new ImageIcon(image.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH));
        lblAnh.setIcon(icon1);
    }
private boolean validData(SanPham kh) {
        String ten = txtTen.getText().trim();
        String sl = txtSL.getText().trim();
        String dg = txtDonGia.getText().trim();
        if (!(ten.length() > 0)) {
            JOptionPane.showInternalMessageDialog(null, "Tên Sản Phẩm Không Được Rỗng");
            return false;
        }
      if (!(sl.length() > 0 && sl.matches("[0-9]+"))) {
            JOptionPane.showInternalMessageDialog(null, "Số Lượng Sản Phẩm Không Được Rỗng Và Là Số ");
            return false;
        }
         if (!(dg.length() > 0 && dg.matches("[0-9]+"))) {
            JOptionPane.showInternalMessageDialog(null, "Đơn Gía Sản Phẩm Không Được Rỗng Và Là Số");
            return false;
        }
        
        return true;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnSua;
    private swing.Button btnThem;
    private swing.Button btnTim;
    private swing.Button button2;
    private swing.Combobox cbboxCL;
    private swing.Combobox cbboxDM;
    private swing.Combobox cbboxKC;
    private swing.Combobox cbboxMS;
    private swing.Combobox cbboxNCC;
    private swing.Combobox cbboxNSX;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnh;
    private swing.Table table;
    private swing.TextField txtDonGia;
    private swing.TextField txtSL;
    private swing.TextField txtTen;
    // End of variables declaration//GEN-END:variables
 private void updateTable() {
        ListSP = sp_dao.getAllSP();
        dataModel = (DefaultTableModel) table.getModel();
        for (SanPham sp : ListSP) {

            dataModel.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getDanhMuc().getTenDanhMuc(), df.format(sp.getDonGia()), sp.getSoLuong(), sp.getChatLieu().getTenCL(), sp.getMauSac().getTenMS(), sp.getKichCo().getTenKC(), sp.getnSX().getTenNSX(), sp.getNcc().getTenNCC(), sp.getAnh()});
        }
    }

    public void xoaModel(JTable table) {
        DefaultTableModel del = (DefaultTableModel) table.getModel();
        del.getDataVector().removeAllElements();
    }

    public SanPham reverSPFromTextFile() throws ParseException, SQLException {
        DanhMucSP dm = dm_dao.getDanhMucTenDM(cbboxDM.getSelectedItem().toString());
        String ten = txtTen.getText().toString();
        MauSac ms = ms_dao.getMauSacTenMau(cbboxMS.getSelectedItem().toString());
        ChatLieu clieu = clieu_dao.getChatLieuTheoTen(cbboxCL.getSelectedItem().toString());
        NhaSX nsx = nsx_dao.getNhaSXTenNSX(cbboxNSX.getSelectedItem().toString());
        KichCo kc = kc_dao.getKichCoTenKC(cbboxKC.getSelectedItem().toString());
        NhaCungCap ncc = ncc_dao.getNCCTheoTen(cbboxNCC.getSelectedItem().toString());
        int sl = Integer.parseInt(txtSL.getText());
        double dg = Double.parseDouble(txtDonGia.getText().toString());
        String anh = imageName.toString();
        return new SanPham(dm, ten, ms, clieu, nsx, kc, sl, dg, ncc, anh);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int r = table.getSelectedRow();
        cbboxDM.setSelectedItem(table.getValueAt(r, 2).toString());
        txtTen.setText(table.getValueAt(r, 1).toString());
        cbboxMS.setSelectedItem(table.getValueAt(r, 6).toString());
        cbboxCL.setSelectedItem(table.getValueAt(r, 5).toString());
        cbboxNSX.setSelectedItem(table.getValueAt(r, 8).toString());
        cbboxKC.setSelectedItem(table.getValueAt(r, 7).toString());
        txtSL.setText(table.getValueAt(r, 4).toString());
        txtDonGia.setText(table.getValueAt(r, 3).toString());
        cbboxNCC.setSelectedItem(table.getValueAt(r, 9).toString());
        var sp_dao = new SanPham_Dao();
        SanPham sp = sp_dao.getSPTheoMa(table.getValueAt(r, 0).toString());
        imageName = sp.getAnh();
        upImage(sp.getAnh());

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

}
