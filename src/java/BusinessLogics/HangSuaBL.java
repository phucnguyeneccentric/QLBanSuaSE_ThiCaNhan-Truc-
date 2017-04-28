/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogics;

import JavaBeans.HangSua;
import java.sql.Connection;
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
public class HangSuaBL {

    public static List<HangSua> docTatCa() {
        Connection con = CSDL.ketNoi();
        List<HangSua> dshs = new ArrayList<>();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from hang_sua");
            while (rs.next()) {
                HangSua hs = new HangSua();
                hs.setMaHangSua(rs.getString("ma_hang_sua"));
                hs.setTenHangSua(rs.getString("ten_hang_sua"));
                hs.setDiaChi(rs.getString("dia_chi"));
                hs.setDienThoai(rs.getString("dien_thoai"));
                hs.setEmail(rs.getString("email"));
                dshs.add(hs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangSuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dshs;
    }
}
