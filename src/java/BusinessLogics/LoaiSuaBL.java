/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogics;

import JavaBeans.LoaiSua;
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
public class LoaiSuaBL {

    public static List<LoaiSua> docTatCa() {
        Connection con = CSDL.ketNoi();
        List<LoaiSua> dsls = new ArrayList<>();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from loai_sua");
            while (rs.next()) {
                LoaiSua ls = new LoaiSua();
                ls.setMaLoaiSua(rs.getString("ma_loai_sua"));
                ls.setTenLoai(rs.getString("ten_loai"));
                dsls.add(ls);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsls;
    }
}
