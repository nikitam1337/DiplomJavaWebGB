package com.example.diplom.service.impl;

import com.example.diplom.model.NoteDiary;
import com.example.diplom.repository.NoteDiaryRepository;
import com.example.diplom.service.NoteDiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteDiaryServiceImpl implements NoteDiaryService {

    private final NoteDiaryRepository noteDiaryRepo;

    @Override
    public NoteDiary createNote(NoteDiary noteDiary) {
        return noteDiaryRepo.save(noteDiary);
    }

    @Override
    public List<NoteDiary> getAllNotes() {
        return noteDiaryRepo.findAll();
    }

    @Override
    public NoteDiary getNoteById(Long id) {
        return noteDiaryRepo.findById(id).orElseThrow(null);
    }

    @Override
    public NoteDiary updateNote(NoteDiary noteDiary) {
        NoteDiary noteByID = getNoteById(noteDiary.getId());

        noteByID.setExampleSituation(noteDiary.getExampleSituation());
        noteByID.setBodilySensations(noteDiary.getBodilySensations());
        noteByID.setFeeling(noteDiary.getFeeling());
        noteByID.setBehavior(noteDiary.getBehavior());
        return noteDiaryRepo.save(noteByID);
    }

    @Override
    public void deleteNote(Long id) {
        NoteDiary noteById = getNoteById(id);
        noteDiaryRepo.delete(noteById);
    }

    @Override
    public List<NoteDiary> listNotesDiary() {
        return noteDiaryRepo.findAll();
    }
}
