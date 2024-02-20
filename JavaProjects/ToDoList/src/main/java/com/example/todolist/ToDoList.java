package com.example.todolist;

import java.util.ArrayList;

public class ToDoList {
    private String title;
    private ArrayList<Entry> entries = new ArrayList<>();

    public ToDoList(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Entry> getEntries(){
        return entries;
    }

    public void addEntry(Entry entry){
        entries.add(entry);
    }
}
