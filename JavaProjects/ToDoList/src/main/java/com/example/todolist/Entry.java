package com.example.todolist;

public class Entry {

    private String entry;
    private boolean checked = false;

    public Entry(String entry){
        this.entry = entry;
    }

    public String getEntry(){
        return entry;
    }

    public void check(){
         checked = !checked;
    }
    public boolean isChecked(){
        return checked;
    }

    public String toString(){
        return entry + ", " + checked + "\n";
    }
}
