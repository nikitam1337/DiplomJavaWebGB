package com.example.diplom.service;

import com.example.diplom.model.Note;
import com.example.diplom.model.User;

import java.util.List;

public interface NoteService {
    Note createNote(Note note);

    List<Note> getAllNotes();

    Note getNoteById(Long id);

    Note updateNote(Note note);

    void deleteNote(Long id);

    List<Note> listNotes();

    List<Note> getNotesByUser(User user);
}