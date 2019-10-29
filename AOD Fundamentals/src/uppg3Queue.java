import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class uppg3Queue<Item> implements Iterable<Item>
{
	
	//this is where the program starts
	public static void main(String[] args) throws java.lang.StringIndexOutOfBoundsException
    {
		//make the queue
    	uppg3Queue<String> queue = new uppg3Queue<String>();

		System.out.println("How long is your message?");
		
		//create the scanners
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        //scan number of inputs
		int numberofinputs = scanner1.nextInt();
		System.out.println("Type your message: ");

	   //scan the inputs i:times
       for(int i = 0; i < numberofinputs; i++)
       {
           String item = scanner2.nextLine();
           queue.enqueue(item);
       }

       //remove the first value
		for(int i = 0; i < numberofinputs; i++)
		{
    		System.out.println();
			queue.dequeue();
		}

    }
	
	//creates the starting and ending point
    private Node<Item> first;    
    private Node<Item> last;     
    private int n;             

    //define the node
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }

    //create an empty queue
    public uppg3Queue()
    {
        first = null;
        last  = null;
        n = 0;
    }

    // check if list is empty
    public boolean isEmpty() {   return first == null;  }

    //add to the end of the list
    public void enqueue(Item item)
    {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
        System.out.print(this.toString());
    }

    //remove the first element
    public Item dequeue()
    {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        System.out.print(this.toString());
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    //convert to the [x], output
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
        {
            s.append("["+item+"]"+", ");
        }
        if(s.lastIndexOf(",") > 0)  {  s.deleteCharAt(s.lastIndexOf(",")); }

        return s.toString();
    }

    //iterator constructor
    public Iterator<Item> iterator()
    {
        return new ListIterator(first);
    }

    //creates the ListIterator
    private class ListIterator implements Iterator<Item>
    {
        private Node<Item> current;

        public ListIterator(Node<Item> first)
        {
            current = first;
        }

        public boolean hasNext() { 
        	return current != null;                     
        }
        
        public void remove() {
        	throw new UnsupportedOperationException();  
        }

        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}