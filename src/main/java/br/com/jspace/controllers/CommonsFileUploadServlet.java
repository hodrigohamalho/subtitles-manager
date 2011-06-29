package br.com.jspace.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.jspace.core.SubtitlesManager;

@WebServlet(name="/CommonsFileUploadServlet", urlPatterns="/upload.do")
public class CommonsFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private File tmpDir;
	private File destinationDir;
	private File file = null;
	private static final String TMP_DIR_PATH = "/tmp";
	private static final String DESTINATION_DIR_PATH = "/subtitles";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		//		PropertiesUtil props = new PropertiesUtil("src/main/resources/path.properties");
		tmpDir = new File(TMP_DIR_PATH);

		if(!tmpDir.isDirectory()) {
			throw new ServletException(DESTINATION_DIR_PATH + " is not a directory");
		}

		String realPath = getServletContext().getRealPath(DESTINATION_DIR_PATH);
		destinationDir = new File(realPath);

		if(!destinationDir.isDirectory()) {
			throw new ServletException(DESTINATION_DIR_PATH+ " is not a directory");
		}
	}

	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory  fileItemFactory = new DiskFileItemFactory ();
		fileItemFactory.setSizeThreshold(1*1024*1024); //1 MB
		fileItemFactory.setRepository(tmpDir);

		ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
		String fileName;
		int segundos = 0;


		try {
			List items = uploadHandler.parseRequest(request);
			Iterator itr = items.iterator();

			while(itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				if (item.getFieldName().equals("segundos")){
					segundos = Integer.valueOf(item.getString());
				}else{
					fileName = item.getName();
					file = new File(destinationDir,fileName);
					item.write(file);
				}
			}


			SubtitlesManager subtitleManager = new SubtitlesManager();
			String downloadPath = subtitleManager.convertFile(file.getAbsoluteFile().toString(), segundos);
			request.setAttribute("downloadPath", downloadPath);

		}catch(FileUploadException ex) {
			log("Error encountered while parsing the request",ex);
		} catch(Exception ex) {
			log("Error encountered while uploading file",ex);
		}

		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
}
