package uk.co.wowcher.utility;

import java.util.HashMap;
import java.util.Map;

import uk.co.wowcher.io.UtilityIO;

public class UtilityMapTime {
	
	private static  UtilityIO utilityIO = new UtilityIO(); 

	public static Map<Integer, String> hoursDay;
	static { 
		hoursDay = new HashMap<Integer, String>() {{ 
			put(12, "Midday "); 
			put(24, "Midnight ");
		}}; 
	}

	public static Map<Integer, String> oneToNine = utilityIO.getOneToNine();	
	public static Map<Integer, String> tenToNineteen = utilityIO.getTenToNineteen();	
	public static Map<Integer, String> twentyToYwentytree= utilityIO.getTwentyToYwentytree();
	public static Map<Integer, String> tensToFifty = utilityIO.getTensToFifty();
	
}
