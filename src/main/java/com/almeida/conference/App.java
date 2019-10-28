package com.almeida.conference;

import com.almeida.conference.entities.Track;
import com.almeida.conference.services.TrackService;
import com.almeida.conference.utils.FileUtils;
import com.almeida.conference.utils.Logger;

import java.io.File;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Conference Management!
 *
 */
public class App {

    private static final String FILE_PATH =  System.getProperty("user.dir") + File.separator +"files"+ File.separator + "input.txt";
    private static final TrackService trackService = TrackService.getInstance();
    private static final Logger logger = Logger.getLogger();

    public static void main( String[] args ){

        List<String> rawList = FileUtils.readFromFile(FILE_PATH);
        if (rawList.size() == 0) {
            logger.fatal("File can't be empty!");
            System.exit(1);
        }



        List<Track> tracks = trackService.schedule(rawList);

        IntStream.range(0, tracks.size()).forEach(i -> {
            Track track = tracks.get(i);
            System.out.println("Track " + (i + 1) + ":");
            System.out.print(track.getMorning().formatedOutput());
            System.out.print(track.getAfternoon().formatedOutput());
            System.out.println();
        });

    }
}
