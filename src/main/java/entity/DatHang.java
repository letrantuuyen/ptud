package entity;

import java.util.Date;
import java.util.Objects;

public class DatHang {

    private String maDH;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private Date ngayDH;
    private double tongTien;

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
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

    public Date getNgayDH() {
        return ngayDH;
    }

    public void setNgayDH(Date ngayDH) {
        this.ngayDH = ngayDH;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public DatHang(String maDH, NhanVien nhanVien, KhachHang khachHang, Date ngayDH, double tongTien) {
        this.maDH = maDH;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ngayDH = ngayDH;
        this.tongTien = tongTien;
    }

    public DatHang(NhanVien nhanVien, KhachHang khachHang, Date ngayDH, double tongTien) {
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ngayDH = ngayDH;
        this.tongTien = tongTien;
    }

    public DatHang() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.maDH);
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
        final DatHang other = (DatHang) obj;
        if (!Objects.equals(this.maDH, other.maDH)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatHang{" + "maDH=" + maDH + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", ngayDH=" + ngayDH + ", tongTien=" + tongTien + '}';
    }
    
    
}
