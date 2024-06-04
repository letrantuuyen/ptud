package entity;

public class CT_HDBanHang {

    private int soLuong;
    private double thanhTien;
    private HDBanHang hoaDonBH;
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

    public HDBanHang getHoaDonBH() {
        return hoaDonBH;
    }

    public void setHoaDonBH(HDBanHang hoaDonBH) {
        this.hoaDonBH = hoaDonBH;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public CT_HDBanHang(int soLuong, double thanhTien, HDBanHang hoaDonBH, SanPham sanPham) {
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.hoaDonBH = hoaDonBH;
        this.sanPham = sanPham;
    }

    public CT_HDBanHang() {
    }

    @Override
    public String toString() {
        return "CT_HDBanHang{" + "soLuong=" + soLuong + ", thanhTien=" + thanhTien + ", hoaDonBH=" + hoaDonBH + ", sanPham=" + sanPham + '}';
    }

    
}
