//Gabe Bryant
//Lab 2
//1/13/2019
import java.util.*;

public class Stats
{
	private static final int MAX_SIZE = 100;
	public static void main(String[] args)
	{
        	int[] List = new int[MAX_SIZE];		
		int numItems;

        	numItems = fillUp (List);

        	System.out.println("\n\10\7" + " The range of your " +
                                   numItems + " items is :  " + 
				   range (List, numItems));

        	System.out.println("\n\10\7" + " The mean of your " + 
                                   numItems + " items is  :  " +
				   mean (List, numItems));
	}
	
	public static int fillUp(int[] list)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please Input your values (Enter 0 to stop)");
		int count = 0;
		int input = 1;
		// create loop to get input from user that is zero terminated
		while(input != 0)
		{
			input = in.nextInt();
			if(input != 0)
			{
				list[count] = input;
				count++;
			}
				
			if(input == 0 && count < 2)
			{
				System.out.println("Please enter two or more values");
				input = 1;
			}
			else if(count == 99)
			{
				input = 0;
			}
		}
		return count;
	}
	
	public static int range(int[] list, int numItems)
	{
		int min;
		int max;
		int range = 0;		

		//calculate max
		max = list[0];
		min = list[0];
		for(int i = 0; i < numItems; i++)
		{
			if(list[i] > max)
				max = list[i];
			else if(list[i] < min)
				min = list[i];
		}

		//calculate range
		range = max - min;
		return range;
	}

	public static double mean(int[] list, int numItems)
	{
		int sum = 0;
		double mean;
		for(int i = 0; i < numItems; i++)
		{
			sum += list[i];
		}
		mean = (double)sum/(double)numItems;
		return mean;
	}
}
