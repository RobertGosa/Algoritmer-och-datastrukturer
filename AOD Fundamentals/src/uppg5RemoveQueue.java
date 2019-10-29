import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class uppg5RemoveQueue<Item> implements Iterable<Item>
{
    private Node<Item> first;   
    private Node<Item> last;   
    private int n;              

    //what a node contains
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }

    //creates the queue
    public uppg5RemoveQueue()
    {
        first = null;
        last  = null;
        n = 0;
    }

    //28-36 are a art of the iterable implementation
    public boolean isEmpty() {   return first == null;  }

    public int size() {   return n;  }

    public Item peek()
    {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    //adds a node as first
    public void enqueue(Item item)
    {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        if (isEmpty()) first = last;
        else first.next = oldfirst;
        n++;
        System.out.println(this.toString());
    }

    //removes a node at the specified index
    public void remove(int index) {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        Node currentNode = first;
        if (index == 1) {
            dequeue();
        } else {
        for (int i = 2; i < index; i++)
            currentNode = currentNode.next;
        currentNode.next = currentNode.next.next;
        System.out.println(this.toString());
        }
    }

    //removes first node
    public Item dequeue()
    {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        System.out.println(this.toString());
        if (isEmpty()) last = null;
        return item;
    }

    //prints values as "[x],"
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
        return new NodeIterator(first);
    }

    //iterator class
    private class NodeIterator implements Iterator<Item>
    {
        private Node<Item> current;

        //where the iteration starts
        public NodeIterator(Node<Item> first)
        {
            current = first;
        }

        //108-111 are a part of the iterator implementation
        public boolean hasPrevious()  { return current != null; }
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        //find the next item
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        //finds the previous item
        public Item previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            Item item = current.item;
            return item;
        }
    }


    //this is where the program starts
    public static void main(String[] args) throws java.lang.StringIndexOutOfBoundsException
    {
    	//creates the queue
    	uppg5RemoveQueue<String> queue = new uppg5RemoveQueue<String>();

        System.out.println("How long is your message?");

        //creates the scanners
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        
        //scans the number of inputs
        int numberofinputs = scanner1.nextInt();

        System.out.println("Type your message: ");

        //scans the inputs
        for(int i = 0; i < numberofinputs; i++)
        {
            String item = scanner2.nextLine();
            queue.enqueue(item);

        }
        
        //removes the 3rd element, starting at 1
        queue.remove(3);
    }
}