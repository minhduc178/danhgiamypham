package com.danhgiamypham.service;

import java.util.List;
import java.util.Set;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.CauHoi;
import com.danhgiamypham.model.CauTraLoi;
import com.danhgiamypham.model.NhomCauHoi;

public interface CauHoiService {
	public  ResponseData<Boolean> themCauHoi(CauHoi ch);
	public  ResponseData<List<NhomCauHoi>> getNhomCauHoi();
	public  ResponseData<List<CauTraLoi>> getCauTraLoi(int maCH);
	public  ResponseData<Set<CauHoi>> getCauHoi(int mch);
	public  ResponseData<Set<CauHoi>> locCauHoiTheoNhom(String[] param,int mnch);

}
