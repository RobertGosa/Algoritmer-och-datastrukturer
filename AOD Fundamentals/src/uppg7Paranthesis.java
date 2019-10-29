import java.util.Scanner;

public class uppg7Paranthesis {

	//this is where the program starts
    public static void main(String[] args) {
    	//creates a scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a series of Parentheses.");
        //scan the string
        String s = scan.next();
        //check if balanced
        isBalanced(s);
    }

    public static boolean isBalanced(String list)
    {
    	//create the stack
        uppg7stack<Character> stack = new uppg7stack<Character>();
        
        //for every character in the string do following
        //check every character for the type of paranthesis
        //if open paranthesis, push it to the stack, if close check with the last element in the stack
        for (int i = 0; i< list.length(); i++)
        {
            if(list.charAt(i) == '(')
            {
                stack.push('(');
            }

            if (list.charAt(i) == '{')
            {
                stack.push('{');
            }

            if (list.charAt(i) == '[')
            {
                stack.push('[');
            }

            if (list.charAt(i)== ')')
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                if (stack.pop() != '(')
                {
                    return false;
                }
            }

            else if(list.charAt(i)== '}')
            {
                if(stack.isEmpty())
                {
                    return false;
                }

                if(stack.pop() != '{')
                {
                    return false;
                }
            }

            else if(list.charAt(i) == ']')
            {
                if(stack.isEmpty())
                {
                    return false;
                }

                if (stack.pop() != '[')
                {
                    return false;
                }
            }
        }
        
        //if stack is empty then result is true
        boolean result = stack.isEmpty();
        //print result
        if(result == true) {
        	System.out.print("Paranthesis match.");
        } else {
        	System.out.print("Paranthesis do not match.");
        }
        return result;
    }
}
