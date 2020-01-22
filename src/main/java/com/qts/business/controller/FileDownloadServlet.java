package com.qts.business.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

@WebServlet(urlPatterns="/download-file")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext(); 
		String filePath = request.getParameter("filePath");
		if (filePath == null || filePath.equals("")) {
			throw new ServletException("File Name can't be null or empty");
		}
		File file = new File(filePath);
		if (!file.exists()) {
			throw new ServletException("File doesn't exist on server");
		}
		String mimeType = context.getMimeType(file.getAbsolutePath());
		response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + FilenameUtils.getName(filePath) + "\"");

		ServletOutputStream sos = response.getOutputStream();
		Files.copy(Paths.get(filePath), sos);
		sos.flush();
		sos.close();
	}
}
