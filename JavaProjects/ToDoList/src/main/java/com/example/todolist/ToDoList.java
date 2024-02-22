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

    private Entry getEntry(int index) {
        return entries.get(index);
    }
    public void addEntry(Entry entry){
        entries.add(entry);
    }

    public void deleteEntry(Entry entry){
        entries.remove(entry);
    }

    public String toString(){
        String string = title + "\n";
        for (Entry entry : entries)
            string += entry.toString();
        return string;
    }


}
