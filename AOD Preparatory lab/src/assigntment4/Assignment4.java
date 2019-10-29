package assigntment4;

import java.util.ArrayList;
import java.util.List;

public class Assignment4 {	
	
	static Node first = new Node(3);
	
	public static void main (String [] args) {
		insertNodeAsFirst(5);
		insertNodeAsFirst(4);
		insertNodeAsFirst(6);
		removeFirstNode();
		insertNodeToPosition(1, 1);
		//printNodes();
		insertInNumericalOrder(sortList(), 2);
	}
	
	public static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void insertNodeAsFirst(int data) {
		Node oldfirst = first;
		first = new Node(data);
		first.next = oldfirst;
	}
	
	public static Node removeFirstNode() {
		Node removedNode = first;
		first = first.next;
		return removedNode;
	}
	
	public static Node printNodes() {
		Node currentNode = first;
		while(currentNode != null) {
		System.out.println(currentNode.data + " ");
		currentNode = currentNode.next;
		}
		return currentNode;
	}
	
	public static int countNodes() {
		Node currentNode = first;
		int numberOfNodes = 0;
		while(currentNode != null) {
			numberOfNodes++;
			}
		return numberOfNodes;
	}
	
	public static void insertNodeToPosition (int data, int position) {
		if(position == 1) {
			insertNodeAsFirst(data);
		} else {
		Node currentNode = first;
		Node newNode = new Node(data);
		for(int i = 2; i < position; i++) {
			currentNode = currentNode.next;
		}
		newNode.next = currentNode.next;
		currentNode.next = newNode;
		}
	}
	
	public static int[] sortList() {
		Node currentNode = first;
		int numberOfNodes = 0;
		List<Integer> list = new ArrayList<>();
		
		while(currentNode != null) {
		list.add(currentNode.data);
		currentNode = currentNode.next;
		numberOfNodes++;
		}
		
		int data[] = new int[numberOfNodes];
		int b = 0;
		
		for(int i = 0; i < numberOfNodes; i++) {
		data[i] = list.get(i);
		}
		
		for(int a = 0; a < numberOfNodes; a++) {
			for(int i = 0; i + 1 < numberOfNodes - b; i++) {
				if(data[i] > data[i+1]) {
				int swap = data[i];
				   data[i] = data[i+1];
				   data[i+1] = swap;
				}
			}
			b++;
		}
		
		System.out.println("------");
		
		for(int i = 0; i < numberOfNodes; i++) {
			//System.out.println(data[i]);
		}
		
		return data;
			   		
	}
	
	
	public static void insertInNumericalOrder(int[] data, int number) {
		Node currentNode = first;
		int numberOfNodes = countNodes();
		for(int i = 0; i < numberOfNodes; i++) {
		currentNode.data =  data[i];
		currentNode = currentNode.next;
		}
		Node node = printNodes();
	}
	
}
