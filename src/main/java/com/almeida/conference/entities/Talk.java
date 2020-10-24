package com.almeida.conference.entities;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class reperesntind a Talk of the conferênce
 *
 * @author marcos.almeida
 */
@Data
public class Talk implements Comparable {

    public Talk(int length, String title) {
        this.length = length;
        this.title = title;
    }

    public Talk(String title) {
        this.title = title;
        this.length = this.getLength(title);
    }

    private int length;
    private String title;

    /**
     * Extracts the length of the Talk from it's title
     *
     * @param title title
     * @return length of the talk
     */
    private int getLength(String title) {
        Pattern pattern = Pattern.compile("((\\d+)+(min))");
        Matcher matcher = pattern.matcher(title);
        if (matcher.find()) {
            return Integer.valueOf(matcher.group().replaceAll("[^\\d.]", ""));
        }
        return 5;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "length=" + length +
                ", title='" + title + '\'' +
                '}';
    }

    /**
     * Simplify the compare method by conparing the length, then the title hash
     *
     * @param o {@link Talk}
     * @return integer size
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Talk) {
            Talk t = (Talk) o;
            if (this.length == t.length) {
                return this.title.hashCode() - t.title.hashCode();
            } else {
                return this.length - t.length;
            }
        }
        return -1;
    }

}
