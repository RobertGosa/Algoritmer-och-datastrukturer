public class uppg7stack<Item> {
    private Node first;
    private int counter;

    //what the node contains
    private class Node {
        Item item;
        Node next;
    }

    //checks if the stack is empty
    public boolean isEmpty() {
        return counter == 0;
    }

    //returns the size of the stack
    public int size() {
        return counter;
    }

    //adds item to stack
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        counter++;
    }

    //removes item from stack
    public Item pop() {
        Item item = first.item;
        first = first.next;
        counter--;
        return item;
    }
}