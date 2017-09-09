/*********************************************************************
 * purpose : Read the Text from a file, split it into words and
 * 			 arrange it as Linked List. Take a user input to search a
 * 			 Word in the List. If the Word is not found then add it to
 * 			 the list, and if it found then remove the word from the
 * 			 List. In the end save the list into a file.
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 8 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class UnOrderedList {
	
	public static Scanner scan=new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the address of the file:");
		String address=scan.nextLine();
		System.out.println("Enter the word you want to search:");
		String findWord=scan.next();
		Utility.checkForWord(address, findWord);
	}

}
