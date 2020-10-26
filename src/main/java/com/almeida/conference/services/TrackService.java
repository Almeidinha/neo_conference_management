package com.almeida.conference.services;

import com.almeida.conference.entities.Talk;
import com.almeida.conference.entities.Track;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Service responsable to schedule the Talks into Session Tracks
 */
@NoArgsConstructor
public class TrackService {

    private static final TrackService trackService = new TrackService();

    public static TrackService getInstance() {
        return trackService;
    }

    /**
     * Organize the Talks into Track Sessions,
     * Creat a new Track if a Talk doesn't fit in any Session
     *
     * @param rawList List of {@link Talk}
     * @return List of {@link Track}
     */
    public List<Track> schedule(List<String> rawList) {

        TreeSet<Talk> talks = getTalkList(rawList);
        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track());

        talks.descendingSet().forEach(talk -> {
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

    /**
     * Converts the List of String titles into a TreeSet of Talks
     *
     * @param rawList List of Strings from the file
     * @return TreeSet of Talks
     */
    private TreeSet<Talk> getTalkList(List<String> rawList) {
        TreeSet<Talk> talks = new TreeSet<>();

        rawList.forEach(title -> {
            Talk talk = new Talk(title);
            talks.add(talk);
        });

        return talks;

    }

}
