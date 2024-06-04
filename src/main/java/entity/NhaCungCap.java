/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;


public class NhaCungCap {

    private String maNCC;
    private String tenNCC;
    private String sDT;
    private String diaChi;
    private String email;

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NhaCungCap(String maNCC, String tenNCC, String sDT, String diaChi, String email) {
        super();
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sDT = sDT;
        this.diaChi = diaChi;
        this.email = email;
    }

    public NhaCungCap(String tenNCC, String sDT, String diaChi, String email) {
        this.tenNCC = tenNCC;
        this.sDT = sDT;
        this.diaChi = diaChi;
        this.email = email;
    }

    public NhaCungCap() {
        super();
    }

    @Override
    public String toString() {
        return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", sDT=" + sDT + ", diaChi=" + diaChi + ", email="
                + email + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maNCC == null) ? 0 : maNCC.hashCode());
        return result;
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
        NhaCungCap other = (NhaCungCap) obj;
        if (maNCC == null) {
            if (other.maNCC != null) {
                return false;
            }
        } else if (!maNCC.equals(other.maNCC)) {
            return false;
        }
        return true;
    }

}
