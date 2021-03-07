import java.util.*;

public class TestEmployee
{
	public static void main(String[] args)
	{
		Date hireDate = new Date();
		Date birthDate = new Date(1980,3,8);
		Employee mark = new Employee("Brown","Morris",birthDate,hireDate,40000);
		System.out.println(mark);
	}
}
