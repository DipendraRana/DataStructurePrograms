/*********************************************************************
 * purpose : Take an Arithmetic Expression such as
 * 			 (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) where parentheses are
 * 			 used to order the performance of operations. Ensure
 * 			 parentheses must appear in a balanced fashion.
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 9 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class BalancedParanthesisChecker {
	
	public static Scanner scan=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Arithematic Expression:");
		String expression=scan.nextLine();
		boolean isBalanced=Utility.simpleBalancedParanthesis(expression);
		System.out.println("Is Balanced:"+isBalanced);
	}

}
