package entity;

import java.util.Objects;

public class SanPham {

    private String maSP;
    private DanhMucSP DanhMuc;
    private String tenSP;
    private MauSac mauSac;
    private ChatLieu chatLieu;
    private NhaSX nSX;
    private KichCo kichCo;
    private int soLuong;
    private Double donGia;
    private NhaCungCap ncc;

    public void setNcc(NhaCungCap ncc) {
        this.ncc = ncc;
    }

    public NhaCungCap getNcc() {
        return ncc;
    }
    private String anh;

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public DanhMucSP getDanhMuc() {
        return DanhMuc;
    }

    public void setDanhMuc(DanhMucSP DanhMuc) {
        this.DanhMuc = DanhMuc;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public ChatLieu getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }

    public NhaSX getnSX() {
        return nSX;
    }

    public void setnSX(NhaSX nSX) {
        this.nSX = nSX;
    }

    public KichCo getKichCo() {
        return kichCo;
    }

    public void setKichCo(KichCo kichCo) {
        this.kichCo = kichCo;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public SanPham(String maSP, DanhMucSP DanhMuc, String tenSP, MauSac mauSac, ChatLieu chatLieu, NhaSX nSX, KichCo kichCo, int soLuong, Double donGia, NhaCungCap ncc, String anh) {
        this.maSP = maSP;
        this.DanhMuc = DanhMuc;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.nSX = nSX;
        this.kichCo = kichCo;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ncc = ncc;
        this.anh = anh;
    }

    public SanPham(DanhMucSP DanhMuc, String tenSP, MauSac mauSac, ChatLieu chatLieu, NhaSX nSX, KichCo kichCo, int soLuong, Double donGia, NhaCungCap ncc, String anh) {
        this.DanhMuc = DanhMuc;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.nSX = nSX;
        this.kichCo = kichCo;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ncc = ncc;
        this.anh = anh;
    }

   

    public SanPham() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.maSP);
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
        final SanPham other = (SanPham) obj;
        if (!Objects.equals(this.maSP, other.maSP)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", DanhMuc=" + DanhMuc + ", tenSP=" + tenSP + ", mauSac=" + mauSac + ", chatLieu=" + chatLieu + ", nSX=" + nSX + ", kichCo=" + kichCo + ", soLuong=" + soLuong + ", donGia=" + donGia + ", ncc=" + ncc + ", anh=" + anh + '}';
    }

    

    
}
