package assignment3;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment3 {

	public static void main (String[] args) {
		int nrElements;
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many numbers will be entered? ");
		nrElements = scanner.nextInt();
		int numbers[] = new int[nrElements];
		System.out.println("Enter the numbers: ");
		for(int i = 0; i < nrElements; i++) {
			numbers[i] = scanner.nextInt();
		}
		for(int i = nrElements - 1; i >= 0; i--) {
			System.out.println(numbers[i]);
		}
}
}
