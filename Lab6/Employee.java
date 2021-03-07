import java.util.*;

public class Employee extends Person
{
	private double salary;
	private Date employmentDate;

	public Employee(String lastName, String firstName, Date birthDate, Date employmentDate, double salary)
	{
		super(lastName,firstName,birthDate);
		this.employmentDate = employmentDate;
		this.salary = salary;
	}

	public Date getEmploymentDate()
	{
		return employmentDate;
	}

	public void setEmploymentDate(Date employmentDate)
	{
		this.employmentDate = employmentDate;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public String toString()
	{
		return  "name = " + getLastName() + ", " + getFirstName() + "\nsalary = " + getSalary() + "\nbirth = " + getBirthDate() + "\nhired = " + getEmploymentDate();
	}
}
