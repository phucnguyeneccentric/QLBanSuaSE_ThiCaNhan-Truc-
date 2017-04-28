<%-- 
    Document   : them-sua-moi
    Created on : Apr 14, 2017, 3:12:53 PM
    Author     : NHQ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page2" class="main">
    <div class="col1 thuc-don">
        <%@include  file="thuc-don.jsp" %>
    </div>
    <div class="col2">
        <form name="frmThemSua" action="trang-them-sua-moi.jsp" method="post">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Mã sữa: </td>
                        <td><input type="text" name="txtMaSua" value="${sua.maSua}" /></td>
                    </tr>
                    <tr>
                        <td>Tên sữa: </td>
                        <td><input type="text" name="txtTenSua" value="${sua.tenSua}" /></td>
                    </tr>
                    <tr>
                        <td>Hãng sữa: </td>
                        <td><select name="cboHangSua">
                                <c:forEach items="${dshs}" var="hs">
                                    <option value="${hs.maHangSua}">${hs.tenHangSua}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Lọai sữa: </td>
                        <td><select name="cboLoaiSua">
                                <c:forEach items="${dsls}" var="ls">
                                    <option value="${ls.maLoaiSua}">${ls.tenLoai}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Trọng lượng: </td>
                        <td><input type="text" name="txtTrongLuong" value="${sua.trongLuong}" /></td>
                    </tr>
                    <tr>
                        <td>Đơn giá: </td>
                        <td><input type="text" name="txtDonGia" value="${sua.donGia}" /></td>
                    </tr>
                    <tr>
                        <td>TP dinh dưỡng: </td>
                        <td><textarea name="txtTPDinhDuong" rows="4" cols="20">${sua.tpDinhDuong}</textarea></td>
                    </tr>
                    <tr>
                        <td>Lợi ích: </td>
                        <td><textarea name="txtLoiIch" rows="4" cols="20">${sua.loiIch}</textarea></td>
                    </tr>
                    <tr>
                        <td>Hình ảnh: </td>
                        <td><input type="file" name="txtHinh" value="${sua.hinh}" width="50" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Thêm mới" name="btnThemMoi" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>                 
    </div>
</div>