/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import java.io.Serializable;

/**
 *
 * @author hv
 */
public class HangSua implements Serializable {

    private String maHangSua;
    private String tenHangSua;
    private String diaChi;
    private String dienThoai;
    private String email;

    public String getMaHangSua() {
        return maHangSua;
    }

    public void setMaHangSua(String maHangSua) {
        this.maHangSua = maHangSua;
    }

    public String getTenHangSua() {
        return tenHangSua;
    }

    public void setTenHangSua(String tenHangSua) {
        this.tenHangSua = tenHangSua;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HangSua() {
        
    }

}
