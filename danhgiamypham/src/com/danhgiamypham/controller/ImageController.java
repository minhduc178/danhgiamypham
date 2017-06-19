package com.danhgiamypham.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.danhgiamypham.Utilities.PathRsIMG;
import com.danhgiamypham.model.PathImage;

@Controller
@RequestMapping("/resources")
public class ImageController {

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public void getResource(@PathParam(value="name") String name,
			HttpServletResponse response) {
		StringBuilder rs = new StringBuilder();
		try {
			// Creating the directory to store file
			PathImage sanPhamImg = new PathImage();
			String location = sanPhamImg.getSanPhamIMG();
			String path = PathRsIMG.pathHinh(location);
			File dir = new File(path);
			
			if (!dir.exists()) {
				throw new FileNotFoundException(name);
			}

			// read file
			File file = new File(dir.getAbsolutePath()
					+ System.getProperty("file.separator") + name);
			InputStream in = new FileInputStream(file);
			IOUtils.copy(in, response.getOutputStream());
			response.flushBuffer();
		} catch (Exception e) {
			rs.append("Error: ").append(e.getMessage());
		}
	}
	
	@RequestMapping(value = "getBinhLuan", method = RequestMethod.GET)
	public void getResourceBinhLuan(@PathParam(value="name") String name,
			HttpServletResponse response) {
		StringBuilder rs = new StringBuilder();
		try {
			// Creating the directory to store file
			PathImage binhLuanImg = new PathImage();
			String location = binhLuanImg.getBinhLuanIMG();
			String path = PathRsIMG.pathHinh(location);
			File dir = new File(path);
			
			if (!dir.exists()) {
				throw new FileNotFoundException(name);
			}

			// read file
			File file = new File(dir.getAbsolutePath()
					+ System.getProperty("file.separator") + name);
			InputStream in = new FileInputStream(file);
			IOUtils.copy(in, response.getOutputStream());
			response.flushBuffer();
		} catch (Exception e) {
			rs.append("Error: ").append(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "getAnhDaiDien", method = RequestMethod.GET)
	public void getResourceAnhDaiDien(@PathParam(value="name") String name,
			HttpServletResponse response) {
		StringBuilder rs = new StringBuilder();
		try {
			// Creating the directory to store file
			PathImage anhDDImg = new PathImage();
			String location = anhDDImg.getHinhDaiDien();
			String path = PathRsIMG.pathHinh(location);
			File dir = new File(path);
			
			if (!dir.exists()) {
				throw new FileNotFoundException(name);
			}

			// read file
			File file = new File(dir.getAbsolutePath()
					+ System.getProperty("file.separator") + name);
			InputStream in = new FileInputStream(file);
			IOUtils.copy(in, response.getOutputStream());
			response.flushBuffer();
		} catch (Exception e) {
			rs.append("Error: ").append(e.getMessage());
		}
	}
}
