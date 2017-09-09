/***********************************************
 * purpose : To store all logic of the programs
 *           
 * @author Dipendra Rana
 * @version 5.0
 * @since 24 August 2017          
 ***********************************************/

package com.bridgelabz.utility;

import java.util.Scanner;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Utility {

	public static Scanner scanner = new Scanner(System.in);

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
		switch(choice) {
		case 1:	System.out.println("Enter the amount to be Withdrawn:");
				amount=scanner.nextInt();
				if(amount<=cashBalance) 
					cashBalance=cashBalance-amount;
				else
					System.out.println("Out Of cash");
				queue.poll();
				break;
		case 2:	System.out.println("Enter the amount to Deposit:");
				amount=scanner.nextInt();
				cashBalance=cashBalance+amount;
				queue.poll();
				break;
		}
		return cashBalance;
	}
}