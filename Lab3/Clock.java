import java.util.*;

public class Clock
{
	private int hours;
	private int minutes;
	private int seconds;
//default constructor
	public Clock()
	{
		hours = 0;
		minutes = 0;
		seconds = 0;
	}
//constructor with specified parameters
	public Clock(int h, int m, int s)
	{
		hours = h;
		minutes = m;
		seconds = s;
	}
//reset to default
	public void reset()
	{
		hours = 0;
		minutes = 0;
		seconds = 0;
	}
//reset to specified parameters
	public void reset(int h, int m, int s)
	{
		hours = h;
		minutes = m;
		seconds = s;
	}
//method to advance clock by one second
	public void advance()
	{
		seconds++;
		if(seconds == 60)
		{
			minutes++;
			seconds = 0;
		}
		if(minutes == 60)
		{
			hours++;
			minutes = 0;
		}
		if(hours == 24)
		{
			hours = 0;
		}
	} 
//method to output time in a string
	public String toString()	
	{
		String myClock = "";
		if(hours < 10)
		{
			myClock += "0";	
		}
		myClock += (hours + ":");
		if(minutes < 10)
		{
			myClock += "0";
		}
		myClock += (minutes + ":");
		if(seconds < 10)
		{
			myClock += "0";
		}
		myClock += seconds;
	
		return myClock;
	} 
}



















