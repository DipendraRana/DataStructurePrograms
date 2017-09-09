/*********************************************************************
 * purpose : Read a List of Numbers from a file and arrange it
 * 			 ascending Order in a Linked List. Take user input for a
 * 			 number, if found then pop the number out of the list else
 * 			 insert the number in appropriate position
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 8 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class OrderedList {
	
	public static Scanner scan=new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the address of the file:");
		String address=scan.nextLine();
		System.out.println("Enter the number you want to search:");
		int findNumber=scan.nextInt();
		Utility.checkForNumber(address, findNumber);
	}

}
