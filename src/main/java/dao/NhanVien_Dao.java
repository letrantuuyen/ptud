package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.Connect;
import entity.CaLam;
import entity.ChucVu;

import entity.NhanVien;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;

public class NhanVien_Dao {

    public ArrayList<NhanVien> getAllNV() {
        ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
        String Sql = "select * from NhanVien";
        try {

            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                var cl_dao = new CaLam_Dao();
                CaLam cl = cl_dao.getCaLamBuoi(rs.getString("MaCa"));
                nv.setCaLam(cl);
                var cv_dao = new ChucVu_Dao();
                ChucVu cv = cv_dao.getChucVu(rs.getString("MaCV"));
                nv.setChucVu(cv);
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setCmnd(rs.getString("CMND"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSdt(rs.getString("SDT"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                dsNV.add(nv);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsNV;
    }

    public NhanVien getNV(String maNV) {
        NhanVien nv = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();

        try {
            String sql = "select * from NhanVien where MaNV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                var cl_dao = new CaLam_Dao();
                CaLam cl = cl_dao.getCaLamBuoi(rs.getString("MaCa"));
                nv.setCaLam(cl);
                var cv_dao = new ChucVu_Dao();
                ChucVu cv = cv_dao.getChucVu(rs.getString("MaCV"));
                nv.setChucVu(cv);
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setCmnd(rs.getString("CMND"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSdt(rs.getString("SDT"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return nv;
    }

    public boolean themNV(NhanVien nv) {
        int n = 0;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into NhanVien(MaCa, MaCV, TenNV, GioiTinh, CMND, DiaChi, SDT, NgaySinh) values( ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, nv.getCaLam().getMaC());
            ps.setString(2, nv.getChucVu().getMaCV());
            ps.setString(3, nv.getTenNV());
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getCmnd());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getSdt());
            Calendar cal = Calendar.getInstance();
            cal.setTime(nv.getNgaySinh());
            java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
            ps.setDate(8, sqlDate);
            System.out.println(nv.getSdt());
            n = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    public NhanVien getNVMoiNhat() {
        NhanVien nv = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        Statement stmt = null;
        try {
            String sql = "select top 1 * from NhanVien order by MaNV DESC";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                var cl_dao = new CaLam_Dao();
                CaLam cl = cl_dao.getCaLamBuoi(rs.getString("MaCa"));
                nv.setCaLam(cl);
                var cv_dao = new ChucVu_Dao();
                ChucVu cv = cv_dao.getChucVu(rs.getString("MaCV"));
                nv.setChucVu(cv);
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setCmnd(rs.getString("CMND"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSdt(rs.getString("SDT"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return nv;
    }

    public boolean xoa(String ma) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete from NhanVien where MaNV = ?");
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

    public boolean sua(NhanVien nv) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            String sql = "update NhanVien set MaCa=?, MaCV=?, TenNV=?, GioiTinh=?, CMND=?, DiaChi=?, SDT=?, NgaySinh=? where MaNV=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nv.getCaLam().getMaC());
            ps.setString(2, nv.getChucVu().getMaCV());
            ps.setString(3, nv.getTenNV());
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getCmnd());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getSdt());
            Calendar cal = Calendar.getInstance();
            cal.setTime(nv.getNgaySinh());
            java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
            ps.setDate(8, sqlDate);
            ps.setString(9, nv.getMaNV());
            System.out.println(nv);
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

    public NhanVien TimNVTheoSDT(String sDT) throws SQLException {
        NhanVien nv = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();

        try {
            String sql = "select * from NhanVien where SDT = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                var cl_dao = new CaLam_Dao();
                CaLam cl = cl_dao.getCaLamBuoi(rs.getString("MaCa"));
                nv.setCaLam(cl);
                var cv_dao = new ChucVu_Dao();
                ChucVu cv = cv_dao.getChucVu(rs.getString("MaCV"));
                nv.setChucVu(cv);
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setCmnd(rs.getString("CMND"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSdt(rs.getString("SDT"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return nv;
    }

    public ArrayList<NhanVien> traCuuNV(String ten, String sdt, String cv) {
        NhanVien nv = null;
        ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
        var cv_dao = new ChucVu_Dao();
        String txtten = ten == null ? "" : ("" + ten);
        String txtsdt = sdt == null ? "" : ("" + sdt);

        //	String txtdm = dm_dao.getDanhMucTenDM(dmsp) == null ? "" : ("" + dm_dao.getDanhMucTenDM(dmsp).getMaDanhMuc());
        String txtcv = cv_dao.getCVTenCV(cv) == null ? "" : ("" + cv_dao.getCVTenCV(cv).getMaCV());
        //System.out.println(nv.getChucVu().getTenCV());
        String sql = "select *from NhanVien where TenNV like N'%" + txtten + "%' and SDT like N'%" + txtsdt
                + "%'and MaCV like N'%" + txtcv + "%'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                var cl_dao = new CaLam_Dao();
                CaLam cl = cl_dao.getCaLamBuoi(rs.getString("MaCa"));
                nv.setCaLam(cl);
                ChucVu cv1 = cv_dao.getChucVu(rs.getString("MaCV"));
                nv.setChucVu(cv1);
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setCmnd(rs.getString("CMND"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSdt(rs.getString("SDT"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                dsNV.add(nv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsNV;

    }
}
