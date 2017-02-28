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
		MySkipList<Character> skipList = new MySkipList<Character>();
		skipList.insert('A');
		skipList.insert('B');
		skipList.insert('C');
		skipList.insert('D');
		skipList.insert('E');
		
		skipList.insert('F');
		skipList.insert('G');
		skipList.insert('H');
		skipList.insert('I');
		skipList.insert('J');
		
		assertTrue(skipList.search('A'));
		assertTrue(skipList.search('B'));
		assertTrue(skipList.search('C'));
		assertTrue(skipList.search('D'));
		assertTrue(skipList.search('E'));
		assertTrue(skipList.search('F'));
		assertTrue(skipList.search('G'));
		assertTrue(skipList.search('H'));
		assertTrue(skipList.search('I'));
		assertTrue(skipList.search('J'));
		
		assertFalse(skipList.search('Z'));
		assertFalse(skipList.insert('A'));
		
		assertTrue(skipList.remove('A'));
		assertFalse(skipList.search('A'));
		
		skipList.insert('A');
		assertTrue(skipList.search('A'));
		
		assertEquals(10, skipList.getSize());
	}
	
}
