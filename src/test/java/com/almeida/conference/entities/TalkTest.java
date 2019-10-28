package com.almeida.conference.entities;

import org.junit.Test;

import java.util.NavigableSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class TalkTest {

    @Test
    public void test(){
        String line1 = "Ruby on Rails Legacy App Maintenance 60min";
        String line2 = "Programming in the Boondocks of Seattle 30min";
        String line3 = "Rails for Python Developers lightning";

        Talk talk1 = new Talk(line1);
        Talk talk2 = new Talk(line2);
        Talk talk3 = new Talk(line3);

        System.out.println(talk1.getLength());
        System.out.println(talk2.getLength());
        System.out.println(talk3.getLength());

        assertEquals(talk1.getLength(), 60);
        assertEquals(talk2.getLength(), 30);
        assertEquals(talk3.getLength(), 5);

        TreeSet<Talk> talks = new TreeSet<>();
        talks.add(talk1);
        talks.add(talk3);
        talks.add(talk2);
        System.out.println(talks);
        NavigableSet<Talk> talks1 = talks.descendingSet();
        System.out.println(talks1);

        assertEquals(talks1.first().getLength() , 60);
    }

}
