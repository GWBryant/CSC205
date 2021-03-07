
import java.util.*;

@SuppressWarnings("unchecked")
public class JCFQueue
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		LinkedList queue1 = new LinkedList();
		LinkedList queue2 = new LinkedList();
		Object key = new Character('$');

        	queue1.addLast(new Character('b'));
        	queue1.addLast(new Character('$'));
        	queue1.addLast(new Character('E'));
        	queue1.addLast(new Character('$'));
        	queue2.addLast(new Character('b'));
        	queue2.addLast(new Character('$'));
        	queue2.addLast(new Character('E'));
        	queue2.addLast(new Character('b'));
		System.out.println("dup check = " +
                    identicalCheck(queue1, queue2));
		findAndReplace(queue1, key, new Character('*'));
		System.out.println("** After findAndReplace **");
		printQueue(queue1);
	}

	private static boolean identicalCheck(LinkedList queue1,
                                              LinkedList queue2)
                throws CloneNotSupportedException
	{
		if(queue1.size() != queue2.size())
			return false;
		for(int i = 0; i < queue1.size(); i++)
		{
			if(((Comparable)queue1.get(i)).compareTo((Comparable)queue2.get(i)) != 0)
				return false;
		}
		return true;



	}


	private static void findAndReplace(LinkedList queue1, 
		Object key, Object newVal)
	{
		for(int i = 0; i < queue1.size(); i++)
		{
			if(((Comparable)queue1.get(i)).compareTo((Comparable)key) == 0)
			{
				queue1.remove(i);
				queue1.add(i,newVal);
			}	
		}
	}



	private static void printQueue (LinkedList q)
		 throws CloneNotSupportedException
	{
		if(q.size() == 0)
			System.out.println("Queue is empty");
		for(int i = 0; i < q.size();i++)
		{
			System.out.println(q.get(i));
		}
	}


}
