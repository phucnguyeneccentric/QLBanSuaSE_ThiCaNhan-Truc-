/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BusinessLogics.HangSuaBL;
import BusinessLogics.LoaiSuaBL;
import BusinessLogics.SuaBL;
import JavaBeans.HangSua;
import JavaBeans.LoaiSua;
import JavaBeans.Sua;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hv
 */
@WebServlet(name = "DanhSachSuaServlet", urlPatterns = {"/DanhSachSuaServlet"})
public class DanhSachSuaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        List<HangSua> dshs = HangSuaBL.docTatCa();
        request.setAttribute("dshs", dshs);

        List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
        request.setAttribute("dsls", dsls);

        int tongSoTrang, suaHienThi, suaDauTrang, trang, tongSoSua;
        suaHienThi = 5;
        suaDauTrang = 0;
        tongSoSua = SuaBL.soSuaTheoHang("AB");
        if (request.getParameter("trang") != null) {
            trang = Integer.parseInt(request.getParameter("trang"));
            suaDauTrang = (trang - 1) * suaHienThi;
        }
        List<Sua> dss = SuaBL.docTheoHang("AB", suaDauTrang, suaHienThi);
        String maHangSua = request.getParameter("maHang");
        String maLoaiSua = request.getParameter("maLoai");
        if (maHangSua != null) {
            dss = SuaBL.docTheoHang(maHangSua, suaDauTrang, suaHienThi);
            tongSoSua = SuaBL.soSuaTheoHang(maHangSua);
        }
        if (maLoaiSua != null) {
            dss = SuaBL.docTheoLoai(maLoaiSua, suaDauTrang, suaHienThi);
            tongSoSua = SuaBL.soSuaTheoLoai(maLoaiSua);
        }
        tongSoTrang = (tongSoSua % suaHienThi == 0) ? tongSoSua / suaHienThi : (tongSoSua / suaHienThi) + 1;
        request.setAttribute("tongSoTrang", tongSoTrang);
        request.setAttribute("dss", dss);

        request.getRequestDispatcher("Views/danh-sach-sua.jsp").include(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
