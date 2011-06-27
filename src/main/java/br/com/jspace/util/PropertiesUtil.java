package br.com.jspace.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private Properties props;

	public PropertiesUtil(String propertiesName) {
		props = new Properties();

		try{
			InputStream in = new FileInputStream(propertiesName);
			props.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValor(String chave) {
		return (String) props.getProperty(chave);
	}
}
