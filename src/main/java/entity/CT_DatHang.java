/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class CT_DatHang {

    private int soLuong;
    private double thanhTien;
    private DatHang DatHang;
    private SanPham sanPham;

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public DatHang getDatHang() {
        return DatHang;
    }

    public void setDatHang(DatHang DatHang) {
        this.DatHang = DatHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public CT_DatHang(int soLuong, double thanhTien, DatHang DatHang, SanPham sanPham) {
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.DatHang = DatHang;
        this.sanPham = sanPham;
    }

    public CT_DatHang() {
    }

    @Override
    public String toString() {
        return "CT_DatHang{" + "soLuong=" + soLuong + ", thanhTien=" + thanhTien + ", DatHang=" + DatHang + ", sanPham=" + sanPham + '}';
    }

    
}
