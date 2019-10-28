package com.almeida.conference.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {


    public static List<String> readFromFile(String p) {

        List<String> lines = new ArrayList<>();
        Path path = Paths.get(p);
        /*try {
            lines = Files.readAllLines(path, Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("Could not find .txt file");
        }*/

        // Let's use Java 8 cuz... why not? (I know, it's slower... buts its soo prety!)
       // Also, it handles the closing if the readers
       try (Stream<String> list = Files.lines(path)) {
           lines = list.collect(Collectors.toList());
       } catch (IOException e) {
           System.out.println("Could not find .txt file");
       }

        return lines;

    }

}
