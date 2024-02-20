package com.example.todolist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryTest {
    @Test
    void testCreateEntry(){
        Entry entry = new Entry("this is my first entry");
        assertEquals("this is my first entry", entry.getEntry());
    }

    @Test
    void testCheckedIsFalse(){
        Entry entry = new Entry("test entry");
        assertFalse(entry.isChecked());
    }
}