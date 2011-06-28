package br.com.jspace.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubtitlesManager {

	public String convertFile(String path, int amount) throws IOException, ParseException{
		String text = this.readFile(path);
		List<String> timesString = this.extractTimes(text);
		List<Date> times = this.convertStringToTime(timesString);
		List<String> newTimes = this.addOrSubTime(times, amount);

		for (int i=0; i < newTimes.size(); i ++) {
			text = text.replace(timesString.get(i), newTimes.get(i).replace(":", "#k#"));
		}

		text = text.replaceAll("#k#", ":");
		String fileName = path.substring(path.lastIndexOf(File.separator)+1);
		this.writeFile(fileName, text);
//		BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
//		out.write(text);
//		out.close();

		return fileName;
	}

	public String readFile(String path) throws IOException, ParseException {
		StringBuilder text = new StringBuilder();
		String line = "";
		RandomAccessFile accessFile = new RandomAccessFile(new File(path), "rw");

		while (line != null) {
			line = accessFile.readLine();
			text.append(line+"\n");
		}

		accessFile.close();
		return text.toString();
	}

	public void writeFile(String fileName, String content) throws IOException{
		FileOutputStream local;  
		PrintStream contentFile;  
		try{  
			local = new FileOutputStream("/subtitle/" + fileName);
			contentFile = new PrintStream(local);  
			contentFile.print(content);  
		}catch (Exception e){
			System.err.println(e);  
		} 
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

		for (String time : times) {
			dates.add(format.parse(time));
		}

		return dates;
	}

	public List<String> addOrSubTime(List<Date> times, int amount){
		List<String> newTime = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

		for (Date time : times) {
			calendar.setTime(time);
			calendar.add(Calendar.SECOND, amount);
			newTime.add(format.format(calendar.getTime()));
		}
		return newTime;
	}
}
