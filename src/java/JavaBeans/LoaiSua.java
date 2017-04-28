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
public class LoaiSua implements Serializable {

    private String maLoaiSua;
    private String tenLoai;

    public LoaiSua() {
    }

    public String getMaLoaiSua() {
        return maLoaiSua;
    }

    public void setMaLoaiSua(String maLoaiSua) {
        this.maLoaiSua = maLoaiSua;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

}
