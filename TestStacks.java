import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestStacks{

    final static String [] valid = {
        "( ) ( ( ) ) {( [ ( ) ] ) } ",
        "(3) (3 + (4 - 5) ) {( [ ( ) ] ) } ",
        "((() (()){([() ])}))",
        "[(5+x) -(y+z)]"
    };

    final static String [] invalid ={
        ")(()){([()])}",
        "({[])}",
        "("
    };

    // public boolean testStrings(){
    //     Stack2540Array test = new Stack2540Array();

        
    // }



    public static void main(String[] args) throws Exception {
        // Stack2540Array test = new Stack2540Array();
        for(int i = 0; i < valid.length; i++){
            System.out.println("Valid check: String:\t" + i +"\tMatched:\t" + isMatched(valid[i]));
        }
        for(int i = 0; i < invalid.length; i++){
            System.out.println("Invalid check: String:\t" + i +"\tMatched:\t" + isMatched(invalid[i]));
        }


        String filename = "dblp200.txt";
        // Scanner reader = new Scanner(new File(filename));
        String[] reverseInput = reverse(filename);

        PrintWriter writer = new PrintWriter(filename+ "_Reverse");
        for(String a : reverseInput){
            writer.print(a);
        }
        writer.close();
        

        // String[] testCases
        
    }


    public static boolean isMatched(String expression) {
        final String opening = "({[";
        final String closing = ")}]";
        Stack2540Array buffer = new Stack2540Array();
        for (char c : expression.toCharArray ()) {
            if (opening.indexOf(c) != -1) 
                buffer.push(c);
            else if (closing.indexOf(c) != -1) {
                if (buffer.isEmpty ()) 
                    return false;
                if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
                    return false;
            }
        }
        return buffer.isEmpty ();
    }

    public static String [] reverse(String filename) throws Exception{
        Scanner scanner = new Scanner(new File(filename)).useDelimiter("[^a-zA-Z]+");
        Stack2540Array stack = new Stack2540Array();
        int[] newLineCount = new int[2000];
        int lineCountIndex = 0;
        int iWordCounter = 0;
        String temp;
        while (scanner.hasNext()){
            temp = scanner.next();
            if(temp.contains("\n"))
            {
                newLineCount[lineCountIndex++] = iWordCounter;
                iWordCounter = 0;
            }
            else{
                iWordCounter++;
            }
            stack.push(temp.toLowerCase());
        }
        String [] rev = new String[stack.size()];

        // StringBuilder test = new StringBuilder();
        int i = 0;
        while(!stack.isEmpty())
        {
            // test.append(stack.pop());
            if(newLineCount[lineCountIndex] < 1)
            {
                rev[i++] = "\n"+stack.pop();  
                lineCountIndex--; 
            }
            else{
                rev[i++] = " "+ stack.pop();
            }
            newLineCount[lineCountIndex]--;
        }
        
        
        scanner.close();
        return rev;
        }

/*
    public static boolean isMatched(String expression){
        Stack2540Array insideBrackets = new Stack2540Array();
        Stack2540Array outsideBrackets = new Stack2540Array();


        // while(expression.charAt(0))
        for(int i = 0; i < expression.length(); i++)
        {
            String a = expression.c

            // switch (a) {
            //     case 40: // '('
            //         insideBrackets.push();
            //         break;
            //     case 41: // ')'
            //         outsideBrackets.push(a.toString());
            //         // checkbracketStack = true;
            //         break;                    
            //     case 91: // '['
            //         insideBrackets.push(a.toString());
            //         break;    
                    
            //     case 93: // ']'
            //         // insideBrackets.push(a.toString());
            //         outsideBrackets.push(a.toString());
            //         // checkbracketStack = true;
            //         break;

            //     case 123: // '{'
            //         insideBrackets.push(a.toString());
            //         break;

            //     case 125: // '}'
            //         outsideBrackets.push(a.toString());
            //         // checkbracketStack = true;
            //         break;                    
            //     default:
            //         break; 
            // }
            while(!outsideBrackets.isEmpty()){
                String temp = outsideBrackets.pop();
                int test = temp.codePointAt()
                switch (test) {
                    case 41:
                        if(insideBrackets.pop().compareTo("(") != 0)
                            return false;
                        insideBrackets.pop();
                        break;
                    case 93:
                        if(insideBrackets.pop().compareTo("[") != 0)
                            return false;
                        insideBrackets.pop();
                        break;
                    case 125:
                        if(insideBrackets.pop().compareTo("{") != 0)
                            return false;  
                        insideBrackets.pop();           
                        break;
                    default: 
                        break;
                }
            }
        }
        if(!insideBrackets.isEmpty())
        {
            return false;
        }
        return true;
    }*/
}
