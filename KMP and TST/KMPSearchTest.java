import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class KMPSearchTest {

	@Test
	public void testEmpty() {
		assertEquals("Empty text or toFindtern is invalid", -1, KMPSearch.searchFirst("", ""));
		assertEquals("Empty text or toFindtern is invalid", 0, KMPSearch.searchAll("", ""));
		assertFalse("Empty text or toFindtern is invalid", KMPSearch.contains("", ""));
	}

	@Test
	public void testContains() {
		String test = "yriqndqurhellorthwi";
		String toFind = "hello";
		boolean result = KMPSearch.contains(test, toFind);
		assertEquals(result, true);
	}

	@Test
	public void testSearchFirst() {
		String test = "yriqndqurhellorthwiyeqishellopurha";
		String toFind = "hello";
		int result = KMPSearch.searchFirst(test, toFind);
		assertEquals(result, 9);
	}

	@Test
	public void testSearchAll() {
		String test = "urahdnuwhellohfajnkuwhellohfuancushrhellonbvskuhfshellohfun";
		String toFind = "hello";
		int result = KMPSearch.searchAll(test, toFind);
		assertEquals(result, 4);
	}

	@Test
	public void main() 
	{
//		 In inStream = new In("BUSES_SERVICE_0.json");
//		 String bus = inStream.readAll();
//		 String toFind = "VehicleNo";
//		 System.out.println(KMPSearch.searchAll(bus, toFind));
//		
//		 In inStream1 = new In("BUSES_SERVICE_0.json");
//		 bus = inStream1.readAll();
//		 toFind = "16555";
//		 System.out.println(KMPSearch.contains(bus, toFind));
//		
//		 In inStream2 = new In("BUSES_SERVICE_0.json");
//		 bus = inStream2.readAll();
//		 toFind = "HAMPTON PARK";
//		 System.out.println(KMPSearch.searchFirst(bus, toFind));
//		
//		 In inStream3 = new In("BUSES_SERVICE_0.json");
//		 bus = inStream3.readAll();
//		 toFind = "9043409";
//		 System.out.println(KMPSearch.contains(bus, toFind));
	}
}