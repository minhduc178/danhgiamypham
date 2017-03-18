package com.danhgiamypham.service;

import java.util.List;
import java.util.Set;

import com.danhgiamypham.model.CauHoi;
import com.danhgiamypham.model.CauTraLoi;
import com.danhgiamypham.model.NhomCauHoi;

public interface CauHoiService {
	public boolean themCauHoi(CauHoi ch);
	public List<NhomCauHoi> getNhomCauHoi();
	public List<CauTraLoi> getCauTraLoi(int maCH);
	public Set<CauHoi> getCauHoi(int mch);
	public Set<CauHoi> locCauHoiTheoNhom(String[] param,int mnch);

}
