import java.util.ArrayList;

public class Calendar {
	
	private ArrayList<CalendarEvent> scheduledEvents;
	
	// adds a given event into the calendar
	public void addEvent(CalendarEvent e) {
		scheduledEvents.add(e);
	}
	
	// returns a list of events from a given day
	public CalendarEvent[] getEvents(int date) {
		return null;
	}
	
}
