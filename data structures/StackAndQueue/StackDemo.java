package StackAndQueue;

import java.util.ArrayList;
import java.util.List;

public class StackDemo {

    public static void main(String []args) {

        Stack<Integer> myStack = new Stack<>(5);
        /*
        myStack.push(25);
        myStack.push(16);
        myStack.push(68);
        myStack.pop();
        System.out.println(myStack);
        myStack.push(56);
        myStack.push(100);
        System.out.println(myStack);
        System.out.println(myStack.top());
        */
        myStack.push(100);
        myStack.push(35);
        myStack.push(65);
        myStack.push(68);
        myStack.push(45);
        System.out.println(myStack);
        myStack.pop();
        myStack.push(98);
        System.out.println(myStack);
    }
}
