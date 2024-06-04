package entity;

import java.util.Objects;

public class DanhMucSP {

    private String maDanhMuc;
    private String tenDanhMuc;

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public DanhMucSP(String maDanhMuc, String tenDanhMuc) {
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
    }

    public DanhMucSP(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public DanhMucSP() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.maDanhMuc);
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
        final DanhMucSP other = (DanhMucSP) obj;
        if (!Objects.equals(this.maDanhMuc, other.maDanhMuc)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DanhMucSP{" + "maDanhMuc=" + maDanhMuc + ", tenDanhMuc=" + tenDanhMuc + '}';
    }

}
