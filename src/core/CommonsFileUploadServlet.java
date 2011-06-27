package core;

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


@WebServlet(name="/CommonsFileUploadServlet", urlPatterns="/upload.do")
public class CommonsFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String TMP_DIR_PATH = "/Users/fabricioraphael/subtitle/tmp/";
	private File tmpDir;
	private static final String DESTINATION_DIR_PATH = "/Users/fabricioraphael/subtitle/tmp/";
	private File destinationDir;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		tmpDir = new File(TMP_DIR_PATH);
		
		if(!tmpDir.isDirectory()) {
			throw new ServletException(TMP_DIR_PATH + " 1s n0t 4 D1r3ct0rY #1");
		}
		
//		String realPath = getServletContext().getRealPath(DESTINATION_DIR_PATH);
//		destinationDir = new FIle(realPath);
		destinationDir = new File(DESTINATION_DIR_PATH);
		
		if(!destinationDir.isDirectory()) {
			throw new ServletException(DESTINATION_DIR_PATH+" 1s n0t 4 D1r3ct0rY #2");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = "NULL";
		Long fileSize = null;

		DiskFileItemFactory  fileItemFactory = new DiskFileItemFactory ();
		fileItemFactory.setSizeThreshold(1*1024*1024); //1 MB
		fileItemFactory.setRepository(tmpDir);

		ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
		
		try {
			List items = uploadHandler.parseRequest(request);
			Iterator itr = items.iterator();
			while(itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				if(item.isFormField()) {
					fileName = item.getFieldName();
				} else {
					fileName = item.getName();
					fileSize = item.getSize();
					
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
