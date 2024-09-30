package com.test.test.questions;

import java.util.Stack;

public class Notation {

//    . EVALUATE REVERSE POLISH NOTATION
//    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish
//    Notation. Evaluate the expression. Return an integer that represents the value of the expression. Note that: The valid operators are '+', '-', '*', and '/'. Each operand may be an integer or another expression. The division between two integers always truncates toward zero. There will not be any division by zero. The input represents a valid arithmetic expression in a reverse polish notation. The answer and all the intermediate calculations can be represented in a 32-bit integer. Example 1:
//    Input: tokens = ["2","1","+","3","*"]
//    Output: 9
//    Explanation: ((2 + 1) * 3) = 9
//    Example 2:
//    Input: tokens = ["4","13","5","/","+"]
//    Output: 6
//    Explanation: (4 + (13 / 5)) = 6
//    Example 3:
//    Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]


    public static int polishNottion(String[] input){
        int output = 0;
        Stack<Integer> stack = new Stack<>();
        for(String data : input){

            switch (data) {
                case "+":
                    Integer value1 = stack.pop();
                    Integer value2 = stack.pop();
                    output = value1 + value2;
                    stack.push(output);
                    break;

                case "-" :
                    output = stack.pop() - stack.pop();
                    break;
                case "*" :
                    Integer mul1 = stack.pop();
                    Integer mul2 = stack.pop();
                    output = mul1 * mul2;
                    stack.push(output);
                    break;
                case "/" :
                    int dividend =stack.pop();
                    int divisor = stack.pop();
                    output = dividend / divisor;
                    break;
                    default :
                        stack.push(Integer.parseInt(data));
                        break;

            }

        }
        return output;
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        int result = Notation.polishNottion(tokens);
        System.out.println(result);
    }
}
