/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.NhaSX;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class NhaSX_Dao {

    public ArrayList<NhaSX> getAllNSX() {
        ArrayList<NhaSX> lsnsx = new ArrayList<NhaSX>();
        String Sql = "select * from NhaSX";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                NhaSX nsx = new NhaSX();
                nsx.setMaNSX(rs.getString("MaNSX"));
                nsx.setTenNSX(rs.getString("TenNSX"));
                lsnsx.add(nsx);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lsnsx;
    }

    public NhaSX getNhaSXMaNSX(String mNSX) {
        NhaSX nsx = null;
        PreparedStatement stmt = null;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("select * from NhaSX where MaNSX = ?");
            stmt.setString(1, mNSX);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maNSX = rs.getString(1);
                String tenNSX = rs.getString(2);
                nsx = new NhaSX(maNSX, tenNSX);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return nsx;
    }

    public NhaSX getNhaSXTenNSX(String ten) {
        NhaSX nsx = null;
        PreparedStatement stmt = null;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("select * from NhaSX where TenNSX = ?");
            stmt.setString(1, ten);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maNSX = rs.getString(1);
                String tenNSX = rs.getString(2);
                nsx = new NhaSX(maNSX, tenNSX);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return nsx;
    }

    public boolean them(NhaSX ncc) {
        PreparedStatement stmt = null;
        int n = 0;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("insert into NhaSX(TenNSX) values(?)");
            stmt.setString(1, ncc.getTenNSX());
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
            stmt = con.prepareStatement("delete from NhaSX where MaNSX = ?");
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

    public boolean sua(NhaSX ncc) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            String sql = "update NhaSX set TenNSX=? where MaNSX=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTenNSX());
            ps.setString(2, ncc.getMaNSX());
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

    public ArrayList<NhaSX> traCuuNSX(String ten) {
        ArrayList<NhaSX> dsNCC = new ArrayList<NhaSX>();
        String txtten = ten == null ? "" : ("" + ten);
        String sql = "select *from NhaSX where TenNSX like N'%" + txtten + "%'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NhaSX ncc = new NhaSX();
                ncc.setMaNSX(rs.getString("MaNSX"));
                ncc.setTenNSX(rs.getString("TenNSX"));
                dsNCC.add(ncc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsNCC;

    }
}
