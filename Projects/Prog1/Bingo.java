import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Bingo{
	
	public static void main(String[]args) throws FileNotFoundException
	{
		//construct bingo game object and play the game
		Bingo b = new Bingo();
		b.playGame();	
	}


	public final int ROW = 5;
	public final int COL = 5;
	public int num;
	private int[][] card = new int[ROW][COL];
	private BitSet bingoNums = new BitSet(76);
	private boolean win = false;
	private boolean vertical = false;
	private boolean horizontal = false;
	private boolean diagonal = false;
	
	public Bingo()
	{
	}	
	//fill up array from file
	public void fillCard() throws FileNotFoundException
	{
		//reads numbers from file and fills them into a two dimensional array serving as a card
		File inFile = new File("bingo.in");
		Scanner in = new Scanner(inFile);
		while(in.hasNextInt())
		{
			for(int i = 0; i < 5; i++)
			{
				for(int j = 0; j < 5; j++)
				{	
					card[i][j] = in.nextInt();
					in.nextLine();
				}
			}
		}
	}
	// print out card
	public void printCard()
	{
		//prints bingo card formatted to look like a 5x5 bingo card
		System.out.println("YOUR BINGO CARD :");
		System.out.println("   B    I    N    G    O ");
		System.out.println("__________________________");
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{	if(card[i][j] < 10 && card[i][j] != 0)
				{
					System.out.print("|  " + card [i][j] + " "); 
				}
				else if(card[i][j] == 0)
				{
					System.out.print("|  X "); 
				}
				else	
				{	
					System.out.print("| " + card[i][j] + " ");
				}
			}
			System.out.println("|");
			System.out.println("__________________________");
		}
	}
	//function to start the game
	public void playGame() throws FileNotFoundException
	{
		//starts by filling up and printing out card 
		int count  = 0;
		fillCard();
		printCard();
		System.out.println("BINGO CARDS PICKED AT RANDOM FROM BIN:");
		//while loop to continually pick random numbers and check and see if bingo game has been won
		while(!win)
		{
			numPicker();
			for(int i = 0; i < 5; i++)
			{
				for(int j = 0; j < 5; j++)
				{
					if(card[i][j] == num)
						card[i][j] = 0;
				}
			}
			checkForWin();
			count++;
			if((count % 8) == 0)
				System.out.println();
		}
		//prints out different end statement depending on how the bingo card was completed
		System.out.println();
		if(vertical == true)
		{
			System.out.println("You win a vertical Bingo after " + count + " picks!");
		}
		else if(horizontal == true)
		{
			System.out.println("You win a horizontal Bingo after " + count + " picks!");
		}	 
		else if(diagonal == true)
		{
			System.out.println("You win a diagonal Bingo after " + count + " picks!");
		}
		printCard();
	}
	
	public int numPicker()
	{
		//method to pick a random number between 1 and 75
		//uses bitset to ensure there are no repeated numbers
		do
		{
			num = (int)Math.round(Math.random() * 74 + 1);	
		}while(bingoNums.get(num) == true);
		bingoNums.set(num);
		System.out.print(num +"\t");
		return num;
	}

	public boolean checkForWin()
	{
		//method to check bingo card for a win and the type of win
		//Method checks for win by seeing if a row, column, or diagonal sums to 0
		int vsum = 0;
		int hsum = 0;
		int d1sum = 0;
		int d2sum = 0;
		while(!win)
		{
			for(int i = 0; i < card.length; i++)
			{
				for(int j = 0; j < card[i].length; j++)
				{
					vsum += card[j][i];
				}	
				if(vsum == 0)
				{
					win = true;
					vertical = true;
				}
				else
					vsum = 0;
			}	
			for(int i = 0; i < card.length; i++)
			{
				for(int j = 0; j < card[i].length; j++)
				{
					hsum += card[i][j];
				}
				if(hsum == 0)
				{
					win = true;
					horizontal = true;
				}
				else
					hsum = 0;
			}	
			for(int i = 0; i < card.length; i++)
			{
				d1sum += card[i][i];
			}
			if(d1sum == 0)
				win = true;
				diagonal = true;
			for(int i = 0;i < card.length; i++)
			{
				d2sum += card[i][card.length-i-1];
			}
			if(d2sum == 0)
				win = true;
				diagonal = true;
			break;
		}
		return win;
	}
}
