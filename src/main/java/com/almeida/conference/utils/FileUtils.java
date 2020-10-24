package com.almeida.conference.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class responsable to File related Operations
 *
 * @author marcos.almedia
 */
public class FileUtils {

    private static final Logger logger = Logger.getLogger();

    /**
     * Reads the File Lines into a List of Strings
     *
     * @param p String Path
     * @return List with the Lines from the File
     */
    public static List<String> readFromFile(String p) {

        List<String> lines = new ArrayList<>();
        Path path = Paths.get(p);

        if (Files.exists(path)) {
            // Let's use Java 8 cuz... why not? (I know, it's slower... buts its soo prety!)
            // Also, it handles closing the readers.
            try (Stream<String> list = Files.lines(path)) {
                lines = list.collect(Collectors.toList());
            } catch (IOException e) {
                logger.error("Error While reading file : " + e.getMessage());
            }
        } else {
            logger.error("Could not find .txt file");
        }
        /*try {
            lines = Files.readAllLines(path, Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("Could not find .txt file");
        }*/
        return lines;
    }

}
