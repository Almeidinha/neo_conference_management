package com.almeida.conference.utils;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class FileUtilsTest {

    private static final String FILE_PATH =  System.getProperty("user.dir") + File.separator +"files"+ File.separator + "input.txt";

    @Test
    public void readFromFile() {
        File file = new File(FILE_PATH);
        assertTrue(file.exists());
        List<String> list = FileUtils.readFromFile(FILE_PATH);
        assertNotNull(list);
        assertTrue(list.size() > 0);
        list.forEach(System.out::println);
    }


}
