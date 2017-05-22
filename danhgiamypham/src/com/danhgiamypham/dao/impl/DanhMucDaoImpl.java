package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.DanhMucDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;
import com.danhgiamypham.model.NhomSanPham;

@Component
public class DanhMucDaoImpl implements DanhMucDao {

	Logger logger = Logger.getLogger("DanhMucDaoImpl");
	@Autowired
	private DBProvider dbProvider;

	@Override
	public ResponseData<List<DanhMuc>> getAll() {
		ResponseData<List<DanhMuc>> response = new ResponseData<List<DanhMuc>>();
		List<DanhMuc> danhMucs = new ArrayList<DanhMuc>();
		try {
			logger.log(Level.INFO, "db provider is null: "
					+ (dbProvider == null));
			Connection cnn = dbProvider.getConnection();
			Statement st = cnn.createStatement();
			String sql = "{call getAll()}";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int maDM = rs.getInt("MaDanhMuc");
				String tenDM = rs.getString("TenDanhMuc");
				String link = rs.getString("Link");
				DanhMuc dm = new DanhMuc(maDM, tenDM, link);
				danhMucs.add(dm);
			}
			response.setData(danhMucs);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getAll bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<List<NhomSanPham>> getNhomSanPham() {
		ResponseData<List<NhomSanPham>> response = new ResponseData<List<NhomSanPham>>();
		List<NhomSanPham> nhomSanPhams = new ArrayList<NhomSanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			Statement st = cnn.createStatement();
			String sql = "{call getNhomSanPham()}";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int maNSP = rs.getInt("MaNhomSanPham");
				String tenNSP = rs.getString("TenNhom");
				int maDM = rs.getInt("MaDanhMuc");
				NhomSanPham nsp = new NhomSanPham(maNSP, tenNSP, maDM);
				nhomSanPhams.add(nsp);
			}
			response.setData(nhomSanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getNhomSanPham bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<Boolean> themNhomSanPham(int maDanhMuc, String tenNhomSanPham) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themNhomSanPham(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDanhMuc);
			st.setString(2, tenNhomSanPham);

			int rs = st.executeUpdate();

			if (rs == 1) {
				response.setData(true);
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("themNhomSanPham bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<List<NhomHang>> getNhomHang() {
		ResponseData<List<NhomHang>> response = new ResponseData<List<NhomHang>>();
		List<NhomHang> nhomHangs = new ArrayList<NhomHang>();
		try {
			Connection cnn = dbProvider.getConnection();
			Statement st = cnn.createStatement();
			String sql = "{call getNhomHang()}";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int maNH = rs.getInt("MaNhomSanPham");
				String tenNH = rs.getString("TenNhom");

				NhomHang nh = new NhomHang(maNH, tenNH);
				nhomHangs.add(nh);
			}
			response.setData(nhomHangs);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getNhomHang bi loi");
		}
		return response;

	}

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
	public ResponseData<Boolean> themHang(String tenHang, int maNhomSanPham) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themHang(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, tenHang);
			st.setInt(2, maNhomSanPham);

			int rs = st.executeUpdate();

			if (rs == 1) {
				response.setData(true);
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("themHang bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<List<Hang>> getHangTheoNhom(int maNhomHang) {
		ResponseData<List<Hang>> response = new ResponseData<List<Hang>>();
		List<Hang> hangs = new ArrayList<Hang>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getHangTheoNhom(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maNhomHang);
			ResultSet rs = st.executeQuery();
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
			response.setErrorMessage("getHangTheoNhom bi loi");
		}
		return response;
	}

}
