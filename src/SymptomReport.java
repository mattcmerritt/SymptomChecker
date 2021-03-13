
public class SymptomReport implements CalendarEvent {
	private int _counter = 0;
	private int _date = 0;
	private String _time = null;
	private String _descriptive = null;
	private String[] _SymptomArray = { "Loss of Taste", "Loss of Smell", "Red/Watery Eyes", "Shortness of Breath",
			"Cough", "Headache", "Body Aches", "Sore Throat", "Severe Fatigue", "Fever", "Vomitting/Diarrhea",
			"Chills" };

	public SymptomReport(int date, String time) {
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

	public void addSymptoms(int i) {
		if (_counter == 0) {
			_descriptive = _SymptomArray[i - 1];
		}
		
		else {
			_descriptive = _descriptive + "," + _SymptomArray[i - 1] ;
		}
	}

	public void printSymptoms() {
		for (int i = 0; i < _SymptomArray.length; i++) {

			System.out.println(i + 1 + " " + _SymptomArray[i]);

		}
	}

	public void addDescription(String description) {
		_descriptive = description;
	}

}
