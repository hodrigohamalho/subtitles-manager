package core;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
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
	public void sumOrsubTime(){
		
	}
}
