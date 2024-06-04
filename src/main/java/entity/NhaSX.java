/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;


public class NhaSX {
    private String maNSX;
    private String tenNSX;

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public NhaSX(String maNSX, String tenNSX) {
        this.maNSX = maNSX;
        this.tenNSX = tenNSX;
    }

    public NhaSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public NhaSX() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.maNSX);
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
        final NhaSX other = (NhaSX) obj;
        if (!Objects.equals(this.maNSX, other.maNSX)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NhaSX{" + "maNSX=" + maNSX + ", tenNSX=" + tenNSX + '}';
    }  
}
