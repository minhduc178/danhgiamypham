package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.SanPhamMoiDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.HinhAnhSanPham;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPham;
import com.danhgiamypham.model.SanPhamMoi;

@Component
public class SanPhamMoiDaoImpl implements SanPhamMoiDao {

	@Autowired
	private DBProvider dbProvider;

	@Override
	public ResponseData<List<Hang>> getHang() {
		ResponseData<List<Hang>> response = new ResponseData<List<Hang>>();
		List<Hang> hangs = new ArrayList<Hang>();
		try {
			Connection cnn = dbProvider.getConnection();
			Statement st = cnn.createStatement();
			String sql = "{call getHang()}";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int maH = rs.getInt("MaHang");
				String tenH = rs.getString("TenHang");
				int maNH = rs.getInt("MaNhomHang");

				Hang nh = new Hang(maH, tenH, maNH);
				hangs.add(nh);
			}
			response.setData(hangs);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getHang bi loi");
		}
		return response;
	}
	
	
	@Override
	public ResponseData<List<NhomSanPham>> getNhomSanPhamTheoDanhMuc(int maDanhMuc) {
		ResponseData<List<NhomSanPham>> response = new ResponseData<List<NhomSanPham>>();
		List<NhomSanPham> nhomSanPhams = new ArrayList<NhomSanPham>();

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getNhomSanPhamTheoDanhMuc(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDanhMuc);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maNSP = rs.getInt("MaNhomSanPham");
				String tenN = rs.getString("TenNhom");

				NhomSanPham nh = new NhomSanPham(maNSP, tenN);
				nhomSanPhams.add(nh);
			}
			response.setData(nhomSanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getNhomSanPhamTheoDanhMuc bi loi");
		}
		return response;

	}
	
	@Override
	public ResponseData<List<NhomSanPham>> getNhomSanPhamTheoSP(int maSP, int MaDanhMuc) {
		ResponseData<List<NhomSanPham>> response = new ResponseData<List<NhomSanPham>>();
		List<NhomSanPham> nhomSanPhams = new ArrayList<NhomSanPham>();

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getNhomSanPhamTheoSanPham(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			st.setInt(2, MaDanhMuc);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maNSP = rs.getInt("MaNhomSanPham");
				String tenN = rs.getString("TenNhom");

				NhomSanPham nh = new NhomSanPham(maNSP, tenN);
				nhomSanPhams.add(nh);		
			}
			response.setData(nhomSanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getNhomSanPhamTheoSP bi loi");

		}
		return response;

	}
	
	@Override
	public ResponseData<Boolean> themSanPham(SanPhamMoi spm) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themSanPham(?,?,?,?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, spm.getTenSanPham());
			st.setInt(2, spm.getMaHang());
			st.setString(3, spm.getGioiThieu());
			st.setString(4, spm.getCongDung());
			st.setString(5, spm.getCachSuDung());
			st.setString(6, spm.getThanhPhan());
			st.setInt(7, spm.getMaNguoiDung());

			int rs  = st.executeUpdate();
			
			if(rs==1){
				response.setData( true);
			} 
			int id = getMaxMaSanPham();
			spm.setMaSanPham(id);
			
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("themSanPham bi loi");
		}
		return response;

	}
	
	public int getMaxMaSanPham() {
		int id = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getMaxMaSanPham()}";
			PreparedStatement st = cnn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				id = rs.getInt("MaxMaSanPham");
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public ResponseData<Boolean> themHinhAnhMoi(HinhAnhSanPham hasp){
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themHinhAnhMoi(?,?,?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, hasp.getMaSanPham()); 
			st.setString(2, hasp.getHinhAnhChinh());
			st.setString(3, hasp.getHinh1());
			st.setString(4, hasp.getHinh2());
			st.setString(5, hasp.getHinh3());
			st.setString(6, hasp.getHinh4());
		
			int rs  = st.executeUpdate();
			
			if(rs==1){
				response.setData(true);
			} 
			
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@Override
	public  ResponseData<Boolean> themNhomSanPhamMoi(int maSP, int maNhom) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themSanPhamNhomSanPham(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			st.setInt(2,maNhom);
			int rs = st.executeUpdate();

			if (rs == 1) {
				response.setData(true);
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("themNhomSanPhamMoi bi loi");
		}
		return response;
	}
	
	
	@Override
	public ResponseData<Boolean> capNhatSanPham(SanPham spm) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call capNhatSanPhamSua(?,?,?,?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, spm.getMaSanPham());
			st.setString(2, spm.getTenSanPham());
			st.setInt(3, spm.getMaHang());
			st.setString(4, spm.getGioiThieu());
			st.setString(5, spm.getCongDung());
			st.setString(6, spm.getCachSuDung());
			st.setString(7, spm.getThanhPhan());

			int rs  = st.executeUpdate();
			
			if(rs==1){
				response.setData(true);
			} 
			
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("capNhatSanPham bi loi");

		}
		return response;

	}
	
	public ResponseData<Boolean> capNhatHinhAnh(int maSP, HinhAnhSanPham hasp){
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call capNhatHinhAnh(?,?,?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, hasp.getMaSanPham()); 
			st.setString(2, hasp.getHinhAnhChinh());
			st.setString(3, hasp.getHinh1());
			st.setString(4, hasp.getHinh2());
			st.setString(5, hasp.getHinh3());
			st.setString(6, hasp.getHinh4());
		
			int rs  = st.executeUpdate();
			
			if(rs==1){
				response.setData(true);
			} 
			
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("capNhatHinhAnh bi loi");
		}
		return response;
	}
	
	@Override
	public ResponseData<Boolean> capNhatNhomSanPham(int maSP, int maNhom) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call capNhatSanPhamNhomSanPham(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			st.setInt(2,maNhom);
			int rs = st.executeUpdate();

			if (rs == 1) {
				response.setData(true);
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("capNhatNhomSanPham bi loi");
		}
		return response;
	}
	

	@Override
	public ResponseData<Boolean> xoaHinhAnhSanPham(int maSP) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call xoaHinhAnhSanPham(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			int rs = st.executeUpdate();
			if (rs == 1) {
				response.setData(true);
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("xoaHinhAnhSanPham bi loi");
		}
		return response;
	}
	
	@Override
	public ResponseData<Boolean> xoaNhomSanPham(int maSP){
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call xoaNhomSanPham(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			int rs = st.executeUpdate();
			if (rs == 1) {
				response.setData(true);
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("xoaNhomSanPham bi loi");
		}
		return response;
	}
	
	
	
	
	


}