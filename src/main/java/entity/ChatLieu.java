/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;


public class ChatLieu {
    private String maCL;
    private String tenCL;

    public String getMaCL() {
        return maCL;
    }

    public void setMaCL(String maCL) {
        this.maCL = maCL;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }

    public ChatLieu(String maCL, String tenCL) {
        this.maCL = maCL;
        this.tenCL = tenCL;
    }

    public ChatLieu(String tenCL) {
        this.tenCL = tenCL;
    }

    public ChatLieu() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.maCL);
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
        final ChatLieu other = (ChatLieu) obj;
        if (!Objects.equals(this.maCL, other.maCL)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ChatLieu{" + "maCL=" + maCL + ", tenCL=" + tenCL + '}';
    }
    
}
