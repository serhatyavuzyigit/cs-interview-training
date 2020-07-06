package StackAndQueue;

import java.util.Scanner;

public class PrefixToInfix {

    /***
     given prefix expression turns to it's infix presentation
     for example;
     *+AB-CD -> ((A + B) * (C - D))
     *
     * Reverse operaiton of PostfixToInfix
     * * */

    private static String operators = "+-*/";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the prefix expression :");
        String prefixExpression = input.nextLine();
        String infixPresentation = prefixToInfix(prefixExpression);
        System.out.println(infixPresentation);

    }

    private static String prefixToInfix(String prefix) {
        String infix = "";
        Stack<String> myStack = new Stack<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (operators.indexOf(c) == -1) {
                // if char is operand
                myStack.push(c + "");
            } else {
                String operand1 = myStack.pop();
                String operand2 = myStack.pop();
                myStack.push("(" + operand1 + " " + c + " " + operand2 + ")");
            }
        }
        infix = myStack.pop();
        return infix;
    }
}
