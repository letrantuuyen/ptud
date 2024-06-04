package form;

import connect.Connect;
import dao.DanhMuc_Dao;
import dao.KichCo_Dao;
import dao.MauSac_Dao;
import dao.NhaSX_Dao;
import dao.SanPham_Dao;
import entity.DanhMucSP;
import entity.KichCo;
import entity.MauSac;
import entity.NhaSX;
import entity.SanPham;
import static gui.Main.panelTransaction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormTKSP extends javax.swing.JPanel implements ActionListener, MouseListener {

    public FormTKSP() {
        try {
            Connect.getInstance().connect();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        initComponents();
        table.fixTable(jScrollPane1);
        ListSP = new ArrayList<SanPham>();
        nsx_dao = new NhaSX_Dao();
        ms_dao = new MauSac_Dao();
        kc_dao = new KichCo_Dao();
        dm_dao = new DanhMuc_Dao();
        sp_dao = new SanPham_Dao();
        upcomBoBox();
        updateTable();
    }
    private NhaSX_Dao nsx_dao;
    private MauSac_Dao ms_dao;
    private KichCo_Dao kc_dao;
    private DanhMuc_Dao dm_dao;
    private ArrayList<SanPham> ListSP;
    private ArrayList<SanPham> ListTimSP;
    private SanPham_Dao sp_dao;
    private DefaultTableModel dataModelSP;
    DecimalFormat df = new DecimalFormat("#,##0 VND");

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.Table();
        jLabel16 = new javax.swing.JLabel();
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
        jLabel12 = new javax.swing.JLabel();
        btnCapNhat = new swing.Button();

        setBackground(new java.awt.Color(204, 204, 255));
        setToolTipText("");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Quần Áo", "Tên Quần Áo", "Danh Mục", "Đơn Giá", "Số Luọng", "Chất Liệu", "Màu sắc", "Kích Cỡ", "Nhà Sản Xuất", "Nhà Cung Cấp"
            }
        ));
        table.setShowGrid(true);
        table.setShowVerticalLines(false);
        jScrollPane1.setViewportView(table);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("TÌM KIẾM QUẦN ÁO");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), null), "Tìm Kiếm ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfTenSP.setHintText("Tên quần áo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Danh Mục: ");

        cbbDM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả" }));

        btnTimSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loupe.png"))); // NOI18N
        btnTimSP.setText("Tìm Kiếm");
        btnTimSP.setColor2(new java.awt.Color(0, 102, 204));
        btnTimSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Kích Cở:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Tên:");

        btnCapNhat.setText("Cập Nhật Quần Áo");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbbMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(cbbKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbbDM, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(cbbKC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 260, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimSPActionPerformed
        // TODO add your handling code here:
        xoaModel(table);
        ListTimSP = new ArrayList<SanPham>();
        ListTimSP = sp_dao.timSPNC(tfTenSP.getText().toString(), cbbDM.getSelectedItem().toString().trim(), cbbNSX.getSelectedItem().toString().trim(), cbbMS.getSelectedItem().toString().trim(), cbbKC.getSelectedItem().toString().trim());
        if (ListTimSP.size() > 0) {
            for (SanPham sp : ListTimSP) {
                dataModelSP.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getDanhMuc().getTenDanhMuc(), df.format(sp.getDonGia()), sp.getSoLuong(), sp.getChatLieu().getTenCL(), sp.getMauSac().getTenMS(), sp.getKichCo().getTenKC(), sp.getnSX().getTenNSX(), sp.getNcc().getTenNCC()});
            }
        } else {

            JOptionPane.showMessageDialog(null, "Không Có Sản Phẩm Nào Phù Hợp");
            updateTable();
            //            ListTimSP = ListSP;
        }
    }//GEN-LAST:event_btnTimSPActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int r = table.getSelectedRow();
        if (r != -1) {
            FormSanPham.ma = table.getValueAt(r, 0).toString();
            panelTransaction.showForm(new FormSanPham());
        } else {
            JOptionPane.showMessageDialog(null, "Xin Chọn Quần Áo Trước Khi Cập Nhập ");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed
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
        dataModelSP = (DefaultTableModel) table.getModel();
        for (SanPham sp : ListSP) {

            dataModelSP.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getDanhMuc().getTenDanhMuc(), df.format(sp.getDonGia()), sp.getSoLuong(), sp.getChatLieu().getTenCL(), sp.getMauSac().getTenMS(), sp.getKichCo().getTenKC(), sp.getnSX().getTenNSX(), sp.getNcc().getTenNCC()});
        }
    }

    public void xoaModel(JTable table) {
        DefaultTableModel del = (DefaultTableModel) table.getModel();
        del.getDataVector().removeAllElements();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnCapNhat;
    private swing.Button btnTimSP;
    private swing.Combobox cbbDM;
    private swing.Combobox cbbKC;
    private swing.Combobox cbbMS;
    private swing.Combobox cbbNSX;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.Table table;
    private swing.TextField tfTenSP;
    // End of variables declaration//GEN-END:variables

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		 int r = table.getSelectedRow();
	        cbbDM.setSelectedItem(table.getValueAt(r, 2).toString());
	        tfTenSP.setText(table.getValueAt(r, 1).toString());
	        cbbMS.setSelectedItem(table.getValueAt(r, 6).toString());
	        cbbNSX.setSelectedItem(table.getValueAt(r, 8).toString());
	        cbbKC.setSelectedItem(table.getValueAt(r, 7).toString());
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
