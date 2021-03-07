import java.util.*;

public class searching
{
	public static void main(String[] args)
	{
		int[] list = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(linearSearch(list, 7));
		System.out.println(booleanSearch(list, 6));
	}
	
	public static int linearSearch(int[] list, int key)
	{
		boolean found = false;
		int location = -1;
		int index = 0;
		while(found == false && index != list.length)
		{
			if(list[index] == key)
			{
				location = index;
				found = true;
			}
			index++;
		}
		return location;	
	}
		
	public static int booleanSearch(int[] list, int key)
	{
		int first = 0; int last = list.length-1; int middle, location;

		boolean found = false;
		
		do{

			middle = (first+last)/2;
			
			if(key == list[middle])
			{
				found = true;
			}
			else if (key < list[middle])
			{
				last = middle-1;
			}
			else
			{
				first = middle+1;
			}
		}while(!found && first <= last);
		location = middle;
		return(found ? location : -1);
	}
}
