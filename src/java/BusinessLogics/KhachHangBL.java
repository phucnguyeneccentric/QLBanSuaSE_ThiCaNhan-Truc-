/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogics;

import JavaBeans.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WIN
 */
public class KhachHangBL {

    public static void them(KhachHang kh) {
        Connection con = CSDL.ketNoi();
        String sql = "insert into khach_hang(ma_khach_hang, ten_khach_hang, phai, dia_chi, dien_thoai, email) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMaKhachHang());
            ps.setString(2, kh.getTenKhachHang());
            ps.setBoolean(3, kh.isPhai());
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, kh.getDienThoai());
            ps.setString(6, kh.getEmail());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
