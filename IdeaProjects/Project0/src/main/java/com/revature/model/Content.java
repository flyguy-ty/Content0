package com.revature.model;

public class Content {
    
    private int content_id;
    private String title;
    private String mood;
    private int timelength;

    public Content(String title, int timelength) {

        this.title = title;
        this.timelength = timelength;

    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public int getTimelength() {
        return timelength;
    }

    public void setTimelength(int timelength) {
        this.timelength = timelength;
    }

    @Override
    public String toString(){
        return "For you: "
                 + title + " (" + timelength + " min"+")";
    }
}
