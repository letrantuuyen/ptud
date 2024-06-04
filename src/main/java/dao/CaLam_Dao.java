/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.CaLam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CaLam_Dao {

    public CaLam getCaLamBuoi(String mCL) {
        CaLam cl = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from CaLam where MaCa = ?");
            stmt.setString(1, mCL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maCL = rs.getString(1);
                String buoi = rs.getString(2);
                String tgbd = rs.getString(3);
                String tgkt = rs.getString(4);
                cl = new CaLam(maCL, buoi, tgbd, tgkt);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return cl;
    }

    public CaLam getMLtheobuoi(String bCL) {
        CaLam cl = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from CaLam where Buoi = ?");
            stmt.setString(1, bCL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maCL = rs.getString(1);
                String buoi = rs.getString(2);
                String tgbd = rs.getString(3);
                String tgkt = rs.getString(4);
                cl = new CaLam(maCL, buoi, tgbd, tgkt);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return cl;
    }

    public ArrayList<CaLam> getAllCL() {
        ArrayList<CaLam> dsCL = new ArrayList<CaLam>();
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            String Sql = "select * from CaLam";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                CaLam ncc = new CaLam(rs.getString("MaCa"), rs.getString("Buoi"), rs.getString("ThoiGianBatDau"), rs.getString("ThoiGianKetThuc"));
                dsCL.add(ncc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCL;
    }
     public boolean them(CaLam ncc) {
        PreparedStatement stmt = null;
        int n = 0;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("insert into CaLam(Buoi,ThoiGianBatDau,ThoiGianKetThuc) values(?,?,?)");
            stmt.setString(1, ncc.getBuoi());
            stmt.setString(2, ncc.getTgBD());
            stmt.setString(3, ncc.getTgKT());
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
            stmt = con.prepareStatement("delete from CaLam where MaCa = ?");
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

    public boolean sua(CaLam ncc) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            String sql = "update CaLam set Buoi=?, ThoiGianBatDau=?,ThoiGianKetThuc=? where MaCa=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getBuoi());
            ps.setString(2, ncc.getTgBD());
            ps.setString(3, ncc.getTgKT());
            ps.setString(4, ncc.getMaC());
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

    public ArrayList<CaLam> traCuuCL(String ten) {
        ArrayList<CaLam> dsNCC = new ArrayList<CaLam>();
        String txtten = ten == null ? "" : ("" + ten);
        String sql = "select *from CaLam where Buoi like N'%" + txtten + "%'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	CaLam ncc = new CaLam();
                ncc.setMaC(rs.getString("MaCa"));
                ncc.setBuoi(rs.getString("Buoi"));
                ncc.setTgBD(rs.getString("ThoiGianBatDau"));
                ncc.setTgKT(rs.getString("ThoiGianKetThuc"));
                dsNCC.add(ncc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsNCC;

    }
}
