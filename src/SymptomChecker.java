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
		} else {
			calendar = new Calendar();
			calendar.scheduleUpcomingTests();
		}

		System.out.println(calendar.displayCalendar());
		System.out.println();
		int date = getDate(input);
		mainBehavior(input, calendar, date);
		System.out.println(calendar.displayCalendar());
		calendar.saveCalendar("Calendar.txt");
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
	public static void mainBehavior(Scanner in, Calendar c, int date){
		System.out.println("What do you want to do?");
		System.out.println("1. Print calendar\n2. Add event to calendar\n3. Check the events on a certain date\n4. Mark test as completed\n5. Save the calendar to a file\n6. Change the current date");
		String options = in.nextLine();
		int intOptions = Integer.parseInt(options);
		if(intOptions == 1){
			System.out.println(c.displayCalendar());
		} else if (intOptions == 2){
			System.out.println("What type of event do you want to add?");
			System.out.println("Put TestResult if you want test results or input anything else for a symptom report");
			String eventOption = in.nextLine();
			System.out.println("What time are you reporting? (please include AM/PM)");
			String time = in.nextLine();
			if (eventOption.toLowerCase().equals("testresult")){
				System.out.println("What was the result of your COVID test?");
				String description = in.nextLine();
				TestResult result = new TestResult(date,time,description);
				c.addEvent(result);
			} else {
				SymptomReport symptom = new SymptomReport(date, time);
				System.out.println("What symptoms do you have currently. Input all symptoms one at a time and input 0 when done");
				symptom.printSymptoms();
				String currentSymptom = in.nextLine();
				int currentSymptomInt = Integer.parseInt(currentSymptom);
				while(currentSymptomInt >= 1 && currentSymptomInt <= 12){
					symptom.addSymptoms(currentSymptomInt);
					System.out.println("What symptoms do you have currently. Input all symptoms one at a time and input 0 when done");
					symptom.printSymptoms();
					currentSymptom = in.nextLine();
					currentSymptomInt = Integer.parseInt(currentSymptom);
				}
				c.addEvent(symptom);
			}
		} else if (intOptions == 3) {
			// checking events
			System.out.println("What date would you like to check for events?");
			int checkDate = Integer.parseInt(in.nextLine());
			CalendarEvent[] events = c.getEvents(checkDate);
			System.out.println("We found " + events.length + " events on March " + checkDate + ".");
			System.out.println();
			for (CalendarEvent event: events) {
				if (event instanceof SymptomReport) {
					System.out.println("Symptom Report");
				}
				else if (event instanceof TestResult) {
					System.out.println("Test Result");
				}
				else if (event instanceof UpcomingTest) {
					System.out.println("Upcoming Test");
				}
				System.out.println("Time: " + event.getTime());
				System.out.println("Description: " + event.getDescription());
				System.out.println();
			}
		} else if (intOptions == 4) {
			// mark test completed
			System.out.println("Marking all tests from today as completed.");
			CalendarEvent[] events = c.getEvents(date);
			for (CalendarEvent event: events) {
				if (event instanceof UpcomingTest) {
					((UpcomingTest) event).completeTest();
				}
			}
		} else if (intOptions == 5) {
			// save calendar
		} else if (intOptions == 6) {
			// change date
		}
	}
}
