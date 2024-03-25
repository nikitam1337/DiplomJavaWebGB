package com.example.diplom.service.impl;

import com.example.diplom.model.Note;
import com.example.diplom.model.User;
import com.example.diplom.repository.NoteRepository;
import com.example.diplom.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        note.setCreatedDate(LocalDate.now());
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Note updateNote(Note note) {
        Note noteByID = getNoteById(note.getId());

        noteByID.setFeeling(note.getFeeling());
        noteByID.setLifeSituation(note.getLifeSituation());
        noteByID.setTelexSensation(note.getTelexSensation());
        noteByID.setYourActions(note.getYourActions());
        noteByID.setMyThoughtsAboutOthers(note.getMyThoughtsAboutOthers());
        noteByID.setMyThoughts(note.getMyThoughts());
        return noteRepository.save(noteByID);
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<Note> listNotes() {
        return noteRepository.findAll();
    }


    @Override
    public List<Note> getNotesByUser(User user) {
        return noteRepository.findByUser(user);
    }


}