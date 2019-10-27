package com.almeida.conference.entities;

public class Talk {

    public Talk(int length, String title) {
        this.length = length;
        this.title = title;
    }

    private int length;
    private String title;

    public int getLength() {
        return length;
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
}
