import java.util.*;

public class sorting
{
	public static void main(String[] args)
	{
		int[] nums = {2,16,9,7,17,4};
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i] +  " ");
		}
		System.out.println();

		//bubbleSort(nums);
		selectSort(nums);
		
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i] +  " ");
		}
	}

	public static void bubbleSort(int[] list)
	{
		int temp;
		int currentBottom = list.length;
		boolean pass = true;
		
		while(pass)
		{
			pass = false;
			for(int i = 0; i < currentBottom-1; i++)
			{
				if(list[i+1]<list[i])
				{
					temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
				
					pass = true;
				}
			}
			currentBottom--;
		}
	}

	public static void selectSort(int[] nums)
	{
		int temp; int minIndex;
		
		for(int i = 0; i < nums.length-1; i++)
		{
			minIndex = i;
			for(int j = minIndex+1; j < nums.length; j++)
			{
				if(nums[j]<nums[minIndex])
				{
					minIndex = j;
				}
			} 
			if(minIndex != i)
			{
				temp = nums[i];
				nums[i] = nums[minIndex];
				nums[minIndex] = temp;
			}
		}	
	}
}
