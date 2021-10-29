import java.io.*;
import java.util.*;

public class Stack2540ArrayI extends Stack2540Array{

    private int CAPACITY = 256;
    private int top;
    private String[] stack;


    public Stack2540ArrayI(int size){
        stack = new String[size];
        top = -1;
    }

    public Stack2540ArrayI(){

    stack = new String[CAPACITY];
    top = -1;
    }

    public void resize(){
        if(top >= stack.length-2){
            // CAPACITY *= 2;
            String[] newArray = Arrays.copyOf(stack, stack.length+128);
            stack = newArray;
        }
    }

    public void push(String element) {
        if(++top >= stack.length-1){
            resize();
        }
        stack[top] = element;
    }
}

