/*********************************************************************
 * purpose : Add the Prime Numbers that are Anagram in the Range of
 * 			 0 - 1000 in a Queue using the Linked List and Print the
 * 			 Anagrams from the Queue. Note no Collection Library can
 * 			 be used.
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 8 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class PrintAnagramFromQueue {
	
	public static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int minRange=scanner.nextInt();
		int maxRange=scanner.nextInt();
		Utility.printAnagramQueue(minRange, maxRange);
	}

}
