package core;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;


public class TestSubtitlesManager {

	SubtitlesManager manager = new SubtitlesManager();
	String path = "/Users/rodrigoramalho/Movies/Inception.1080p.BluRay.x264-REFiNED/refined-inception-1080p.srt";
	
	@Test
	public void readFile() throws IOException{
		String text = manager.readFile(path);
		assertNotNull(text);
		assertFalse(text.isEmpty());
	}
	
	@Test
	public void extractTime() throws IOException{
		String text = manager.readFile(path);
		List<String> times = manager.extractTimes(text);
		assertNotNull(times);
		assertFalse(times.isEmpty());
		
		assertTrue(times.contains("00:00:01"));
		assertTrue(times.contains("02:28:17"));
	}
	
	@Test
	public void convertStringToTime() throws IOException, ParseException{
		String text = manager.readFile(path);
		List<String> times = manager.extractTimes(text);
		List<Date> datas = manager.convertStringToTime(times);
		assertNotNull(datas);
		assertFalse(datas.isEmpty());
	}
	
	@Test
	public void sumTime() throws IOException, ParseException{
		String text = manager.readFile(path);
		List<String> times = manager.extractTimes(text);
		List<Date> datas = manager.convertStringToTime(times);
		
		List<Date> newTimes = manager.addOrSubTime(datas, Operations.SUM, 10);
		assertFalse(newTimes.isEmpty());
		Calendar calendar = Calendar.getInstance();
		calendar.set(0,0,0,0,0,11);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		
		assertEquals(dateFormat.format(calendar.getTime()), 
				dateFormat.format(newTimes.get(0).getTime()));
	}
	
	@Test
	public void subTime() throws IOException, ParseException{
		String text = manager.readFile(path);
		List<String> times = manager.extractTimes(text);
		List<Date> datas = manager.convertStringToTime(times);
		
		List<Date> newTimes = manager.addOrSubTime(datas, Operations.SUM, -1);
		assertFalse(newTimes.isEmpty());
		Calendar calendar = Calendar.getInstance();
		calendar.set(0,0,0,0,0,0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		
		assertEquals(dateFormat.format(calendar.getTime()), 
				dateFormat.format(newTimes.get(0).getTime()));
	}
}
