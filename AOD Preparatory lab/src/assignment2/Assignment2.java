package assignment2;

import java.util.Scanner;

public class Assignment2 {

    public static void main (String[] args){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter characters:");
    String c;

    c = keyboard.nextLine();
    StringBuilder abc = new StringBuilder(c);
    int N = abc.length();
    int i = 0;
    while (i < N){
        if (abc.charAt(i) == 'a'){
            abc.setCharAt(i, 'X');

        }
        i++;
    }
    System.out.println(abc);
    }
}
