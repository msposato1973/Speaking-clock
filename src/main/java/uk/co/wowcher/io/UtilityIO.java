package uk.co.wowcher.io;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UtilityIO {
	
	private Map<Integer, String> oneToNine = new HashMap<Integer, String>();
	private Map<Integer, String> tensToFifty = new HashMap<Integer, String>();
	private Map<Integer, String> tenToNineteen = new HashMap<Integer, String>();
	private Map<Integer, String> twentyToYwentytree = new HashMap<Integer, String>();
	
	public Map<Integer, String> getOneToNine() {
		return oneToNine;
	}
	
	public Map<Integer, String> getTensToFifty() {
		return tensToFifty;
	}


	public Map<Integer, String> getTenToNineteen() {
		return tenToNineteen;
	}


	public Map<Integer, String> getTwentyToYwentytree() {
		return twentyToYwentytree;
	}


	public void setTOneToNine(Map<Integer, String> oneToNine) {
		this.oneToNine = oneToNine;
	}
	
	public void setTensToFifty(Map<Integer, String> tensToFifty) {
		this.tensToFifty = tensToFifty;
	}


	public void setTenToNineteen(Map<Integer, String> tenToNineteen) {
		this.tenToNineteen = tenToNineteen;
	}


	public void setTwentyToYwentytree(Map<Integer, String> twentyToYwentytree) {
		this.twentyToYwentytree = twentyToYwentytree;
	}

	
	
	public UtilityIO() {
		init();
	}

	
	public void init() {
		try {
			setTOneToNine(loadMapPropertie("oneToNine.properties"));
			setTensToFifty(loadMapPropertie("tensToFifty.properties"));
			setTenToNineteen(loadMapPropertie("tensToNineteen.properties")); 
			setTwentyToYwentytree(loadMapPropertie("twentyToTwentyTree.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public  Map<Integer, String> loadMapPropertie(String fileName) throws IOException {
		Map<Integer, String> map = new HashMap<Integer, String>();
	
		Properties properties = getPropertiesFor(fileName);
			
			for (String key : properties.stringPropertyNames()) {
				String value = properties.getProperty(key);
				map.put(Integer.valueOf(key), value);
			}
		
		return map;
	}
	
	public  Properties getPropertiesFor(String fileName) throws IOException {
		Properties properties = new Properties();
		properties.load(getClass().getClassLoader().getResourceAsStream(fileName));

		return properties;
	}
	
}
