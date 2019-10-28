package com.almeida.conference.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackTest {

    @Test
    public void add() {
        Talk talk = new Talk("Rails Magic 60min");
        Track track = new Track();
        track.add(talk);

        assertEquals(1, track.getMorning().getTalkList().size());

        talk = new Talk("Java is so complex! 110min");
        track.add(talk);

        talk = new Talk("php is bad! 25min");
        track.add(talk);

        assertEquals(2, track.getMorning().getTalkList().size());
        assertEquals(1, track.getAfternoon().getTalkList().size());
    }

}
