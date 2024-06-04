package entity;

import java.util.Objects;

public class TaiKhoan {

    private String tenDN;
    private String matKhau;
    private String quyen;
    private NhanVien nhanVien;

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public TaiKhoan(String tenDN, String matKhau, String quyen, NhanVien nhanVien) {
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.quyen = quyen;
        this.nhanVien = nhanVien;
    }

    public TaiKhoan() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.tenDN);
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
        final TaiKhoan other = (TaiKhoan) obj;
        if (!Objects.equals(this.tenDN, other.tenDN)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "tenDN=" + tenDN + ", matKhau=" + matKhau + ", quyen=" + quyen + ", nhanVien=" + nhanVien + '}';
    }
    
}
