package com.almeida.conference.enums;

import java.time.LocalTime;

public enum SessionEmun {

    MORNING(180, LocalTime.of(9, 0, 0)),
    AFTERNOON(240, LocalTime.of(1, 0, 0));

    private int length;
    private LocalTime startTime;

    SessionEmun(int length, LocalTime startTime) {
        this.length = length;
        this.startTime = startTime;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
}
