package com.test.test.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Priority {

    CRITICAL("Critical"), HIGH("High"), MEDIUM("Medium");
    private final String value;

    public static Priority getByValue(String value) {
        for (Priority p : Priority.values()) {
            if (p.value.equals(value)) {
                return p;
            }
        }
        return null;
    }

    public static Priority getByName(String name) {
        for (Priority p : Priority.values()) {
            if (p.name().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
