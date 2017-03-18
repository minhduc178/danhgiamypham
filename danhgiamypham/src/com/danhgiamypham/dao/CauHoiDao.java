package com.danhgiamypham.dao;

import java.util.List;
import java.util.Set;

import com.danhgiamypham.model.CauHoi;
import com.danhgiamypham.model.CauTraLoi;
import com.danhgiamypham.model.NhomCauHoi;
import com.danhgiamypham.model.SanPham;

public interface CauHoiDao {
	public boolean themCauHoi(CauHoi ch);
	public List<NhomCauHoi> getNhomCauHoi();
	public List<CauTraLoi> getCauTraLoi(int maCH);
	public Set<CauHoi> getCauHoiTheoNhom(int mnbp, int mnch);
	public Set<CauHoi> getCauHoi(int mch);



}
