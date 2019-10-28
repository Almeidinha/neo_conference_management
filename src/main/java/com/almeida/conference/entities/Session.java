package com.almeida.conference.entities;

import com.almeida.conference.enums.SessionEmun;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class Session {

    public Session(SessionEmun sessionEmun) {
        this.sessionEmun = sessionEmun;
        this.sessionLength = sessionEmun.getLength();
        this.timeAvaliable = sessionEmun.getLength();
        this.startTime = sessionEmun.getStartTime();
        this.talkList = new LinkedList<>();
    }

    private int sessionLength;
    private int timeAvaliable;
    private LocalTime startTime;
    private List<Talk> talkList;
    private SessionEmun sessionEmun;


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


    void add(Talk talk) {
        if (talk == null) {
            throw  new NullPointerException("Talk can't be null!");
        }

        int timeRequired = talk.getLength();
        if (timeRequired > this.timeAvaliable) {
            throw new RuntimeException("Session is already full");
        }
        this.talkList.add(talk);
        this.timeAvaliable -= talk.getLength();
    }

    public String formatedOutput() {

        String period = this.sessionEmun == SessionEmun.MORNING ? "AM" : "PM";
        LocalTime st = LocalTime.of(this.startTime.getHour(), this.startTime.getMinute());
        StringBuilder sb = new StringBuilder();

        for (Talk talk : this.getTalkList()) {
            if (st.getHour() < 10) {
                sb.append(0);
            }
            sb.append(st.getHour()).append(":");

            if (st.getMinute() < 10) {
                sb.append(0);
            }
            sb.append(st.getMinute()).append(period).append(" ");
            sb.append(talk.getTitle()).append("\n");
            st = st.plusMinutes(talk.getLength());
        }
        if (period.equals("AM")) {
            sb.append("12:00PM Lunch\n");
        } else {
            sb.append(st).append(" Networking Event\n");
        }

        return sb.toString();
    }
}
