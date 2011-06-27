package core;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Upload
 */
@WebServlet(name="/Upload", urlPatterns={"/upload.do"})
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Upload() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			SubtitlesManager subTitle = new SubtitlesManager();
			String txt;
			List<String> times;
			List<Date> date = null;
			List<Date> newDate = null;
			List<String> finalDate = null;
			
//			txt = subTitle.readFile("/Users/fabricioraphael/subtitle/tmplegenda.srt");
			
//			times = subTitle.extractTimes(txt);
			
//			System.out.println("Times extract:   " + times + "\n");
//			
//			try {
//				date = subTitle.convertStringToTime(times);
//			} catch (ParseException e) {
//				System.out.println("Passou aqui catch!");
//				e.printStackTrace();
//			}
			
//			newDate = subTitle.addOrSubTime(date, Operations.SUM, 2);
			
//			System.out.println(newDate + "\n");
			
//			finalDate = subTitle.convertListToString(newDate); 
			
//			System.out.println(finalDate);
			
	}

}
