package alda.skip_list;

import java.util.Random;


/**
 * ALDA IN8 - uppgift ur boken
 * 
 * Write the routines to perform insertion, deletion, and searching in skip lists.
 * 
 * @author Oskar Steinhauf
 * 
 * @author Filip Fellman
 * 
 * @author Erik Sv�rdson
 * 
 * */


public class MySkipList<T extends Comparable<? super T>>{

	private int sizeOfList;
	private SkipNode<T> startNode;
	
	/**
	 * Konstruktor av skip list.
	 * 
	 * @param antalet levels man vill ha i listan
	 * */

	public MySkipList(int level){
		startNode = new SkipNode<T>(null, level);
		this.sizeOfList = 0;
		
	}
	
	//Default konstruktor
	public MySkipList(){
		this(3);
	}
	

	
	
	/**
	 * Insertion funktionen som l�gger till ett element i listan
	 * 
	 * 
	 * @param element man vill stoppa in
	 * 
	 * @return true om gick att stoppa in
	 * 
	 *  @return false om elementet redan finns
	 *
	 * */
	
	public boolean insert(T data){
		if(search(data)) return false; //L�gg inte till element om elementet redan finns
		
		SkipNode<T> currentNode = startNode;
		SkipNode<T> newSkipNode = new SkipNode<T>(data, setNodeLevel());
		
		int level = currentNode.level-1;
		
		do{
			SkipNode<T> nextNode = currentNode.nextNode[level];
			
			if(nextNode == null){
				if(newSkipNode.level > level){
					newSkipNode.set(nextNode,level);
					currentNode.set(newSkipNode, level);
				}
				level--;
			}else if(newSkipNode.data.compareTo(nextNode.data)>0){
				currentNode = nextNode;
			}else{
				if(level < newSkipNode.level ){
					currentNode.set(newSkipNode, level);
					newSkipNode.set(nextNode, level);
				}
				level--;
			}
			
		}while(0 <= level);
		
		sizeOfList++;
		return true;
	}
	
	
	
	/**
	 * Tar bort ett element ur listan
	 * 
	 * @param elementet att ta bort
	 * 
	 * @return true om elementet tagits bort
	 * 
	 * @return false om elementet inte hittades
	 * 
	 * */
	public boolean remove(T data){
		SkipNode<T> currentNode = startNode;
		int levelInList = currentNode.level-1;
		boolean removed = false;
		do{
			SkipNode<T> nextNode = currentNode.nextNode[levelInList];
			if(nextNode == null){	
				levelInList--;
			}else if(data.compareTo(nextNode.data) == 0){
				/*
				 * Elementet �r hittat och det ska tas bort
				 * */
				currentNode.set(nextNode.nextNode[levelInList],levelInList);
				levelInList--;
				removed = true;
				
			}else if(data.compareTo(nextNode.data)> -1){
				currentNode = nextNode;
				
			}else{
				levelInList--;
			}
			
		}while(0 <= levelInList);
		
		if(removed) sizeOfList--;
		return removed;
	}

	
	
	/**
	 * Letar efter ett element i listan
	 * 
	 *
	 * @param elementet att hitta
	 * 
	 * @return true om elementet har hittats
	 * 
	 * @return false om den inte hittats
	 * */
	public boolean search(T data){
		SkipNode<T> currentNode = startNode;
		SkipNode<T> nextNode = null;
		int level = currentNode.level-1;
		
		do{
			nextNode = currentNode.nextNode[level];
			
			if(nextNode == null){
				level--; continue;
			}else if(data.compareTo(nextNode.data) == 0){
				return true;
			}else if(data.compareTo(nextNode.data) > 0 ){
				currentNode = nextNode;
			}else{
				level--;
			}
		}while(0 <= level);
		

		return false;
	}


	/**
	 * 
	 * �vriga funktioner
	 * 
	 * */
	
	/**
	 * H�mta storleken p� hela listan 
	 **/
	
	public int getSize(){
		return sizeOfList;
	}
	
	/**
	 * S�tter en slumpm�ssig antal levlar f�r noden
	 * 
	 * @return en level som noden ska ha. 
	 */
	private int setNodeLevel(){
		Random r = new Random();
		int levelForNode = 1;
		do{
			levelForNode++;
		}while(levelForNode < startNode.level && r.nextBoolean());
		
		return levelForNode;
	}
	
	/**
	 * Nodklass
	 * */
	
	private class SkipNode<T>{
		private T data; 
		private int level;
		
		private SkipNode<T> [] nextNode;
		
		@SuppressWarnings("unchecked")
		public SkipNode(T data, int level){
			this.data = data;
			this.level = level;
			this.nextNode = (SkipNode<T> []) new SkipNode[level];
		}
		
		public void set(SkipNode<T> node, int level){
			this.nextNode[level] = node;
		}
		
	}


}

