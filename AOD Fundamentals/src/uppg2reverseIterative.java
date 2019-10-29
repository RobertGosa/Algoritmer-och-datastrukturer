import java.lang.String;
import java.util.Scanner;

//reverses an input
public class uppg2reverseIterative
{
	//this is where the program starts
    public static void main(String[] args)
    {

		System.out.println("Reverse iterative: ");
		//creates the scanner
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        
        //converts string to char[]
        char[] characters = inputString.toCharArray();
        IteReverseJava(characters);
        
        //print output
		System.out.println(printTheArray(characters));
		System.out.println();

    }
    
    //reverse the input
    public static void IteReverseJava(char[] charArr)
    {

        for (int i = charArr.length - 1; i >= 0; i--)
        {
        	System.out.print(charArr[i]);
        }
        System.out.println("");
    }

//print the array with the [x], 
    public static String printTheArray(char[] chars)
    {

		StringBuilder strB = new StringBuilder();

		    	for(int i = 0; i < chars.length; i++)
		    	{
		    		strB.append("[" + chars[i] + "]");
		    		if(i != chars.length-1)
		    		{
		    			strB.append(", ");
		    		}
				}
			return strB.toString();
	 }
}