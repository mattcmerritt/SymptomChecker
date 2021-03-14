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

		System.out.println(
				"Would you like to start a new calendar or load a calendar from a file? (\"load\" to use a file, anything else to start a new one)");
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
		} else {
			calendar = new Calendar();
			calendar.scheduleUpcomingTests();
		}

		System.out.println(calendar.displayCalendar());
        System.out.println();
		System.out.println(getDate(input));
	}

	public static int getDate(Scanner input) {
		System.out.println("What is today's date? (ex. 1-31)");
		String input2 = input.nextLine();
		int date = Integer.parseInt(input2);
		
		if (date <= 31 && date >= 1) {
			return date;
		}
		
		else {
			return getDate(input);
		}
		
	}
}
