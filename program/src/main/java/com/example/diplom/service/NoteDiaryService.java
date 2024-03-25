package com.example.diplom.service;

import com.example.diplom.model.NoteDiary;

import java.util.List;

public interface NoteDiaryService {

    NoteDiary createNote(NoteDiary noteDiary);

    List<NoteDiary> getAllNotes();

    NoteDiary getNoteById(Long id);

    NoteDiary updateNote(NoteDiary noteDiary);

    void deleteNote(Long id);

    List<NoteDiary> listNotesDiary();
}
