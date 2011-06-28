package br.com.jspace.controllers;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jspace.core.SubtitlesManager;

@WebServlet(name="/SubtitleManagerServlet", urlPatterns="/upload.do")
public class SubtitleManagerServlet extends CommonsFileUploadServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Faz o upload
		super.doPost(request, response);
		
		SubtitlesManager subtitleManager = new SubtitlesManager();
		try {
			String legend = subtitleManager.convertFile("/subtitle/legenda.srt", 2);
			
		} catch (ParseException e) {
			System.out.println("Catch! =/");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/result.jsp").forward(request, response);
		
	}
	
}
