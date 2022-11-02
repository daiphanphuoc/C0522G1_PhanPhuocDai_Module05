package daiphan.com.model;

public class SoTietKiemDto {


    private int id;

    private String ngayMoSo;

    private String ngayGui;

    private int kyHan;
    private double tienGui;
    private double laiSuat;
    private String uuDai;


    private KhachHang khachHang;

    public SoTietKiemDto() {
    }

    public SoTietKiemDto(String ngayMoSo, String ngayGui, int kyHan, double tienGui, double laiSuat,
                         String uuDai, KhachHang khachHang) {
        this.ngayMoSo = ngayMoSo;
        this.ngayGui = ngayGui;
        this.kyHan = kyHan;
        this.tienGui = tienGui;
        this.laiSuat = laiSuat;
        this.uuDai = uuDai;
        this.khachHang = khachHang;
    }

    public SoTietKiemDto(int id, String ngayMoSo, String ngayGui, int kyHan, double tienGui, double laiSuat,
                         String uuDai, KhachHang khachHang) {
        this.id = id;
        this.ngayMoSo = ngayMoSo;
        this.ngayGui = ngayGui;
        this.kyHan = kyHan;
        this.tienGui = tienGui;
        this.laiSuat = laiSuat;
        this.uuDai = uuDai;
        this.khachHang = khachHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo(String ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
    }

    public int getKyHan() {
        return kyHan;
    }

    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }

    public double getTienGui() {
        return tienGui;
    }

    public void setTienGui(double tienGui) {
        this.tienGui = tienGui;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
