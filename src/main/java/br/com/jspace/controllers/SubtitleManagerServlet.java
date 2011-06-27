package br.com.jspace.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="/SubtitleManagerServlet", urlPatterns="/upload.do")
public class SubtitleManagerServlet extends CommonsFileUploadServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Faz o upload
		super.doPost(request, response);
		
		
	}
	
}
