package com.almeida.conference.services;

import com.almeida.conference.entities.Talk;
import com.almeida.conference.entities.Track;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class TrackServiceTest {

    @Test
    public void schedule() {

        List<String> talks = getTestList();

        TrackService instance = TrackService.getInstance();
        List<Track> schedule = instance.schedule(talks);

        schedule.forEach(track -> {
            System.out.println(track.getMorning());
            System.out.println(track.getAfternoon());
        });

        assertTrue(schedule.size() > 0);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void getTalkList() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        TrackService instance = TrackService.getInstance();
        List<String> lineList = getTestList();
        Method method = TrackService.class.getDeclaredMethod("getTalkList", List.class);
        method.setAccessible(true);
        TreeSet<Talk> talkList  = (TreeSet<Talk>) method.invoke(instance, lineList);

        assertEquals(lineList.size(), talkList.size());
        assertTrue(lineList.get(0).contains(talkList.last().getTitle()));

    }

    private List<String> getTestList() {

        String line1 = "Ruby on Rails Legacy App Maintenance 60min";
        String line2 = "Programming in the Boondocks of Seattle 30min";
        String line3 = "Rails for Python Developers lightning";

        List<String> talks = new ArrayList<>();
        talks.add(line1);
        talks.add(line2);
        talks.add(line3);

        return talks;


    }

}
