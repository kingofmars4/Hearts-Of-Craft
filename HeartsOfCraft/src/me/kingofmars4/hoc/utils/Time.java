package me.kingofmars4.hoc.utils;

public class Time {
	
	public static int day = 1;
	public static String month = "January";
	public static int year = 2020;
	
	public static void passTurn() {
		int extra;
		Time.day = Time.day+15;
		
			if (Time.month.equalsIgnoreCase("january")) {
				if (Time.day > 31) {
					extra = Time.day - 31;
					Time.day = extra;
					Time.month = "February";
				}
			} else if (Time.month.equalsIgnoreCase("february")) {
				if (Time.day > 28) {
					extra = Time.day - 28;
					Time.day = extra;
					Time.month = "March";
				}
			} else if (Time.month.equalsIgnoreCase("march")) {
				if (Time.day > 31) {
					extra = Time.day - 31;
					Time.day = extra;
					Time.month = "April";
				}
			} else if (Time.month.equalsIgnoreCase("april")) {
				if (Time.day > 30) {
					extra = Time.day - 30;
					Time.day = extra;
					Time.month = "May";
				}
			} else if (Time.month.equalsIgnoreCase("may")) {
				if (Time.day > 31) {
					extra = Time.day - 31;
					Time.day = extra;
					Time.month = "June";
				}
			} else if (Time.month.equalsIgnoreCase("june")) {
				if (Time.day > 30) {
					extra = Time.day - 30;
					Time.day = extra;
					Time.month = "July";
				}
			} else if (Time.month.equalsIgnoreCase("july")) {
				if (Time.day > 31) {
					extra = Time.day - 31;
					Time.day = extra;
					Time.month = "August";
				}
			} else if (Time.month.equalsIgnoreCase("august")) {
				if (Time.day > 31) {
					extra = Time.day - 31;
					Time.day = extra;
					Time.month = "September";
				}
			} else if (Time.month.equalsIgnoreCase("september")) {
				if (Time.day > 30) {
					extra = Time.day - 30;
					Time.day = extra;
					Time.month = "October";
				}
			} else if (Time.month.equalsIgnoreCase("october")) {
				if (Time.day > 31) {
					extra = Time.day - 31;
					Time.day = extra;
					Time.month = "November";
				}
			} else if (Time.month.equalsIgnoreCase("november")) {
				if (Time.day > 30) {
					extra = Time.day - 30;
					Time.day = extra;
					Time.month = "December";
				}
			} else if (Time.month.equalsIgnoreCase("december")) {
				if (Time.day > 31) {
					extra = Time.day - 31;
					Time.day = extra;
					Time.month = "January";
					Time.year++;
				}
			}
	}
}
