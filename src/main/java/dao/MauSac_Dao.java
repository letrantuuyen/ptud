/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.MauSac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MauSac_Dao {

    public ArrayList<MauSac> getAllMS() {
        ArrayList<MauSac> lsms = new ArrayList<MauSac>();
        String Sql = "select * from MauSac";
        try {

            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setMaMS(rs.getString("MaMS"));
                ms.setTenMS(rs.getString("TenMS"));
                lsms.add(ms);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lsms;
    }

    public MauSac getMauSacMaMau(String mMS) {
        MauSac ms = null;
        PreparedStatement stmt = null;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("select * from MauSac where MaMS = ?");
            stmt.setString(1, mMS);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maMS = rs.getString(1);
                String tenMS = rs.getString(2);
                ms = new MauSac(maMS, tenMS);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ms;
    }

    public MauSac getMauSacTenMau(String ten) {
        MauSac ms = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from MauSac where TenMS = ?");
            stmt.setString(1, ten);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maMS = rs.getString(1);
                String tenMS = rs.getString(2);
                ms = new MauSac(maMS, tenMS);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ms;
    }

    public boolean them(MauSac ncc) {
        PreparedStatement stmt = null;
        int n = 0;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("insert into MauSac(TenMS) values(?)");
            stmt.setString(1, ncc.getTenMS());
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
            stmt = con.prepareStatement("delete from MauSac where MaMS = ?");
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

    public boolean sua(MauSac ncc) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            String sql = "update MauSac set TenMS=? where MaMS=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTenMS());
            ps.setString(2, ncc.getMaMS());
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

    public ArrayList<MauSac> traCuuMS(String ten) {
        ArrayList<MauSac> dsNCC = new ArrayList<MauSac>();
        String txtten = ten == null ? "" : ("" + ten);
        String sql = "select *from MauSac where TenMS like N'%" + txtten + "%'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                MauSac ncc = new MauSac();
                ncc.setMaMS(rs.getString("MaMS"));
                ncc.setTenMS(rs.getString("TenMS"));
                dsNCC.add(ncc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsNCC;

    }
}
