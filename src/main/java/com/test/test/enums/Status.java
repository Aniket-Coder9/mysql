package com.test.test.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    NEW("New"), ASSIGNED("Assigned"), RESOLVED("Resolved"), CLOSED("Closed");
    private final String value;

    public static Status getByValue(String value) {
        for (Status s : Status.values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        return null;
    }

    public static Status getByName(String name) {
        for (Status s : Status.values()) {
            if (s.name().equals(name)) {
                return s;
            }
        }
        return null;
    }
}
