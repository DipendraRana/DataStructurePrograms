/*********************************************************************
 * purpose : Extend the Prime Number Program and store only the
 * 			 numbers in that range that are Anagrams. For e.g. 17 and
 * 			 71 are both Prime and Anagrams in the 0 to 1000 range.
 * 			 Further store in a 2D Array the numbers that are Anagram
 * 			 and numbers that are not Anagram
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 10 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class PrimeAndAnagram {
	
	public static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int minRange=scanner.nextInt();
		int maxRange=scanner.nextInt();
		Utility.primeAndAnagram(minRange, maxRange);

	}

}
