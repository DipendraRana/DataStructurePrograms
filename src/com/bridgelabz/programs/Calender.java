/**********************************************************
 * purpose : takes the month and year as command-line
 * 			 arguments and prints the Calendar of the month.
 * 			 Store the Calendar in an 2D Array, the first
 * 			 dimension the week of the month and the second
 * 			 dimension stores the day of the week
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 31 August 2017          
 **********************************************************/

package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class Calender {
	
	protected String[][] calender;
	
	protected int month;
	
	protected int year;
	
	public Calender(int month,int year) {
		calender=new String[7][7];
		this.month=month;
		this.year=year;
		this.fillCalender();
	}
	
	public void displayCalender() {
		for(int i=0;i<7;i++) {    
		for(int j=0;j<7;j++) {
			if(calender[i][j]==null)
				System.out.format("    ");
			else
				System.out.format("%3s ",calender[i][j]);
		}	
		System.out.println();
	}
	}
	
	public String[][] getCalender(){
		return calender;
	}
	
	public void fillCalender() {
		calender=Utility.calender(month, year);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month=Integer.parseInt(args[0]);
		int year=Integer.parseInt(args[1]);
		Calender calender=new Calender(month,year);
		calender.displayCalender();
	}

}