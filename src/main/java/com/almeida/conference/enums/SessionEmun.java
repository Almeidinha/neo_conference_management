package com.almeida.conference.enums;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

public enum SessionEmun {

    MORNING(180, LocalTime.of(9, 0, 0)),
    AFTERNOON(240, LocalTime.of(1, 0, 0));

    @Getter
    @Setter
    private int length;

    @Getter
    @Setter
    private LocalTime startTime;

    SessionEmun(int length, LocalTime startTime) {
        this.length = length;
        this.startTime = startTime;
    }

}
