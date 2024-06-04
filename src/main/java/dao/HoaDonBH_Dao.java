/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.CT_HDBanHang;
import entity.HDBanHang;
import entity.KhachHang;
import entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class HoaDonBH_Dao {

    public ArrayList<HDBanHang> getAllHDBH() {
        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();
        String Sql = "select * from HDBanHang";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                HDBanHang hdbh = new HDBanHang();
                hdbh.setMaHDBH(rs.getString("MaHDBH"));
                var nv_dao = new NhanVien_Dao();
                hdbh.setNhanVien(nv_dao.getNV(rs.getString("MaNV")));
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setNgayLapHDBH(rs.getDate("NgayLapHDBH"));
                hdbh.setTongTien(rs.getDouble("TongTien"));
                dsHDBH.add(hdbh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;
    }

    public boolean themHD(HDBanHang hd) {
        int n = 0;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into HDBanHang(MaNV, MaKH, NgayLapHDBH, TongTien) values(?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            Timestamp timestamp = new Timestamp(hd.getNgayLapHDBH().getTime());
            ps.setString(1, hd.getNhanVien().getMaNV());
            ps.setString(2, hd.getKhachHang().getMaKH());
            ps.setTimestamp(3, timestamp);
            ps.setDouble(4, hd.getTongTien());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n > 0;
    }

    public HDBanHang getHD(String ma) {
        HDBanHang hdbh = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();

        try {
            String sql = "select * from HDBanHang where MaHDBH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hdbh = new HDBanHang();
                hdbh.setMaHDBH(rs.getString("MaHDBH"));
                var nv_dao = new NhanVien_Dao();
                hdbh.setNhanVien(nv_dao.getNV(rs.getString("MaNV")));
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setNgayLapHDBH(rs.getDate("NgayLapHDBH"));
                hdbh.setTongTien(rs.getDouble("TongTien"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return hdbh;
    }

    public ArrayList<HDBanHang> getHDTheoSDT(String sdt) {
        ArrayList<HDBanHang> dshdbh = new ArrayList<HDBanHang>();
        Connect.getInstance();
        Connection con = Connect.getConnection();

        try {
            String sql = "select * from HDBanHang hd join KhachHang kh on hd.MaKH=kh.MaKH where SDT = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sdt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HDBanHang hdbh = new HDBanHang();
                hdbh.setMaHDBH(rs.getString("MaHDBH"));
                var nv_dao = new NhanVien_Dao();
                hdbh.setNhanVien(nv_dao.getNV(rs.getString("MaNV")));
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setNgayLapHDBH(rs.getDate("NgayLapHDBH"));
                hdbh.setTongTien(rs.getDouble("TongTien"));
                dshdbh.add(hdbh);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dshdbh;
    }

    public HDBanHang getHoaDonMoiNhat() {
        HDBanHang hd = null;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        Statement stmt = null;
        try {
            String sql = "select top 1 * from HDBanHang order by MaHDBH DESC";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NhanVien_Dao nv_dao = new NhanVien_Dao();
                NhanVien nv = nv_dao.getNV(rs.getString("MaNV"));
                KhachHang_Dao kh_dao = new KhachHang_Dao();
                KhachHang kh = kh_dao.getKH(rs.getString("MaKH"));
                hd = new HDBanHang(rs.getString("MaHDBH"), nv, kh, rs.getDate("NgayLapHDBH"), rs.getDouble("TongTien"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return hd;
    }

    public boolean xoa(String maHDBH) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete HDBanHang where MaHDBH = ?");
            stmt.setString(1, maHDBH);
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

    public ArrayList<HDBanHang> TKDTNam(String nam) {

        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();

        String txtnam = nam == null ? "" : ("" + nam);
        String Sql = " select * from HDBanHang where YEAR(NgayLapHDBH) = '" + txtnam + "' ";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                HDBanHang hdbh = new HDBanHang();
                hdbh.setMaHDBH(rs.getString("MaHDBH"));
                var nv_dao = new NhanVien_Dao();
                hdbh.setNhanVien(nv_dao.getNV(rs.getString("MaNV")));
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setNgayLapHDBH(rs.getDate("NgayLapHDBH"));
                hdbh.setTongTien(rs.getDouble("TongTien"));

                dsHDBH.add(hdbh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;
    }

    public double getTKDTNam(String nam) {
        double t = 0;
        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();

        String txtnam = nam == null ? "" : ("" + nam);
        String Sql = " select SUM(TongTien) as" + "'Tien'" + "from HDBanHang where YEAR(NgayLapHDBH) = N'" + txtnam + "'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                t = rs.getDouble("Tien");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;

    }

    public ArrayList<HDBanHang> TKDTNThang(String thang, String nam) {

        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();
        String txtnam = nam == null ? "" : ("" + nam);
        String txtthang = thang == null ? "" : ("" + thang);
        String Sql = " select * from HDBanHang where MONTH(NgayLapHDBH) = '" + txtthang + "' and YEAR(NgayLapHDBH) = N'" + txtnam + "' ";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                HDBanHang hdbh = new HDBanHang();
                hdbh.setMaHDBH(rs.getString("MaHDBH"));
                var nv_dao = new NhanVien_Dao();
                hdbh.setNhanVien(nv_dao.getNV(rs.getString("MaNV")));
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setNgayLapHDBH(rs.getDate("NgayLapHDBH"));
                hdbh.setTongTien(rs.getDouble("TongTien"));

                dsHDBH.add(hdbh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;
    }

    public double getTKDTThang(String thang, String nam) {
        double t = 0;
        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();
        String txtnam = nam == null ? "" : ("" + nam);
        String txtthang = thang == null ? "" : ("" + thang);
        String Sql = " select SUM(TongTien) as" + "'Tien'" + "from HDBanHang where MONTH(NgayLapHDBH) = N'" + txtthang + "' and YEAR(NgayLapHDBH) = N'" + txtnam + "'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                t = rs.getDouble("Tien");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;

    }

    public ArrayList<HDBanHang> TKDTNNgay(String ngay, String thang, String nam) {

        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();
        String txtngay = ngay == null ? "" : ("" + ngay);
        String txtnam = nam == null ? "" : ("" + nam);
        String txtthang = thang == null ? "" : ("" + thang);
        String Sql = " select * from HDBanHang where DAY(NgayLapHDBH) = '" + txtngay + "' and MONTH(NgayLapHDBH) = '" + txtthang + "' and YEAR(NgayLapHDBH) = N'" + txtnam + "' ";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                HDBanHang hdbh = new HDBanHang();
                hdbh.setMaHDBH(rs.getString("MaHDBH"));
                var nv_dao = new NhanVien_Dao();
                hdbh.setNhanVien(nv_dao.getNV(rs.getString("MaNV")));
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setNgayLapHDBH(rs.getDate("NgayLapHDBH"));
                hdbh.setTongTien(rs.getDouble("TongTien"));

                dsHDBH.add(hdbh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;
    }

    public double getTKDTNgay(String ngay, String thang, String nam) {
        double t = 0;
        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();
        String txtngay = ngay == null ? "" : ("" + ngay);
        String txtnam = nam == null ? "" : ("" + nam);
        String txtthang = thang == null ? "" : ("" + thang);
        String Sql = " select SUM(TongTien) as" + "'Tien'" + "from HDBanHang where DAY(NgayLapHDBH) = '" + txtngay + "' and MONTH(NgayLapHDBH) = '" + txtthang + "' and YEAR(NgayLapHDBH) = N'" + txtnam + "' ";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                t = rs.getDouble("Tien");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;

    }

    public ArrayList<HDBanHang> getNgay(String ngay, String thang, String nam) {
        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();

        String txtngay = ngay == null ? "" : ("" + ngay);
        String txtthang = thang == null ? "" : ("" + thang);
        String txtnam = nam == null ? "" : ("" + nam);

        String Sql = " select MaKH, sum(TongTien)  as" + "'TongTien'" + " from HDBanHang  where Day(NgayLapHDBH) = N'" + txtngay + "' and MONTH(NgayLapHDBH) = N'" + txtthang + "' and YEAR (NgayLapHDBH) = N'" + txtnam + "' group by MaKH order by sum(TongTien) desc";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                HDBanHang hdbh = new HDBanHang();
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setTongTien(rs.getDouble("TongTien"));
                dsHDBH.add(hdbh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;

    }

    public ArrayList<HDBanHang> getThang(String thang, String nam) {
        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();
        String txtthang = thang == null ? "" : ("" + thang);
        String txtnam = nam == null ? "" : ("" + nam);

        String Sql = " select MaKH, sum(TongTien)  as" + "'TongTien'" + " from HDBanHang  where  MONTH(NgayLapHDBH) = N'" + txtthang + "' and YEAR(NgayLapHDBH) = N'" + txtnam + "' group by MaKH order by sum(TongTien) desc";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                HDBanHang hdbh = new HDBanHang();
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setTongTien(rs.getDouble("TongTien"));
                dsHDBH.add(hdbh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;

    }

    public ArrayList<HDBanHang> getNam(String nam) {

        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();

        String txtnam = nam == null ? "" : ("" + nam);
        String Sql = " select   MaKH, sum(TongTien)  as" + "'TongTien'" + " from  HDBanHang  where YEAR(NgayLapHDBH) = N'" + txtnam + "' group by MaKH order by sum(TongTien) desc";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                HDBanHang hdbh = new HDBanHang();
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setTongTien(rs.getDouble("TongTien"));
                dsHDBH.add(hdbh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;
    }

    public ArrayList<HDBanHang> getCTNam(String maKH, String nam) {

        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();
        String txtnam = nam == null ? "" : ("" + nam);
        String Sql = " select MaHDBH,MaKH,TongTien from HDBanHang where MaKH='" + maKH + "' and YEAR(NgayLapHDBH)='" + nam + "'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                HDBanHang hdbh = new HDBanHang();
                hdbh.setMaHDBH(rs.getString("MaHDBH"));
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setTongTien(rs.getDouble("TongTien"));
                dsHDBH.add(hdbh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;
    }

    public ArrayList<HDBanHang> getCTThang(String maKH, String thang, String nam) {

        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();
        String txtthang = thang == null ? "" : ("" + thang);
        String txtnam = nam == null ? "" : ("" + nam);
        String Sql = " select MaHDBH,MaKH,TongTien from HDBanHang where  MaKH='" + maKH + "' and MONTH(NgayLapHDBH) = N'" + txtthang + "' and YEAR(NgayLapHDBH)='" + nam + "'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                HDBanHang hdbh = new HDBanHang();
                hdbh.setMaHDBH(rs.getString("MaHDBH"));
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setTongTien(rs.getDouble("TongTien"));
                dsHDBH.add(hdbh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;
    }

    public ArrayList<HDBanHang> getCTNgay(String maKH, String ngay, String thang, String nam) {

        ArrayList<HDBanHang> dsHDBH = new ArrayList<HDBanHang>();
        String txtngay = ngay == null ? "" : ("" + ngay);
        String txtthang = thang == null ? "" : ("" + thang);
        String txtnam = nam == null ? "" : ("" + nam);
        String Sql = " select MaHDBH,MaKH,TongTien from HDBanHang where  MaKH='" + maKH + "' and Day(NgayLapHDBH) = N'" + txtngay + "' and MONTH(NgayLapHDBH) = N'" + txtthang + "' and YEAR(NgayLapHDBH)='" + nam + "'";
        try {
            Connect.getInstance();
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                HDBanHang hdbh = new HDBanHang();
                hdbh.setMaHDBH(rs.getString("MaHDBH"));
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setTongTien(rs.getDouble("TongTien"));
                dsHDBH.add(hdbh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHDBH;
    }

    public ArrayList<HDBanHang> getHDKH(String sdt) {
        ArrayList<HDBanHang> dshdbh = new ArrayList<HDBanHang>();
        Connect.getInstance();
        Connection con = Connect.getConnection();

        try {
            String sql = "select * from HDBanHang where MaKH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sdt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HDBanHang hdbh = new HDBanHang();
                hdbh.setMaHDBH(rs.getString("MaHDBH"));
                var nv_dao = new NhanVien_Dao();
                hdbh.setNhanVien(nv_dao.getNV(rs.getString("MaNV")));
                var kh_dao = new KhachHang_Dao();
                hdbh.setKhachHang(kh_dao.getKH(rs.getString("MaKH")));
                hdbh.setNgayLapHDBH(rs.getDate("NgayLapHDBH"));
                hdbh.setTongTien(rs.getDouble("TongTien"));
                dshdbh.add(hdbh);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dshdbh;
    }

}
