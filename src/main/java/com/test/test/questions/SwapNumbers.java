package com.test.test.questions;

import java.util.Scanner;

public class SwapNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Capture input values from the user
        System.out.print("Enter value for a: ");
        int a = scanner.nextInt();
        System.out.print("Enter value for b: ");
        int b = scanner.nextInt();
        System.out.print("Enter value for c: ");
        int c = scanner.nextInt();
        System.out.print("Enter value for d: ");
        int d = scanner.nextInt();
        System.out.print("Enter value for e: ");
        int e = scanner.nextInt();

        // Perform the swaps according to the specified rules
        a = a + b + c + d + e;
        b = a - (b + c + d + e);
        c = a - (b + c + d + e);
        d = a - (b + c + d + e);
        e = a - (b + c + d + e);
        a = a - (b + c + d + e);

        // Output the results
        System.out.println("After swapping:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);

        scanner.close();
    }
}
