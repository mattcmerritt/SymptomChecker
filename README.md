# SymptomChecker

## Features

This repository was made to address the issues of the symptom checker application currently used by Quinnipiac, particularly how it can be hard to keep track of upcoming testing dates required by the university. This project is a prototype of how to improve on the symptom checker, demonstrating with the month of March 2021 and simple console input and output.

This project was completed by Christian Cooper, Henok Ketsela, and Matthew Merritt for Challenge 1 of CSC109.

## About the Code

This project consists of five classes:
* ``SymptomChecker.java``: Main class that handles user input, creating calendars, and scheduling events
* ``Calendar.java``: Contains a collection of events that can be added to, as well as loading and saving functionality
* ``SymptomReport.java``: Contains date, time, and symptom information that is used when completing daily check-ins
* ``TestResult.java``: Contains date, time, and test results information that come from any form of COVID testing
* ``UpcomingTest.java``: Contains date, time, and location information that is provided by the university for required testing

Additionally, the interface ``CalendarEvent.java`` is used to generalize symptom reports, test results, and upcoming tests.

## How to Run

To run the driver class, navigate to the ``src`` directory of the project in the command line, and run the following lines:

```
javac SymptomChecker.java
java SymptomChecker
```

Alternatively, you can import the project into your choice of IDE and run the file named ``SymptomChecker.java`` in the ``src`` directory.

## Example Output

An example of the output of running ``SymptomChecker.java`` is shown below. Lines that begin with ```>``` are input by the user.

```
**************Welcome to the Quinnipiac Symptom Checker App****************** 

Would you like to start a new calendar or load a calendar from a file? ("load" to use a file, anything else to start a new one)
> new
    Su        Mo        Tu        We        Th        Fr        Sa    
           !  1   !     2      !  3   !     4         5         6     
    7      !  8   !     9      !  10  !     11        12        13    
    14     !  15  !     16     !  17  !     18        19        20    
    21     !  22  !     23     !  24  !     25        26        27    
    28     !  29  !     30     !  31  ! 

What is today's date? (ex. 1-31)
> 14
What do you want to do? Input a number to choose an option or 0 to quit.
1. Print calendar
2. Add event to calendar
3. Check the events on a certain date
4. Mark tests as completed
5. Save the calendar to a file
6. Change the current date
> 2
What type of event do you want to add?
Put TestResult if you want test results or input anything else for a symptom report
> Symptom Report
What time are you reporting? (please include AM/PM)
> 4:00 PM
What symptoms do you have currently. Input all symptoms one at a time and input 0 when done
1 Loss of Taste
2 Loss of Smell
3 Red/Watery Eyes
4 Shortness of Breath
5 Cough
6 Headache
7 Body Aches
8 Sore Throat
9 Severe Fatigue
10 Fever
11 Vomitting/Diarrhea
12 Chills
> 6
What symptoms do you have currently. Input all symptoms one at a time and input 0 when done
1 Loss of Taste
2 Loss of Smell
3 Red/Watery Eyes
4 Shortness of Breath
5 Cough
6 Headache
7 Body Aches
8 Sore Throat
9 Severe Fatigue
10 Fever
11 Vomitting/Diarrhea
12 Chills
> 0

What do you want to do? Input a number to choose an option or 0 to quit.
1. Print calendar
2. Add event to calendar
3. Check the events on a certain date
4. Mark tests as completed
5. Save the calendar to a file
6. Change the current date
> 3
What date would you like to check for events?
> 10
We found 1 events on March 10.

Upcoming Test
Time: 10:00 AM - 5:00 PM
Description: Located at Burt Khan

What do you want to do? Input a number to choose an option or 0 to quit.
1. Print calendar
2. Add event to calendar
3. Check the events on a certain date
4. Mark tests as completed
5. Save the calendar to a file
6. Change the current date
5
What would you like to name the calendar file?
> march2021.txt

What do you want to do? Input a number to choose an option or 0 to quit.
1. Print calendar
2. Add event to calendar
3. Check the events on a certain date
4. Mark tests as completed
5. Save the calendar to a file
6. Change the current date
> 0
```

Additionally, this will create the following text file, named ``march2021.txt``:
```
Upcoming Test
1
10:00 AM - 5:00 PM
Located at Burt Khan
Upcoming Test
3
10:00 AM - 5:00 PM
Located at Burt Khan
Upcoming Test
8
10:00 AM - 5:00 PM
Located at Burt Khan
Upcoming Test
10
10:00 AM - 5:00 PM
Located at Burt Khan
Upcoming Test
15
10:00 AM - 5:00 PM
Located at Burt Khan
Upcoming Test
17
10:00 AM - 5:00 PM
Located at Burt Khan
Upcoming Test
22
10:00 AM - 5:00 PM
Located at Burt Khan
Upcoming Test
24
10:00 AM - 5:00 PM
Located at Burt Khan
Upcoming Test
29
10:00 AM - 5:00 PM
Located at Burt Khan
Upcoming Test
31
10:00 AM - 5:00 PM
Located at Burt Khan
Symptom Report
14
4:00 PM
Headache
```