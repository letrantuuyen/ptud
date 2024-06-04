package entity;

public class CT_HDNhapHang {

    private int soLuong;
    private double donGia;
    private HDNhapHang hoaDonNH;
    private SanPham sanPham;

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public HDNhapHang getHoaDonNH() {
        return hoaDonNH;
    }

    public void setHoaDonNH(HDNhapHang hoaDonNH) {
        this.hoaDonNH = hoaDonNH;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public CT_HDNhapHang(int soLuong, double donGia, HDNhapHang hoaDonNH, SanPham sanPham) {
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.hoaDonNH = hoaDonNH;
        this.sanPham = sanPham;
    }

    public CT_HDNhapHang() {
    }

    @Override
    public String toString() {
        return "CT_HDNhapHang{" + "soLuong=" + soLuong + ", donGia=" + donGia + ", hoaDonNH=" + hoaDonNH + ", sanPham=" + sanPham + '}';
    }

}
