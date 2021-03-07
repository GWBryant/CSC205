
public class Puzzle
{
	public static void main(String[] args)
        {	
		puzzle(9);
	}

	private static int puzzle (int n)
	{
		int puzz;	

		for(int i = 1; i <= 4-n; i++)
			System.out.print("\t");
        	if ( (n % 3) == 2 )
		{
			for(int i = 1; i <= 4-n; i++)
				System.out.print("\t");
			System.out.print("puzzle(" +  n + ") = ");
			System.out.println("returns 1");
           		puzz =  1;
		}
        	else if ( (n % 3) == 1 )
		{
			System.out.print("puzzle(" +  n + ") = ");
			System.out.println("puzzle(" + (n+1) + ") + 2");	
           		puzz = ( puzzle (n + 1) + 2 );
			for(int i = 1; i <= 4-n; i++)
				System.out.print("\t");
			System.out.println("puzzle (" + n + ") returns = " + puzz);
        	}
		else
		{
			System.out.print("puzzle(" +  n + ") = ");
			System.out.println("puzzle(" + n/3 + ") + 1"); 
          		puzz = ( puzzle (n / 3) + 1 );
			for(int i = 1; i <= 4-n; i++)
				System.out.print("\t");
			System.out.println("puzzle(" + n + ") returns = " + puzz);
		}
		return puzz;
	}
}
