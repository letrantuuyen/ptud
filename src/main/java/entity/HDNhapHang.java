package entity;

import java.sql.Date;
import java.util.Objects;

public class HDNhapHang {

    private String maHDNH;
    private NhanVien nhanVien;
    private NhaCungCap nhaCC;
    private Date ngayLapHDNH;

    public String getMaHDNH() {
        return maHDNH;
    }

    public void setMaHDNH(String maHDNH) {
        this.maHDNH = maHDNH;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public NhaCungCap getNhaCC() {
        return nhaCC;
    }

    public void setNhaCC(NhaCungCap nhaCC) {
        this.nhaCC = nhaCC;
    }

    public Date getNgayLapHDNH() {
        return ngayLapHDNH;
    }

    public void setNgayLapHDNH(Date ngayLapHDNH) {
        this.ngayLapHDNH = ngayLapHDNH;
    }

    public HDNhapHang(String maHDNH, NhanVien nhanVien, NhaCungCap nhaCC, Date ngayLapHDNH) {
        this.maHDNH = maHDNH;
        this.nhanVien = nhanVien;
        this.nhaCC = nhaCC;
        this.ngayLapHDNH = ngayLapHDNH;
    }

    public HDNhapHang(NhanVien nhanVien, NhaCungCap nhaCC, Date ngayLapHDNH) {
        this.nhanVien = nhanVien;
        this.nhaCC = nhaCC;
        this.ngayLapHDNH = ngayLapHDNH;
    }

    public HDNhapHang() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.maHDNH);
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
        final HDNhapHang other = (HDNhapHang) obj;
        if (!Objects.equals(this.maHDNH, other.maHDNH)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HDNhapHang{" + "maHDNH=" + maHDNH + ", nhanVien=" + nhanVien + ", nhaCC=" + nhaCC + ", ngayLapHDNH=" + ngayLapHDNH + '}';
    }
  
}
