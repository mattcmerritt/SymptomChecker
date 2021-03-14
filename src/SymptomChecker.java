import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class SymptomChecker {

	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);

		System.out.println("**************Welcome to the Quinnipiac Symptom Checker App****************** \n");
		
		System.out.println("Would you like to start a new calendar or load a calendar from a file? (\"load\" to use a file, anything else to start a new one)");
		String calendarChoice = input.nextLine();
		Calendar calendar;
		if (calendarChoice.toLowerCase().equals("load")) {
			do {
				File currentDirectory = new File(".");
				System.out.println("Please input a filename: ");
				System.out.println("The current directory is " + currentDirectory.getAbsolutePath());
				String calendarFilename = input.nextLine();
				calendar = Calendar.loadCalendar(calendarFilename);
				if (calendar == null) {
					System.out.println("Sorry, that file could not be found. Please try again.");
				}
			} while (calendar == null);
		}
		else {
			calendar = new Calendar();
			calendar.scheduleUpcomingTests();
		}
		
		System.out.println(calendar.displayCalendar());
		System.out.println();
		
		
		
		

		System.out.println("                   Please type in one number for one of the following options:");
		System.out.println("                   1. SymtomApp (To take your daily Symptom Checker Test)");
		System.out.println("                   2. TestResult (To view your test results)");
		System.out.println("                   3. UpcomingTest (To view your upcoming test)");
		System.out.println("                   4. Calender (To view the current month)");

		
		Double amount = input.nextDouble();
		int amountInt = (int) Math.round(amount);

		System.out.println("loading up...  \n");

		if (amountInt == 1) {
			System.out.println("Welcome to the SymtpomApp");

		}

		else if (amountInt == 2) {
			System.out.println("test2");
		} else if (amountInt == 3) {
			System.out.println("test3");
		}

		else if (amountInt == 4) {
			System.out.println("test4");
		}

		else {
			System.out.println("Please enter a valid option (numbers only)");
		}
	}

}
