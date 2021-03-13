public class UpcomingTest implements CalendarEvent {
	private int _date;
	private String _time = null;
	private String _descriptive = "";
	private boolean _completed = false;

	public UpcomingTest(int date, String time, String descriptive) {
		_date = date;
		_time = time;
		_descriptive = descriptive;
	}

	// returns the date that this test is scheduled for
	public int getDate() {
		return _date;
	}

	// returns the time window for testing
	public String getTime() {
		return _time;
	}

	// returns the location of the test and any other information
	public String getDescription() {
		return _descriptive;
	}

	// sets completed to true
	public void completeTest() {
		_completed = true;
		_descriptive = "Completed: " + _descriptive;
	}

	// returns status of completed
	public boolean getCompleted() {
		return _completed;
	}

}
