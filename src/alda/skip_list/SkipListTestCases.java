package alda.skip_list;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * 	
 * 	TA BORT VID INLÄMNING
 * 
 * */

public class SkipListTestCases {
	
	MySkipList<Integer> skipper = new MySkipList<Integer>(5);
	
	@Before
	public void init(){
		for(int i = 0; i <= 1000; i++) 
			skipper.insert(new Integer(i));
	}
	
	

	@Test
	public void searchList(){
		assertTrue(skipper.search(new Integer(0)));			// ska finnas
		assertFalse(skipper.search(new Integer(1024)));		// ska inte finnas
	}
	
	@Test
	public void testDupes(){
		
		assertFalse(skipper.insert(new Integer(0)));
		assertFalse(skipper.insert(new Integer (100)));
		assertFalse(skipper.insert(new Integer(1000)));
		assertEquals(1001, skipper.getSize());
	}
	
	@Test
	public void remove(){
		assertFalse(skipper.remove(new Integer(1002)));
		assertTrue(skipper.remove(new Integer(0)));
		assertTrue(skipper.remove(new Integer(100)));
	}
	
	@Test
	public void characterTest(){
		MySkipList<Character> listChar = new MySkipList<Character>(4);
		listChar.insert('A');
		listChar.insert('B');
		listChar.insert('C');
		listChar.insert('D');
		listChar.insert('E');
		
		assertTrue(listChar.search('A'));
		assertFalse(listChar.search('Z'));
		assertFalse(listChar.insert('A'));
		
		assertTrue(listChar.remove('A'));
		assertEquals(4, listChar.getSize());
	}
	
}
