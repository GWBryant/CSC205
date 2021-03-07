import java.util.*;
import java.io.*;

public class HourlyEmployee extends Employee implements Serializable
{

	//constructor for hourly employee, calls super for employee class
	public HourlyEmployee(String name, double wage)
	{
		super(name,wage);
	}

	//implementation of abstract compute pay class
	public double computePay(double hoursWorked)
	{
		if(hoursWorked <= 40)
			return hoursWorked*getWage();
		else
			return 40*getWage() + (hoursWorked-40)*getWage()*1.5;
	}

	//method to pad toString to be exactly n characters long
	public static String pad(String str, int n)
	{
		if(str.length() > n)
			return str.substring(0,n);
		while(str.length() < n)
			str += " ";
		return str;
	}

	//Puts wage in dollar format
	public static String toDollars(double amount)
	{
		long roundedAmount = Math.round(amount * 100);
		long dollars = roundedAmount / 100;
		long cents = roundedAmount % 100;
		if (cents <= 9)
			return dollars + ".0" + cents;
		else
			return dollars + "." + cents;
	}


	public String toString()
	{
		String dolls = toDollars(getWage());
		return pad(getName(),40-(dolls+"/hour$").length()) + "$" + dolls + "/hour";
	}
}

