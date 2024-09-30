package com.test.test.utils;

import java.util.Random;
import java.util.regex.Pattern;

public class TicketNumberGenerator {
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generateRandomString() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(26);
            builder.append(ALPHA_NUMERIC_STRING.charAt(index));
        }

        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(10);
            builder.append(ALPHA_NUMERIC_STRING.charAt(26 + index));
        }

        return builder.toString();
    }
}
