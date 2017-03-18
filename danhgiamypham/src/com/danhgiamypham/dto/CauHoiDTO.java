package com.danhgiamypham.dto;

import java.util.List;

import com.danhgiamypham.model.CauHoi;
import com.danhgiamypham.model.CauTraLoi;
import com.danhgiamypham.model.NhomCauHoi;

public class CauHoiDTO {
	private int maNguoiDung;
	private int maNhomCauHoi;
	private int maCauHoi;
	private String tieuDe;
	private String noiDung;
	
	private  List<CauTraLoi> cauTraLois;
	private  CauHoi cauHoiTheoNgayDang;
	
	List<NhomCauHoi> nhomCauHois;
	
	

	public CauHoiDTO() {

	}

	public CauHoiDTO(int maNguoiDung, int maNhomCauHoi, String tieuDe,
			String noiDung) {

		this.maNguoiDung = maNguoiDung;
		this.maNhomCauHoi = maNhomCauHoi;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;

	}

	public CauHoi unbind() {
		CauHoi ch = new CauHoi();
		ch.setMaNguoiDung(maNguoiDung);
		ch.setMaNhomCauHoi(maNhomCauHoi);
		ch.setTieuDe(tieuDe);
		ch.setNoiDung(noiDung);

		return ch;

	}
	

	public CauHoi getCauHoiTheoNgayDang() {
		return cauHoiTheoNgayDang;
	}

	public void setCauHoiTheoNgayDang(CauHoi cauHoiTheoNgayDang) {
		this.cauHoiTheoNgayDang = cauHoiTheoNgayDang;
	}

	public List<CauTraLoi> getCauTraLois() {
		return cauTraLois;
	}

	public void setCauTraLois(List<CauTraLoi> cauTraLois) {
		this.cauTraLois = cauTraLois;
	}

	public List<NhomCauHoi> getNhomCauHois() {
		return nhomCauHois;
	}

	public void setNhomCauHois(List<NhomCauHoi> nhomCauHois) {
		this.nhomCauHois = nhomCauHois;
	}

	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public int getMaNhomCauHoi() {
		return maNhomCauHoi;
	}

	public void setMaNhomCauHoi(int maNhomCauHoi) {
		this.maNhomCauHoi = maNhomCauHoi;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public int getMaCauHoi() {
		return maCauHoi;
	}

	public void setMaCauHoi(int maCauHoi) {
		this.maCauHoi = maCauHoi;
	}
	
	

}
