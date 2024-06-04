/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import java.util.Objects;


public class NhanVien {

    private String maNV;
    private CaLam caLam;
    private ChucVu chucVu;
    private String tenNV;
    private String gioiTinh;
    private String cmnd;
    private String diaChi;
    private String sdt;
    private Date ngaySinh;

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public CaLam getCaLam() {
        return caLam;
    }

    public void setCaLam(CaLam caLam) {
        this.caLam = caLam;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public NhanVien(String maNV, CaLam caLam, ChucVu chucVu, String tenNV, String gioiTinh, String cmnd, String diaChi, String sdt, Date ngaySinh) {
        this.maNV = maNV;
        this.caLam = caLam;
        this.chucVu = chucVu;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
    }

    public NhanVien(CaLam caLam, ChucVu chucVu, String tenNV, String gioiTinh, String cmnd, String diaChi, String sdt, Date ngaySinh) {
        this.caLam = caLam;
        this.chucVu = chucVu;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
    }

    public NhanVien() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.maNV);
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
        final NhanVien other = (NhanVien) obj;
        if (!Objects.equals(this.maNV, other.maNV)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", caLam=" + caLam + ", chucVu=" + chucVu + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", cmnd=" + cmnd + ", diaChi=" + diaChi + ", sdt=" + sdt + ", ngaySinh=" + ngaySinh + '}';
    }
   
}
