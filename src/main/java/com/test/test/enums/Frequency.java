package com.test.test.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Frequency {
    ALWAYS("Always"), RANDOM("Random");
    private final String value;

    public static Frequency getByValue(String value) {
        for (Frequency f : Frequency.values()) {
            if (f.value.equals(value)) {
                return f;
            }
        }
        return null;
    }

    public static Frequency getByName(String name) {
        for (Frequency f : Frequency.values()) {
            if (f.name().equals(name)) {
                return f;
            }
        }
        return null;
    }
}
