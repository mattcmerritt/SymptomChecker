public class UpcomingTest implements CalendarEvent {
	private int _date;
	private String _time = null;
	private String _descriptive = "";

	public UpcomingTest (int date, String time, String descriptive){
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

}
