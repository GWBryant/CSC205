import java.util.*;

public class mySums
{
	public static void main(String[] args)
	{
		System.out.println(iterativeSum(4));
		System.out.println(recurSum(4));	
	}
	
	public static double iterativeSum(int n)
	{
		double sum = 0;
		for(int i = 1; i <= n; i++)
		{
			sum += (Math.pow(2,i) +1);
		}
		return sum;	
	}

	public static double recurSum(int n)
	{	
		if(n == 1)
		{
			return 3;
		}
		else
		{
			return (Math.pow(2,n)+1) + recurSum(n-1);	
		}	
	}
} 
