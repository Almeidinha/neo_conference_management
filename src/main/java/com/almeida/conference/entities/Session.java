package com.almeida.conference.entities;

import java.time.LocalTime;
import java.util.List;

public class Session {

    public Session(int sessionLength, int timeAvaliable, LocalTime startTime, List<Talk> talkList) {
        this.sessionLength = sessionLength;
        this.timeAvaliable = timeAvaliable;
        this.startTime = startTime;
        this.talkList = talkList;
    }

    private int sessionLength;
    private int timeAvaliable;
    private LocalTime startTime;
    private List<Talk> talkList;


    public int getSessionLength() {
        return sessionLength;
    }

    public void setSessionLength(int sessionLength) {
        this.sessionLength = sessionLength;
    }

    public int getTimeAvaliable() {
        return timeAvaliable;
    }

    public void setTimeAvaliable(int timeAvaliable) {
        this.timeAvaliable = timeAvaliable;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public List<Talk> getTalkList() {
        return talkList;
    }

    public void setTalkList(List<Talk> talkList) {
        this.talkList = talkList;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionLength=" + sessionLength +
                ", timeAvaliable=" + timeAvaliable +
                ", startTime=" + startTime +
                ", talkList=" + talkList +
                '}';
    }
}
