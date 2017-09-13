/*********************************************************************
 * purpose : A palindrome is a string that reads the same forward and
 * 			 backward, for example, radar, toot, and madam. We would
 * 			 like to construct an algorithm to input a string of
 * 			 characters and check whether it is a palindrome.
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 9 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class PalindromeChecker {
	
	public static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word=scanner.next();
		Utility.palindromeChecker(word);
	}

}
