import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;



import java.util.Scanner;

public class Calendar {

	private ArrayList<CalendarEvent> _scheduledEvents;
	private int _startingDay; // starting day is what day the month starts on, 0 is Sunday, 6 is Saturday
	private int _daysInMonth;

	// default constructor to create a blank calendar
	public Calendar() {
		_scheduledEvents = new ArrayList<CalendarEvent>();
		_startingDay = 1; // March 2021 starts on a Monday
		_daysInMonth = 31; // March has 31 days
	}

	// adds a given event into the calendar
	public void addEvent(CalendarEvent e) {
		_scheduledEvents.add(e);
	}

	// returns an array of events from a given day
	public CalendarEvent[] getEvents(int date) {
		CalendarEvent[] matchingEvents = new CalendarEvent[0];
		for (int i = 0; i < _scheduledEvents.size(); i++) {
			if (_scheduledEvents.get(i).getDate() == date) {
				// creating a temporary array with room for an additional element
				CalendarEvent[] longerArray = Arrays.copyOf(matchingEvents, matchingEvents.length + 1);
				longerArray[longerArray.length - 1] = _scheduledEvents.get(i);
				// overwriting previous array with longer array
				matchingEvents = longerArray;
			}
		}
		return matchingEvents;
	}

	// returns a graphical representation of a standard calendar with characters around
	// [] around days with a symptom report, () around days with an test result, and !! around days with an upcoming test
	public String displayCalendar() {
		String output = "";
		output += "    Su        Mo        Tu        We        Th        Fr        Sa    \n";
		for (int i = 0; i < _startingDay; i++) {
			output += String.format("%-10s" , "");
		}
		for (int date = 1; date <= _daysInMonth; date++) {

			// determining what events need to be shown for the given day
			CalendarEvent[] eventsOnDay = getEvents(date);
			boolean hasSymptomReport = false, hasTestResult = false, hasUpcomingTest = false;
			for (CalendarEvent event: eventsOnDay) {
				if (event instanceof SymptomReport)
					hasSymptomReport = true;
				else if (event instanceof TestResult)
					hasTestResult = true;
				else if (event instanceof UpcomingTest)
					hasUpcomingTest = true;
			}

			// adding the symbols around the date
			String day = "    " + String.format("%-6s" , "" + date);
			if (hasSymptomReport) {
				day = day.substring(0, 3) + "[" + day.substring(4, 6) + "]" + day.substring(7);
			}
			if (hasTestResult) {
				day = day.substring(0, 2) + "(" + day.substring(3, 7) + ")" + day.substring(8);
			}
			if (hasUpcomingTest) {
				day = day.substring(0, 1) + "!" + day.substring(2, 8) + "!" + day.substring(9);
			}

			// adding the current day to the output and line breaks for each week
			output += day;
			if ((date + _startingDay) % 7 == 0) {
				output += "\n";
			}

		}
		return output;
	}

	public static Calendar loadCalendar(String filename) {
		Calendar calendar = new Calendar();
		File calendarFile = new File(filename);
		try (Scanner fileScanner = new Scanner(calendarFile)) {
			while (fileScanner.hasNextLine()) {

				String type = fileScanner.nextLine();
				int date = Integer.parseInt(fileScanner.nextLine());
				String time = fileScanner.nextLine();
				String description = fileScanner.nextLine();

				CalendarEvent event;

				if (type.equals("Symptom Report")) {
					event = new SymptomReport(date, time);
					((SymptomReport) event).addDescription(description);
					calendar.addEvent(event);
				}
				else if (type.equals("Test Result")) {
					event = new TestResult(date, time, description);
					calendar.addEvent(event);
				}
				else if (type.equals("Upcoming Test")) {
					event = new UpcomingTest(date, time, description);
					calendar.addEvent(event);
				}
				else {
					System.out.println("Bad event in calendar, skipping");
				}

			}

			return calendar;
		}
		catch (FileNotFoundException e) {
			return null;
		}
	}

	public void saveCalendar(String filename) {
		try {
			FileWriter fileWriter = new FileWriter(filename);
			PrintWriter out = new PrintWriter(fileWriter);

			for (CalendarEvent event: _scheduledEvents) {
				if (event instanceof SymptomReport) {
					out.println("Symptom Report");
				}
				else if (event instanceof TestResult) {
					out.println("Test Result");
				}
				else if (event instanceof UpcomingTest) {
					out.println("Upcoming Test");
				}
				else {
					out.println("Invalid Event"); // will be ignored when reading in events
				}

				out.println(event.getDate());
				out.println(event.getTime());
				out.println(event.getDescription());
			}

			out.close();
			fileWriter.close();
		}
		catch (IOException e){
			System.out.println("An issue occured while saving.");
		}
	}

	public void scheduleUpcomingTests() {
		// this will only work for the month of March, the actual dates would need to come from the university
		int[] dates = {1, 3, 8, 10, 15, 17, 22, 24, 29, 31};
		for (int day: dates) {
			addEvent(new UpcomingTest(day, "10:00 AM - 5:00 PM", "Located at Burt Khan"));
		}
	}

}
