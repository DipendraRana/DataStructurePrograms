/*********************************************************************
 * purpose : Create a Slot of 10 to store Chain of Numbers that belong
 * 			 to each Slot to efficiently search a number from a given
 * 			 set of number.Firstly store the numbers in the Slot.
 * 			 Since there are 10 Numbers divide each number by 11 and
 * 			 the reminder put in the appropriate slot. Create a Chain
 * 			 for each Slot to avoid Collision. If a number searched is
 * 			 found then pop it or else push it. Use Map of Slot Numbers
 * 			 and Ordered LinkedList to solve the problem. In the Figure
 * 			 Below, you can see number 77/11 reminder is 0 hence sits
 * 			 in the 0 slot while 26/11 remainder is 4 hence sits in
 * 			 slot 4
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 11 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class HashingFuction {
	
	public static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<LinkedList<Integer>> slot=new ArrayList<LinkedList<Integer>>();
		String address=scanner.next();
		int searchNumber=scanner.nextInt();
		String[] words = Utility.readFromFile(address);
		int[] numbers=new int[words.length];
		int i=0;
		for(String word:words) {
			numbers[i]=Integer.parseInt(word);
			i++;
		}
		slot=Utility.searchInSlotHashing(numbers,searchNumber);
		System.out.println("Enter the file name to which the array is going to be stored:");
		String destinationAddress=scanner.next();
		FileWriter file=new FileWriter(destinationAddress);
		PrintWriter writeToFile=new PrintWriter(file);
		for(i=0;i<11;i++) {
			if(slot.get(i).size()>=1) {
				for(int j=0;j<slot.get(i).size();j++)
					writeToFile.write(String.valueOf(slot.get(i).get(j))+" ");
			}
		}
		file.close();
	}

}
