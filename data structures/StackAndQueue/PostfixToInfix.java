package StackAndQueue;

import java.util.Scanner;

public class PostfixToInfix {

    /***
     given postfix expression turns to it's infix presentation
     for example;
     abc++ -> (a + (b + c))
     ab*c+ -> ((a * b) + c)
     */

    private static String operators = "+-*/";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the postfix expression :");
        String postfixExpression = input.nextLine();
        String infixPresentation = postfixToInfix(postfixExpression);
        System.out.println(infixPresentation);

    }


    private static String postfixToInfix(String postfix) {
        String infix = "";
        Stack<String> myStack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (operators.indexOf(c) == -1) {
                // if char is operand
                myStack.push(c + "");
            } else {
                String operand1 = myStack.pop();
                String operand2 = myStack.pop();
                myStack.push("(" + operand2 + " " + postfix.charAt(i) + " " + operand1 + ")");
            }
        }

        infix = myStack.pop();
        return infix;
    }
}
