/*********************************************************************
 * purpose : Queue implementation
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 11 September 2017          
 *********************************************************************/

package com.bridgelabz.utility;

import java.util.ArrayList;

public class Queue<T> {
	
	public ArrayList<T> array;
	
	public int topOfArray,firstOfArray;
	
	public Queue() {
		array=new ArrayList<T>();
		topOfArray=-1;
		firstOfArray=-1;
	}
	
	public boolean isEmpty() {
		return (array.size()==0);
	}
	
	public void enqueue(T element) {
		if(isEmpty()) {
			topOfArray++;
			firstOfArray++;
			array.add(topOfArray, element);
		}
		else {
			topOfArray++;
			array.add(topOfArray, element);
		}
	}
	
	public void dequeue() {
		if(isEmpty()) 
			System.out.println("Empty Queue");
		else {
			array.remove(firstOfArray);
			topOfArray--;
		}
	}

}
