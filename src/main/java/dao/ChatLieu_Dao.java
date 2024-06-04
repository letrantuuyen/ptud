/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.ChatLieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ChatLieu_Dao {

    public ArrayList<ChatLieu> getAllCL() {
        ArrayList<ChatLieu> lscl = new ArrayList<ChatLieu>();
        String Sql = "select * from ChatLieu";
        try {

            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                cl.setMaCL(rs.getString("MaCL"));
                cl.setTenCL(rs.getString("TenCL"));
                lscl.add(cl);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lscl;
    }

    public ChatLieu getChatLieuMaCL(String mCL) {
        ChatLieu cl = null;
        PreparedStatement stmt = null;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("select * from ChatLieu where MaCL = ?");
            stmt.setString(1, mCL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maCL = rs.getString(1);
                String tenCL = rs.getString(2);
                cl = new ChatLieu(maCL, tenCL);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return cl;
    }

    public ChatLieu getChatLieuTheoTen(String ten) {
        ChatLieu cl = null;
        PreparedStatement stmt = null;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("select * from ChatLieu where TenCL = ?");
            stmt.setString(1, ten);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maCL = rs.getString(1);
                String tenCL = rs.getString(2);
                cl = new ChatLieu(maCL, tenCL);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return cl;
    }

    public boolean them(ChatLieu ncc) {
        PreparedStatement stmt = null;
        int n = 0;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("insert into ChatLieu(TenCL) values(?)");
            stmt.setString(1, ncc.getTenCL());
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
            stmt = con.prepareStatement("delete from ChatLieu where MaCL = ?");
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

    public boolean sua(ChatLieu ncc) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            String sql = "update ChatLieu set TenCL=? where MaCL=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTenCL());
            ps.setString(2, ncc.getMaCL());
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

    public ArrayList<ChatLieu> traCuuCL(String ten) {
        ArrayList<ChatLieu> dsNCC = new ArrayList<ChatLieu>();
        String txtten = ten == null ? "" : ("" + ten);
        String sql = "select *from ChatLieu where TenCL like N'%" + txtten + "%'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ChatLieu ncc = new ChatLieu();
                ncc.setMaCL(rs.getString("MaCL"));
                ncc.setTenCL(rs.getString("TenCL"));
                dsNCC.add(ncc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsNCC;

    }
}
