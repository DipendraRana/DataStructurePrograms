/***********************************************
 * purpose : To store all logic of the programs
 *           
 * @author Dipendra Rana
 * @version 8.0
 * @since 7 August 2017          
 ***********************************************/

package com.bridgelabz.utility;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import com.bridgelabz.programs.Week;
import com.bridgelabz.utility.Queue;

public class Utility {

	public static Scanner scanner = new Scanner(System.in);
	
	public static String[] weeks= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	
	public static int[] daysInMonth= {31,28,31,30,31,30,31,31,30,31,30,31,30,31};
	
	public static int count = 0;

	public static String[] readFromFile(String address) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader file=new BufferedReader(new InputStreamReader(new FileInputStream(address)));		
		String lines=null;
		ArrayList<String> words=new ArrayList<String>();
		while((lines=file.readLine())!=null)
			words.add(lines);
		String[] cloneWords=words.toArray(new String[words.size()]);
		for(int i=0;i<cloneWords.length;i++) {
			cloneWords[i]=cloneWords[i].replaceAll("[()?:!.,;{}]+", "");
		}
		words.clear();
		for(int i=0;i<cloneWords.length;i++) {
			ArrayList<String> newWords=new ArrayList<String>(Arrays.asList(cloneWords[i].split("\\s+")));
			for(int j=0;j<newWords.size();j++)
				words.add(newWords.get(j));
		}
		cloneWords=words.toArray(new String[words.size()]);
		/*System.out.println(Arrays.toString(cloneWords));*/
		return cloneWords;
	}
	
	public static void checkForWord(String sourceAddress,String findWord) throws IOException {
		List<String> array=new LinkedList<String>(Arrays.asList(readFromFile(sourceAddress)));
		if(array.contains(findWord)) {
			System.out.println("Found the word.....removing from list");
			array.remove(findWord);
		}	
		else {
			System.out.println("Not Found the word.....Adding the word to list");
			array.add(findWord);
		}
		System.out.println("Enter the file name to which the array is going to be stored:");
		String destinationAddress=scanner.nextLine();
		FileWriter file=new FileWriter(destinationAddress);
		PrintWriter writeToFile=new PrintWriter(file);
		for(String word : array) 
			writeToFile.write(word+" ");
		file.close();
		//System.out.println(array);
	}

	public static void checkForNumber(String sourceAddress,Integer findNumber) throws IOException {
		String[] stringArray=readFromFile(sourceAddress);
		List<Integer> integerArray=new LinkedList<Integer>();
		for(int i=0;i<stringArray.length;i++)
			integerArray.add(i, Integer.parseInt(stringArray[i]));
		if(integerArray.contains(findNumber)) {
			System.out.println("Found the number.....removing from list");
			integerArray.remove(findNumber);
		}	
		else {
			System.out.println("Not Found the number.....Adding to list");
			integerArray.add(findNumber);
		}
		Collections.sort(integerArray);
		System.out.println("Enter the file name to which the array is going to be stored:");
		String destinationAddress=scanner.nextLine();
		FileWriter file=new FileWriter(destinationAddress);
		PrintWriter writeToFile=new PrintWriter(file);
		for(Integer number : integerArray) 
			writeToFile.write(number+" ");
		file.close();
		
	}
	
	public static  boolean simpleBalancedParanthesis(String expression) {
		Stack<Character> stack=new Stack<Character>();
		char[] newString=expression.toCharArray();
		for(int i=0;i<newString.length;) {
			if(newString[i]=='(') {
				stack.push(newString[i]);
				i++;
			}
			else if(newString[i]==')') {
				if(stack.isEmpty())
					return false;
				else {	
				stack.pop();
				i++;
				}
			}
			else
				i++;
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	
	public static int simulateCashCounter(int cashBalance,int choice,Queue<Integer> queue) {
		int amount;
		String option;
		switch(choice) {
		case 1:	System.out.println("Enter the amount to be Withdrawn:");
				amount=scanner.nextInt();
				if(amount<=cashBalance) { 
					cashBalance=cashBalance-amount;
					System.out.println("Transaction SuccesFull");
					queue.dequeue();
				}	
				else {
					if(cashBalance==0) {
						System.out.println("Soory!! No Cash");
						queue.dequeue();
					}	
					else {
						System.out.println("Soory!!Could not Dispense that much amount");
						System.out.println("Wanna try for less amount(yes/no)");
						option=scanner.next();
						if(option.equals("yes"))
							cashBalance=simulateCashCounter(cashBalance,1,queue);
						else
							queue.dequeue();
					}
				}	
				break;
		case 2:	System.out.println("Enter the amount to Deposit:");
				amount=scanner.nextInt();
				cashBalance=cashBalance+amount;
				System.out.println("Money added SuccesFully");
				queue.dequeue();
				break;
		default: System.out.println("Wrong Option");
				 System.out.println("Have another try");
				 System.out.println("What do you want to do:");
				 System.out.println("1. Withdrawl");
				 System.out.println("2. Deposit");
				 choice=scanner.nextInt();
				 if(choice==1)
					 cashBalance=simulateCashCounter(cashBalance,1,queue);
				 else
					 cashBalance=simulateCashCounter(cashBalance,2,queue);
		}
		return cashBalance;
	}

	public static void palindromeChecker(String word) {
		Deque<Character> deque=new LinkedList<Character>();
		int halfOfWordLength=(int)Math.ceil(word.length()/2.0);
		for(int i=0;i<word.length();i++) 
			deque.add(word.charAt(i));
		while(!deque.isEmpty()) {
			if(deque.getFirst().equals(deque.getLast())) 
				count++;
			else 
				break;
			if(word.length()%2!=0&&count==halfOfWordLength) //when word length is odd and count reaches the halfOfWordLength
				deque.removeFirst();						//then remove only one element else we may get error when we try 
			else {											//execute deque.removeFirst() and deque.removeLast()
				deque.removeFirst();
				deque.removeLast();
			}
		}
		if(count==halfOfWordLength)
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
		
	}
	
	public static String[][] calender(int month,int year) {
		daysInMonth[1]=28;
		String[][] calender=new String[7][7];
		for(int i=0;i<7;i++) 
			calender[0][i]=weeks[i];
		if(!leapYearFinder(year)||month!=2) {
			calenderDatesFillUp(calender,month,year);
		}
		else {
			daysInMonth[1]=29;
			calenderDatesFillUp(calender,month,year);
		}
		return calender;
	}
	
	public static void calenderDatesFillUp(String[][] calender,int month,int year) {
		for(int i=1,k=1;i<7&&k<=daysInMonth[month-1];i++) {
			if(i==1) {
				for(int j=dayOfWeek(1,month,year);j<7;j++,k++)
					calender[1][j]=Integer.toString(k);
			}
			else {
				for(int j=0;j<7&&k<=daysInMonth[month-1];j++,k++)
					calender[i][j]=Integer.toString(k);
			}
		}
	}
	
	public static boolean leapYearFinder(int year) {
		if (Utility.numberOfDigitChecker(year) == 4) {
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
				return true;
				//System.out.println("Leap Year");
			else
				return false;
				//System.out.println("Not Leap Year");
		}
		else
			return false;
	}
	
	public static int numberOfDigitChecker(int number) {
		while (number != 0) {
			number = number / 10;
			count++;
		}
		return count;
	}
	
	public static int dayOfWeek(int day,int month,int year) {
		int y0= year-(14-month)/12;
		int x=y0+y0/4-y0/100+y0/400;
		int m0=month+12*((14-month)/12)-2;
		int dayOfWeek=(day+x+31*m0/12)%7;
		return dayOfWeek;
	}

	public static ArrayList<ArrayList<Integer>> primeNoToStoreInArray(int minRange,int maxRange ) {
		ArrayList<ArrayList<Integer>> twoDArray=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<10;i++)
			twoDArray.add(new ArrayList<Integer>());
		for(int i=minRange;i<maxRange;i++) {
			if(primeChecker(i)&&i!=0&&i!=1) {
				if(i<=100)
					twoDArray.get(0).add(i);
				else if(i>100&&i<=200)
					twoDArray.get(1).add(i);
				else if(i>200&&i<=300)
					twoDArray.get(2).add(i);
				else if(i>300&&i<=400)
					twoDArray.get(3).add(i);
				else if(i>400&&i<=500)
					twoDArray.get(4).add(i);
				else if(i>500&&i<=600)
					twoDArray.get(5).add(i);
				else if(i>600&&i<=700)
					twoDArray.get(6).add(i);
				else if(i>700&&i<=800)
					twoDArray.get(7).add(i);
				else if(i>800&&i<=900)
					twoDArray.get(8).add(i);
				else 
					twoDArray.get(9).add(i);
				count++;
			}	
		}
		/*for(int i=0;i<10;i++) {
			for(int j=0;j<twoDArray.get(i).size();j++) {
				System.out.format("%4d ",twoDArray.get(i).get(j));
			}
			System.out.println();
		}*/
		return twoDArray;
	}
	
	public static ArrayList<String> primeAndAnagram(int minRange,int maxRange){
		ArrayList<String> oneDArray=new ArrayList<String>();
		ArrayList<ArrayList<String>> twoDArray=new ArrayList<ArrayList<String>>();
		for(int i=0;i<2;i++)
			twoDArray.add(new ArrayList<String>());
		oneDArray=primeFinderInRange(minRange,maxRange);
		for(int i=0;i<oneDArray.size();i++) {
			int count=0;
			for(int j=0;j<oneDArray.size();j++){
				if(anagramChecker(oneDArray.get(i),oneDArray.get(j))&&oneDArray.get(i)!=oneDArray.get(j)) 
					count++;
			}
			if(count>0)
				twoDArray.get(0).add(oneDArray.get(i));
			else
				twoDArray.get(1).add(oneDArray.get(i));
		}
		/*for(int i=0;i<twoDArray.size();i++){
			for(int j=0;j<twoDArray.get(i).size();j++)
				System.out.print(twoDArray.get(i).get(j)+" ");
			System.out.println();
		}*/
		return twoDArray.get(0);
	}
	
	public static boolean anagramChecker(String word1,String word2) {
		count=0;
		int countn=0;
		if(word1.length()==word2.length()) {
			for(int j=0;j<word1.length();j++) {
				for(int i=0;i<word1.length();i++) {
					if(word1.charAt(i)==word1.charAt(j))
						count++;
				}
				for(int i=0;i<word2.length();i++) {
					if(word1.charAt(j)==word2.charAt(i))
						countn++;
				}
				if(count!=countn)
					return false;
			}
			if(count==countn)
				return true;
			else
				return false;
		}
		else 
			return false;
	}
	
	public static ArrayList<String> primeFinderInRange(int minRange,int maxRange) {
		ArrayList<String> store=new ArrayList<String>();
		for(int i=minRange;i<maxRange;i++) {
			if(primeChecker(i)&&i!=0&&i!=1) {
				//System.out.println(i);
				store.add(Integer.toString(i));
			}	
		}
		return store;
	}
	
	public static boolean primeChecker(int number) {
		count=0;
		for(int i=2;i<=number/2;i++) {
			if(number%i==0)
				count++;
		}
		if(count==0)
			return true;
		else
			return false;
	}

	public static void printReverseOrderAnagram(int minRange,int maxRange) {
		ArrayList<String> storeArray=primeAndAnagram(minRange,maxRange);
		LinkedList<String> stackLinkedList=new LinkedList<String>();
		for(int i=0;i<storeArray.size();i++)
			stackLinkedList.push(storeArray.get(i));
		System.out.println(stackLinkedList);
		
	}

	public static void printAnagramQueue(int minRange,int maxRange) {
		ArrayList<String> storeArray=primeAndAnagram(minRange,maxRange);
		LinkedList<String> queueLinkedList=new LinkedList<String>();
		for(int i=0;i<storeArray.size();i++)
			queueLinkedList.add(storeArray.get(i));
		System.out.println(queueLinkedList);
	}

	public static ArrayList<LinkedList<Integer>> searchInSlotHashing(int[] numbers,int findNumber) {
		ArrayList<LinkedList<Integer>> slot=new ArrayList<LinkedList<Integer>>(11);
		for(int i=0;i<11;i++) {
			slot.add(new LinkedList<Integer>());
		}
		for(int number:numbers)
			slot.get(number%11).add(number);
		if(slot.get(findNumber%11).size()>=1) {
			Collections.sort(slot.get(findNumber%11));	
			if(Collections.binarySearch(slot.get(findNumber%11), findNumber)==-1) {
				System.out.println("Number Not Found");
				slot.get(findNumber%11).add(findNumber);
				Collections.sort(slot.get(findNumber%11));
			}
			else {
				System.out.println("Number Found");
				slot.get(findNumber%11).remove(Integer.valueOf(findNumber));
			}	
		}
		else {
			System.out.println("Number Not Found");
			slot.get(findNumber%11).add(findNumber);
			Collections.sort(slot.get(findNumber%11));
		}
		return slot;
	}

	public static QueueLinkedList<Week> storingCalenderToQueue(String[][] calendar,int month,int year) {
		QueueLinkedList<Week> weekDay=new QueueLinkedList<Week>();
		for(int i=1;i<calendar.length;i++) {	//storing objects of week each containing the day and date
			for(int j=0;j<calendar[0].length;j++) {
				if(calendar[i][j]!=null)
					weekDay.enqueue(new Week(calendar[0][j],calendar[i][j]));
				else
					weekDay.enqueue(new Week(calendar[0][j],""));
			}
		}
		weekDay.enqueue(new Week(month,year));
		return weekDay;
	}
	
	public static <T> void storingQueueToTwoStack(QueueLinkedList<T> cloneQueue) {
		StackLinkedList<QueueLinkedList<T>> stackToStoreQueue1=new StackLinkedList<QueueLinkedList<T>>();
		StackLinkedList<QueueLinkedList<T>>  stackToStoreQueue2=new StackLinkedList<QueueLinkedList<T>> ();
		stackToStoreQueue1.push(cloneQueue);
		stackToStoreQueue2.push(cloneQueue);
	}

	public static int binaryTreePossible(int noOfNode) {
		int sum=0,sumTill=0;
		if(noOfNode==0||noOfNode==1)
			return 1;
		else {
			
			while(sumTill<noOfNode) {
				sumTill++;
				sum=sum+binaryTreePossible(sumTill-1)*binaryTreePossible(noOfNode-sumTill);
			}
			return sum;
		}
	}
}