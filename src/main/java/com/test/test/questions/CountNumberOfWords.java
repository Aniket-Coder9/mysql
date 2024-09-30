package com.test.test.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountNumberOfWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        Map<String, Long> wordCount = countWords(input);
        System.out.println("Word count: " + wordCount);

        scanner.close();
    }

    private static Map<String, Long> countWords(String input) {
        return Arrays.stream(input.split("\\s+"))
                .filter(word -> !word.trim().isEmpty())
                .collect(Collectors.groupingBy(String::trim, Collectors.counting()));
    }

}
