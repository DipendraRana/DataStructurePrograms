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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month=Integer.parseInt(args[0]);
		int year=Integer.parseInt(args[1]);
		Utility.calender(month, year);
	}

}