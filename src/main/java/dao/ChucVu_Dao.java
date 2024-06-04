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

/**
 *
 * @author PhamDuy
 */
public class ChucVu_Dao {

    public ChucVu getChucVu(String mCV) {
        ChucVu cv = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from ChucVu where MaCV = ?");
            stmt.setString(1, mCV);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                double luong = rs.getDouble(3);
                cv = new ChucVu(ma, ten, luong);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return cv;
    }

    public ChucVu getCVTenCV(String tenCV) {
        ChucVu cv = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from ChucVu where TenCV = ?");
            stmt.setString(1, tenCV);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                double luong = rs.getDouble(3);
                cv = new ChucVu(ma, ten, luong);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return cv;
    }

    public ArrayList<ChucVu> getAllCV() {
        ArrayList<ChucVu> dsCL = new ArrayList<ChucVu>();
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            String Sql = "select * from ChucVu";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                ChucVu ncc = new ChucVu(rs.getString("MaCV"), rs.getString("TenCV"), rs.getDouble("Luong"));
                dsCL.add(ncc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCL;
    }

    public boolean them(ChucVu ncc) {
        PreparedStatement stmt = null;
        int n = 0;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("insert into ChucVu(TenCV,Luong) values(?,?)");
            stmt.setString(1, ncc.getTenCV());
            stmt.setDouble(2, ncc.getLuong());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return n > 0;
    }

    public boolean xoa(String maNCC) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete from ChucVu where MaCV = ?");
            stmt.setString(1, maNCC);
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

    public boolean sua(ChucVu ncc) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            String sql = "update ChucVu set TenCV=?, Luong=? where MaCV=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTenCV());
            ps.setDouble(2, ncc.getLuong());
            ps.setString(3, ncc.getMaCV());
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

    public ArrayList<ChucVu> traCuuCV(String ten) {
        ArrayList<ChucVu> dsNCC = new ArrayList<ChucVu>();
        String txtten = ten == null ? "" : ("" + ten);
        String sql = "select *from ChucVu where TenCV like N'%" + txtten + "%'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ChucVu ncc = new ChucVu();
                ncc.setMaCV(rs.getString("MaCV"));
                ncc.setTenCV(rs.getString("TenCV"));
                ncc.setLuong(rs.getDouble("Luong"));
                dsNCC.add(ncc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsNCC;

    }
}
