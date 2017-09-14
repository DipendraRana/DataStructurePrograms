/*********************************************************************
 * purpose : You are given N nodes, each having unique value ranging
 * 			 from [1, N], how many different binary search tree can be
 * 			 created using all of them.
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 14 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class NoOfBinaryTree {
	
	public static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter the no. of test casses:");
		int noOfTestCasses=scanner.nextInt();
		int[] storeNode=new int[noOfTestCasses];
		for(int i=0;i<noOfTestCasses;i++) {
			System.out.print("Enter case "+(i+1)+": ");
			storeNode[i]=scanner.nextInt();
		}
		for(int i=0;i<storeNode.length;i++) {
			int noOfBTreePosssible=Utility.binaryTreePossible(storeNode[i]);
			System.out.println("For Node "+storeNode[i]+" Possible Binary search Trees are: "+noOfBTreePosssible);
		}
	}

}
