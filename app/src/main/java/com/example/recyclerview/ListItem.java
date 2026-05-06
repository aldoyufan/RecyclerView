package com.example.recyclerview;

public class ListItem {
    private String name;
    private boolean isClicked;

    public ListItem(String name) {
        this.name = name;
        this.isClicked = false;
    }

    public String getName() {
        return name;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
