package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.CauHoiDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.CauHoi;
import com.danhgiamypham.model.CauTraLoi;
import com.danhgiamypham.model.NhomCauHoi;

@Component
public class CauHoiDaoImpl implements CauHoiDao {

	// Thay vi tao moi dbProvider thi khai bao trong danhgiamypham-servlet:
	// id.....
	@Autowired
	private DBProvider dbProvider;

	@Override
	public ResponseData<Boolean> themCauHoi(CauHoi ch) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themCauHoi(?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, ch.getMaNguoiDung());
			st.setInt(2, ch.getMaNhomCauHoi());
			st.setString(3, ch.getTieuDe());
			st.setString(4, ch.getNoiDung());

			int rs = st.executeUpdate();

			if (rs == 1) {
				response.setData(true);
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("themCauHoi bi loi");
		}
		return response;

	}
	
	
	@Override
	public ResponseData<List<NhomCauHoi>> getNhomCauHoi() {
		ResponseData<List<NhomCauHoi>> response = new ResponseData<List<NhomCauHoi>>();
		List<NhomCauHoi> nhomCauHois = new ArrayList<NhomCauHoi>();
		try {
			Connection cnn = dbProvider.getConnection();
			Statement st = cnn.createStatement();
			String sql = "{call getNhomCauHoi()}";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int maNCH = rs.getInt("MaNhomCauHoi");
				String tenNCH = rs.getString("TenNhomCauHoi");

				NhomCauHoi nch = new NhomCauHoi(maNCH, tenNCH);
				nhomCauHois.add(nch);
			}
			response.setData(nhomCauHois);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getNhomCauHoi bi loi");
		}
		return response;
	}
	

	@Override
	public ResponseData<Set<CauHoi>> getCauHoiTheoNhom(int maNhomBoPhan, int maNhomCauHoi) {
		ResponseData<Set<CauHoi>> response = new ResponseData<Set<CauHoi>>();
		Set<CauHoi> cauHois = new HashSet<CauHoi>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getCauHoiTheoNhom(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maNhomBoPhan);
			st.setInt(2, maNhomCauHoi);
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maCH = rs.getInt("MaCauHoi");
				String tenDN = rs.getString("TenDangNhap");
				int maNCH = rs.getInt("MaNhomCauHoi");
				String tieuD = rs.getString("TieuDe");
				String noiD = rs.getString("NoiDung");
				Date ngayD =  rs.getDate("NgayDang");
				int soLCL = rs.getInt("SoLuotClick");
				int soLL = rs.getInt("SoLuotLike");
				
				CauHoi ch = new CauHoi(maCH, tenDN, maNCH, tieuD, noiD, ngayD, soLCL, soLL);
				 cauHois.add(ch);
			}
			response.setData(cauHois);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getCauHoiTheoNhom bi loi");
		}
		return response;

	}
	

	@Override
	public ResponseData<Set<CauHoi>> getCauHoi(int mch) {
		ResponseData<Set<CauHoi>> response = new ResponseData<Set<CauHoi>>();
		Set<CauHoi> cauHois = new HashSet<CauHoi>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getCauHoi(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, mch);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maCH = rs.getInt("MaCauHoi");
				String tenDN = rs.getString("TenDangNhap");
				int maNCH = rs.getInt("MaNhomCauHoi");
				String tieuD = rs.getString("TieuDe");
				String noiD = rs.getString("NoiDung");
				Date ngayD =  rs.getDate("NgayDang");
				int soLCL = rs.getInt("SoLuotClick");
				int soLL = rs.getInt("SoLuotLike");

				CauHoi ch = new CauHoi(maCH, tenDN, maNCH, tieuD, noiD, ngayD, soLCL, soLL);
				cauHois.add(ch);
			}
			response.setData(cauHois);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getCauHoi bi loi");
		}
		return response;
	}
	
	
	@Override
	public  ResponseData<List<CauTraLoi>> getCauTraLoi(int maCH) {
		ResponseData<List<CauTraLoi>> response = new ResponseData<List<CauTraLoi>>();
		List<CauTraLoi> cauTraLois = new ArrayList<CauTraLoi>();

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getCauTraLoi(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maCH);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				maCH  =  rs.getInt("MaCauHoi");
				String noiD = rs.getString("NoiDung");
				int soLT = rs.getInt("SoLuotThich");
				String tenDN = rs.getString("TenDangNhap");
				Date ngayD = rs.getDate("NgayDang");
				
				CauTraLoi ctloi = new CauTraLoi(maCH, noiD, soLT, tenDN, ngayD);
				cauTraLois.add(ctloi);
			}
			response.setData(cauTraLois);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getCauTraLoi bi loi");
		}
		return response;

	}
}
