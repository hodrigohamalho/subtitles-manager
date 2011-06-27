package util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.jspace.util.PropertiesUtil;

public class TestPropertiesUtil {
	@Test
	public void loadProperties(){
		PropertiesUtil props = null;
		props = new PropertiesUtil("src/main/resources/path.properties");
		
		assertNotNull(props);
		assertNotNull(props.getValor("tmp.dir"));
		assertNotNull(props.getValor("destination.dir"));
	}
}
