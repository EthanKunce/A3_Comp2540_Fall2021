

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



    public static void main(String[] args) {
        // Stack2540Array test = new Stack2540Array();
        for(int i = 0; i < valid.length; i++){
            System.out.println("Valid check: String:\t" + i +"\tMatched:\t" + isMatched(valid[i]));
        }
        for(int i = 0; i < invalid.length; i++){
            System.out.println("Invalid check: String:\t" + i +"\tMatched:\t" + isMatched(invalid[i]));
        }

        // String[] testCases
        
    }

    public static boolean isMatched(String expression){
        Stack2540Array insideBrackets = new Stack2540Array();
        Stack2540Array outsideBrackets = new Stack2540Array();


        // while(expression.charAt(0))
        for(int i = 0; i < expression.length(); i++)
        {
            Integer a = expression.codePointAt(i);

            switch (a) {
                case 40: // '('
                    insideBrackets.push(a.toString());
                    break;
                case 41: // ')'
                    outsideBrackets.push(a.toString());
                    // checkbracketStack = true;
                    break;                    
                case 91: // '['
                    insideBrackets.push(a.toString());
                    break;    
                    
                case 93: // ']'
                    // insideBrackets.push(a.toString());
                    outsideBrackets.push(a.toString());
                    // checkbracketStack = true;
                    break;

                case 123: // '{'
                    insideBrackets.push(a.toString());
                    break;

                case 125: // '}'
                    outsideBrackets.push(a.toString());
                    // checkbracketStack = true;
                    break;                    
                default:
                    break; 
            }
            while(!outsideBrackets.isEmpty()){
                int test = outsideBrackets.pop().codePointAt(0);
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

    }
}