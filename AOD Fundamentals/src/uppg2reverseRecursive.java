import java.util.Scanner;
import java.util.Stack;

class uppg2reverseRecursive
{
	//this is where the program starts 
	public static void main(String[] args)
    {
		//create scanner
		Scanner scan = new Scanner(System.in);
		//scan the line
		System.out.println("Reverse recursive: ");
		String s = scan.nextLine();
		//convert to char[]
        char[] characters = s.toCharArray();
        System.out.println(RecReverseJava(s));
        //print the input
		System.out.println(printTheArray(characters));
		System.out.println();

    }

	//reverse the input
	public static String RecReverseJava(String ReverseString)
	{


		if(ReverseString == null || ReverseString.length() <= 1)
			{
				return ReverseString;
			}

		return RecReverseJava(ReverseString.substring(1)) + ReverseString.charAt(0);

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

