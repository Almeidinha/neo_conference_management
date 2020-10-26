package com.almeida.conference.entities;

import com.almeida.conference.enums.SessionEmun;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Session class representing a period ofa Track
 *
 * @author marcos.almeida
 */
@Data
public class Session {

    Session(SessionEmun sessionEmun) {
        this.sessionEmun = sessionEmun;
        this.sessionLength = sessionEmun.getLength();
        this.timeAvaliable = sessionEmun.getLength();
        this.startTime = sessionEmun.getStartTime();
        this.talkList = new ArrayList<>();
    }

    private int sessionLength;
    private int timeAvaliable;
    private LocalTime startTime;
    private List<Talk> talkList;
    private SessionEmun sessionEmun;

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
            throw new NullPointerException("Talk can't be null!");
        }

        int timeRequired = talk.getLength();
        if (timeRequired > this.timeAvaliable) {
            throw new RuntimeException("Session is already full");
        }
        this.talkList.add(talk);
        this.timeAvaliable -= talk.getLength();
    }

    /**
     * <p>Formats the output according to the session type<p/>
     *
     * @return String output formated
     */
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
