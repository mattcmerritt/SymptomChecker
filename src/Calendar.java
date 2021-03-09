import java.util.ArrayList;
import java.util.Arrays;

public class Calendar {
	
	private ArrayList<CalendarEvent> _scheduledEvents;
	
	// default constructor to create a blank calendar
	public Calendar() {
		_scheduledEvents = new ArrayList<CalendarEvent>();
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
	
}
