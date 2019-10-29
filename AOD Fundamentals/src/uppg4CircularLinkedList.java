import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.Math;
import java.util.Scanner;

public class uppg4CircularLinkedList<Item> implements Iterable<Item> {
    private int n;       
    private Node pre;    
    private Node post;    

    //constructor as shown in the course book
    public uppg4CircularLinkedList() {
        pre  = new Node(); // head
        post = new Node(); // tail
        pre.next = post;
        post.prev = pre;
    }

    //what a node contains
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    //checks if the list is empty
    public boolean isEmpty() { 
    	return n == 0;
    }
    
    //returns the size of the list
    public int size() { 
    	return n;      
    }

    //adds an item as last
    public void addlast(Item item)
    {
        Node last = post.prev;
        Node x = new Node();
        x.item = item;
        x.next = post;
        x.prev = last;
        post.prev = x;
        last.next = x;
        n++;
    }

    //adds an items as first
    public void addfirst(Item item)
    {
        Node first = pre.next;
        Node x = new Node();
        x.item = item;
        x.prev = pre;
        x.next = first;
        pre.next = x;
        first.prev = x;
        n++;
    }

    //removes the last element
    public void removelast()
    {
        Item item = post.item;
        post = post.prev;
        n--;
    }

    //removes the first element
    public void removefirst()
    {
        Item item = pre.item;
        pre = pre.next;
        n--;
    }

    //constructor
    public ListIterator<Item> iterator()  { 
    	return new DoublyLinkedListIterator(); 
    }

    //iterator, as shown in the course book
    private class DoublyLinkedListIterator implements ListIterator<Item> {
        private Node current = pre.next; 
        private Node lastAccessed = null;  
        private int index = 0;

        //checks if there is a next value
        public boolean hasNext() {
        	return index < n; 
        }
        
        //checks if there is a previous value
        public boolean hasPrevious()  {
        	return index > 0; 
        }
        
        //returns the previous index
        public int previousIndex() {
        	return index - 1; 
        }
        
        //returns next index
        public int nextIndex() {
        	return index;    
        }

        //moves upwards on the list, to the next item
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastAccessed = current;
            Item item = current.item;
            current = current.next;
            index++;
            return item;
        }

        //returns previous item
        public Item previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = current.prev;
            index--;
            lastAccessed = current;
            return current.item;
        }

        //sets an item to a certain position
        public void set(Item item) {
            if (lastAccessed == null) throw new IllegalStateException();
            lastAccessed.item = item;
        }

        //removes an item
        public void remove() {
            if (lastAccessed == null) throw new IllegalStateException();
            Node x = lastAccessed.prev;
            Node y = lastAccessed.next;
            x.next = y;
            y.prev = x;
            n--;
            if (current == lastAccessed)
                current = y;
            else
                index--;
            lastAccessed = null;
        }

        // add element to list
        public void add(Item item) {
            Node x = current.prev; //prev node
            Node y = new Node(); //new node
            Node z = current; //current node
            y.item = item;
            x.next = y;
            y.next = z;
            z.prev = y;
            y.prev = x;
            n++;
            index++;
            lastAccessed = null;
        }

    }

    //converts to string
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    //this is where the program starts
    public static void main(String[] args) {

    	//creates the scanner
        Scanner sc = new Scanner(System.in);

        //scans the first int
        int n = sc.nextInt();
        
        //creates n random numbers
        System.out.println(n + " random integers between 0 and 99");
        uppg4CircularLinkedList<Integer> list = new uppg4CircularLinkedList<Integer>();
        //add the numbers to the list
        for (int i = 0; i < n; i++)
        list.addlast((int)(Math.random() * (99-0)) + 0);
        //print the list
        System.out.println(list);
        System.out.println();

        //add a random number as last
        System.out.println("Random number will be added at the end of the list:");
        list.addlast((int)(Math.random() * (99-0)) + 0);
        System.out.println(list);

        //add a random number as first
        System.out.println("Random number will be added at the front of the list:");
        list.addfirst((int)(Math.random() * (99-0)) + 0);
        System.out.println(list);

        //remover the last number
        System.out.println("Number will be removed at the end of the list:");
        list.removelast();
        System.out.println(list);

        //remove the first number
        System.out.println("Number will be removed at the front of the list:");
        list.removefirst();
        System.out.println(list);
    }
}