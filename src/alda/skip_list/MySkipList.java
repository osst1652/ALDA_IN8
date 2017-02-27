package alda.skip_list;

import java.util.Random;


/**
 * ALDA IN8 - uppgift ur boken
 * 
 * Write the routines to perform insertion, deletion, and searching in skip lists.
 * 
 * 
 * 
 * @author Oskar Steinhauf
 * 
 * */


public class MySkipList<K extends Comparable<K>, V>{
	
	private SkipNode head;
	private Random random;
	private long siz;
	private double probabilityFactor;
	
	
	/**
	 * Konstruktor av skip list.
	 * */
	public MySkipList() {
		head = new SkipNode (null, null, null, null, 0);
		random = new Random();
		siz = 0;
		probabilityFactor = 0.5;
		
	}
	
	/**
	 * Insert an element in the skip list.
	 * 
	 * @param key
	 * 
	 * @param value
	 * 
	 *
	 * */
	public void Insert(K key, V value){
		
	}
	
	
	/**
	 * Delete an element in the skip list.
	 * 
	 * @param Key of which this element in the list will be removed
	 * 
	 * */
	public V delete(K key){
		V value = null;
		
		return value;
	}
	
	
	/**
	 * Searching for an element in the skip List
	 * 
	 *
	 * @param key
	 * 
	 * */
	
	public V get(K key){
		
		return null;
	}
	

	/**
	 * All the private functions and methods that are used.

	 * */

	private long level(){
		long level = 0;
		do{
			level++;
		}while(level <= siz && random.nextDouble() < probabilityFactor);
		return level;
	}

	private class SkipNode{
		public K key;
		public V value;
		
		public SkipNode next;
		public SkipNode down;
		
		public long level;
	
		public SkipNode(K key, V value, SkipNode next, SkipNode Down, long level){
			this.key = key;
			this.value = value;
			this.next = next;
			this.down = down;
			this.level = level;
		}
	
	}
}

