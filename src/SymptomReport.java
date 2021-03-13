
public class SymptomReport implements CalendarEvent {
	
	private int _date = 0;
	private String _time = null;
	private String _descriptive = null;
	
	public SymptomReport(int date, String time){
		_date = date;
		_time = time;
		_descriptive = "No Symptoms to Report";
	}
	// returns the date that this report was collected on
	public int getDate() {
		return _date;
	}

	// returns the time that this report was collected
	public String getTime() {
		return _time;
	}

	// returns the details contained in the report (symptoms, exposure)
	public String getDescription() {
		return _descriptive;
	}
	

}
