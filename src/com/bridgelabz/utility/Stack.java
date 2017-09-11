/*********************************************************************
 * purpose : Stack implementation
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 11 September 2017          
 *********************************************************************/

package com.bridgelabz.utility;

import java.util.ArrayList;

public class Stack<T> {
	
	public ArrayList<T> array;
	
	public int topOfArray;
	
	public Stack() {
		array=new ArrayList<T>();
		topOfArray=-1;
	}
	
	public void push(T element) {
		topOfArray++;
		array.add(topOfArray, element);
	}
	
	public void pop() {
		if(topOfArray==-1)
			System.out.println("Stack is empty");
		else {
			array.remove(topOfArray);
			topOfArray--;
		}	
	}
	
	public boolean isEmpty() {
		return (topOfArray==-1);
	}
}
