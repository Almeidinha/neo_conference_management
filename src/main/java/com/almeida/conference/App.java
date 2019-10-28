package com.almeida.conference;

import com.almeida.conference.entities.Talk;
import com.almeida.conference.entities.Track;
import com.almeida.conference.services.TrackService;
import com.almeida.conference.utils.FileUtils;
import com.almeida.conference.utils.Logger;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App {

    private static final String FILE_PATH =  System.getProperty("user.dir") + File.separator +"files"+ File.separator + "input.txt";
    private static final TrackService trackService = TrackService.getInstance();
    private static final Logger logger = Logger.getLogger();

    public static void main( String[] args ){

        List<String> list = FileUtils.readFromFile(FILE_PATH);
        if (list.size() == 0) {
            logger.fatal("File is null or empty");
        }

        TreeSet<Talk> talks = new TreeSet<>();

        list.forEach( title -> {
            Talk talk = new Talk(title);
            talks.add(talk);
        });

        List<Track> tracks = trackService.schedule(talks);


        IntStream.range(0, tracks.size()).forEach(i -> {
            Track track = tracks.get(i);
            System.out.println("Track " + (i + 1) + ":");
            System.out.print(track.getMorning().formatedOutput());
            System.out.print(track.getAfternoon().formatedOutput());
            System.out.println();
        });

    }
}
