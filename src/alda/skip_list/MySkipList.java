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
		head = new SkipNode (null, null, null, null, 0); // K key, V value, SkipNode next, SkipNode down, Lon level
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
		
		
		long level = level();
		
		if(head.level < level){
			head = new SkipNode(null,null, null, head, level);
		}
		
		SkipNode currentNode = head;
		SkipNode lastNode = null;
		
		while(currentNode != null){
			if(currentNode.next.key.compareTo(key) > 0 || currentNode.next == null){
				if(currentNode.level <= level){
					SkipNode n = new SkipNode(key, value, currentNode.next, null, currentNode.level);
					if(lastNode != null){
						lastNode.down = n;
					}
					
					currentNode.next = n;
					lastNode = n;
				}
				
				currentNode = currentNode.down;
				continue;
			}else if(currentNode.next.key.equals(key)){
				currentNode.next.value= value;
				return;
			}
			
			currentNode = currentNode.next;
		}
		siz++;
		
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

