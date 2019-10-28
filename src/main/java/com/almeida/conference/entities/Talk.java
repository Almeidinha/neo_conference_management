package com.almeida.conference.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public int getLength() {
        return this.length;
    }

    public int getLength(String title) {
        Pattern pattern = Pattern.compile("((\\d+)+(min))");
        Matcher matcher = pattern.matcher(title);
        if (matcher.find()) {
            return Integer.valueOf(matcher.group().replaceAll("[^\\d.]", ""));
        }
        return 5;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "length=" + length +
                ", title='" + title + '\'' +
                '}';
    }


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
