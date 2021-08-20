package com.clockworkjava.kursspring.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class Quest {

    private String description;

    public Quest(String description) {
        this.description = "Uratuj ksiezniczke";
    }

    @Override
    public String toString() {
        return description;
    }
}
