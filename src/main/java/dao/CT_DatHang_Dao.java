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
import java.util.ArrayList;


public class CT_DatHang_Dao {

    public ArrayList<CT_DatHang> getAllCTDH() {
        ArrayList<CT_DatHang> dsCTDH = new ArrayList<CT_DatHang>();
        String Sql = "select * from CT_DatHang";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                CT_DatHang ctdh = new CT_DatHang();
                ctdh.setSoLuong(rs.getInt("SoLuong"));
                ctdh.setThanhTien(rs.getDouble("ThanhTien"));
                var dh_dao = new DatHang_Dao();
                ctdh.setDatHang(dh_dao.getDH(rs.getString("MaDH")));
                var sp_dao = new SanPham_Dao();
                ctdh.setSanPham(sp_dao.getSPTheoMa(rs.getString("MaSP")));
                dsCTDH.add(ctdh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCTDH;
    }

    public boolean themCtdh(CT_DatHang ct) {
        int n = 0;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into CT_DatHang values(?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ct.getSoLuong());
            ps.setDouble(2, ct.getThanhTien());
            ps.setString(3, ct.getDatHang().getMaDH());
            ps.setString(4, ct.getSanPham().getMaSP());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n > 0;
    }

    public boolean capNhatSoLuongDonGia(String maSP, int soLuong, Double thanhTien) {
        int n = -1;
        String sql = "update CT_DatHang  set SoLuong = ?, ThanhTien = ? where MaSP = ?";
        Connect.getInstance();
        Connection con = Connect.getConnection();
        try {
            PreparedStatement pstmt = con.prepareCall(sql);
            pstmt.setInt(1, soLuong);
            pstmt.setDouble(2, thanhTien);
            pstmt.setString(3, maSP);
            n = pstmt.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<CT_DatHang> getCTDHS(String ma) {
        ArrayList<CT_DatHang> dsCTDH = new ArrayList<CT_DatHang>();
        String sql = "select * from CT_DatHang where MaDH = ?";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CT_DatHang ctdh = new CT_DatHang();
                ctdh.setSoLuong(rs.getInt("SoLuong"));
                ctdh.setThanhTien(rs.getDouble("ThanhTien"));
                var dh_dao = new DatHang_Dao();
                ctdh.setDatHang(dh_dao.getDH(rs.getString("MaDH")));
                var sp_dao = new SanPham_Dao();
                ctdh.setSanPham(sp_dao.getSPTheoMa(rs.getString("MaSP")));
                dsCTDH.add(ctdh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsCTDH;
    }

    public boolean xoa(String maDH) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete CT_DatHang where MaDH = ?");
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
