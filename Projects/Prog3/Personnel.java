import java.util.*;
import java.io.*;
import java.text.*;

public class Personnel implements Serializable
{
	//create private variables for use throughout file.
	private static Scanner in = new Scanner(System.in);
	private static List<Employee> employees = new ArrayList<Employee>();
	private static Format format = new DecimalFormat("############.##");

	//main method calls menu which runs program
	public static void main(String[] args)
	{
		menu();
	}

	//menu method to display menu and handle method calls for different commands
	// calls menu again after command finishes
	public static void menu()
	{
		String choice;
		String name;
		System.out.println("---------------------------------");
		System.out.println("|Commands: n - New employee     |");
		System.out.println("|          c - Compute paychecks|");
		System.out.println("|          r - Raise wages      |");
		System.out.println("|          p - Print records    |");
		System.out.println("|          d - Download data    |");
		System.out.println("|          u - Upload date      |");
		System.out.println("|          q - Quit             |");
		System.out.println("---------------------------------");
		System.out.print("Enter command: ");
		try
		{
			choice = in.nextLine();
			if(choice.equalsIgnoreCase("n"))
			{
				System.out.print("Enter name of new employee: ");
				name = in.nextLine();
				addEmployee(name);
				in.nextLine();
				menu();
			}
			else if(choice.equalsIgnoreCase("c"))
			{
				computePaychecks();
				in.nextLine();
				menu();
				
			}
			else if(choice.equalsIgnoreCase("r"))
			{
				raiseWages();
				in.nextLine();
				menu();
			}
			else if(choice.equalsIgnoreCase("p"))
			{
				System.out.println("Printing Records");
				System.out.println("------------------------------------");
				for(int i = 0; i < employees.size(); i++)
				{
					System.out.println(employees.get(i).toString());
				}
				menu();
			}
			else if(choice.equalsIgnoreCase("d"))
			{
				downloadData();
				menu();
			}
			else if(choice.equalsIgnoreCase("u"))
			{
				uploadData();
				menu();
			}
			else if(choice.equalsIgnoreCase("q"))
			{
				System.out.println("Thank you. Goodbye!");
			}
			else
			{
				System.err.print("Command was not recognized; please try again.");
				in.nextLine();
				menu();			
			}
		}
		catch (InputMismatchException e)
		{
			System.err.println("Invalid input please try again");
			in.nextLine();
			menu();
		}
	}

	//method to add a new employee that is either salaried or hourly
	public static void addEmployee(String name)
	{
		try {
			double wage, salary;
			String type;
			Employee hEmp;
			Employee sEmp;
			System.out.print("Hourly (h) or Salaried (s): ");
			type = in.nextLine();
			switch (type) {
				case "h":
				case "H":
					System.out.print("Enter hourly wage: ");
					wage = in.nextDouble();
					hEmp = new HourlyEmployee(name,wage);
					employees.add(hEmp);
					break;
				case "s":
				case "S":
					System.out.print("Enter yearly salary: ");
					salary = in.nextDouble();
					sEmp = new SalariedEmployee(name,salary);
					employees.add(sEmp);
					break;
				default:
					System.err.print("Input was not h or s; please try again.");
					in.nextLine();
					addEmployee(name);
			}
		}
		catch(InputMismatchException e)
		{
			System.err.println("Input was not h or s; please try again.");
			in.nextLine();
			addEmployee(name);
		}
	}

	//method to compute paychecks for all employees on record based on wages
	public static void computePaychecks()
	{
		double hours;
		try {
			for (int i = 0; i < employees.size(); i++) {
				System.out.print("Enter number of hours worked by " + employees.get(i).getName() + ": ");
				hours = in.nextDouble();
				System.out.println("Pay: $" + format.format(employees.get(i).computePay(hours)));
			}
		}
		catch (InputMismatchException e)
		{
			System.err.print("Invalid input, please try again.");
			in.nextLine();
			computePaychecks();
		}
	}

	//method to raise wages of all employees on record
	public static void raiseWages()
	{
		try {
			double percent;
			System.out.print("Enter Percentage increase: ");
			percent = in.nextDouble();
			for (int i = 0; i < employees.size(); i++) {
				employees.get(i).raiseWage(percent);
			}
			System.out.println("New Wages");
			System.out.println("------------------------------------");
			for (int i = 0; i < employees.size(); i++) {
				System.out.println(employees.get(i).toString());
			}
		}
		catch (InputMismatchException e)
		{
			System.err.print("Invalid input, please try again.");
			in.nextLine();
			raiseWages();
		}
	}

	//method to download data from Employees.dat file in directory
	public static void downloadData()
	{
		try
		{
			String fileName = "Employees.dat";
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream inp = new ObjectInputStream(fileIn);
			employees = (List<Employee>) inp.readObject();
			inp.close();
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage() + " Please try again.");
			in.nextLine();
			downloadData();
		}
		catch (ClassNotFoundException e)
		{
			System.err.println(e.getMessage() + " Please try again.");
			in.nextLine();
			downloadData();
		}
		System.out.println("Download complete!");
		System.out.println("Data downloaded: ");
		System.out.println("------------------------------------");
		for(int i = 0; i < employees.size(); i++)
		{
			System.out.println(employees.get(i).toString());
		}
	}

	//method to upload data from program to Employees.dat file
	public static void uploadData()
	{
		try
		{
			String fileName = "Employees.dat";
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(employees);
			out.close();
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage() + "Please try again.");
			in.nextLine();
			uploadData();
		}
		System.out.println("Upload complete!");
	}
}
