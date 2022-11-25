package uk.co.wowcher.service.impl;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.wowcher.io.UtilityIO;
import uk.co.wowcher.service.ClockService;

public class ClockServiceImplTest {
	
	private ClockService clockService = null;
	private UtilityIO utilityIO = null; 
	
	@Before
	public void setUp() {
		clockService = new ClockServiceImpl();
		utilityIO = new UtilityIO(); 
	}
 

	@Test
	public void testValidationMaptensToFifty() {
		Map<Integer, String> tensToFifty =  utilityIO.getTensToFifty();	
		Assert.assertNotNull(tensToFifty);
	}
	
	@Test
	public void testValidationMapOneToNine() {
		
		Map<Integer, String> oneToNine =  utilityIO.getOneToNine();	
		Assert.assertNotNull(oneToNine);
	}
	
	@Test
	public void testValidationMapOneTenToNineteen() {
		
		Map<Integer, String> tenToNineteen =  utilityIO.getTenToNineteen();	
		Assert.assertNotNull(tenToNineteen);
		
		Assert.assertTrue("nineteen".equalsIgnoreCase(tenToNineteen.get(19)));
	}
	
	@Test
	public void testValidation() {
		Assert.assertNotNull(clockService);
		Assert.assertTrue(clockService.validation("24:34"));
	}
	
	@Test(expected = Exception.class)
	public void testFalseValidation() throws Exception{
		Assert.assertNotNull(clockService);
		Assert.assertFalse(clockService.validation("24"));
	}
	
	@Test
	public void testValidation_24H() throws Exception{
		Assert.assertNotNull(clockService);
		Assert.assertTrue(clockService.validation("24:00"));
	}
	
	@Test
	public void testCheckValidation_Midnight() throws Exception{
		Assert.assertNotNull(clockService);
		Assert.assertTrue(clockService.validation("24:00"));
		String expected  = "It's Midnight"; 
		
		String result = clockService.convertTimeToWords("24:00");
		System.out.println(result);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.contains(expected));
	}
	
	@Test
	public void testCheckValidation_Midday() throws Exception{
		Assert.assertNotNull(clockService);
		Assert.assertTrue(clockService.validation("12:00"));
		String expected  = "It's Midday "; 
		
		String result = clockService.convertTimeToWords("12:00");
		System.out.println(result);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.contains(expected));
	}
	
	@Test(expected = Exception.class)
	public void testCheckValidation_MiddayError() throws Exception{
		Assert.assertNotNull(clockService);
		Assert.assertTrue(clockService.validation("12"));
		String expected  = "It's Midday "; 
		
		String result = clockService.convertTimeToWords("12");
		System.out.println(result);
		Assert.assertNotNull(result);
		Assert.assertFalse(result.contains(expected));
	}

	@Test
	public void testCheckHours() {
		Assert.assertTrue(clockService.validation("08:34"));
		String result = clockService.checkHours(8);
		System.out.println(result);
		Assert.assertNotNull(result.trim());
	 
		Assert.assertTrue("eight".equalsIgnoreCase(result.trim()));
	}

	@Test
	public void testConvertTimeToWords() {
		Assert.assertTrue(clockService.validation("08:34"));
		String result = clockService.checkMinutes(34);
		System.out.println(result);
		
		String expected  = " thirty four";
		Assert.assertNotNull(result);
		
		Assert.assertTrue(result.contains(expected));
	}

}
