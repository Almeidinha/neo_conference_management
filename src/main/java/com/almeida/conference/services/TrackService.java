package com.almeida.conference.services;

public class TrackService {


    private static final TrackService trackService = new TrackService();

    private TrackService() {
    }

    public static TrackService getInstance() {
        return trackService;
    }

}
