import java.util.*;
import java.io.*;

public class SalariedEmployee extends Employee implements Serializable
{
	//constructor for salaried employee object
	public SalariedEmployee(String Name, double Salary)
	{
		super(Name, (Salary/(40*52)));
	}

	//implementation of abstract computePay method
	public double computePay(double hoursWorked)
	{
		return 40 * getWage();
	}

	//method to get salary
	public double getSalary()
	{
		return getWage()*40*52;	
	}

	//method to set salary
	public void setSalary(double salary)
	{
		setWage(salary/(40*52));
	}

	//method to pad toString to be 40 characters long
	public static String pad(String str, int n)
	{
		if(str.length() > n)
			return str.substring(0,n);
		while(str.length() < n)
			str += " ";
		return str;
	}

	//method to put salary in dollar format
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

	//method to return string with object info that's 40 characters long
	public String toString()
	{
		String dolls = toDollars(getSalary());
		return pad(getName(),40-(dolls+"/year$").length()) + "$" +dolls + "/year";
	}
}
