/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.KichCo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class KichCo_Dao {

    public ArrayList<KichCo> getAllKC() {
        ArrayList<KichCo> lscl = new ArrayList<KichCo>();
        String Sql = "select * from KichCo";
        try {

            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                KichCo kc = new KichCo();
                kc.setMaKC(rs.getString("MaKC"));
                kc.setTenKC(rs.getString("TenKC"));
                lscl.add(kc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lscl;
    }

    public KichCo getKichCoMaKC(String mKC) {
        KichCo kc = null;
        PreparedStatement stmt = null;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("select * from KichCo where MaKC = ?");
            stmt.setString(1, mKC);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maKC = rs.getString(1);
                String tenKC = rs.getString(2);
                kc = new KichCo(maKC, tenKC);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return kc;
    }

    public KichCo getKichCoTenKC(String ten) {
        KichCo kc = null;
        PreparedStatement stmt = null;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("select * from KichCo where TenKC = ?");
            stmt.setString(1, ten);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maKC = rs.getString(1);
                String tenKC = rs.getString(2);
                kc = new KichCo(maKC, tenKC);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return kc;
    }

    public boolean them(KichCo ncc) {
        PreparedStatement stmt = null;
        int n = 0;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("insert into KichCo(TenKC) values(?)");
            stmt.setString(1, ncc.getTenKC());
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
            stmt = con.prepareStatement("delete from KichCo where MaKC= ?");
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

    public boolean sua(KichCo ncc) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            String sql = "update KichCo set TenKC=? where MaKC=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTenKC());
            ps.setString(2, ncc.getMaKC());
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

    public ArrayList<KichCo> traCuuKC(String ten) {
        ArrayList<KichCo> dsNCC = new ArrayList<KichCo>();
        String txtten = ten == null ? "" : ("" + ten);
        String sql = "select *from KichCo where TenKC like N'%" + txtten + "%'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                KichCo ncc = new KichCo();
                ncc.setMaKC(rs.getString("MaKC"));
                ncc.setTenKC(rs.getString("TenKC"));
                dsNCC.add(ncc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsNCC;

    }
}
