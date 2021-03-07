import java.util.*;

public class TestClock
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("What would you like to set your DVR to?");
		int h, m ,s;

		System.out.print("hours = ");
		h = in.nextInt();
		if(h > 23)
		{
			System.out.println("Number of hours too large, please enter number between 0 - 23");
			System.out.print("hours = ");
			h = in.nextInt();
		}
		
		System.out.print("minutes = ");
		m = in.nextInt();
		if(m > 59)
		{
			System.out.println("Number of minutes too large, please enter number between 0 - 59");
			System.out.print("minutes = ");
			m = in.nextInt();
		}

		System.out.print("seconds = ");
		s = in.nextInt();
		if(s > 59)
		{
			System.out.println("Number of seconds too large, please enter number between 0 - 59");
			System.out.print("seconds = ");
			s = in.nextInt();
		}

		Clock dvr = new Clock(h,m,s);
		System.out.println("The time is now " + dvr);

		System.out.println("Advancing the time! ");
		dvr.advance();
		
		System.out.println("The time is now " + dvr);
	}
}
