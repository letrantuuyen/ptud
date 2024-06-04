/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.NhanVien_Dao;
import entity.NhanVien;
import entity.TaiKhoan;
import form.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JFrame;
import swing.MenuItem;
import swing.ScrollBarCustom;


public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private NhanVien_Dao nv_dao;
    public static TaiKhoan tkDN;

    public Main() {
        nv_dao = new NhanVien_Dao();
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        execute();
        jScrollPane.setVerticalScrollBar(new ScrollBarCustom());
        panelTransaction.showForm(new FormThongKe());
        setLogin();
    }

    public  void setLogin() {
        lblCV.setText(tkDN.getNhanVien().getChucVu().getTenCV());
        lblName.setText(tkDN.getNhanVien().getTenNV());
    }

    public void execute() {
        ImageIcon iconNV = new ImageIcon(getClass().getResource("/icon/cleaning-staff.png"));
        ImageIcon iconKH = new ImageIcon(getClass().getResource("/icon/customer.png"));
        ImageIcon iconSP = new ImageIcon(getClass().getResource("/icon/new-product.png"));
        ImageIcon iconNCC = new ImageIcon(getClass().getResource("/icon/supplier.png"));
        ImageIcon iconHD = new ImageIcon(getClass().getResource("/icon/budget.png"));
        ImageIcon iconTK = new ImageIcon(getClass().getResource("/icon/trend.png"));
        ImageIcon iconSubMenu = new ImageIcon(getClass().getResource("/icon/subMenu.png"));

        MenuItem menuBH = new MenuItem(iconSubMenu, "Bán Hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormBanHang());
            }

        });
        MenuItem menuCNNV = new MenuItem(iconSubMenu, "Cập Nhật", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormNhanVien());
            }
        });
        MenuItem menuTKNV = new MenuItem(iconSubMenu, "Tìm Kiếm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormTKNV());
            }

        });
        MenuItem menuCV = new MenuItem(iconSubMenu, "Chức Vụ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormChucVu());
            }

        });
        MenuItem menuCL1 = new MenuItem(iconSubMenu, "Ca Làm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormCaLam());
            }

        });
        MenuItem memuDH = new MenuItem(iconSubMenu, "Đặt Hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormDatHang());
            }
        });
        MenuItem menuCNKH = new MenuItem(iconSubMenu, "Cập Nhật", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormKhachHang());
            }
        });
        MenuItem menuTKKH = new MenuItem(iconSubMenu, "Tìm Kiếm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormTKKH());
            }
        });

        MenuItem menuCNSP = new MenuItem(iconSubMenu, "Cập Nhật", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormSanPham());
            }
        });
        MenuItem menuTKSP = new MenuItem(iconSubMenu, "Tìm Kiếm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormTKSP());
            }
        });
        MenuItem menuNSX = new MenuItem(iconSubMenu, "Nhà Sản Xuất", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormNhaSX());
            }
        });
        MenuItem menuMS = new MenuItem(iconSubMenu, "Màu Sắc", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormMau());
            }
        });
        MenuItem menuCL = new MenuItem(iconSubMenu, "Chất Liệu", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormChatLieu());
            }
        });
        MenuItem menuKC = new MenuItem(iconSubMenu, "Kích Cỡ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormSize());
            }
        });
        MenuItem menuDM = new MenuItem(iconSubMenu, "Danh Mục", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormDanhMuc());
            }
        });

        MenuItem menuCNNCC = new MenuItem(iconSubMenu, "Cập Nhật", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    panelTransaction.showForm(new FormNCC());
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        MenuItem menuTKNCC = new MenuItem(iconSubMenu, "Tìm Kiếm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormTKNCC());
            }
        });

        MenuItem menuHDBN = new MenuItem(iconSubMenu, "Bán Hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormHDBH());
            }
        });

        MenuItem menuTKDT = new MenuItem(iconSubMenu, "Doanh Thu", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormThongKeDT());
            }
        });
        MenuItem menuTKSPBC = new MenuItem(iconSubMenu, "Quần Áo", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormTKSPBC());
            }
        });
        MenuItem menuKHBC = new MenuItem(iconSubMenu, "Khách Hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTransaction.showForm(new FormThongKeKH());
            }
        });

        MenuItem menuNV = null;
        if (tkDN.getQuyen().equals("QL")) {
            menuNV = new MenuItem(iconNV, "Nhân Viên", null, menuBH, menuCNNV, menuCV, menuCL1, menuTKNV);
        }else if(tkDN.getQuyen().equals("NV")){
            menuNV = new MenuItem(iconNV, "Nhân Viên", null, menuBH);
        }
        MenuItem menuKH = new MenuItem(iconKH, "Khách Hàng", null, memuDH, menuCNKH, menuTKKH);
        MenuItem menuSP = new MenuItem(iconSP, "Quần Áo", null, menuCNSP, menuNSX, menuMS, menuCL, menuKC, menuDM, menuTKSP);
        MenuItem menuNCC = new MenuItem(iconNCC, "Nhà Cung Cấp", null, menuCNNCC, menuTKNCC);
        MenuItem menuHD = new MenuItem(iconHD, "Hóa Đơn", null, menuHDBN);
        MenuItem menuTK = new MenuItem(iconTK, "Thống Kê", null, menuTKDT, menuTKSPBC, menuKHBC);
        addMenu(menuNV, menuKH, menuSP, menuNCC, menuHD, menuTK);
    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        lblCV = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panelTransaction = new transaction.PanelTransaction();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(115, 120, 230));
        panelMenu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        panelMenu.setPreferredSize(new java.awt.Dimension(213, 384));

        panelMoving.setOpaque(false);

        jLabel1.setSize(200,130);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo_login.png"));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(imgScale);
        jLabel1.setIcon(scaleIcon);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane.setBorder(null);

        menus.setBackground(new java.awt.Color(115, 120, 230));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane.setViewportView(menus);

        lblCV.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        lblCV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnLogout.setBackground(new java.awt.Color(255, 102, 102));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(18, 18, 18))
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblCV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout)
                .addGap(109, 109, 109))
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1517, 859));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        panelTransaction.showForm(new FormThongKe());
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblCV;
    private javax.swing.JLabel lblName;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMoving;
    public static transaction.PanelTransaction panelTransaction;
    // End of variables declaration//GEN-END:variables

}
