/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;


public class ChucVu {

    private String maCV;
    private String tenCV;
    private double luong;

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public ChucVu(String maCV, String tenCV, double luong) {
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.luong = luong;
    }

    public ChucVu(String tenCV, double luong) {
        this.tenCV = tenCV;
        this.luong = luong;
    }

    public ChucVu() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.maCV);
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
        final ChucVu other = (ChucVu) obj;
        if (!Objects.equals(this.maCV, other.maCV)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ChucVu{" + "maCV=" + maCV + ", tenCV=" + tenCV + ", luong=" + luong + '}';
    }

}
