/*********************************************************************
 * purpose : 1. Create the Week Object having a list of WeekDay objects
 * 			 each storing the day(i.e S,M,T,W,Th,..) and the 
 * 			 Date(1,2,3..) . The WeekDay objects are stored in a Queue
 * 			 implemented using Linked List. Further maintain also a
 * 			 Week Object in a Queue to finally display the Calendar.
 * 
 * 			 2.Modify the above program to store the Queue in two Stacks.
 * 			 Stack here is also implemented using Linked List and not
 * 			 from Collection Library
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 13 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.QueueLinkedList;
import com.bridgelabz.utility.Utility;

public class Week {
	
	protected String day;
	
	protected String date;
	
	protected String[][] calender;
	
	protected Calender week;
	
	public Week() {
		this.day=null;
		this.date=null;
		this.calender=null;
	}
	
	public Week(int month,int year) {
		week=new Calender(month,year);	//calling calendar class
		calender=week.getCalender();
	}
	
	public String[][] getCalendar() {
		return calender;
	}
	
	public void displayCalender() {
		week.displayCalender();
	}
	
	public Week(String day,String date) {
		this.day=day;
		this.date=date;
	}
	
	public static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the month in number:");
		int month=scanner.nextInt();
		System.out.println("Enter the year:");
		int year=scanner.nextInt();
		Week week=new Week(month,year);
		QueueLinkedList<Week> cloneQueue=Utility.storingCalenderToQueue(week.getCalendar(),month,year);
		Week printCalender=cloneQueue.topElement();	//Accessing top element of queue which is a object
		printCalender.displayCalender();	//that object will display the calendar and below it there are objects storing day and date of a calendar 
		Utility.storingQueueToTwoStack(cloneQueue);	//storing queue to two stack
	}

}
