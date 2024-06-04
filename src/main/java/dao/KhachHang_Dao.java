/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KhachHang_Dao {

    public ArrayList<KhachHang> getAllKH() {
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            String Sql = "select * from KhachHang";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("SDT"),
                        rs.getString("DiaChi"));
                dskh.add(kh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dskh;
    }

    public boolean xoa(String maKH) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete from KhachHang where MaKH = ?");
            stmt.setString(1, maKH);
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

    public boolean sua(KhachHang kh) {
        Connect.getInstance();
        Connection con = Connect.getConnection();

        int n = 0;
        try {
            String sql = "update KhachHang set TenKH=?, SDT=?, DiaChi=? where MaKH=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getsDT());
            ps.setString(3, kh.getDiaChi());
            ps.setString(4, kh.getMaKH());
            n = ps.executeUpdate();
            if (n > 0) {
                return true;
            }
            con.close();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return false;
    }

    public KhachHang TimKHTheoSDT(String sDT) throws SQLException {
        KhachHang kh = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();

        try {
            String sql = "select * from KhachHang where SDT = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString(1);
                String tenKH = rs.getString(2);
                String sdt = rs.getString(3);
                String diaChi = rs.getString(4);
                kh = new KhachHang(maKH, tenKH, sdt, diaChi);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return kh;
    }

    public boolean themKH(KhachHang kh) {
        int n = 0;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into KhachHang(TenKH, SDT, DiaChi) values(?, ?, ?)";

            ps = con.prepareStatement(sql);
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getsDT());
            ps.setString(3, kh.getDiaChi());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n > 0;
    }

    public KhachHang getKH(String maKH) {
        KhachHang kh = null;
        PreparedStatement pstmt = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        try {
            String sql = "select * from KhachHang where MaKH = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maKH);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                kh = new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("SDT"), rs.getString("DiaChi"));

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return kh;
    }

    public KhachHang getKHMoi() {
        KhachHang kh = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        Statement pstmt = null;
        try {
            String sql = "select top 1 * from KhachHang order by MaKH DESC";
            pstmt = con.createStatement();

            ResultSet rs = pstmt.executeQuery(sql);
            while (rs.next()) {
                kh = new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("DiaChi"), rs.getString("SDT"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return kh;
    }

    public ArrayList<KhachHang> traCuuKH(String tenKH, String sdt) {
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        String txtten = tenKH == null ? "" : ("" + tenKH);
        String txtsdt = sdt == null ? "" : ("" + sdt);
        System.out.println(txtten);
        String sql = "select *from KhachHang where TenKH like N'%" + txtten + "%' and SDT like N'%" + txtsdt + "%'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setsDT(rs.getString("SDT"));
                dsKH.add(kh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsKH;

    }
}
