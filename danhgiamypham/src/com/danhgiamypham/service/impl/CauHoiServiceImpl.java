package com.danhgiamypham.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhgiamypham.dao.CauHoiDao;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.CauHoi;
import com.danhgiamypham.model.CauTraLoi;
import com.danhgiamypham.model.NhomCauHoi;
import com.danhgiamypham.service.CauHoiService;

@Service
public class CauHoiServiceImpl implements CauHoiService {

	@Autowired
	private CauHoiDao cauHoiDao;

	@Override
	public  ResponseData<Boolean> themCauHoi(CauHoi ch) {
		return cauHoiDao.themCauHoi(ch);
	}

	@Override
	public  ResponseData<List<NhomCauHoi>> getNhomCauHoi() {
		return cauHoiDao.getNhomCauHoi();
	}

	@Override
	public  ResponseData<Set<CauHoi>> getCauHoi(int mch) {
		return cauHoiDao.getCauHoi(mch);
	}
	
	@Override
	public  ResponseData<Set<CauHoi>> locCauHoiTheoNhom(String[] chuoinbp,int mnch){
		ResponseData<Set<CauHoi>> response = new ResponseData<Set<CauHoi>>();
		Set<CauHoi> cauHois = new HashSet<CauHoi>();
		if (chuoinbp.length == 0) {
			response = cauHoiDao.getCauHoi(mnch);
		} else { 
			for (String r : chuoinbp) {
				int mnbp = Integer.parseInt(r);
				ResponseData<Set<CauHoi>> rs = cauHoiDao.getCauHoiTheoNhom(mnbp, mnch);	
				cauHois.addAll(rs.getData());
			}
			response.setData(cauHois);
		}

		return response;
	}


	@Override
	public  ResponseData<List<CauTraLoi>> getCauTraLoi(int maCH) {
		return cauHoiDao.getCauTraLoi(maCH);
	}


}
