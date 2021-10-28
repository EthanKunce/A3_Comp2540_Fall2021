import java.io.*;
import java.util.*;

public class Stack2540Array {

    private int CAPACITY = 10000;
    private int top;
    private String[] stack;

    public Stack2540Array(){

    stack = new String[CAPACITY];
    top = -1;
    }

    public int size() { return top + 1; }

    public boolean isEmpty () { return (top == -1); }

    public String top(){

        if (top == -1){
            return null;
        }

        return stack[top];
    }

    public int getSize(){
        return top;
    }

    public void push(String element) {
        top++;
        stack[top] = element;
    }

    public void push(char element) {
        top++;
        stack[top] = element+"";
    }

    public String pop(){
        // String temp;
        if(top == -1)
        {
            return null;
        }

        String temp = stack[top];
        stack[top] = null;
        top--;
        return temp;
    }

    // public static boolean isMatched(String expression){
        
    // }

    
}