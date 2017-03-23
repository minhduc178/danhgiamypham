package com.danhgiamypham.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danhgiamypham.dto.CauHoiDTO;
import com.danhgiamypham.model.CauHoi;
import com.danhgiamypham.model.CauTraLoi;
import com.danhgiamypham.model.NhomCauHoi;
import com.danhgiamypham.service.CauHoiService;

@Controller
@RequestMapping("/cauhoi/")
public class CauHoiController {

	@Autowired
	private CauHoiService cauHoiService;

	@RequestMapping(value = "them", method = RequestMethod.POST)
	@ResponseBody
	public boolean cauHoi(@RequestBody CauHoiDTO chDTO) {
		CauHoi ch = chDTO.unbind();
		
		return cauHoiService.themCauHoi(ch);
		
	}

	@RequestMapping(value = "get-nhomcauhoi", method = RequestMethod.GET)
	@ResponseBody
	public List<NhomCauHoi> getNhomCauHoi() {
		return cauHoiService.getNhomCauHoi();
	}
	
	@RequestMapping(value = "get-cauhoi", method = RequestMethod.GET)
	@ResponseBody
	public Set<CauHoi> getCauHoi(@RequestParam("mnch") int mnch) {
		return cauHoiService.getCauHoi(mnch);
	}
	
	@RequestMapping(value = "loc-cau-hoi", method = RequestMethod.GET)
	@ResponseBody
	public Set<CauHoi> getCauHoiTheoNhom(@RequestParam("param") String[] param,
			                        @RequestParam("mnch") 	int mnch) {
		return cauHoiService.locCauHoiTheoNhom(param, mnch);
	}
	
	@RequestMapping(value="get-cautraloi", method = RequestMethod.GET)
	@ResponseBody
	public List<CauTraLoi> getCauTraLoi(@RequestParam("maCH") int maCH){
		return cauHoiService.getCauTraLoi(maCH);
	}
	



}
