
public class Links
{
	public static void main(String[] args)
	{
          	Node pos1 = null;
    		Node pos2 = null;
    		pos1 = new Node(new Integer(13));
   		pos1.setNext(new Node(new Integer(15), null));
    		pos2 = new Node(new Integer(11), null);
		pos2.setNext(pos1);
		printList(pos2);
		System.out.println(count(pos2));
		findMax(pos2);
	}

	private static void printList(Node head)
	{
		if (head != null)
		{
			System.out.println(head.getItem());
			printList(head.getNext());
		}
	}

	private static int count(Node head)
	{
		if (head == null)
			return 0;
		return 1 + count(head.getNext());
	}

	private static void findMax(Node head)
	{	
		Node max = head;
		Node current = head.getNext();

		for(int i = 1; i < count(head); i++)
		{
			if(((Comparable)max.getItem()).compareTo((Comparable)current.getItem()) < 0)
				max = current;
			current = current.getNext();
		}
		System.out.println(max.getItem()); 
	}
}
