/*********************************************************************
 * purpose : Create a Program which creates Banking Cash Counter where
 * 			 people come in to deposit Cash and withdraw Cash. Have an
 * 			 input panel to add people to Queue to either deposit or
 * 			 withdraw money and dequeue the people. Maintain the Cash
 * 			 Balance.
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 9 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;
import com.bridgelabz.utility.Queue;
import com.bridgelabz.utility.Utility;

public class BankingCashCounter {
	
	public static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer;
		System.out.println("How much cash is there, today?");
		int cashBalance=scanner.nextInt();
		do {
			Queue<Integer> queue=new Queue<Integer>();
			System.out.println("How many people are standing in queue");
			int countingPeople=scanner.nextInt();
			for(int i=1;i<=countingPeople;i++)
				queue.enqueue(i);
			int i=1;
				while(!queue.isEmpty()) {
				System.out.println("Person "+i);
				System.out.println("What do you want to do:");
				System.out.println("1. Withdrawl");
				System.out.println("2. Deposit");
				int choice=scanner.nextInt();
				cashBalance=Utility.simulateCashCounter(cashBalance, choice, (Queue<Integer>) queue);
				System.out.println();
				i++;
			}
			System.out.println("Would you attend more People(yes/no)");
			answer=scanner.next();
		}while(answer.equals("yes"));
	}

}
