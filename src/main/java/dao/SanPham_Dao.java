package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.Connect;
import entity.*;
import java.sql.PreparedStatement;

public class SanPham_Dao {
     String imageName = null;

    public ArrayList<SanPham> getAllSP() {
        ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
        String Sql = "select * from SanPham";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                var dm_dao = new DanhMuc_Dao();
                DanhMucSP dm = dm_dao.getDanhMucMaDM(rs.getString("MaDanhMuc"));
                sp.setDanhMuc(dm);
                sp.setTenSP(rs.getString("TenSP"));
                sp.setDonGia(rs.getDouble("DonGia"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                var cl_dao = new ChatLieu_Dao();
                ChatLieu cl = cl_dao.getChatLieuMaCL(rs.getString("MaCL"));
                sp.setChatLieu(cl);
                var ms_dao = new MauSac_Dao();
                MauSac ms = ms_dao.getMauSacMaMau(rs.getString("MaMS"));
                sp.setMauSac(ms);
                var kc_dao = new KichCo_Dao();
                KichCo kc = kc_dao.getKichCoMaKC(rs.getString("MaKC"));
                sp.setKichCo(kc);
                var nsx_dao = new NhaSX_Dao();
                NhaSX nsx = nsx_dao.getNhaSXMaNSX(rs.getString("MaNSX"));
                sp.setnSX(nsx);
                var ncc_dao = new NCC_Dao();
                NhaCungCap ncc = ncc_dao.TimNCCTheoMa(rs.getString("MaNCC"));
                sp.setNcc(ncc);
             
                sp.setAnh(rs.getString("Anh"));

                dsSP.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsSP;
    }

    public SanPham getSPTheoMa(String maSP) {
        SanPham sp = null;
        String sql = "Select * from SanPham where maSP = ?";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DanhMuc_Dao dm_dao = new DanhMuc_Dao();
                DanhMucSP dmsp = dm_dao.getDanhMucMaDM(rs.getString("maDanhMuc"));
                sp = new SanPham();
                sp.setMaSP(rs.getString("maSP"));
                sp.setDanhMuc(dmsp);
                sp.setTenSP(rs.getString("tenSP"));
                sp.setDonGia(rs.getDouble("DonGia"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                var cl_dao = new ChatLieu_Dao();
                ChatLieu cl = cl_dao.getChatLieuMaCL(rs.getString("MaCL"));
                sp.setChatLieu(cl);
                var ms_dao = new MauSac_Dao();
                MauSac ms = ms_dao.getMauSacMaMau(rs.getString("MaMS"));
                sp.setMauSac(ms);
                var kc_dao = new KichCo_Dao();
                KichCo kc = kc_dao.getKichCoMaKC(rs.getString("MaKC"));
                sp.setKichCo(kc);
                var nsx_dao = new NhaSX_Dao();
                NhaSX nsx = nsx_dao.getNhaSXMaNSX(rs.getString("MaNSX"));
                sp.setnSX(nsx);
                var ncc_dao = new NCC_Dao();
                NhaCungCap ncc = ncc_dao.TimNCCTheoMa(rs.getString("MaNCC"));
                sp.setNcc(ncc);
                sp.setAnh(rs.getString("Anh"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

    public boolean them(SanPham sp) {
        PreparedStatement stmt = null;
        int n = 0;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("insert into SanPham(MaDanhMuc,TenSP,MaMS,MaCL,MaNSX,MaKC,MaNCC,SoLuong,DonGia,Anh) values(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, sp.getDanhMuc().getMaDanhMuc());
            stmt.setString(2, sp.getTenSP());
            stmt.setString(3, sp.getMauSac().getMaMS());
            stmt.setString(4, sp.getChatLieu().getMaCL());
            stmt.setString(5, sp.getnSX().getMaNSX());
            stmt.setString(6, sp.getKichCo().getMaKC());
            stmt.setString(7, sp.getNcc().getMaNCC());
            stmt.setInt(8, sp.getSoLuong());
            stmt.setDouble(9, sp.getDonGia());
            stmt.setString(10, sp.getAnh());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return n > 0;
    }
    public boolean sua(SanPham sp) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "update SanPham set MaDanhMuc=?, TenSP=?, MaMS=?, MaCL=?,MaNSX=?, MaKC=?, MaNCC=?, SoLuong=?, DonGia=?, Anh=? where MaSP=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sp.getDanhMuc().getMaDanhMuc());
            stmt.setString(2, sp.getTenSP());
            stmt.setString(3, sp.getMauSac().getMaMS());
            stmt.setString(4, sp.getChatLieu().getMaCL());
            stmt.setString(5, sp.getnSX().getMaNSX());
            stmt.setString(6, sp.getKichCo().getMaKC());
            stmt.setString(7, sp.getNcc().getMaNCC());
            stmt.setInt(8, sp.getSoLuong());
            stmt.setDouble(9, sp.getDonGia());
            stmt.setString(10, sp.getAnh());
            stmt.setString(11, sp.getMaSP());
            n = stmt.executeUpdate();
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
     public boolean xoa(String ma) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete from SanPham where MaSP = ?");
            stmt.setString(1, ma);
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

    public ArrayList<SanPham> timSPNC(String ten, String dmsp, String nsx, String ms, String kc) {

        ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
        var dm_dao = new DanhMuc_Dao();
        var cl_dao = new ChatLieu_Dao();
        var ms_dao = new MauSac_Dao();
        var kc_dao = new KichCo_Dao();
        var nsx_dao = new NhaSX_Dao();
        var ncc_dao= new NCC_Dao();

        String txttsp = ten == null ? "" : ("" + ten);
        String txtdm = dm_dao.getDanhMucTenDM(dmsp) == null ? "" : ("" + dm_dao.getDanhMucTenDM(dmsp).getMaDanhMuc());
        String txtnsx = nsx_dao.getNhaSXTenNSX(nsx) == null ? "" : ("" + nsx_dao.getNhaSXTenNSX(nsx).getMaNSX());
        String txtms = ms_dao.getMauSacTenMau(ms) == null ? "" : ("" + ms_dao.getMauSacTenMau(ms).getMaMS());
        String txtkc = kc_dao.getKichCoTenKC(kc) == null ? "" : ("" + kc_dao.getKichCoTenKC(kc).getMaKC());
        String Sql = "select * from SanPham where TenSP like N'%" + txttsp + "%' and MaDanhMuc like N'%" + txtdm + "%' and MaNSX like N'%" + txtnsx + "%' and MaMS like N'%" + txtms + "%' and MaKC like '%" + txtkc + "%'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                DanhMucSP dm = dm_dao.getDanhMucMaDM(rs.getString("MaDanhMuc"));
                sp.setDanhMuc(dm);
                sp.setTenSP(rs.getString("TenSP"));
                sp.setDonGia(rs.getDouble("DonGia"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                ChatLieu cl = cl_dao.getChatLieuMaCL(rs.getString("MaCL"));
                sp.setChatLieu(cl);
                sp.setMauSac(ms_dao.getMauSacMaMau(rs.getString("MaMS")));
                sp.setKichCo(kc_dao.getKichCoMaKC(rs.getString("MaKC")));
                sp.setnSX(nsx_dao.getNhaSXMaNSX(rs.getString("MaNSX")));
                sp.setNcc(ncc_dao.TimNCCTheoMa(rs.getString("MaNCC")));
                sp.setAnh(rs.getString("Anh"));
                dsSP.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsSP;
    }

    public boolean capNhatSoLuong(String maSP, int soLuong) {
        int n = -1;
        String sql = "update SanPham  set soLuong = ? where maSP = ?";
        Connect.getInstance();
        Connection con = Connect.getConnection();
        try {
            PreparedStatement pstmt = con.prepareCall(sql);
            pstmt.setInt(1, soLuong);
            pstmt.setString(2, maSP);
            n = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return n > 0;
    }
}
