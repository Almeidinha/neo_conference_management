package com.almeida.conference.entities;

import com.almeida.conference.enums.SessionEmun;
import lombok.Data;

/**
 * Class representing a Track in the conference split into Sessions
 *
 * @author marcos.almeida
 */
@Data
public class Track {

    public Track(Session morning, Session afternoon) {
        this.morning = morning;
        this.afternoon = afternoon;
    }

    public Track() {
        this.morning = new Session(SessionEmun.MORNING);
        this.afternoon = new Session(SessionEmun.AFTERNOON);
    }

    private Session morning;
    private Session afternoon;

    @Override
    public String toString() {
        return "Track{" +
                "morning=" + morning +
                ", afternoon=" + afternoon +
                '}';
    }

    /**
     * Adds a Talk to a Session, if there's time avaliable to fit it in
     * otherwise return false.
     *
     * @param talk {@link Talk}
     * @return boolean
     */
    public boolean add(Talk talk) {
        boolean added = true;

        if (morning.getTimeAvaliable() >= talk.getLength()) {
            morning.add(talk);
        } else if (afternoon.getTimeAvaliable() >= talk.getLength()) {
            afternoon.add(talk);
        } else {
            added = false;
        }
        return added;

    }

}
