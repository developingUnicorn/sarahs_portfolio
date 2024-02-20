package com.example.todolist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    @Test
    void createToDoList() {
        ToDoList toDoList = new ToDoList("Shopping");
        assertEquals("Shopping", toDoList.getTitle());
    }

    @Test
    void getEntriesFromList() {
        ToDoList toDoList = new ToDoList("Shopping");
        ArrayList<Entry> entries = toDoList.getEntries();
        assertTrue(entries.isEmpty());
    }

    @Test
    void addEntryToList(){
        ToDoList toDoList = new ToDoList("Shopping");
        toDoList.addEntry(new Entry("apples"));
        assertFalse(toDoList.getEntries().isEmpty());
    }
}