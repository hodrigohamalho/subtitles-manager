package core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubtitlesManager {

	public String readFile(String path) throws IOException {

		StringBuilder text = new StringBuilder();
		FileInputStream fis = new FileInputStream(new File(path));

		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fis);

		// Here BufferedInputStream is added for fast reading.
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		// dis.available() returns 0 if the file does not have more lines.
		String line = "";
		while (line != null) {
			line = reader.readLine();
			text.append(line);
		}

		fis.close();
		bis.close();
		bis.close();
		
		return text.toString();
	}
	
	
	public List<String> extractTimes(String text){
		List<String> times = new ArrayList<String>();
		
		Pattern pattern = Pattern.compile("\\d{2}:\\d{2}:\\d{2}");
		Matcher matcher = pattern.matcher(text);
		
		while(matcher.find()){
			times.add(matcher.group());
		}
		
		return times;
	}
	
	public List<Date> convertStringToTime(List<String> times) throws ParseException{
		List<Date> dates = new ArrayList<Date>();
		
		for (String time : times) {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			dates.add(format.parse(time));
		}
		
		return dates;
	}
	
	public List<Date> addOrSubTime(List<Date> times){
		List<Date> newDate = new ArrayList<Date>();
		
		
		
		return newDate;
	}
}
