package entity;

import java.util.Date;
import java.util.Objects;

public class HDBanHang {

    private String maHDBH;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private Date ngayLapHDBH;
    private double tongTien;

    public String getMaHDBH() {
        return maHDBH;
    }

    public void setMaHDBH(String maHDBH) {
        this.maHDBH = maHDBH;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Date getNgayLapHDBH() {
        return ngayLapHDBH;
    }

    public void setNgayLapHDBH(Date ngayLapHDBH) {
        this.ngayLapHDBH = ngayLapHDBH;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public HDBanHang(String maHDBH, NhanVien nhanVien, KhachHang khachHang, Date ngayLapHDBH, double tongTien) {
        this.maHDBH = maHDBH;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ngayLapHDBH = ngayLapHDBH;
        this.tongTien = tongTien;
    }

    public HDBanHang(NhanVien nhanVien, KhachHang khachHang, Date ngayLapHDBH, double tongTien) {
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ngayLapHDBH = ngayLapHDBH;
        this.tongTien = tongTien;
    }

    public HDBanHang() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.maHDBH);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HDBanHang other = (HDBanHang) obj;
        if (!Objects.equals(this.maHDBH, other.maHDBH)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HDBanHang{" + "maHDBH=" + maHDBH + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", ngayLapHDBH=" + ngayLapHDBH + ", tongTien=" + tongTien + '}';
    }
    
    

}
