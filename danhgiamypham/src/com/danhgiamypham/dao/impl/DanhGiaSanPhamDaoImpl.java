package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.DanhGiaSanPhamDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.DanhGiaSanPham;
import com.danhgiamypham.model.LuotLike;
import com.danhgiamypham.model.SanPham;

@Component
public class DanhGiaSanPhamDaoImpl implements DanhGiaSanPhamDao {

	@Autowired
	private DBProvider dbProvider;

	@Override
	public ResponseData<List<DanhGiaSanPham>> getDanhGiaSanPham(String link) {
		ResponseData<List<DanhGiaSanPham>> response = new ResponseData<List<DanhGiaSanPham>>();
		List<DanhGiaSanPham> danhGiaSanPhams = new ArrayList<DanhGiaSanPham>();

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getDanhGia(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, link);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maDG  = rs.getInt("MaDanhGia");
				int diemDG = rs.getInt("DiemDanhGia");
				String binhL = rs.getString("BinhLuan");
				int soLL = rs.getInt("SoLuotLike");
				int tinhT = rs.getInt("TinhTrang");
				Date ngayGN = rs.getDate("NgayGiaNhap");
				String tenDD = rs.getString("TenDienDan");
				String hinhAnh = rs.getString("HinhAnh");
				int maNDG  = rs.getInt("MaNguoiDung");
				int nDBL = rs.getInt("LuotBinhLuan");
				int nDT = rs.getInt("LuotThich");
				
				DanhGiaSanPham blsp = new DanhGiaSanPham(maDG, diemDG, binhL, soLL, tinhT,ngayGN, tenDD, hinhAnh,maNDG,nDBL, nDT);
				danhGiaSanPhams.add(blsp);			
			}
			response.setData(danhGiaSanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getDanhGiaSanPham bi loi");
		}
		return response;

	}
	
	@Override
	public ResponseData<List<String>> getHinhAnhBinhLuan(int maDG) {
		ResponseData<List<String>> response = new ResponseData<List<String>>();
		List<String> hinhAnhList = new ArrayList<String>();

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getHinhAnhBinhLuan(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDG);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String hinhAnh = rs.getString("HinhAnh");
				hinhAnhList.add(hinhAnh);			
			}
			response.setData(hinhAnhList);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getHinhAnhBinhLuan bi loi");
		}
		return response;
	}

	@Override
	public ResponseData<LuotLike> getLuotLike(int maDanhGia, int maND) {
		ResponseData<LuotLike> response = new ResponseData<LuotLike>();
		LuotLike luotLike = null;

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getLuotLike(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDanhGia);
			st.setInt(2, maND);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int daLike = rs.getInt("DaLike");

				luotLike = new LuotLike(daLike);
			}
			response.setData(luotLike);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getLuotLike bi loi");
		}
		return response;

	}

}