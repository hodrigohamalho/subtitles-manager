package core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
		String line = "", time0 = "", time1 = "";
		List<String> extract;
		List<Date> date = null;
		List<String> result;
		while (line != null) {
			line = reader.readLine();
			try {
				extract = this.extractTimes(line);
				date = this.convertStringToTime(extract);
				time0 = this.addOrSubTime(date.get(0), Operations.SUM, 2);
				time1 = this.addOrSubTime(date.get(1), Operations.SUM, 2);
				System.out.println("Dates: " + date + "   Time0: " + time0 + "   Time1: " + time1);
			} catch (Exception e) {	}
			text.append(line);
		}

		fis.close();
		bis.close();
		bis.close();
		
		return text.toString();
	}
	
	public void addText(String arq, String conteudo, boolean save) throws IOException{
		FileWriter fw = new FileWriter(arq, save);

		fw.write(conteudo);
		fw.close();
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
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		dates.add(format.parse(times.get(0)));
		dates.add(format.parse(times.get(1)));
		
		return dates;
	}
	
	public String sub(List<String> listString) throws IOException{
		String leg;
		
		leg = this.readFile("/Users/fabricioraphael/subtitle/tmplegenda.srt");
		
		
		
		
		
		
		return null;
	}
	
	public String clearDate(String date){
		Pattern pattern = Pattern.compile("\\d{2}:\\d{2}:\\d{2}");
		Matcher matcher = pattern.matcher(date);
		
		while(matcher.find()){
			date = matcher.group();
		}
		return date;
	}
	
	public String addOrSubTime(Date times, Operations operator, int amount){
		String newDate;
		Calendar calendar = Calendar.getInstance();
			calendar.setTime(times);
			
			if (operator.equals(Operations.SUM)){
				calendar.add(Calendar.SECOND, amount);
			}else{
				calendar.add(Calendar.SECOND, -amount);
			}
			
			newDate = calendar.getTime().toString();
			
		return this.clearDate(newDate);
	}
}
