package br.com.jspace.controllers;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.jspace.core.SubtitlesManager;


public class CommonsFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private File tmpDir;
	private File destinationDir;
	private static final String DESTINATION_DIR = "/subtitle/";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		//	PropertiesUtil props = new PropertiesUtil("src/main/resources/path.properties");
		tmpDir = new File(DESTINATION_DIR);

		if(!tmpDir.isDirectory()) {
			throw new ServletException(DESTINATION_DIR + " is not a directory");
		}

		destinationDir = new File(DESTINATION_DIR);

		if(!destinationDir.isDirectory()) {
			throw new ServletException(DESTINATION_DIR+ " is not a directory");
		}
	}

	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory  fileItemFactory = new DiskFileItemFactory ();
		fileItemFactory.setSizeThreshold(1*1024*1024); //1 MB
		fileItemFactory.setRepository(tmpDir);

		ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);

		try {
			List items = uploadHandler.parseRequest(request);
			Iterator itr = items.iterator();

			while(itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				if (item.getName() != null){
					File file = new File(destinationDir,item.getName());
					item.write(file);
				}
			}
		}catch(FileUploadException ex) {
			log("Err ",ex);
		} catch(Exception ex) {
			log("Err ",ex);
		}
	}
}
