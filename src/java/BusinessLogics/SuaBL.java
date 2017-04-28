/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogics;

import JavaBeans.Sua;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hv
 */
public class SuaBL {

    public static List<Sua> docTheoHang(String maHangSua, int top, int max) {
        Connection con = CSDL.ketNoi();
        List<Sua> dss = new ArrayList<>();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from sua where ma_hang_sua = '" + maHangSua + "' limit " + top + "," + max);
            while (rs.next()) {
                Sua sua = new Sua();
                sua.setMaSua(rs.getString("ma_sua"));
                sua.setTenSua(rs.getString("ten_sua"));
                sua.setMaHangSua(rs.getString("ma_hang_sua"));
                sua.setMaLoaiSua(rs.getString("ma_loai_sua"));
                sua.setTrongLuong(rs.getInt("trong_luong"));
                sua.setDonGia(rs.getInt("don_gia"));
                sua.setTpDinhDuong(rs.getString("tp_dinh_duong"));
                sua.setLoiIch(rs.getString("loi_ich"));
                sua.setHinh(rs.getString("hinh"));
                dss.add(sua);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dss;
    }

    public static List<Sua> docTheoLoai(String maLoaiSua, int top, int max) {
        Connection con = CSDL.ketNoi();
        List<Sua> dss = new ArrayList<>();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from sua where ma_loai_sua = '" + maLoaiSua + "' limit " + top + "," + max);
            while (rs.next()) {
                Sua sua = new Sua();
                sua.setMaSua(rs.getString("ma_sua"));
                sua.setTenSua(rs.getString("ten_sua"));
                sua.setMaHangSua(rs.getString("ma_hang_sua"));
                sua.setMaLoaiSua(rs.getString("ma_loai_sua"));
                sua.setTrongLuong(rs.getInt("trong_luong"));
                sua.setDonGia(rs.getInt("don_gia"));
                sua.setTpDinhDuong(rs.getString("tp_dinh_duong"));
                sua.setLoiIch(rs.getString("loi_ich"));
                sua.setHinh(rs.getString("hinh"));
                dss.add(sua);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dss;
    }

    public static int soSuaTheoHang(String maHangSua) {
        Connection con = CSDL.ketNoi();
        int soSua = 0;
        try {
            ResultSet rs = con.createStatement().executeQuery("select count(*) as so_sua from sua where ma_hang_sua = '" + maHangSua + "'");
            rs.next();
            soSua = rs.getInt("so_sua");
        } catch (SQLException ex) {
            Logger.getLogger(SuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soSua;
    }

    public static int soSuaTheoLoai(String maLoaiSua) {
        Connection con = CSDL.ketNoi();
        int soSua = 0;
        try {
            ResultSet rs = con.createStatement().executeQuery("select count(*) as so_sua from sua where ma_loai_sua = '" + maLoaiSua + "'");
            rs.next();
            soSua = rs.getInt("so_sua");
        } catch (SQLException ex) {
            Logger.getLogger(SuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soSua;
    }

    public static void them(Sua sua) {
        Connection con = CSDL.ketNoi();
        try {
            PreparedStatement ps = con.prepareStatement("insert into sua(ma_sua,ten_sua,ma_hang_sua,ma_loai_sua,trong_luong,don_gia,tp_dinh_duong,loi_ich,hinh) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, sua.getMaSua());
            ps.setString(2, sua.getTenSua());
            ps.setString(3, sua.getMaHangSua());
            ps.setString(4, sua.getMaLoaiSua());
            ps.setInt(5, sua.getTrongLuong());
            ps.setInt(6, sua.getDonGia());
            ps.setString(7, sua.getTpDinhDuong());
            ps.setString(8, sua.getLoiIch());
            ps.setString(9, sua.getHinh());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<Sua> suaBanChay(int suaHienThi) {
        Connection con = CSDL.ketNoi();
        String sql = "select s.*, sum(so_luong) as sl from sua s inner join ct_hoadon cthd on s.ma_sua = cthd.ma_sua group by ma_sua, ten_sua order by sl desc limit 0," + suaHienThi;
        List<Sua> dss = new ArrayList<>();
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                Sua sua = new Sua();
                sua.setMaSua(rs.getString("ma_sua"));
                sua.setTenSua(rs.getString("ten_sua"));
                sua.setMaHangSua(rs.getString("ma_hang_sua"));
                sua.setMaLoaiSua(rs.getString("ma_loai_sua"));
                sua.setTrongLuong(rs.getInt("trong_luong"));
                sua.setDonGia(rs.getInt("don_gia"));
                sua.setTpDinhDuong(rs.getString("tp_dinh_duong"));
                sua.setLoiIch(rs.getString("loi_ich"));
                sua.setHinh(rs.getString("hinh"));
                dss.add(sua);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dss;
    }

    public static Sua timSuaTheoMa(String maSua) {
        Connection con = CSDL.ketNoi();
        Sua sua = null;
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from sua where ma_sua = '" + maSua + "'");
            rs.next();
            sua = new Sua();
            sua.setMaSua(rs.getString("ma_sua"));
            sua.setTenSua(rs.getString("ten_sua"));
            sua.setMaHangSua(rs.getString("ma_hang_sua"));
            sua.setMaLoaiSua(rs.getString("ma_loai_sua"));
            sua.setTrongLuong(rs.getInt("trong_luong"));
            sua.setDonGia(rs.getInt("don_gia"));
            sua.setTpDinhDuong(rs.getString("tp_dinh_duong"));
            sua.setLoiIch(rs.getString("loi_ich"));
            sua.setHinh(rs.getString("hinh"));
        } catch (SQLException ex) {
            Logger.getLogger(SuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sua;
    }

    public static List<Sua> timSuaTheoTenHangLoai(String tenSua, String maHangSua, String maLoaiSua) {
        Connection con = CSDL.ketNoi();
        List<Sua> dss = new ArrayList<>();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from sua where ten_sua like '%" + tenSua + "%' and ma_hang_sua = '" + maHangSua + "' and ma_loai_sua = '" + maLoaiSua + "'");
            while (rs.next()) {
                Sua sua = new Sua();
                sua.setMaSua(rs.getString("ma_sua"));
                sua.setTenSua(rs.getString("ten_sua"));
                sua.setMaHangSua(rs.getString("ma_hang_sua"));
                sua.setMaLoaiSua(rs.getString("ma_loai_sua"));
                sua.setTrongLuong(rs.getInt("trong_luong"));
                sua.setDonGia(rs.getInt("don_gia"));
                sua.setTpDinhDuong(rs.getString("tp_dinh_duong"));
                sua.setLoiIch(rs.getString("loi_ich"));
                sua.setHinh(rs.getString("hinh"));
                dss.add(sua);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dss;
    }
}
