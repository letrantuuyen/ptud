/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;


public class KhachHang {
    private String maKH;
    private String tenKH;
    private String sDT;
    private String diaChi;

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
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

    public KhachHang(String maKH, String tenKH, String sDT, String diaChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sDT = sDT;
        this.diaChi = diaChi;
    }

    public KhachHang(String tenKH, String sDT, String diaChi) {
        this.tenKH = tenKH;
        this.sDT = sDT;
        this.diaChi = diaChi;
    }

    public KhachHang(String maKH) {
        this.maKH = maKH;
    }

    public KhachHang() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.maKH);
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
        final KhachHang other = (KhachHang) obj;
        if (!Objects.equals(this.maKH, other.maKH)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", sDT=" + sDT + ", diaChi=" + diaChi + '}';
    }
    
}
