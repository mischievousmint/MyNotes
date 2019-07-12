package com.example.mynotes;

public class NotesModel{

    public String title;
    public String subtitle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { this.title = title; }

    public String getSubtitle() { return subtitle; }

    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }

    public NotesModel(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public NotesModel() {
    }

}


