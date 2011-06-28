package core;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.jspace.core.Operations;
import br.com.jspace.core.SubtitlesManager;


public class TestSubtitlesManager {

	SubtitlesManager manager = new SubtitlesManager();
	String path = "src/test/resources/refined-inception-1080p.srt";
	
	@Test
	public void readFile() throws Exception{
		String text = manager.readFile(path);
		assertNotNull(text);
		assertFalse(text.isEmpty());
	}
	
	@Test
	public void extractTime() throws Exception{
		String text = manager.readFile(path);
		List<String> times = manager.extractTimes(text);
		assertNotNull(times);
		assertFalse(times.isEmpty());
		
		assertTrue(times.contains("00:00:01"));
		assertTrue(times.contains("02:28:17"));
	}
	
	@Test
	public void convertStringToTime() throws Exception{
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

		List<String> newTimes = manager.addOrSubTime(datas, Operations.SUM, 10);
		assertFalse(newTimes.isEmpty());
		assertEquals("00:00:11", newTimes.get(0));
		assertEquals("02:28:27", newTimes.get(newTimes.size()-1));
	}

	@Test
	public void subTime() throws IOException, ParseException{
		String text = manager.readFile(path);
		List<String> times = manager.extractTimes(text);
		List<Date> datas = manager.convertStringToTime(times);

		List<String> newTimes = manager.addOrSubTime(datas, Operations.SUB, -1);
		assertFalse(newTimes.isEmpty());
		assertEquals("00:00:00", newTimes.get(0));
		assertEquals("02:28:16", newTimes.get(newTimes.size()-1));
	}
	
	@Test
	public void convertFile() throws IOException, ParseException{
		String fileName = manager.convertFile(path, Operations.SUM, 10);
		assertEquals("refined-inception-1080p.srt", fileName);
	}
}
