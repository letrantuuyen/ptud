/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.DanhMucSP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.Connect;
import entity.CaLam;
import entity.NhanVien;
import java.sql.Statement;
import java.util.ArrayList;


public class DanhMuc_Dao {

    public ArrayList<DanhMucSP> getAllDM() {
        ArrayList<DanhMucSP> lsdm = new ArrayList<DanhMucSP>();
        String Sql = "select * from DanhMucSP";
        try {

            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                DanhMucSP dm = new DanhMucSP();
                dm.setMaDanhMuc(rs.getString("MaDanhMuc"));
                dm.setTenDanhMuc(rs.getString("TenDanhMuc"));
                lsdm.add(dm);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lsdm;
    }

    public DanhMucSP getDanhMucMaDM(String mDM) {
        DanhMucSP dm = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from DanhMucSP where MaDanhMuc = ?");
            stmt.setString(1, mDM);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maDM = rs.getString(1);
                String tenDM = rs.getString(2);
                dm = new DanhMucSP(maDM, tenDM);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dm;
    }

    public DanhMucSP getDanhMucTenDM(String ten) {
        DanhMucSP dm = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from DanhMucSP where TenDanhMuc = ?");
            stmt.setString(1, ten);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maDM = rs.getString(1);
                String tenDM = rs.getString(2);
                dm = new DanhMucSP(maDM, tenDM);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dm;
    }
    public boolean them(DanhMucSP ncc) {
        PreparedStatement stmt = null;
        int n = 0;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("insert into DanhMucSP(TenDanhMuc) values(?)");
            stmt.setString(1, ncc.getTenDanhMuc());
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
            stmt = con.prepareStatement("delete from DanhMucSP where MaDanhMuc= ?");
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

    public boolean sua(DanhMucSP ncc) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            String sql = "update DanhMucSP set TenDanhMuc=? where MaDanhMuc=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTenDanhMuc());
            ps.setString(2, ncc.getMaDanhMuc());
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

    public ArrayList<DanhMucSP> traCuuDM(String ten) {
        ArrayList<DanhMucSP> dsNCC = new ArrayList<DanhMucSP>();
        String txtten = ten == null ? "" : ("" + ten);
        String sql = "select *from DanhMucSP where TenDanhMuc like N'%" + txtten + "%'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DanhMucSP ncc = new DanhMucSP();
                ncc.setMaDanhMuc(rs.getString("MaDanhMuc"));
                ncc.setTenDanhMuc(rs.getString("TenDanhMuc"));
                dsNCC.add(ncc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsNCC;

    }
}
