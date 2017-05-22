package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.HoiDapDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.HoiDap;

@Component
public class HoiDapDaoImpl implements HoiDapDao {

	// Thay vi tao moi dbProvider thi khai bao trong danhgiamypham-servlet:
	// id.....
	@Autowired
	private DBProvider dbProvider;

	@Override
	public  ResponseData<List<HoiDap>> getHoiDap() {
		ResponseData<List<HoiDap>> response = new ResponseData<List<HoiDap>>();
		List<HoiDap> hoiDaps = new ArrayList<HoiDap>();
		try {
			Connection cnn = dbProvider.getConnection();
			Statement st = cnn.createStatement();
			String sql = "{call getHoiDap()}";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int maHD = rs.getInt("MaHoiDap");
				String cauH = rs.getString("CauHoi");
				String noiD = rs.getString("NoiDung");
				String tenMD = rs.getString("TenMucDang");
				String tenND = rs.getString("TenNguoiDung");
				Date ngayD = rs.getDate("NgayDang");
				int soLTL = rs.getInt("SoLuotTraLoi");
				int soLT = rs.getInt("SoLuotThich");
				int tinhT = rs.getInt("TinhTrang");
				
				HoiDap hd = new HoiDap(maHD, cauH, noiD, tenMD, tenND, ngayD, soLTL, soLT,tinhT  );
				hoiDaps.add(hd);
			}
			response.setData(hoiDaps);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getHoiDap bi loi");
		}
		return response;

	}
	
	
	

}