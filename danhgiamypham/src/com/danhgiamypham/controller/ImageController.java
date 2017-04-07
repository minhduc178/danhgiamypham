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

@Controller
@RequestMapping("/resources")
public class ImageController {

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public void getResource(@PathParam(value="name") String name,
			HttpServletResponse response) {
		StringBuilder rs = new StringBuilder();
		try {
			// Creating the directory to store file
			
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "webapps" + File.separator + "FILE_UPLOAD");
			
		//	File dir = new File("/FILE_UPLOAD/HINHSANPHAM");
			
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
