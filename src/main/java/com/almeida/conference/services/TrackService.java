package com.almeida.conference.services;

import com.almeida.conference.entities.Talk;
import com.almeida.conference.entities.Track;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class TrackService {

    private static final TrackService trackService = new TrackService();

    private TrackService() {
    }

    public static TrackService getInstance() {
        return trackService;
    }

    public List<Track> schedule(TreeSet<Talk> talks) {

        LinkedList<Track> tracks = new LinkedList<>();

        tracks.add(new Track());
        talks.descendingSet().forEach( talk -> {
            boolean success = false;

            for (Track track : tracks) {
                if (track != null) {
                    success = track.add(talk);
                    if (success) break;
                }
            }
            if (!success) {
                Track newTrack = new Track();
                newTrack.add(talk);
                tracks.add(newTrack);
            }

        });
        return tracks;
    }

}
