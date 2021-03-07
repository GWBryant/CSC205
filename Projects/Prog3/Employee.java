import java.util.*;
import java.io.*;

public abstract class Employee implements Serializable{
	//initialize private global variables for name and wage
	private String name;
	private double wage;

	//protected constructor
	protected Employee(String n, double w)
	{
		name = n;
		wage = w;
	}

	//abstract method to compute pay
	public abstract double computePay(double hoursWorked);

	//getter and setter for name
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}

	//getter and setter for wage
	public void setWage(double w)
	{
		wage = w;
	}

	public double getWage()
	{
		return wage;
	}

	//method to raise wage by a percentage
	public void raiseWage(double percent)
	{
		setWage(getWage() + (getWage() * (percent / 100)));
	}
}
