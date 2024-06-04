/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;


public class KichCo {

    private String maKC;
    private String tenKC;

    public String getMaKC() {
        return maKC;
    }

    public void setMaKC(String maKC) {
        this.maKC = maKC;
    }

    public String getTenKC() {
        return tenKC;
    }

    public void setTenKC(String tenKC) {
        this.tenKC = tenKC;
    }

    public KichCo(String maKC, String tenKC) {
        this.maKC = maKC;
        this.tenKC = tenKC;
    }

    public KichCo(String tenKC) {
        this.tenKC = tenKC;
    }

    public KichCo() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.maKC);
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
        final KichCo other = (KichCo) obj;
        if (!Objects.equals(this.maKC, other.maKC)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KichCo{" + "maKC=" + maKC + ", tenKC=" + tenKC + '}';
    }

}
