public class TestResult implements CalendarEvent {
	int _date = 0;
	String _time = null;
	String _descriptive = "";

	public TestResult(int date, String time, String descriptive){
		_date = date;
		_time = time;
		_descriptive = descriptive;
	}
	// returns the date that this test occurred
	public int getDate() {
		return _date;
	}

	// returns the time that this test result was generated
	public String getTime() {
		return _time;
	}

	// returns the result of the test and any other details
	public String getDescription() {
		return _descriptive;
	}

}
