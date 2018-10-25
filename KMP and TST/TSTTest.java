import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.lang.String;

import org.junit.Test;

public class TSTTest {

	@Test
	public void testEmpty()
	{
		TST<Long> trie = new TST<>();
		assertEquals("size of an empty trie should be 0",0, trie.size());
		assertFalse("searching an empty trie should return false",trie.contains(""));
		assertNull("getting from an empty trie should return null",trie.get(""));
	}

	@Test
	public void testContains() 
	{
		TST<Integer> tst = new TST<Integer>();
		int i = 0;
		String str = "test string";
		Scanner scanner = new Scanner(str);
		while(scanner.hasNext())
		{
			String key = scanner.next();
			tst.put(key, i);
			i++;
		}  
		assertEquals(true, tst.contains("string"));
		assertEquals(false, tst.contains("streng"));
	}

	@Test
	public void testGet() 
	{
		TST<Integer> tst = new TST<Integer>();
		int i = 0;
		String str = "test string";
		Scanner scanner = new Scanner(str);
		while(scanner.hasNext())
		{
			String key = scanner.next();
			tst.put(key, i);
			i++;
		}  

		assertEquals(1, (int)tst.get("string"));
		assertEquals(0, (int)tst.get("test"));
	}

	@Test
	public void testSize() 
	{
		TST<Integer> tst = new TST<Integer>();
		int i = 0;
		String str = "my brother got caught not doing the dishes";
		Scanner scanner = new Scanner(str);
		while(scanner.hasNext()){
			String key = scanner.next();
			tst.put(key, i);
			i++;
		}  
		assertEquals(8, (int)tst.size());
	}

	@Test
	public void testPut() 
	{
		TST<Integer> tst = new TST<Integer>();
		int i = 0;
		String str = "my brother got caught not doing the dishes";
		Scanner scanner = new Scanner(str);
		while(scanner.hasNext())
		{
			String key = scanner.next();
			tst.put(key, i);
			i++;
		}  
		tst.put("food", 9);
		assertEquals(9, (int)tst.get("food"));  	  
	}

	@Test
	public void testKeysWithPrefix() 
	{
		TST<Integer> tst = new TST<Integer>();
		int i = 0;
		String str = "acc dog cat fish accident jump run sit accenture";
		Scanner scanner = new Scanner(str);
		while(scanner.hasNext())
		{
			String key = scanner.next();
			tst.put(key, i);
			i++;
		}  
		LinkedList<String> list = new LinkedList<String>();
		list.add("acc");
		list.add("accenture");
		list.add("accident");
		assertEquals(list, tst.keysWithPrefix("acc"));
	}

	@Test
	public void main() throws IOException, ParseException 
	{
//		int  i=0;
//		JSONParser p = new JSONParser();
//		JSONArray array = (JSONArray) p.parse(new FileReader("BUSES_SERVICE_0.json"));
//
//		TST<Integer> tst = new TST<Integer>();
//		for (Object o : array) 
//		{
//			JSONObject object = (JSONObject) o;
//			String key = (String) object.get("Destination");
//			tst.put(key, i);
//			i++;		  
//		} 
//		tst = new TST<Integer>();
//		Scanner scanner = new Scanner(new File ("google-books-common-words.txt"));
//		while(scanner.hasNext()) 
//		{
//			tst.put((String)scanner.next(),(int)scanner.nextLong());
//		}
//		System.out.println("1: "+tst.size());
//		System.out.println("2: "+tst.contains("SOUTHSIDE"));
//		System.out.println("3: "+tst.keysWithPrefix("DOWN").size()+"\n");
//		System.out.println("4: "+tst.size());
//		System.out.println("5: "+tst.get("ALGORITHM"));
//		System.out.println("6: "+tst.contains("EMOJI"));
//		System.out.println("7: "+tst.contains("BLAH"));
//		System.out.println("8: "+tst.keysWithPrefix("TEST").size());
	}
}