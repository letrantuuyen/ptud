
package form;

import connect.Connect;
import entity.TaiKhoan;
import static form.FormTKSPBC.RbtnNamSP;
import static form.FormTKSPBC.RbtnNgaySP;
import static form.FormTKSPBC.RbtnThangSP;
import static form.FormTKSPBC.cbbNamSP;
import static form.FormTKSPBC.cbbNgaySP;
import static form.FormTKSPBC.cbbThangSP;
import gui.Main;
import java.sql.Connection;
import java.util.Hashtable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class FromCTSPBC extends javax.swing.JFrame {

    /**
     * Creates new form FromCTSPBC
     */
    public static String maSP;

    public FromCTSPBC() {
        initComponents();
    }
    public static DefaultTableModel dataModelBC;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tableSPBC = new swing.Table();
        jLabel2 = new javax.swing.JLabel();
        btnIn = new swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi Tiết");
        setBackground(new java.awt.Color(204, 0, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tableSPBC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Quần Áo", "Mã Hóa Đơn Bán Hàng", "Số Lượn Bán", "Thành Tiền"
            }
        ));
        tableSPBC.setShowGrid(true);
        tableSPBC.setShowVerticalLines(false);
        jScrollPane.setViewportView(tableSPBC);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CHI TIẾT QUẦN ÁO  ĐÃ BÁN");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    .addComponent(jScrollPane))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  public void printBillNam(String data, String data1, TaiKhoan tk, String source) {
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport(source);
            map.put("txtNam", data);
            map.put("maSP", data1);
            map.put("ma", tk.getNhanVien().getMaNV().toString());
            map.put("ten", tk.getNhanVien().getTenNV().toString());
            map.put("cv", tk.getNhanVien().getChucVu().getTenCV().toString());
            JasperPrint p = JasperFillManager.fillReport(report, map, con);
            JasperViewer.viewReport(p, false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void printBillThang(String data, String data1, String data2, TaiKhoan tk, String source) {
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Hashtable map = new Hashtable();
            JasperReport report;
            report = JasperCompileManager.compileReport(source);
            map.put("txtThang", data);
            map.put("txtNam", data1);
            map.put("maSP", data2);
            map.put("ma", tk.getNhanVien().getMaNV().toString());
            map.put("ten", tk.getNhanVien().getTenNV().toString());
            map.put("cv", tk.getNhanVien().getChucVu().getTenCV().toString());
            JasperPrint p = JasperFillManager.fillReport(report, map, con);
            JasperViewer.viewReport(p, false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void printBillNgay(String data, String data1, String data2, String data3, TaiKhoan tk, String source) {
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Hashtable map = new Hashtable();
            JasperReport report;
            report = JasperCompileManager.compileReport(source);
            map.put("maSP", data3);
            map.put("txtNam", data);
            map.put("txtNgay", data2);
            map.put("txtThang", data1);
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
        String ngay = cbbNgaySP.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbNgaySP.getSelectedItem().toString().trim();
        String nam = cbbNamSP.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbNamSP.getSelectedItem().toString().trim();
        String thang = cbbThangSP.getSelectedItem().toString().trim().equalsIgnoreCase("Tất Cả") ? "" : cbbThangSP.getSelectedItem().toString().trim();
        System.out.println(maSP);
        if (RbtnNgaySP.isSelected()) {
            printBillNgay(nam, thang, ngay, maSP,Main.tkDN, "src\\main\\java\\report\\reportCTQANgay.jrxml");
            
        } else if (RbtnThangSP.isSelected()) {
            printBillThang(thang, nam, maSP,Main.tkDN, "src\\main\\java\\report\\reportCTQAThang.jrxml");
        } else if (RbtnNamSP.isSelected()) {
            printBillNam(nam, maSP,Main.tkDN, "src\\main\\java\\report\\reportCTQANam.jrxml");
        }

    }//GEN-LAST:event_btnInActionPerformed

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
            java.util.logging.Logger.getLogger(FromCTSPBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromCTSPBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromCTSPBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromCTSPBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromCTSPBC().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnIn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    protected static swing.Table tableSPBC;
    // End of variables declaration//GEN-END:variables
}