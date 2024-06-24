package airportSimulation;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class globalclock {
	public int seconds;
	public int minutes;
	public int hours;
	int formattedTime;
	int timewithsec;
	String showtimee;
	public void gettime()
	{	
		LocalTime currentTime = LocalTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hhmm");
	    formattedTime = Integer.parseInt(currentTime.format(formatter));
	}
	public int printtime()
	{
		LocalTime currentTimesec = LocalTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hhmmss");
	    timewithsec = Integer.parseInt(currentTimesec.format(formatter));
	    return timewithsec;
	}
	public void displaytime()
	{
		System.out.println("Current Time: " + timewithsec);
	}
	public String showtime()
	{
		LocalTime currentTimesec = LocalTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
	    showtimee =currentTimesec.format(formatter);
	    return showtimee;
	}
}
