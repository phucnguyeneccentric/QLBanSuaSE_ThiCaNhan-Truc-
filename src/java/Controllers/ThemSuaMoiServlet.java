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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NHQ
 */
@WebServlet(name = "ThemSuaMoiServlet", urlPatterns = {"/ThemSuaMoiServlet"})
public class ThemSuaMoiServlet extends HttpServlet {

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
        List<LoaiSua> dsls = LoaiSuaBL.docTatCa();

        request.setAttribute("dshs", dshs);
        request.setAttribute("dsls", dsls);
        Sua sua = null;
        if (request.getParameter("btnThemMoi") != null) {
            sua = new Sua();
            sua.setMaSua(request.getParameter("txtMaSua"));
            sua.setTenSua(request.getParameter("txtTenSua"));
            sua.setMaHangSua(request.getParameter("cboHangSua"));
            sua.setMaLoaiSua(request.getParameter("cboLoaiSua"));
            sua.setTrongLuong(Integer.parseInt(request.getParameter("txtTrongLuong")));
            sua.setDonGia(Integer.parseInt(request.getParameter("txtDonGia")));
            sua.setTpDinhDuong(request.getParameter("txtTPDinhDuong"));
            sua.setLoiIch(request.getParameter("txtLoiIch"));
            sua.setHinh(request.getParameter("txtHinh"));
            SuaBL.them(sua);
        }
        request.setAttribute("sua", sua);
        request.getRequestDispatcher("Views/them-sua-moi.jsp").include(request, response);
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
