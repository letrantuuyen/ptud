/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.*;
import java.util.Calendar;


public class DatHang_Dao {

    public ArrayList<DatHang> getAllDH() {
        ArrayList<DatHang> dsDH = new ArrayList<DatHang>();
        String Sql = "select * from DatHang";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                DatHang dh = new DatHang();
                dh.setMaDH(rs.getString("MaDH"));
                var nv_dao = new NhanVien_Dao();
                dh.setNhanVien(nv_dao.getNV(rs.getString("MaNV")));
                var kh_dao = new KhachHang_Dao();
                dh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                dh.setNgayDH(rs.getDate("NgayDH"));
                dh.setTongTien(rs.getDouble("TongTien"));
                dsDH.add(dh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsDH;
    }

    public boolean themDH(DatHang dh) {
        int n = 0;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into DatHang(MaNV, MaKH, NgayDH, TongTien) values(?, ?, ?, ?)";

            ps = con.prepareStatement(sql);
            Timestamp timestamp = new Timestamp(dh.getNgayDH().getTime());
            ps.setString(1, dh.getNhanVien().getMaNV());
            ps.setString(2, dh.getKhachHang().getMaKH());
            ps.setTimestamp(3, timestamp);
            ps.setDouble(4, dh.getTongTien());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n > 0;
    }

    public DatHang getDHMoiNhat() {
        DatHang dh = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        Statement stmt = null;
        try {
            String sql = "select top 1 * from DatHang order by MaDH DESC";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NhanVien_Dao nv_dao = new NhanVien_Dao();
                NhanVien nv = nv_dao.getNV(rs.getString("MaNV"));
                KhachHang_Dao kh_dao = new KhachHang_Dao();
                KhachHang kh = kh_dao.getKH(rs.getString("MaKH"));
                dh = new DatHang(rs.getString("MaDH"), nv, kh, rs.getDate("NgayDH"), rs.getDouble("TongTien"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dh;
    }

    public DatHang getDH(String ma) {
        DatHang dh = null;
        PreparedStatement pstmt = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        try {
            String sql = "select * from DatHang where MaDH = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ma);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                dh = new DatHang();
                dh.setMaDH(rs.getString("MaDH"));
                var nv_dao = new NhanVien_Dao();
                dh.setNhanVien(nv_dao.getNV(rs.getString("MaNV")));
                var kh_dao = new KhachHang_Dao();
                dh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                dh.setNgayDH(rs.getDate("NgayDH"));
                dh.setTongTien(rs.getDouble("TongTien"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dh;
    }

    public ArrayList<DatHang> getDHMaKH(String ma) {
        ArrayList<DatHang> ls = new ArrayList<DatHang>();
        PreparedStatement pstmt = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        try {
            String sql = "select * from DatHang where MaKH = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ma);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DatHang dh = new DatHang();
                dh.setMaDH(rs.getString("MaDH"));
                var nv_dao = new NhanVien_Dao();
                dh.setNhanVien(nv_dao.getNV(rs.getString("MaNV")));
                var kh_dao = new KhachHang_Dao();
                dh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                dh.setNgayDH(rs.getDate("NgayDH"));
                dh.setTongTien(rs.getDouble("TongTien"));
                ls.add(dh);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ls;

    }

    public boolean capNhatTongTien(String maDH, Double tongTien) {
        int n = -1;
        String sql = "update DatHang  set TongTien = ? where MaDH = ?";
        Connect.getInstance();
        Connection con = Connect.getConnection();
        try {
            PreparedStatement pstmt = con.prepareCall(sql);
            pstmt.setDouble(1, tongTien);
            pstmt.setString(2, maDH);
            n = pstmt.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean xoa(String maDH) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete DatHang where MaDH = ?");
            stmt.setString(1, maDH);
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
}
