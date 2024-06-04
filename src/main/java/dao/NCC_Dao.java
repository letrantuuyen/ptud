package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;
import entity.KichCo;
import entity.NhaCungCap;
import java.sql.PreparedStatement;

public class NCC_Dao {

    public ArrayList<NhaCungCap> getAllNCC() {
        ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            String Sql = "select * from NhaCC";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getString("MaNCC"), rs.getString("TenNCC"), rs.getString("SDT"), rs.getString("DiaChi"), rs.getString("Email"));
                dsNCC.add(ncc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsNCC;
    }

    public boolean themNhaCC(NhaCungCap ncc) {
        PreparedStatement stmt = null;
        int n = 0;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("insert into NhaCC(TenNCC,DiaChi,SDT,Email) values(?,?,?,?)");
            stmt.setString(1, ncc.getTenNCC());
            stmt.setString(2, ncc.getDiaChi());
            stmt.setString(3, ncc.getsDT());
            stmt.setString(4, ncc.getEmail());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return n > 0;
    }
    public NhaCungCap getNCCTheoTen(String ten) {
        NhaCungCap ncc = null;
        PreparedStatement stmt = null;
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            stmt = con.prepareStatement("select *from NhaCC  where TenNCC = ?");
            stmt.setString(1, ten);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ma = rs.getString(1);
                String tenncc = rs.getString(2);
                String sdt = rs.getString(3);
                String diachi= rs.getString(4);
                String email = rs.getString(5);
             
                
                ncc = new NhaCungCap(ma, tenncc, sdt, diachi, email);
              
                     
                     
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ncc;
    }

    public boolean xoa(String maNCC) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete from NhaCC where MaNCC = ?");
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

    public boolean sua(NhaCungCap ncc) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            String sql = "update NhaCC set TenNCC=?, DiaChi=?, SDT=?, Email=? where MaNCC=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getDiaChi());
            ps.setString(3, ncc.getsDT());
            ps.setString(4, ncc.getEmail());
            ps.setString(5, ncc.getMaNCC());
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

    public NhaCungCap TimNCCTheoSDT(String sDT) throws SQLException {
        NhaCungCap ncc = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();

        try {
            String sql = "select * from NhaCC where SDT = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maNCC = rs.getString(1);
                String tenNCC = rs.getString(2);
                String sdt = rs.getString(4);
                String diaChi = rs.getString(3);
                String email = rs.getString(5);
                ncc = new NhaCungCap(maNCC, tenNCC, sdt, diaChi, email);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ncc;
    }
    public NhaCungCap TimNCCTheoMa(String ma) throws SQLException {
        NhaCungCap ncc = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();

        try {
            String sql = "select * from NhaCC where MaNCC = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maNCC = rs.getString(1);
                String tenNCC = rs.getString(2);
                String sdt = rs.getString(4);
                String diaChi = rs.getString(3);
                String email = rs.getString(5);
                ncc = new NhaCungCap(maNCC, tenNCC, sdt, diaChi, email);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ncc;
    }

    public ArrayList<NhaCungCap> traCuuNCC(String tenNCC, String sdt) {
        ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
        String txtten = tenNCC == null ? "" : ("" + tenNCC);
        String txtsdt = sdt == null ? "" : ("" + sdt);
        String sql = "select *from NhaCC where TenNCC like N'%" + txtten + "%' and SDT like N'%" + txtsdt + "%'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getString("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setsDT(rs.getString("SDT"));
                ncc.setEmail(rs.getString("Email"));
                dsNCC.add(ncc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsNCC;

    }
}
