/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import java.util.Objects;


public class CaLam {

    private String maC;
    private String buoi;
    private String tgBD;
    private String tgKT;

    public String getMaC() {
        return maC;
    }

    public void setMaC(String maC) {
        this.maC = maC;
    }

    public String getBuoi() {
        return buoi;
    }

    public void setBuoi(String buoi) {
        this.buoi = buoi;
    }

    public String getTgBD() {
        return tgBD;
    }

    public void setTgBD(String tgBD) {
        this.tgBD = tgBD;
    }

    public String getTgKT() {
        return tgKT;
    }

    public void setTgKT(String tgKT) {
        this.tgKT = tgKT;
    }

    public CaLam(String maC, String buoi, String tgBD, String tgKT) {
        this.maC = maC;
        this.buoi = buoi;
        this.tgBD = tgBD;
        this.tgKT = tgKT;
    }

    public CaLam(String buoi, String tgBD, String tgKT) {
        this.buoi = buoi;
        this.tgBD = tgBD;
        this.tgKT = tgKT;
    }

    public CaLam() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.maC);
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
        final CaLam other = (CaLam) obj;
        if (!Objects.equals(this.maC, other.maC)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CaLam{" + "maC=" + maC + ", buoi=" + buoi + ", tgBD=" + tgBD + ", tgKT=" + tgKT + '}';
    }

}
