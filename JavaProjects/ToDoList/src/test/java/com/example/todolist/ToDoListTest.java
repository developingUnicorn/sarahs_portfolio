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

    @Test
    void deleteEntryFromList(){
        ToDoList toDoList = new ToDoList("Shopping");
        Entry entry = new Entry("apples");
        toDoList.addEntry(entry);
        toDoList.deleteEntry(entry);
        assertTrue(toDoList.getEntries().isEmpty());
    }

    @Test
    void printToDoList(){
        ToDoList toDoList = new ToDoList("shopping");
        Entry entry = new Entry("apples");
        toDoList.addEntry(entry);
        toDoList.addEntry(new Entry("bananas"));
        String expected = "shopping\n" +
        "apples, false\n" +
        "bananas, false\n";

        assertEquals(expected, toDoList.toString());
    }
}