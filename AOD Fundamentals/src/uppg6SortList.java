import java.lang.String;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class uppg6SortList
{
    public static void main(String[] args)
    {
    	//creates the scanner
    	Scanner scanner = new Scanner(System.in);

		System.out.println("Sort: ");
		//creates the array used as the queue
        int[] integers = new int[100];
        
        //adds numbers to the array
        integers = sort(add(integers, 7)); // to insert
        integers = sort(add(integers, 1)); // to insert
        integers = sort(add(integers, 4)); // to insert
        integers = sort(add(integers, 2)); // to insert
        //removes the number on the 2nd position
        integers = sort(remove(integers, 2)); // to remove
        }

    //adds a number, newInt, to the queue
	public static int[] add(int[] arr, int newInt) {
		int[] newArr = new int[arr.length + 1];
		
		if(arr.length == 0) {
			newArr[0] = newInt;
			return newArr;
		}
		
		for(int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		
		newArr[arr.length] = newInt;
		return newArr;
	}
	
	//removes a value at the specified position
	public static int[] remove(int[] arr, int position) {
		
		if(arr.length == 0) {
			throw new NoSuchElementException("Can not remove because the array is empty");
		}
		
		if(position > arr.length) {
			throw new NoSuchElementException("Can not remove because the posistion does not exist");
		}
		
		int[] newArr = new int[arr.length-1];
		position -= 1;
		
		for(int i = 0; i < position; i++) {
			newArr[i] = arr[i];
		}
		for(int i = position; i < arr.length - 1; i++) {
			newArr[i] = arr[i+1];
		}
		return newArr;
	}

	//sorts the array using insertion sort algorithm
    public static int[] sort(int[] arr) {
    	int size = arr.length; 
    	//current starts at 1 and j at 0
        for (int i = 1; i < size; ++i) { 
            int current = arr[i]; 
            int j = i - 1; 
            //while j is positive and the j:th position has a value bigger than the current value swap j with j+1
            while (j >= 0 && arr[j] > current) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            //put the current value back in the list
            arr[j + 1] = current; 
        }
        
        //prints the array as the "[x]," form 
        System.out.println(printTheArray(arr));
		System.out.println();
		//returns the sorted array
        return arr;
}
    
    //
    public static String printTheArray(int[] integers)
    {

		StringBuilder strB = new StringBuilder();

		    	for(int i = 0; i < integers.length; i++)
		    	{
		    		strB.append("[" + integers[i] + "]");
		    		if(i != integers.length-1)
		    		{
		    			strB.append(", ");
		    		}
				}
			return strB.toString();
	 }
}