import java.util.*;
import java.io.*;
import java.text.*;

public class Library
{
	private static int numBooks; 
	private static String inFile;
	private static ArrayList<LibraryBook> books = new ArrayList<LibraryBook>(50);
	private static int count = 0;
	private static int displayCount = 0;
		 
	public static void main(String[] args)
	{
		getData();	
	}
	
	//method to clear the screen
	public static void clearScreen()
	{
		System.out.println("\u001b[H\u001b[2J");
	}
	//method to get file from current directory
	public static void getData()
	{
		Scanner in = new Scanner(System.in);
		if(count == 0)
		{
			clearScreen();
			System.out.println("		The Book Search Program			");
			System.out.println("----------------------------------------------------");
			System.out.println("	What file is your book data stored in?");
		}
		System.out.println("	Here are the files in the current directory :");
		
		//Get all files from directory
		File curDir = new File(".");
		String[] fileNames = curDir.list();
		ArrayList<String> data = new ArrayList<String>();
		
		//find files that end in .dat
		for(String s:fileNames)
		{
			if(s.endsWith(".dat"))
				data.add(s);
		}
		
		//print data files in current dir
		for(int i = 0; i < data.size(); i++)
		{
			System.out.print(data.get(i) + " ");
		} 
	        	
		System.out.println();
		System.out.print("Filename: ");
		
		inFile = in.nextLine();
		inputBooks(inFile,books);
		if(books.size() > 1)
			sortLibrary(books);	
		if(displayCount == 0)
		{
			displayCount++;
			System.out.println("A total of " +  numBooks + " books have been loaded and sorted by title");
			System.out.print("Press enter to continue... ");
			in.nextLine();
			menu();
		}
	}
	//method to input datafile of books and info into library database's ArrayList of books 
	public static void inputBooks(String inputFile, ArrayList<LibraryBook> books)
	{
	numBooks = 0;
	try{
		Scanner in = new Scanner(new File(inputFile));
		while(in.hasNext())
		{
			Scanner lsc = new Scanner(in.nextLine()).useDelimiter(";");

			String title = lsc.next();
			String name = lsc.next();
			int copyright = lsc.nextInt();
			double price = lsc.nextDouble();
			String genre = lsc.next();

			books.add(new LibraryBook(title,name,copyright,price,genre));
			numBooks++;
		}
	}
	catch (IOException e) {
		System.err.println("File could not be read try again with another file name");
		count++;
		getData();
	}
	}
	
	//method to print out menu and take user input for options
	public static void menu()
	{
		Scanner in = new Scanner(System.in);
		int choice;
		String key;
		clearScreen();
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("      THE GREAT BOOKS SEARCH PROGRAM         ");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("1) Display all book records");
		System.out.println("2) Search for a book by Title");
		System.out.println("3) Exit Search Program");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.print("Please Enter Your Choice > ");
		try{
		choice = in.nextInt();
		in.nextLine();
		if(choice == 1)
		{
			for(int i = 0; i < books.size(); i++)
			{
				clearScreen();
				printRecord(books,i);
				System.out.println("Press enter to continue or enter m to go to menu...");
				if(in.nextLine().equalsIgnoreCase("m"))
				{
					break;
				}	
			}
			menu();
		}
		else if(choice == 2)
		{
			System.out.print("Enter title of book > ");
			try{
				key = in.nextLine();
				clearScreen();
				printRecord(books,searchLibrary(books,key));
				System.out.print("Press enter to continue...");
				in.nextLine();
				menu();
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.err.println("Book not found");
				System.out.print("Press enter to continue...");
				in.nextLine();
				menu();
			}
		}
		else if(choice == 3)
		{
			System.out.println("Thank you! Goodbye =^)");	
		}
		else
		{
			System.out.println("invalid input please try again");
			System.out.print("press enter to continue...");
			in.nextLine();
			menu();
		}
		}
		catch(InputMismatchException e)
		{
			Scanner in2 = new Scanner(System.in);
			System.err.println("invalid input please try again");
			System.out.print("Press enter to continue...");
			in2.nextLine();
			menu();
		}
	}	
	
	//method to sort library database by title in alphabetical order
	public static void sortLibrary(ArrayList<LibraryBook> books)
	{
		int minIndex;
		LibraryBook temp; 
		for(int i = 0; i < books.size()-1; i++)
		{
			minIndex = i;
			for(int j = minIndex+1; j < books.size(); j++)
			{
				if(books.get(j).compareTo(books.get(minIndex)) < 0)
				{
					minIndex = j;				
				}
			}
			if(minIndex != i)
			{
				temp = books.get(i);
				books.set(i,books.get(minIndex));
				books.set(minIndex,temp);
			}
		}
	}
	
	//method to search library database for a book by title
	public static int searchLibrary(ArrayList<LibraryBook> books, String key)
	{
		int first = 0; int last = books.size()-1; int middle, location;
		
		boolean found = false;
		
		do
		{
			middle = (first + last)/2;
			
			if(key.equalsIgnoreCase(books.get(middle).getTitle()))
			{
				found = true;
			}
			else if(key.compareToIgnoreCase(books.get(middle).getTitle()) < 0)
			{
				last = middle-1;
			}
			else
			{
				first = middle+1;
			}
		}while((!found) && (first<=last));
		
		location = middle;
		
		return (found ? location : -1);
	}
	
	//methods to print record of a book in library database
	public static void printRecord(ArrayList<LibraryBook> books, int location)
	{
		DecimalFormat form = new DecimalFormat("##.00");
		if(location >= 0)
		{
			System.out.println("Record #" + (location+1) + " :");
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		}
		System.out.println("Title:		" + books.get(location).getTitle());
		System.out.println("Author's Name:	" + books.get(location).getAuthor());
		System.out.println("Copyright:	" + books.get(location).getCopyright());
		System.out.println("Price:		" + form.format(books.get(location).getPrice()));
		if(books.get(location).getGenre().equals("f"))
		{
			System.out.println("Genre:		fiction\n");
		}
		else if(books.get(location).getGenre().equals("n"))
		{
			System.out.println("Genre:		nonfiction\n");
		}
		if(books.get(location).getGenre().equals("d"))
		{
			System.out.println("Genre:		drama\n");
		}
		if(books.get(location).getGenre().equals("p"))
		{
			System.out.println("Genre:		poetry\n");
		}	
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
}























