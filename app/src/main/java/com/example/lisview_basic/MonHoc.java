package com.example.lisview_basic;

public class MonHoc {


    private String tenMonHoc;
    private String soTinChi;

    public MonHoc(String tenMonHoc, String soTinChi) {
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }

    public MonHoc() {
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(String soTinChi) {
        this.soTinChi = soTinChi;
    }
}
