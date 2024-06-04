/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;


public class MauSac {
    private String maMS;
    private String tenMS;

    public String getMaMS() {
        return maMS;
    }

    public void setMaMS(String maMS) {
        this.maMS = maMS;
    }

    public String getTenMS() {
        return tenMS;
    }

    public void setTenMS(String tenMS) {
        this.tenMS = tenMS;
    }

    public MauSac(String maMS, String tenMS) {
        this.maMS = maMS;
        this.tenMS = tenMS;
    }

    public MauSac(String tenMS) {
        this.tenMS = tenMS;
    }

    public MauSac() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.maMS);
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
        final MauSac other = (MauSac) obj;
        if (!Objects.equals(this.maMS, other.maMS)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MauSac{" + "maMS=" + maMS + ", tenMS=" + tenMS + '}';
    }
    
}
