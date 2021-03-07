import java.util.*;

public class Pez
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Stack stack1 = new Stack();
		stack1.push("yellow");
		stack1.push("red");
		stack1.push("green");
		stack1.push("green");
		stack1.push("yellow");
		stack1.push("yellow");
		stack1.push("red");
		stack1.push("green");
		removeGreen(stack1);
		print(stack1);
	}

	public static void removeGreen(Stack s) throws CloneNotSupportedException
	{
		Stack temp = new Stack();
		while(!s.isEmpty())
		{
			if(((String)s.top()).equals("green"))
			{
				s.pop();
			}
			else
			{
				temp.push(s.pop());
			}
		}
		while(!temp.isEmpty())
		{
			s.push(temp.pop());
		}
	}
	
	public static void print(Stack s) throws CloneNotSupportedException
	{
		while(!s.isEmpty())
		{
			System.out.println(s.pop());		
		}	
	}
}
