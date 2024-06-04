/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.CT_HDBanHang;
import entity.HDBanHang;
import entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CT_HDBanHang_Dao {

    public ArrayList<CT_HDBanHang> getAllCTHD() {
        ArrayList<CT_HDBanHang> dsDH = new ArrayList<CT_HDBanHang>();
        String Sql = "select * from CT_HDBanHang";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                CT_HDBanHang ctdh = new CT_HDBanHang();
                ctdh.setSoLuong(rs.getInt("SoLuong"));
                ctdh.setThanhTien(rs.getDouble("ThanhTien"));
                var hd_dao = new HoaDonBH_Dao();
                ctdh.setHoaDonBH(hd_dao.getHD(rs.getString("MaHDBH")));
                var sp_dao = new SanPham_Dao();
                ctdh.setSanPham(sp_dao.getSPTheoMa(rs.getString("MaSP")));
                dsDH.add(ctdh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsDH;
    }

    public boolean themCthd(CT_HDBanHang ct) {
        int n = 0;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into CT_HDBanHang values(? , ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ct.getSoLuong());
            ps.setDouble(2, ct.getThanhTien());
            ps.setString(3, ct.getHoaDonBH().getMaHDBH());
            ps.setString(4, ct.getSanPham().getMaSP());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n > 0;
    }

    public boolean xoa(String maHDBH) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete CT_HDBanHang where MaHDBH = ?");
            stmt.setString(1, maHDBH);
            n = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public ArrayList<CT_HDBanHang> getNgay(String ngay, String thang, String nam) {
        ArrayList<CT_HDBanHang> dsHDBH = new ArrayList<CT_HDBanHang>();

        String txtngay = ngay == null ? "" : ("" + ngay);
        String txtthang = thang == null ? "" : ("" + thang);
        String txtnam = nam == null ? "" : ("" + nam);

        String Sql = " select  top 5 ct.MaSP,sum(ct.SoLuong) as" + "'Tong'" + " from CT_HDBanHang ct join HDBanHang hd on ct.MaHDBH=hd.MaHDBH where Day(hd.NgayLapHDBH) = N'" + txtngay + "' and MONTH(NgayLapHDBH) = N'" + txtthang + "' and YEAR (NgayLapHDBH) = N'" + txtnam + "' Group by ct.MaSP order by sum(ct.SoLuong) desc";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                CT_HDBanHang ct = new CT_HDBanHang();
                var sp_dao = new SanPham_Dao();
                ct.setSanPham(sp_dao.getSPTheoMa(rs.getString("MaSP")));
                ct.setSoLuong(rs.getInt("Tong"));
                dsHDBH.add(ct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;

    }

    public ArrayList<CT_HDBanHang> getThang(String thang, String nam) {
        ArrayList<CT_HDBanHang> dsHDBH = new ArrayList<CT_HDBanHang>();

        String txtthang = thang == null ? "" : ("" + thang);
        String txtnam = nam == null ? "" : ("" + nam);

        String Sql = " select  top 5 ct.MaSP,sum(ct.SoLuong) as" + "'Tong'" + " from CT_HDBanHang ct join HDBanHang hd on ct.MaHDBH=hd.MaHDBH where  MONTH(NgayLapHDBH) = N'" + txtthang + "' and YEAR (NgayLapHDBH) = N'" + txtnam + "' Group by ct.MaSP order by sum(ct.SoLuong) desc";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                CT_HDBanHang ct = new CT_HDBanHang();
                var sp_dao = new SanPham_Dao();
                ct.setSanPham(sp_dao.getSPTheoMa(rs.getString("MaSP")));
                ct.setSoLuong(rs.getInt("Tong"));
                dsHDBH.add(ct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;

    }

    public ArrayList<CT_HDBanHang> getNam(String nam) {
        ArrayList<CT_HDBanHang> dsHDBH = new ArrayList<CT_HDBanHang>();
        String txtnam = nam == null ? "" : ("" + nam);
        String Sql = " select  top 5 MaSP,sum(ct.SoLuong) as" + "'Tong'" + " from CT_HDBanHang ct join HDBanHang hd on ct.MaHDBH=hd.MaHDBH where YEAR (NgayLapHDBH) = N'" + txtnam + "' Group by MaSP order by sum(SoLuong) Desc";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                CT_HDBanHang ct = new CT_HDBanHang();
                var sp_dao = new SanPham_Dao();
                ct.setSanPham(sp_dao.getSPTheoMa(rs.getString("MaSP")));
                ct.setSoLuong(rs.getInt("Tong"));
                dsHDBH.add(ct);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;

    }

    public ArrayList<CT_HDBanHang> getCTSPNam(String masp, String nam) {
        ArrayList<CT_HDBanHang> dsHDBH = new ArrayList<CT_HDBanHang>();
        String txtnam = nam == null ? "" : ("" + nam);
        String Sql = " select  ct.MaSP ,ct.MaHDBH,ct.SoLuong,ct.ThanhTien from CT_HDBanHang ct join HDBanHang hd on ct.MaHDBH=hd.MaHDBH where ct.MaSP='" + masp + "' and Year(hd.NgayLapHDBH)=N'" + txtnam + "'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                CT_HDBanHang ct = new CT_HDBanHang();
                var sp_dao = new SanPham_Dao();
                ct.setSanPham(sp_dao.getSPTheoMa(rs.getString("MaSP")));
                var hd_dao = new HoaDonBH_Dao();
                ct.setHoaDonBH(hd_dao.getHD(rs.getString("MaHDBH")));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setThanhTien(rs.getDouble("ThanhTien"));
                dsHDBH.add(ct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;
    }

    public ArrayList<CT_HDBanHang> getCTSPThang(String masp, String thang, String nam) {
        ArrayList<CT_HDBanHang> dsHDBH = new ArrayList<CT_HDBanHang>();
        String txtthang = thang == null ? "" : ("" + thang);
        String txtnam = nam == null ? "" : ("" + nam);
        String Sql = " select  ct.MaSP ,ct.MaHDBH,ct.SoLuong,ct.ThanhTien from CT_HDBanHang ct join HDBanHang hd on ct.MaHDBH=hd.MaHDBH where ct.MaSP='" + masp + "' and MONTH(hd.NgayLapHDBH) = N'" + txtthang + "'and Year(hd.NgayLapHDBH)=N'" + txtnam + "'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                CT_HDBanHang ct = new CT_HDBanHang();
                var sp_dao = new SanPham_Dao();
                ct.setSanPham(sp_dao.getSPTheoMa(rs.getString("MaSP")));
                var hd_dao = new HoaDonBH_Dao();
                ct.setHoaDonBH(hd_dao.getHD(rs.getString("MaHDBH")));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setThanhTien(rs.getDouble("ThanhTien"));
                dsHDBH.add(ct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;
    }

    public ArrayList<CT_HDBanHang> getCTSPNgay(String masp, String ngay, String thang, String nam) {
        ArrayList<CT_HDBanHang> dsHDBH = new ArrayList<CT_HDBanHang>();
        String txtngay = ngay == null ? "" : ("" + ngay);
        String txtthang = thang == null ? "" : ("" + thang);
        String txtnam = nam == null ? "" : ("" + nam);
        String Sql = " select  ct.MaSP ,ct.MaHDBH,ct.SoLuong,ct.ThanhTien from CT_HDBanHang ct join HDBanHang hd on ct.MaHDBH=hd.MaHDBH where ct.MaSP='" + masp + "' and DAY(hd.NgayLapHDBH) = N'" + txtngay + "'and MONTH(hd.NgayLapHDBH) = N'" + txtthang + "'and Year(hd.NgayLapHDBH)=N'" + txtnam + "'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                CT_HDBanHang ct = new CT_HDBanHang();
                var sp_dao = new SanPham_Dao();
                ct.setSanPham(sp_dao.getSPTheoMa(rs.getString("MaSP")));
                var hd_dao = new HoaDonBH_Dao();
                ct.setHoaDonBH(hd_dao.getHD(rs.getString("MaHDBH")));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setThanhTien(rs.getDouble("ThanhTien"));
                dsHDBH.add(ct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;
    }

}
