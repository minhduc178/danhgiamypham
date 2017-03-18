package com.danhgiamypham.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhgiamypham.dao.CauHoiDao;
import com.danhgiamypham.model.CauHoi;
import com.danhgiamypham.model.CauTraLoi;
import com.danhgiamypham.model.NhomCauHoi;
import com.danhgiamypham.service.CauHoiService;

@Service
public class CauHoiServiceImpl implements CauHoiService {

	@Autowired
	private CauHoiDao cauHoiDao;

	@Override
	public boolean themCauHoi(CauHoi ch) {
		return cauHoiDao.themCauHoi(ch);
	}

	@Override
	public List<NhomCauHoi> getNhomCauHoi() {
		return cauHoiDao.getNhomCauHoi();
	}

	@Override
	public Set<CauHoi> getCauHoi(int mch) {
		return cauHoiDao.getCauHoi(mch);
	}
	
	@Override
	public Set<CauHoi> locCauHoiTheoNhom(String[] chuoinbp,int mnch){
	//	int indexPage = 0;
	//  int maxItem = 0;
		Set<CauHoi> cauHoiNhom = new HashSet<CauHoi>();
		
		if (chuoinbp.length == 0) {
			cauHoiNhom = cauHoiDao.getCauHoi(mnch);
		} else { 
			for (String r : chuoinbp) {
				int mnbp = Integer.parseInt(r);
				Set<CauHoi> rs = new HashSet<CauHoi>();
				rs = cauHoiDao.getCauHoiTheoNhom(mnbp, mnch);			
				cauHoiNhom.addAll(rs);
				
			}
		}

		return cauHoiNhom;
	}


	@Override
	public List<CauTraLoi> getCauTraLoi(int maCH) {
		return cauHoiDao.getCauTraLoi(maCH);
	}


}
