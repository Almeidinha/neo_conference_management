package com.almeida.conference.entities;

public class Track {

    public Track(Session morning, Session afternoon) {
        this.morning = morning;
        this.afternoon = afternoon;
    }

    private Session morning;
    private Session afternoon;

    public Session getMorning() {
        return morning;
    }

    public void setMorning(Session morning) {
        this.morning = morning;
    }

    public Session getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(Session afternoon) {
        this.afternoon = afternoon;
    }

    @Override
    public String toString() {
        return "Track{" +
                "morning=" + morning +
                ", afternoon=" + afternoon +
                '}';
    }
}
